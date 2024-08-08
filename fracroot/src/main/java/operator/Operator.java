package operator;

public class Operator {

    private double frac(int val1, int val2) {
        return (double) val1 / val2;
    }

    private double root(double val) {
        return Math.sqrt(val);
    }

    public double operate(Object val1, Object val2) {
        if (!(val1 instanceof Integer) || !(val2 instanceof Integer)) {
            throw new IllegalArgumentException("Only integer inputs are supported.");
        }
        return root(frac((int) val1, (int) val2));
    }
}
