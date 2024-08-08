package operator;

public class Operator {

    private double frac(int val1, int val2) {
        if (val2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (double) val1 / val2;
    }

    private double root(double val) {
        if (val < 0) {
            throw new IllegalArgumentException("Cannot compute the square root of a negative number.");
        }
        return Math.sqrt(val);
    }

    public double operate(Object val1, Object val2) {
        if (!(val1 instanceof Integer) || !(val2 instanceof Integer)) {
            throw new IllegalArgumentException("Only integer inputs are supported.");
        }
        return root(frac((int) val1, (int) val2));
    }
}
