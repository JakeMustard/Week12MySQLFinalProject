import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class TestDemoTest {

    private TestDemo testDemo;

    @BeforeEach
    void setUp() {
        testDemo = new TestDemo();
    }

    @ParameterizedTest
    @CsvSource({
        "2, 3, 5, false",
        "0, 3, 0, true",
        "2, -3, 0, true",
        "-2, -3, 0, true"
    })
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            int result = testDemo.addPositive(a, b);
            assertEquals(expected, result);
        } else {
            assertThatThrownBy(() -> testDemo.addPositive(a, b))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
            Arguments.of(2, 3, 5, false),
            Arguments.of(0, 3, 0, true),
            Arguments.of(2, -3, 0, true),
            Arguments.of(-2, -3, 0, true)
        );
    }

    // Test method for randomNumberSquared
    void assertThatNumberSquaredIsCorrect() {
        TestDemo mockDemo = spy(testDemo);
        doReturn(5).when(mockDemo).getRandomInt();
        int fiveSquared = mockDemo.randomNumberSquared();
        assertEquals(25, fiveSquared);
    }
}
