import java.util.Scanner;

public class Game {

    private Scanner scanner;

    private Answer answer;

    public Game(Scanner scanner, Answer answer) {
        this.scanner = scanner;
        this.answer = answer;
    }

    public void start() {

    }

    public static Game of(Scanner scanner, Answer answer) {
        return new Game(scanner, answer);
    }

}
