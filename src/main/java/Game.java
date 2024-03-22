import java.util.Scanner;

public class Game {

    private Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {

    }

    public static Game newInstance(Scanner scanner) {
        return new Game(scanner);
    }

}
