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
        if (input.charAt(0) == input.charAt(1)
                || input.charAt(1) == input.charAt(2)
                || input.charAt(2) == input.charAt(0)) {
            throw new InputMismatchException("[Error] 입력 값은 서로 다른 숫자로 이뤄져야합니다.");
        }
        return input;
    }

    public static boolean isContinue(Scanner scanner) {
        String input = scanner.next();
        if (input.length() != 1 || !isInteger(input) || !"12".contains(input)) {
            throw new InputMismatchException("[Error] 게임 종료 여부 값은 1 (새로 시작), 2 (게임 종료)로 입력하세요.");
        }
        return "1".equals(input);
    }

    public static void showEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
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
