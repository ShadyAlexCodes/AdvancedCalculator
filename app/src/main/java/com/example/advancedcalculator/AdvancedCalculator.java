package com.example.advancedcalculator;

import java.lang.reflect.Array;

public class AdvancedCalculator {

    // Double function to preform operations. Takes in two values and the operator
    public double operation(double firstValue, double secondValue, String operator) {
        switch (operator) {
            case "+":
                return firstValue + secondValue;
            case "-":
                return firstValue - secondValue;
            case "/":
                return firstValue / secondValue;
            case "x":
                return firstValue * secondValue;
            case "%":
                return firstValue % secondValue;
            default:
                return -1;
        }
    }

}
