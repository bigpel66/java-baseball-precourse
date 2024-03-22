import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("숫자 야구 게임 상태 객체 테스트")
class StatusTest {

    @Test
    @DisplayName("상태 객체 생성 확인")
    void requireNonNullStatus() {
        assertThatCode(() -> Objects.requireNonNull(Status.newInstance())).doesNotThrowAnyException();
        assertThatCode(() -> Objects.requireNonNull(Status.of(1, 2))).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("상태 객체 문자열 확인 (낫싱)")
    void checkToStringNothing() {
        assertThat(Status.newInstance().toString()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("상태 객체 문자열 확인 (x스트라이크)")
    void checkToStringStrike() {
        assertThat(Status.of(1, 0).toString()).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("상태 객체 문자열 확인 (x스트라이크 y볼)")
    void checkToStringStrikeBall() {
        assertThat(Status.of(1, 1).toString()).isEqualTo("1스트라이크 1볼");
    }

    @Test
    @DisplayName("상태 객체 문자열 확인 (y볼)")
    void checkToStringBall() {
        assertThat(Status.of(0, 1).toString()).isEqualTo("1볼");
    }

    @Test
    @DisplayName("진행 중인 게임의 종료 여부 확인")
    void isFinish() {
        assertThat(Status.of(3, 0).isFinish()).isTrue();
    }

    @Test
    @DisplayName("스트라이크 증가 확인")
    void increaseStrike() {
        assertThat(Status.of(1, 0).increaseStrike().strike()).isEqualTo(2);
    }

    @Test
    @DisplayName("볼 증가 확인")
    void increaseBall() {
        assertThat(Status.of(0, 1).increaseBall().ball()).isEqualTo(2);
    }
    
}