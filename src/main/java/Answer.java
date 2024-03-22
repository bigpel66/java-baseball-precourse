import java.util.HashSet;
import java.util.Set;

public final class Answer {
    
    private Status status;

    private final String value;

    private final Set<Integer> containSet = new HashSet<>();

    public Answer(String input) {
        value = input;
        for (int i = 0; i < value.length(); i++) {
            containSet.add(value.charAt(i) - '0');
        }
    }

    private Answer() {
        throw new AssertionError("정답 값이 없는 생성을 방지");
    }

    public static Answer of(String input) {
        return new Answer(input);
    }

    public Status grade(String guess) {
        status = Status.newInstance();
        for (int i = 0; i < guess.length(); i++) {
            int digit = guess.charAt(i) - '0';
            if (matchDigit(digit, i)) {
                status.increaseStrike();
            } else if (containsDigit(digit)) {
                status.increaseBall();
            }
        }
        return status;
    }

    public Status status() {
        return status;
    }

    private boolean containsDigit(int digit) {
        return containSet.contains(digit);
    }

    private boolean matchDigit(int digit, int index) {
        return containsDigit(digit) && (value.charAt(index) - '0' == digit);
    }

}
