import java.util.Random;

public final class RandomGenerator {

    private static final Random random = new Random();

    private static final int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static String generate() {
        for (int i = digits.length - 1; i > 0; i--) {
            int randomIndex = random.nextInt(i);
            int temp = digits[i];
            digits[i] = digits[randomIndex];
            digits[randomIndex] = temp;
        }
        return Integer.valueOf(digits[0] * 100 + digits[1] * 10 + digits[2]).toString();
    }

}
