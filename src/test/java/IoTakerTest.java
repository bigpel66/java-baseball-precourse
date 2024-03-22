import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@DisplayName("입출력 담당 객체 테스트")
class IoTakerTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setOutputStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreOutputStream() {
        System.setOut(System.out);
    }

}