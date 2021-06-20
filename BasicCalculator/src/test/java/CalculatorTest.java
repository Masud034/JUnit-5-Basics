import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("When running CalculatorTest")
class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll runs before the CalculatorTest instance created!");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        testReporter.publishEntry("Running " + testInfo.getDisplayName());
        calculator = new Calculator();
        System.out.println("Instance created");
    }

    @AfterEach
    void clean() {
        System.out.println("Cleaning...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll runs after instance done serving its duty");
    }

    @Nested
    @DisplayName("Add method")
    class Add {
        @Test
        @DisplayName("When adding two positive numbers")
        void addPositive() {
            assertAll(
                    () -> assertEquals(4, calculator.add(2, 2), () -> "should return the right sum"),
                    () -> assertEquals(205.73, calculator.add(200, 5.73), () -> "should return the right sum")
            );
        }

        @Test
        @DisplayName("When adding two negative numbers")
        void addNegative() {
            assertAll(
                    () -> assertEquals(-2, calculator.add(-2, 0), () -> "should return the right sum"),
                    () -> assertEquals(-7, calculator.add(-2, -5), () -> "should return the right sum")
            );
        }
    }

    @Test
    @DisplayName("subtract method")
    void subtract() {
        assertEquals(4, calculator.subtract(5.5, 1.5), () -> "should return the right subtracted value");
    }

    @Test
    @DisplayName("multiply method")
    void multiply() {
        assertAll(
                () -> assertEquals(8, calculator.multiply(4, 2), () -> "should return the right multiplied value"),
                () -> assertEquals(5, calculator.multiply(2.5, 2), () -> "should return the right multiplied value")
        );
    }

    @Test
    @DisplayName("divide method")
    void divide() {
        assertAll(
                () -> assertEquals(2.5, calculator.divide(5, 2), () -> "should return the right division value"),
                () -> assertEquals(Double.POSITIVE_INFINITY, calculator.divide(8.5, 0), () -> "should return the right division value")
        );
    }

    //@Test
    @RepeatedTest(3)
    @DisplayName("arithmeticExceptionCheck method")
    void arithmeticExceptionCheck(RepetitionInfo repetitionInfo) {
        //you can do some coding based on repetitionInfo,otherwise leave it blank
        //System.out.println(repetitionInfo.getCurrentRepetition());
        assertThrows(ArithmeticException.class, () -> calculator.arithmeticExceptionCheck(5, 0), () -> "should throw an ArithmeticExceptionError");
    }

    //TestInfo contains information about test
    //TestReport lets you access the console,report

    @Test
    @Disabled
    @DisplayName("TDD method,should not run now")
    void testDisabled() {
        fail("This test should be disabled");
    }
}