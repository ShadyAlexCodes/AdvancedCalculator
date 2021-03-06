package com.example.advancedcalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
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
    TextView txtOutput, txtWarning, txtPlaceholder;
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
        txtWarning = findViewById(R.id.txtWarning);
        txtPlaceholder = findViewById(R.id.txtPlaceholder);
    }


    public void getUserOperation(View view) {
        // Define a psuedo variable that'll act as the placeholder for multiple ID's
        Button button = (Button) view;

        // Remove any errors
        //removeErrorOutput();

        // Run the calculation expression
        calculateExpression();

        // Grab the current operation
        currentOperation = button.getText().toString();

        // Set the error message text for visual purposes
        txtPlaceholder.setText(firstNumber + " " + currentOperation + " " + txtOutput.getText().toString());
    }

    public void getUserNumber(View view) {
        // Grab all the buttons that are assigned to this function
        Button button = (Button) view;
        // Parse their clicked value and and append it
        numberToAppend(Integer.parseInt(button.getText().toString()));
    }

    public void clearButton(View view) {
        // Clear everything

        txtOutput.setText(null);
        txtWarning.setText(null);
        txtPlaceholder.setText(null);
        firstNumber = Double.NaN;
        secondNumber = 0;
        currentOperation = null;
    }

    public void getEqualsResult(View view) {
       // calculate the expression
        calculateExpression();

        // reset all the values
        firstNumber = Double.NaN;
        secondNumber = 0;
        currentOperation = null;
    }

    private boolean endsWithOperator() {
        return txtWarning.getText().toString().contains("+") ||
                txtWarning.getText().toString().contains("-") ||
                txtWarning.getText().toString().contains("/") ||
                txtWarning.getText().toString().contains("x") ||
                txtWarning.getText().toString().contains("%");
    }

    public void decimalNoWork(View view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txtPlaceholder.setText(null);
            }
        }, 4000);
        txtPlaceholder.setText("hahahaha u funny. this button no work");


    }

    private void calculateExpression() {

        if (!endsWithOperator()) {
            // Check if the double is not-not a number
            if (!Double.isNaN(firstNumber)) {

                // Assign the second number the value of the text output
                secondNumber = Double.parseDouble(txtOutput.
                        getText().toString());

                // Reset the output
                txtOutput.setText(null);
                txtPlaceholder.setText(null);
                // Preform the equation
                txtOutput.setText(Double.toString(advancedCalculator.operation(firstNumber, secondNumber, currentOperation)));
            } else {
                // try parsing the first number
                try {
                    // Set the first number equal to the doubled parse value
                    firstNumber = Double.parseDouble(txtOutput.getText().toString());
                    // Set the output text to null
                    txtOutput.setText(null);
                } catch (Exception e) {

                    // set the text color to red
                    txtWarning.setTextColor(Color.RED);
                    // inform the user they are having number issues.
                    txtWarning.setText("Please enter some numbers to continue.");
                }
            }
        } else
        {
            
            // set the text color to red
            txtWarning.setTextColor(Color.RED);
            // inform the user they are having number issues.
            txtWarning.setText("Please enter some numbers to continue.");
            System.out.println("ERROR");
        }
    }

    // Function that'll append the number to the display
    private void numberToAppend(int number) {
        // Make sure the users input isn't greater than 10 arguments
        if (txtOutput.getText().toString().length() <= 10) {
            // Appends the number to the string
            txtOutput.append(Integer.toString(number));
            // Displays the initial number
            txtPlaceholder.append(Integer.toString(number));
            System.out.println("OUTPUT: " + txtOutput.getText().toString());
        } else {
            // Display red and inform the user that they cannot enter more than 10 numbers.
            txtWarning.setTextColor(Color.RED);
            txtWarning.setText("You cannot enter more than 10 numbers");
        }
    }
}