import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("게임 객체 테스트")
class GameTest {

    @Test
    @DisplayName("게임 객체 정상 생성 확인")
    void requireNonNullGame() {
        Scanner sc = new Scanner(System.in);
        assertThatCode(() -> Objects.requireNonNull(Game.of(sc, Answer.of(RandomGenerator.generate()))))
                .doesNotThrowAnyException();
    }

}