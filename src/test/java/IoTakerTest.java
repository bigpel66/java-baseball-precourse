import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

@DisplayName("입출력 담당 객체 테스트")
class IoTakerTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setOutputStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreOutputStream() {
        System.setOut(System.out);
    }

    void setInputStream(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    @DisplayName("숫자 입력 확인")
    void checkNumericInput() {
        setInputStream("9");
        Scanner sc = new Scanner(System.in);
        assertThat(sc.nextInt()).isEqualTo(9);
    }

    @Test
    @DisplayName("숫자가 아닌 값 입력 확인")
    void checkNonNumericInput() {
        setInputStream("string");
        Scanner sc = new Scanner(System.in);
        assertThatThrownBy(sc::nextInt).isInstanceOf(InputMismatchException.class);
    }

    @Test
    @DisplayName("입출력 담당 객체의 생성을 확인")
    void requireNonNullIoTaker() {
        assertThatCode(() -> Objects.requireNonNull(IoTaker.getInstance())).doesNotThrowAnyException();
    }

}