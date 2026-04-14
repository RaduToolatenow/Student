package advanced;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NewIntCalculatorTest {

    @Test
    void testInit() {

        NewIntCalculator calc = new NewIntCalculator();

        calc.init();

        assertEquals(0, calc.state);
    }

    @Test
    void testAdd() {

        NewIntCalculator calc = new NewIntCalculator();
        calc.init();


        calc.add(5);


        assertEquals(5, calc.state);
    }

    @Test
    void testAddNegative() {

        NewIntCalculator calc = new NewIntCalculator();
        calc.init();


        calc.add(-3);


        assertEquals(-3, calc.state);
    }

    @Test
    void testSubtract() {

        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(10);

        calc.subtract(4);

        assertEquals(6, calc.state);
    }

    @Test
    void testMultiply() {

        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(3);

        calc.multiply(4);

        assertEquals(12, calc.state);
    }

    @Test
    void testMultiplyWithZero() {

        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(10);

        calc.multiply(0);

        assertEquals(0, calc.state);
    }

    @Test
    void testOperationAfterClearPointerException() {

        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.clear();

        //null Integer da NullPointerException
        assertThrows(NullPointerException.class, () -> calc.add(5));
    }

    @Test
    void testMultiplyOverflow() {

        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(Integer.MAX_VALUE);

        calc.multiply(2);

        assertEquals(Integer.MAX_VALUE * 2, calc.state); // -2 due to overflow
    }

    @Test
    void testSubtractOverflow() {

        NewIntCalculator calc = new NewIntCalculator();
        calc.init();
        calc.add(Integer.MIN_VALUE);

        calc.subtract(1);

        assertEquals(Integer.MAX_VALUE, calc.state);
    }
}