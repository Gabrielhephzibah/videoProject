package com.cherish.projects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class recSquare extends AppCompatActivity {
    private Button next;

    class Number{
        int number;

        public  boolean is_square(){
            double squareNumber = Math.sqrt(number);
            if(squareNumber == Math.floor(squareNumber)){
                return true;
            }else {
                return false;
            }
        }


        public  boolean is_triangular(){
            int i = 1;
            int triangularNumber = 1;
            while(triangularNumber < number) {
                i++;

                triangularNumber = triangularNumber + i;
            }
            if(triangularNumber == number){
                return true;
            } else {
                return false;
            }
        }

    }

    public void test(View view){

        Log.i("info", "button clicked");
        EditText testEdit = (EditText) findViewById(R.id.testEdit);
        String message;
        if (testEdit.getText().toString().isEmpty()){
            message = "please enter a number";
        } else {
            Number first = new Number();
            first.number = Integer.parseInt(testEdit.getText().toString());
             message = testEdit.getText().toString();
            if (first.is_square() && first.is_triangular()) {
                message += " is a square and triangular number";
            } else if (first.is_square()) {
                message += " is a square number";
            } else if (first.is_triangular()) {
                message += " is a rectangular number";
            } else {
                message += " is neither a square or rectangular number";
            }
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_square);
        next = findViewById(R.id.nextPage);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nextapp = new Intent(getApplicationContext(), Connectgame.class);
                startActivity(nextapp);
            }
        });


    }
}
