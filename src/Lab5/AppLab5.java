package Lab5;

public class AppLab5 {
    public static void main(String[] args) {
        IntCalculator calculator = new IntCalculator(10);

        int result = calculator
                .adauga(10)
                .scade(6)
                .inmult(4)
                .resulta();

        System.out.println("result pt 5.5.1, a: " + result);

        AdvancedCalculator calculator2 = new AdvancedCalculator(12);

        int result2 = calculator2
                .adauga(4)
                .divide(2)
                .power(2)
                .radical(3)
                .resulta();

        System.out.println("result pt 5.5.1, b: " + result2);

    }
}
