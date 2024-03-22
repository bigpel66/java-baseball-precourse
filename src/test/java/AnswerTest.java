import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("정답 객체 테스트")
class AnswerTest {

    @Test
    @DisplayName("정답 객체 정상 생성 확인")
    void checkDefaultConstructor() {
        assertThatCode(() -> Objects.requireNonNull(Answer.of("123"))).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("정답 객체 상태 확인")
    @SuppressWarnings("Reflection Type Conversion Ensured")
    void checkAnswerState() throws NoSuchFieldException, IllegalAccessException {
        Answer answer = Answer.of("123");
        Field status = answer.getClass().getDeclaredField("status");
        status.setAccessible(true);
        assertThat((Status) status.get(answer)).isNull();
        Field value = answer.getClass().getDeclaredField("value");
        value.setAccessible(true);
        assertThat((String) value.get(answer)).isEqualTo("123");
        Field containSet = answer.getClass().getDeclaredField("containSet");
        containSet.setAccessible(true);
        assertThat((Set<Integer>) containSet.get(answer)).contains(1, 2, 3);
    }

    @Test
    @DisplayName("정답인 경우의 채점 동작 확인")
    void gradeCorrectAnswer() {
        Answer answer = Answer.of("123");
        Status grade = answer.grade("123");
        assertThat(grade.strike()).isEqualTo(3);
        assertThat(grade.ball()).isEqualTo(0);
    }

    @Test
    @DisplayName("x스트라이크 경우의 채점 동작 확인")
    void gradeStrikeAnswer() {
        Answer answer = Answer.of("123");
        Status grade = answer.grade("125");
        assertThat(grade.strike()).isEqualTo(2);
        assertThat(grade.ball()).isEqualTo(0);
    }

    @Test
    @DisplayName("x스트라이크 y볼 경우의 채점 동작 확인")
    void gradeStrikeBallAnswer() {
        Answer answer = Answer.of("123");
        Status grade = answer.grade("132");
        assertThat(grade.strike()).isEqualTo(1);
        assertThat(grade.ball()).isEqualTo(2);
    }

    @Test
    @DisplayName("y볼 경우의 채점 동작 확인")
    void gradeBallAnswer() {
        Answer answer = Answer.of("123");
        Status grade = answer.grade("432");
        assertThat(grade.strike()).isEqualTo(0);
        assertThat(grade.ball()).isEqualTo(2);
    }

    @Test
    @DisplayName("낫싱인 경우의 채점 동작 확인")
    void gradeNothing() {
        Answer answer = Answer.of("123");
        Status grade = answer.grade("456");
        assertThat(grade.strike()).isEqualTo(0);
        assertThat(grade.ball()).isEqualTo(0);
    }

}