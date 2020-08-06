package com.cherish.projects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button nextBtn;

    public void changeCurrency(View view) {


        Log.i("info", "button clicked");

        EditText currency = (EditText) findViewById(R.id.currencyEditText);
        String message = "please enter a number";
        if (currency.getText().toString().isEmpty()) {
            Toast.makeText(this, "please enter a number", Toast.LENGTH_SHORT).show();
        }else{
//
        String amountNaira = currency.getText().toString();
//        double amountNairaDouble = Double.parseDouble(amountNaira);
//        double amountInDollarsDouble = amountNairaDouble * 360.3;
//        String amountInDollarsString = String.format("%.2f", amountInDollarsDouble);

        int amountNairaInteger = Integer.valueOf(amountNaira);
        int amountInDollarsInteger = amountNairaInteger / 360;
        String amountInDollarsString = Integer.toString(amountInDollarsInteger);
        Toast.makeText(this, amountNaira + " naira(#) " + " is " + amountInDollarsString + " dollars($)", Toast.LENGTH_LONG).show();
//        Log.i("amount in dollars", amountInDollarsString);
    }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getApplicationContext(),lowHigh.class);
                startActivity(next);
            }
        });



        }
    }




