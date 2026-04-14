package advanced;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NewIntCalculatorTest {

    @Test
    void testInit() {
        // Arrange
        NewIntCalculator calc = new NewIntCalculator();

        // Act
        calc.init();

        // Assert
        assertEquals(0, calc.state);
    }

    @Test
    void testAdd() {
        // Arrange
        NewIntCalculator calc = new NewIntCalculator();
        calc.init();

        // Act
        calc.add(5);

        // Assert
        assertEquals(5, calc.state);
    }

    @Test
    void testAddNegative() {
        // Arrange
        NewIntCalculator calc = new NewIntCalculator();
        calc.init();

        // Act
        calc.add(-3);

        // Assert
        assertEquals(-3, calc.state);
    }

    @Test
    void testSubtract() {
        // Arrange
        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(10);

        // Act
        calc.subtract(4);

        // Assert
        assertEquals(6, calc.state);
    }

    @Test
    void testMultiply() {
        // Arrange
        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(3);

        // Act
        calc.multiply(4);

        // Assert
        assertEquals(12, calc.state);
    }

    @Test
    void testMultiplyWithZero() {
        // Arrange
        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(10);

        // Act
        calc.multiply(0);

        // Assert
        assertEquals(0, calc.state);
    }
}