import java.util.Scanner;

public final class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (loop(scanner)) ;
    }

    private static boolean loop(Scanner scanner) {
        try {
            Game game = Game.of(scanner, Answer.of(RandomGenerator.generate()));
            game.start();
            if (!IoTaker.isContinue(scanner)) {
                System.out.println("게임을 종료합니다.");
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

}
