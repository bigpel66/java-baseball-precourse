import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                Game game = Game.of(scanner, Answer.of(RandomGenerator.generate()));
                game.start();
                if (!IoTaker.isContinue(scanner)) {
                    System.out.println("게임을 종료합니다.");
                    return;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
