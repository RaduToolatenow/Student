package advanced;

public class Lab5Calc {

    public static void main(String[] args) {

        // Integer
        NewIntCalculator intCalc = new NewIntCalculator();
        intCalc.init();
        intCalc.add(10);
        intCalc.add(5);
        intCalc.subtract(3);
        intCalc.multiply(2);
        System.out.println("Integer result: " + intCalc.result());

        // Double
        DoubleCalculator doubleCalc = new DoubleCalculator();
        doubleCalc.init();
        doubleCalc.add(10);
        doubleCalc.add(5);
        doubleCalc.subtract(3.3);
        doubleCalc.multiply(2.2);
        System.out.println("Double result: " + doubleCalc.result());
    }
}