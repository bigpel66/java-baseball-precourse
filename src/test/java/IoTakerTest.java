import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("입출력 담당 객체가 정적 메서드만 호출 가능한지 확인")
    void requireNonNullIoTaker() throws NoSuchMethodException {
        Constructor<IoTaker> constructor = IoTaker.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        assertThatThrownBy(constructor::newInstance).isInstanceOf(InvocationTargetException.class);
    }

    @Test
    @DisplayName("세자리 숫자 입력 확인")
    void check3DigitsInput() {
        setInputStream("123");
        Scanner sc = new Scanner(System.in);
        String input = IoTaker.getGuess(sc);
        assertThat(input).isEqualTo("123");
    }

    @Test
    @DisplayName("동일한 숫자 입력 필터링 확인")
    void checkDuplicatedDigits() {
        setInputStream("122");
        Scanner sc = new Scanner(System.in);
        assertThatThrownBy(() -> IoTaker.getGuess(sc)).isInstanceOf(InputMismatchException.class);
    }

    @Test
    @DisplayName("세자리가 아닌 숫자 입력 확인")
    void check2DigitsInput() {
        setInputStream("99");
        Scanner sc = new Scanner(System.in);
        assertThatThrownBy(() -> IoTaker.getGuess(sc)).isInstanceOf(InputMismatchException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 입력 값 필터링 확인")
    void checkNonDigitInput() {
        setInputStream("abc");
        Scanner sc = new Scanner(System.in);
        assertThatThrownBy(() -> IoTaker.getGuess(sc)).isInstanceOf(InputMismatchException.class);
    }

    @Test
    @DisplayName("게임 재개 확인")
    void checkContinueGame() {
        setInputStream("1");
        Scanner sc = new Scanner(System.in);
        assertThat(IoTaker.isContinue(sc)).isTrue();
    }

    @Test
    @DisplayName("게임 종료 확인")
    void checkStopGame() {
        setInputStream("2");
        Scanner sc = new Scanner(System.in);
        assertThat(IoTaker.isContinue(sc)).isFalse();
    }

    @Test
    @DisplayName("게임 재개/종료 여부에서 잘못된 값 입력 확인")
    void checkWrongInputContinuable() {
        setInputStream("a");
        Scanner sc = new Scanner(System.in);
        assertThatThrownBy(() -> IoTaker.isContinue(sc)).isInstanceOf(InputMismatchException.class);
    }

    @Test
    @DisplayName("게임 종료 후 출력 메시지 확인")
    void checkEndMessage() {
        IoTaker.showEndMessage();
        assertThat(outputStream.toString()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 끝\n"
                + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
    }

}