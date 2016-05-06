package com.faeddalberto.calculator.steps;

import com.faeddalberto.calculator.Calculator;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

public class SubstractTwoNumbersSteps extends Steps {

    private Calculator calculator;
    private double myResult;

    @Given("a calculator which calculates subs")
    public void givenTheCalculator(){
        calculator = new Calculator();
    }

    @When("I substract $number1 and $number2")
    public void whenISubstractNumber1AndNumber2(double number1, double number2) {
        myResult = calculator.sub(number1, number2);
    }

    @Then("the sub outcome should be $result")
    public void thenTheOutcomeShould(double result) {
        assert myResult == result;
    }
}

