package operator;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
    private Operator operator;
    private int val1;
    private int val2;
    private double result;

    @Before
    public void before() {
        operator = new Operator();
    }

    @Given("^Two input values, (\\d+) and (\\d+)$")
    public void twoInputValuesAnd(int arg0, int arg1) {
        val1 = arg0;
        val2 = arg1;
    }

    @When("^I do the operation on the two values$")
    public void iDoTheOperationOnTheTwoValues() {
        operator = new Operator();
        result = operator.operate(val1, val2);
    }

    @Then("^I expect the result (\\d+)$")
    public void iExpectTheResult(int arg0) {
        System.out.println("Expected: " + arg0 + " Actual: " + result + " Acceptable delta: 0.001");
        Assert.assertEquals(arg0, result, 0.001);
    }
}
