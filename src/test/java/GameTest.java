import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("게임 객체 테스트")
class GameTest {

    @Test
    @DisplayName("게임 객체 정상 생성 확인")
    void requireNonNullGame() {
        assertThatCode(() -> Objects.requireNonNull(Game.newInstance())).doesNotThrowAnyException();
    }

}