package com.faeddalberto.calculator;

public class Calculator {

    public double add(double number1, double number2) {
        return number1 + number2;
    }

    public double sub(double number1, double number2) {
        return number1 - number2;
    }

    public double multiply(double number1, double number2) {
        return number1 * number2;
    }

    public double divide(double number1, double number2) {
        System.out.println(number1 / number2);
        return number1 / number2;
    }
}
