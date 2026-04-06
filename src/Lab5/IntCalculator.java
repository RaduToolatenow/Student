package Lab5;

public class IntCalculator {
    private int state;

    public IntCalculator(int state) {
        this.state = state;
    }

    /*
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
*/

    //adunare
    public IntCalculator adauga(int nr) {
        state = state + nr;
        return this;
    }

    //scadere
    public IntCalculator scade(int nr) {
        state = state - nr;
        return this;
    }

    //inmultire
    public IntCalculator inmult(int nr) {
        this.state = state * nr;
        return this;
    }

    //rez final
    public int resulta() {
        return this.state;
    }

    //il faci 0
    public IntCalculator clear() {
        this.state = 0;
        return this;
    }

}
