package advanced;

public class DoubleCalculator extends ACalculator {

    @Override
    public void init() {
        state = 0.0;
    }

    public void add(double n) {
        state = (Double) state + n;
    }

    public void subtract(double n) {
        state = (Double) state - n;
    }

    public void multiply(double n) {
        state = (Double) state * n;
    }
}