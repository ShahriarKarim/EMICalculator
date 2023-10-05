package com.example.mortgagecalc;
import static java.lang.Math.pow;
import java.util.*;

import java.io.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateEMI(View v){//view v for listening on click of button
        //Proper naming, named the method based on what its calculating.

        //gathering the views we created, editTexts because user inputs a number
        EditText MortgageAmount = (EditText)findViewById(R.id.editTextNumber);
        EditText InterestRate = (EditText)findViewById(R.id.editTextNumber2);
        EditText LoanTerm = (EditText)findViewById(R.id.editTextNumber3);

        //this is outputting the result of what the user inputted
        EditText EMIResult = (EditText)findViewById(R.id.editTextNumber4);


        //need to use double because values may be decimals eg mortgage principal amount
        double MortgageDouble = Double.parseDouble(MortgageAmount.getText().toString());
        double InterestDouble = Double.parseDouble(InterestRate.getText().toString());
        double LoanTimeDouble = Double.parseDouble(LoanTerm.getText().toString());

        //in order to calculate EMI need to convert years into month
        LoanTimeDouble = LoanTimeDouble*12;
        InterestDouble = InterestDouble/(12*100);

        //the text box now accepts decimal values because user inputted values can be dec

        //formula of EMI, using math power to make it easier to compute powers
        double EMI = (MortgageDouble*InterestDouble*Math.pow(1+InterestDouble,LoanTimeDouble)) / (Math.pow(1+InterestDouble,LoanTimeDouble)-1);

        //since we want to limit the number of decimals to cents, only need two decimals
        //so formatted the EMI and removed unnecessary extra decimals
        String EMIformatted = String.format("%.2f", EMI);

        //output the emi result to the textbox number 4
        EMIResult.setText("The EMI is: " + EMIformatted);





    }

}