import java.util.Scanner;

public final class Game {

    private final Scanner scanner;

    private final Answer answer;

    public Game(Scanner scanner, Answer answer) {
        this.scanner = scanner;
        this.answer = answer;
    }

    public void start() {
        while (true) {
            try {
                String guess = IoTaker.guess(scanner);
                IoTaker.showStatus(answer.grade(guess));
                if (answer.status().isFinish()) {
                    IoTaker.showEndMessage();
                    return;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static Game of(Scanner scanner, Answer answer) {
        return new Game(scanner, answer);
    }

}
