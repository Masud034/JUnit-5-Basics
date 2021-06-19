import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void beforeAll(){
        System.out.println("BeforeAll runs before the CalculatorTest instance created!");
    }

    @BeforeEach
    void init(){
        calculator = new Calculator();
        System.out.println("Instance created");
    }

    @AfterEach
    void clean(){
        System.out.println("Cleaning...");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("AfterAll runs after instance done serving its duty");
    }

    @Test
    @DisplayName("Should add two numbers")
    void add() {
        assertAll(
                () -> assertEquals(4, calculator.add(2, 2)),
                () -> assertEquals(8.5, calculator.add(5, 3.5)),
                () -> assertEquals(205.73, calculator.add(200, 5.73)),
                () -> assertEquals(8, calculator.add(4, 4))
        );
    }

    @Test
    @DisplayName("Should subtract two numbers")
    void subtract() {
        assertEquals(4, calculator.subtract(5.5, 1.5));
    }

    @Test
    @DisplayName("Should multiply two numbers")
    void multiply() {
        assertAll(
                () -> assertEquals(8, calculator.multiply(4, 2)),
                () -> assertEquals(5, calculator.multiply(2.5, 2)),
                () -> assertEquals(11, calculator.multiply(5.5, 2))
        );
    }

    @Test
    @DisplayName("Should divide two numbers")
    void divide() {
        assertAll(
                () -> assertEquals(2.5, calculator.divide(5, 2)),
                () -> assertEquals(4, calculator.divide(8, 2)),
                () -> assertEquals(Double.POSITIVE_INFINITY, calculator.divide(8.5,0))
        );
    }

    @Test
    @DisplayName("Should throw an ArithmeticExceptionError")
    void arithmeticExceptionCheck(){
        assertThrows(ArithmeticException.class, ()-> calculator.arithmeticExceptionCheck(5, 0));
    }

    @Test
    @Disabled
    @DisplayName("TDD method,should not run now")
    void testDisabled(){
        fail("This test should be disabled");
    }
}