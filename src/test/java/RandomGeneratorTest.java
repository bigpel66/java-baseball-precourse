import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("무작위 3자리수 생성 테스트")
class RandomGeneratorTest {

    private static final Pattern pattern = Pattern.compile("[1-9]{3}");

    @Test
    @DisplayName("무작위 3자리 수 1000회 테스트")
    void generateRandomFor1000() {
        for (int i = 0; i < 1000; i++) {
            String digits = RandomGenerator.generate();
            Matcher matcher = pattern.matcher(digits);
            assertThat(matcher.find()).isTrue();
        }
    }

}