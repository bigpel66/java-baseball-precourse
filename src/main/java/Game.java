import java.util.Scanner;

public final class Game {

    private final Scanner scanner;

    private final Answer answer;

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
