package com.cherish.projects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class lowHigh extends AppCompatActivity {
    private Button change;
    int randomNumbers;

    public  void generateRandomNumbers(){
        Random random = new Random();


        randomNumbers = random.nextInt(50) + 1;
    }

    public void guessNumber(View view){

        EditText guessInput = (EditText)findViewById(R.id.guessInput);
        String message;

        if(TextUtils.isEmpty(guessInput.getText().toString())){
            message = "pls enter a number";
        }else {
            int guessInt = Integer.parseInt(guessInput.getText().toString());


            if (guessInt > randomNumbers) {

                message = "ops guess a lower number";

            } else if (guessInt < randomNumbers) {
                message = "ops guess a higher number";

            } else {
                message = "Smile, yeah! you got it right, Try again ";
                generateRandomNumbers();

            }
        }


        Log.i("RandomNumbers", Integer.toString(randomNumbers));
        Log.i("EnteredValue", guessInput.getText().toString());
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_high);
        generateRandomNumbers();

        change = findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fav = new Intent(getApplicationContext(), recSquare.class);
                startActivity(fav);
            }
        });

    }




}
