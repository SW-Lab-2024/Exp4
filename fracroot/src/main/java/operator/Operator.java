package operator;

public class Operator {

    private double frac(int val1, int val2) {
        return (double) val1 / val2;
    }

    private double root(double val) {
        return Math.sqrt(val);
    }

    public double operate(int val1, int val2) {
        return root(frac(val1, val2));
    }
}
