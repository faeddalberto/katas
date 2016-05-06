package com.faeddalberto.calculator.steps;

import com.faeddalberto.calculator.Calculator;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

public class AddTwoNumbersSteps extends Steps {

    private Calculator calculator;
    private double myResult;

    @Given("a calculator which calculates adds")
    public void givenACalculator(){
        calculator = new Calculator();
    }

    @When("I add $number1 and $number2")
    public void whenIAddNumber1AndNumber2(double number1, double number2) {
        myResult = calculator.add(number1, number2);
    }

    @Then("the sum outcome should be $result")
    public void thenTheOutcomeShould(double result) {
        assert myResult == result;
    }
}
