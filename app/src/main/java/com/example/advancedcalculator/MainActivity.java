package com.example.advancedcalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


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

    // Define the advancedCalculator class
    AdvancedCalculator advancedCalculator = new AdvancedCalculator();

    // Create a text view to store the output and error message
    TextView txtOutput, txtErrorMsg;
    // Create a string to store the current operation
    String currentOperation;

    // Store the first number and set it to Not a Number
    private double firstNumber = Double.NaN;
    // Store the second number
    private double secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define the output and error message box.
        txtOutput = findViewById(R.id.txtOutput);
        txtErrorMsg = findViewById(R.id.txtError);
    }


    public void getUserOperation(View view) {
        // Define a pusdeo variable that'll act as the placeholder for multiple ID's
        Button button = (Button) view;

        // Remove any errors
        //removeErrorOutput();

        // Run the calculation expression
        calculateExpression();

        // Grab the current operation
        currentOperation = button.getText().toString();

        // Set the error message text for visual purposes
        txtErrorMsg.setText("A: " + firstNumber + " " + currentOperation + " " + txtOutput.getText().toString());

        System.out.println("MY CURRENT OPERATION: " + currentOperation);

    }

    public void getUserNumber(View view) {
        Button button = (Button) view;
        numberToAppend(Integer.parseInt(button.getText().toString()));
    }

    public void clearButton(View view) {
        txtOutput.setText("");
        txtErrorMsg.setText("");
    }

    public void getEqualsResult(View view) {
        calculateExpression();
   //     txtErrorMsg.setText(firstNumber + " " + currentOperation + " " + secondNumber + " = " + operation(firstNumber, secondNumber, currentOperation));


        /*   txtErrorMsg.setText(Double.toString(operation(firstNumber, secondNumber, currentOperation)));*/
        System.out.println("WHO TF KNOWS: " + firstNumber);
        firstNumber = Double.NaN;
        secondNumber = 0;
        currentOperation = null;
    }


    private void calculateExpression() {
        if (!Double.isNaN(firstNumber)) {
            System.out.println("FIRS TNUMBER: " + firstNumber);
            secondNumber = Double.parseDouble(txtOutput.
                    getText().toString());
            System.out.println("POINT B");
            txtOutput.setText(null);
            System.out.println("SECOND NUMBER: " + secondNumber);

            System.out.println("Print: " + operation(firstNumber, secondNumber, currentOperation));
            System.out.println(firstNumber + " " + currentOperation + " " + secondNumber + " = " + operation(firstNumber, secondNumber, currentOperation));

            txtOutput.setText(Double.toString(operation(firstNumber, secondNumber, currentOperation)));
        } else {
            // try parsing the first number
            try {
                // Set the first number equal to the doubled parse value
                firstNumber = Double.parseDouble(txtOutput.getText().toString());
                // Set the output text to null
                txtOutput.setText(null);
            } catch (Exception e) {

                // set the text color to red
                txtErrorMsg.setTextColor(Color.RED);
                // inform the user they are having number issues.
                txtErrorMsg.setText("Please enter some numbers to continue.");
            }
        }
    }

    // Double function to preform operations. Takes in two values and the operator
    private double operation(double firstValue, double secondValue, String operator) {
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

    // Function that'll append the number to the display
    private void numberToAppend(int number) {
        // Make sure the users input isn't greater than 10 arguments
        if (txtOutput.getText().toString().length() <= 10) {
            // Appends the number to the string
            txtOutput.append(Integer.toString(number));
            // Displays the initial number
            txtErrorMsg.append(Integer.toString(number));
            System.out.println("OUTPUT: " + txtOutput.getText().toString());
        } else {
            // Display red and inform the user that they cannot enter more than 10 numbers.
            txtErrorMsg.setTextColor(Color.RED);
            txtErrorMsg.setText("You cannot enter more than 10 numbers");
        }
    }

    // Simple function that resets the error message text field
    private void removeErrorOutput() {
        // Checks if the string is not null
        if (txtErrorMsg.getText().toString() != null) {
            // Sets the error message's value to null
            txtErrorMsg.setText(null);
        }
    }
}