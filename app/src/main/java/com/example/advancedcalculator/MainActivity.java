package com.example.advancedcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    AdvancedCalculator advancedCalculator = new AdvancedCalculator();
    TextView txtOutput;
    TextView txtErrorMsg;
    int storage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtOutput = (TextView) findViewById(R.id.txtOutput);
        txtErrorMsg = (TextView) findViewById(R.id.txtError);
    }


    /*
    BREAKDOWN

    User presses string of numbers
    User presses operator
        - store the operator
            - check if storage number is empty
            - set the storage number to input
        - store the number
        - array?
            - Allow for multiple numbers?
        - display number below..
        - clear input
    User enters second string of numbers
    User presses equals sign
        - Takes value 1
        - Takes value 2
        - preforms operator
        - prints value
        - stores value in temp variable


    Required Variables
    numberInput (What the user inputs)
    storageNumber (After the user presses an operator)
    storageOperator (Store the operator pressed)
    equationOutput (Display the operators output)



     */

    public void getUserOperation(View view) {

        switch(view.getId()) {
            case R.id.operationClear:
                txtOutput.setText("");
                txtErrorMsg.setText("");
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

                storage = Integer.parseInt(txtOutput.getText().toString());
                txtErrorMsg.setText(Integer.toString(storage) + " + ");
                txtOutput.setText(null);
                System.out.println("ADDITION");
                break;
            case R.id.operatorEqual:
                txtOutput.setText(Integer.toString(storage + Integer.parseInt(txtOutput.getText().toString())));

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
                numberToAppend(0);
                System.out.println("ZERO");
                break;
            case R.id.btnOne:
                numberToAppend(1);
                System.out.println("ONE");
                break;
            case R.id.btnTwo:
                numberToAppend(2);
                System.out.println("TWO");
                break;
            case R.id.btnThree:
                numberToAppend(3);
                System.out.println("THREE");
                break;
            case R.id.btnFour:
                numberToAppend(4);
                System.out.println("FOUR");
                break;
            case R.id.btnFive:
                numberToAppend(5);
                System.out.println("FIVE");
                break;
            case R.id.btnSix:
                numberToAppend(6);
                System.out.println("SIX");
                break;
            case R.id.btnSeven:
                numberToAppend(7);
                System.out.println("SEVEN");
                break;
            case R.id.btnEight:
                numberToAppend(8);
                System.out.println("EIGT");
                break;
            case R.id.btnNine:
                numberToAppend(9);
                System.out.println("NINE");
                break;
            default:
                System.out.println("THERE WAS AN ERROR");
                break;
        }
    }

    private void numberToAppend(int number) {
        if(txtOutput.getText().toString().length() <= 10) {
            txtOutput.append(Integer.toString(number));
            txtErrorMsg.setText(Integer.toString(number));
        } else {
            txtErrorMsg.setTextColor(Color.RED);
            txtErrorMsg.setText("You cannot enter more than 10 numbers");
        }
    }


}