import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("Should add two numbers")
    void add() {
        assertAll(
                () -> assertEquals(4,Calculator.add(2, 2)),
                () -> assertEquals(8.5,Calculator.add(5, 3.5)),
                () -> assertEquals(205.73,Calculator.add(200, 5.73)),
                () -> assertEquals(8,Calculator.add(4, 4))
        );
    }

    @Test
    @DisplayName("Should subtract two numbers")
    void subtract() {
        assertEquals(4, Calculator.subtract(5.5, 1.5));
    }

    @Test
    @DisplayName("Should multiply two numbers")
    void multiply() {
        assertAll(
                () -> assertEquals(8,Calculator.multiply(4, 2)),
                () -> assertEquals(5,Calculator.multiply(2.5, 2)),
                () -> assertEquals(11,Calculator.multiply(5.5, 2))
        );
    }

    @Test
    @DisplayName("Should divide two numbers")
    void divide() {
        assertAll(
                () -> assertEquals(2.5,Calculator.divide(5, 2)),
                () -> assertEquals(4,Calculator.divide(8, 2)),
                () -> assertEquals(Double.POSITIVE_INFINITY,Calculator.divide(8,0)),
                () -> assertThrows(ArithmeticException.class, ()-> Calculator.arithmeticExceptionCheck(5, 0))
        );
    }
}