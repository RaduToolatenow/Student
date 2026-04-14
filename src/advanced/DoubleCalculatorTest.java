package advanced;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoubleCalculatorTest {

    //Unit test

    @Test
    void testInit() {
        DoubleCalculator calc = new DoubleCalculator();

        calc.init();

        assertEquals(0.0, calc.state);
    }

    @Test
    void testAdd() {

        DoubleCalculator calc = new DoubleCalculator();
        calc.init();

        calc.add(3.5);

        assertEquals(3.5, calc.state);
    }

    @Test
    void testAddNegative() {

        DoubleCalculator calc = new DoubleCalculator();
        calc.init();

        calc.add(-2.7);

        assertEquals(-2.7, (Double) calc.state, 0.0001);
    }

    @Test
    void testSubtract() {

        DoubleCalculator calc = new DoubleCalculator();
        calc.init();
        calc.add(10.0);

        calc.subtract(4.5);

        assertEquals(5.5, (Double) calc.state, 0.0001);
    }

    @Test
    void testSubtractResultNegative() {

        DoubleCalculator calc = new DoubleCalculator();
        calc.init();
        calc.add(3.0);

        calc.subtract(7.0);

        assertEquals(-4.0, (Double) calc.state, 0.0001);
    }

    @Test
    void testMultiply() {

        DoubleCalculator calc = new DoubleCalculator();
        calc.init();
        calc.add(2.5);

        calc.multiply(4.0);

        assertEquals(10.0, (Double) calc.state, 0.0001);
    }

    @Test
    void testMultiplyWithZero() {

        DoubleCalculator calc = new DoubleCalculator();
        calc.init();
        calc.add(99.9);

        calc.multiply(0.0);

        assertEquals(0.0, (Double) calc.state, 0.0001);
    }

    @Test
    void testClear() {

        DoubleCalculator calc = new DoubleCalculator();
        calc.init();
        calc.add(5.0);

        calc.clear();

        assertNull(calc.state);
    }

    @Test
    void testResult() {

        DoubleCalculator calc = new DoubleCalculator();
        calc.init();
        calc.add(1.1);
        calc.add(2.2);

        Object result = calc.result();

        assertEquals(3.3, (Double) result, 0.0001);
    }

    //  robustness tests ---

    @Test
    void testMultiplyByInfinity() {

        DoubleCalculator calc = new DoubleCalculator();
        calc.init();
        calc.add(1.0);

        calc.multiply(Double.POSITIVE_INFINITY);

        // Assert - IEEE 754: finite * infinity = infinity
        assertEquals(Double.POSITIVE_INFINITY, (Double) calc.state);
    }

    @Test
    void testAddNaN() {

        DoubleCalculator calc = new DoubleCalculator();
        calc.init();
        calc.add(5.0);

        calc.add(Double.NaN);

        assertTrue(Double.isNaN((Double) calc.state));
    }

    @Test
    void testOperationAfterClearThrowsException() {

        DoubleCalculator calc = new DoubleCalculator();
        calc.init();
        calc.clear(); // null state

        // NullPointerException
        assertThrows(NullPointerException.class, () -> calc.add(5.0));
    }

    @Test
    void testDivideByZeroYieldsInfinity() {

        DoubleCalculator calc = new DoubleCalculator();
        calc.init();
        calc.add(10.0);

        calc.multiply(1.0 / 0.0);

        assertEquals(Double.POSITIVE_INFINITY, (Double) calc.state);
    }
}