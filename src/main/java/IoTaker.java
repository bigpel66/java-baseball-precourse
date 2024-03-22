import java.util.InputMismatchException;
import java.util.Scanner;

public final class IoTaker {

    private IoTaker() {
        throw new AssertionError("정적 메서드만 존재하는 객체로 생성 방지");
    }

    public static String getGuess(Scanner scanner) {
        String input = scanner.next();
        if (input.length() != 3 || !isInteger(input)) {
            throw new InputMismatchException("[Error] 입력 값은 세자리 숫자로 이뤄져야합니다.");
        }
        return input;
    }

    public static void showEndMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
