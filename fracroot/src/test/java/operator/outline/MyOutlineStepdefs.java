package operator.outline;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import operator.Operator;
import org.junit.Assert;

public class MyOutlineStepdefs {
    private Operator operator;
    private Object val1;
    private Object val2;
    private double result;

    @Before
    public void before() {
        operator = new Operator();
    }

    @Given("^Two input values, (.+) and (.+)$")
    public void twoInputValuesAnd(String arg0, String arg1) {
        try {
            val1 = Integer.parseInt(arg0);
        } catch (NumberFormatException e) {
            val1 = Double.parseDouble(arg0);
        }

        try {
            val2 = Integer.parseInt(arg1);
        } catch (NumberFormatException e) {
            val2 = Double.parseDouble(arg1);
        }
    }

    @When("^I do the operation on the two values$")
    public void iDoTheOperationOnTheTwoValues() {
        try {
            result = operator.operate(val1, val2);
        } catch (IllegalArgumentException | ArithmeticException e) {
            result = Double.NaN;
        }
    }

    @Then("^I expect the result (.+)$")
    public void iExpectTheResult(String expected) {
        try {
            double expectedResult = Double.parseDouble(expected);
            System.out.println("Expected: " + expectedResult + " Actual: " + result + " Acceptable delta: 0.001");
            Assert.assertEquals(expectedResult, result, 0.001);
        } catch (NumberFormatException e) {
            Assert.assertTrue(Double.isNaN(result));
        }
    }

    @Then("^I expect an arithmetic error throws$")
    public void iExpectAnArithmeticErrorThrows() {
        Assert.assertTrue(Double.isNaN(result));
    }

    @Then("^I expect an illegal argument error throws$")
    public void iExpectAnIllegalArgumentErrorThrows() {
        Assert.assertTrue(Double.isNaN(result));
    }

    @Then("^I expect a negative argument error throws$")
    public void iExpectANegativeArgumentErrorThrows() {
        Assert.assertTrue(Double.isNaN(result));
    }
}
