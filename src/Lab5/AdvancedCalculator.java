package Lab5;

public class AdvancedCalculator extends IntCalculator {

    public AdvancedCalculator(int nr) {
        super(nr);
    }

    public AdvancedCalculator divide(int value) {
        if (value == 0) {
            throw new ArithmeticException("Nu se imparte la 0");
        }

        int current = resulta();
        clear().adauga(current / value);

        return this;
    }

    public AdvancedCalculator power(int exponent) {
        int current = resulta();
        int result = (int) Math.pow(current, exponent);

        clear().adauga(result);
        return this;
    }

    public AdvancedCalculator radical(int n) {
        if (n == 0) {
            throw new ArithmeticException("Nu merge radical");
        }

        int current = resulta();
        int result = (int) Math.pow(current, 1.0 / n);

        clear().adauga(result);
        return this;
    }
    @Override
    public AdvancedCalculator adauga(int nr) {
        super.adauga(nr);
        return this;
    }

    @Override
    public AdvancedCalculator scade(int nr) {
        super.scade(nr);
        return this;
    }

    @Override
    public AdvancedCalculator inmult(int nr) {
        super.inmult(nr);
        return this;
    }
}
