import java.util.Objects;

public final class IoTaker {

    public static final IoTaker INSTANCE = new IoTaker();

    private IoTaker() {
    }

    public static IoTaker getInstance() {
        Objects.requireNonNull(INSTANCE);
        return INSTANCE;
    }

}
