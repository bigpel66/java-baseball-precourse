public final class Status {

    private int strikeCount;

    private int ballCount;

    private Status() {
        throw new AssertionError("명시적으로 strike, ball를 기재한 생성 허용");
    }

    public Status(int strike, int ball) {
        strikeCount = strike;
        ballCount = ball;
    }

    public static Status of(int strike, int ball) {
        return new Status(strike, ball);
    }

    public static Status newInstance() {
        return new Status(0, 0);
    }

    public Status increaseStrike() {
        strikeCount++;
        return this;
    }

    public Status increaseBall() {
        ballCount++;
        return this;
    }

    public int strike() {
        return strikeCount;
    }

    public int ball() {
        return ballCount;
    }

    @Override
    public String toString() {
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }
        StringBuilder sb = new StringBuilder();
        if (strikeCount != 0) {
            sb.append(strikeCount).append("스트라이크");
        }
        if (sb.length() != 0 && ballCount != 0) {
            sb.append(" ");
        }
        if (ballCount != 0) {
            sb.append(ballCount).append("볼");
        }
        return sb.toString();
    }

    public boolean isFinish() {
        return strikeCount == 3;
    }

}
