public final class Answer {

    private Status status;

    public Answer() {
        status = Status.newInstance();
    }

    public static Answer of(String input) {
        return new Answer();
    }

    public Status grade(String guess) {
        return status;
    }

    public Status status() {
        return status;
    }

    public boolean containsDigit() {
        return true;
    }

    public boolean matchDigit() {
        return true;
    }

}
