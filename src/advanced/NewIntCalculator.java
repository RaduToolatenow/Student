package advanced;

public class NewIntCalculator extends ACalculator {

    @Override
    public void init() {
        state = 0;
    }

    public void add(int n) {
        state = (Integer) state + n;
    }

    public void subtract(int n) {
        state = (Integer) state - n;
    }

    public void multiply(int n) {
        state = (Integer) state * n;
    }
}