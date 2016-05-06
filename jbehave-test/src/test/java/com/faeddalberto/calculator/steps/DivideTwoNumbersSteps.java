package com.faeddalberto.calculator.steps;

import com.faeddalberto.calculator.Calculator;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

public class DivideTwoNumbersSteps extends Steps {

    private Calculator calculator;
    private double myResult;

    @Given("a calculator which calculates divisions")
    public void givenACalculator(){
        calculator = new Calculator();
    }

    @When("I divide $number1 by $number2")
    public void whenIMultiplyNumber1AndNumber2(double number1, double number2) {
        myResult = calculator.divide(number1, number2);
    }

    @Then("the quotient should be $result")
    public void thenTheOutcomeShould(double result) {
        assert myResult == result;
    }
}
