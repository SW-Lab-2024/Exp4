package operator;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
    private Operator operator;
    private Object val1;
    private Object val2;
    private double result;

    @Before
    public void before() {
        operator = new Operator();
    }

    @Given("^Two integer input values, (-?\\d+) and (-?\\d+)$")
    public void twoIntegerInputValues(int arg0, int arg1) {
        val1 = arg0;
        val2 = arg1;
    }

    @Given("^Two double input values, (-?\\d+\\.?\\d*) and (-?\\d+\\.?\\d*)$")
    public void twoDoubleInputValues(double arg0, double arg1) {
        val1 = arg0;
        val2 = arg1;
    }

    @When("^I do the operation on the two values$")
    public void iDoTheOperationOnTheTwoValues() {
        try {
            result = operator.operate(val1, val2);
        } catch (IllegalArgumentException e) {
            result = Double.NaN;
        } catch (ArithmeticException e) {
            result = Double.POSITIVE_INFINITY;
        }
    }

    @Then("^I expect the result (\\d+\\.?\\d*)$")
    public void iExpectTheResult(double arg0) {
        System.out.println("Expected: " + arg0 + " Actual: " + result + " Acceptable delta: 0.001");
        Assert.assertEquals(arg0, result, 0.001);
    }

    @Then("^I expect an illegal argument error throws$")
    public void iExpectAnIllegalArgumentErrorThrows() {
        Assert.assertTrue(Double.isNaN(result));
    }


    @Then("^I expect an arithmetic error throws$")
    public void iExpectAnArithmeticErrorThrows() {
        Assert.assertTrue(Double.isInfinite(result));
    }

    @Then("^I expect a negative argument error throws$")
    public void iExpectANegativeArgumentErrorThrows() {
        Assert.assertTrue(Double.isNaN(result));
    }
}
