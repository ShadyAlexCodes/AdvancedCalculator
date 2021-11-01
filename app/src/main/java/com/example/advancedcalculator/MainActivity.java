package com.example.advancedcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    AdvancedCalculator advancedCalculator = new AdvancedCalculator();

    private Array numberStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void getUserOperation(View view) {
        switch(view.getId()) {
            case R.id.operationClear:
                System.out.println("CLEAR");
                break;
            case R.id.operationModulus:
                System.out.println("MODULUS");
                break;
            case R.id.operationMultiplication:
                System.out.println("MULTIPLICATION");
                break;
            case R.id.operationDivision:
                System.out.println("DIVISION");
                break;
            case R.id.operationSubtraction:
                System.out.println("SUBTRACTION");
                break;
            case R.id.operatorAddition:
                System.out.println("ADDITION");
                break;
            case R.id.operatorEqual:
                System.out.println("EQUAL");
                break;
            default:
                System.out.println("THERE WAS AN ERROR");
                break;
        }
    }

    public void getUserNumber(View view) {
        switch(view.getId()) {
            case R.id.btnZero:
                System.out.println("ZERO");
                break;
            case R.id.btnOne:
                System.out.println("ONE");
                break;
            case R.id.btnTwo:
                System.out.println("TWO");
                break;
            case R.id.btnThree:
                System.out.println("THREE");
                break;
            case R.id.btnFour:
                System.out.println("FOUR");
                break;
            case R.id.btnFive:
                System.out.println("FIVE");
                break;
            case R.id.btnSix:
                System.out.println("SIX");
                break;
            case R.id.btnSeven:
                System.out.println("SEVEN");
                break;
            case R.id.btnEight:
                System.out.println("EIGT");
                break;
            case R.id.btnNine:
                System.out.println("NINE");
                break;
            default:
                System.out.println("THERE WAS AN ERROR");
                break;
        }
    }
}