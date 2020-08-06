package com.cherish.projects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Connectgame extends AppCompatActivity {
        private  Button nextPage;
//        boolean activePlayer = true;
    // 0 = red, 1 = yellow, 2 = empty;
        int activePlayer = 0;
        int[] gameState = {2,2,2,2,2,2,2,2,2};
        int[][] winningPosition = {{0,1,2}, {3,4,5},{6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
        boolean gameActive = true;

    public  void  drop(View view){
       ImageView dropapples = (ImageView) view;

       int change = Integer.parseInt(dropapples.getTag().toString());
            if(gameState[change]==2 && gameActive) {
                gameState[change] = activePlayer;
                dropapples.setTranslationY(-1500);
                if (activePlayer == 0) {
                    dropapples.setImageResource(R.drawable.yellowapple);
                    activePlayer = 1;
                } else {
                    dropapples.setImageResource(R.drawable.redapple3);
                    activePlayer = 0;
                }


//       if(activePlayer==true){
//
//           dropapples.setImageResource(R.drawable.redapple3);
//           activePlayer =false;
//
//       } else {
//           dropapples.setImageResource(R.drawable.yellowapple);
//           activePlayer=true;
//       }

                dropapples.animate().translationYBy(1500).rotation(3600).setDuration(500);
                for (int[] apples : winningPosition) {
                    if (gameState[apples[0]] == gameState[apples[1]] && gameState[apples[1]] == gameState[apples[2]] && gameState[apples[0]] != 2) {
                        //someone has won
                        gameActive = false;
                        String winner = "";
                        if (activePlayer == 1) {
                            winner = "yellow";

                        } else {
                            winner = "red";
                        }


                        Toast.makeText(this, winner + " has won", Toast.LENGTH_SHORT).show();

                        Button playAgain = (Button)findViewById(R.id.PlayAgainBtn);
                        TextView winningText = (TextView)findViewById(R.id.winningText);
                        winningText.setText(winner + " has won");
                        winningText.setVisibility(View.VISIBLE);
                        playAgain.setVisibility(View.VISIBLE);


                    }
                }
            }


    }

public  void  play(View view){

    Log.i("info","clicked");
    Button playAgain = (Button)findViewById(R.id.PlayAgainBtn);
    TextView winningText = (TextView)findViewById(R.id.winningText);
    winningText.setVisibility(View.INVISIBLE);
    playAgain.setVisibility(View.INVISIBLE);
    GridLayout gridLayout = (GridLayout)findViewById(R.id.gridlayout);

        for(int i=0; i<gridLayout.getChildCount(); i++) {
            ImageView apple = (ImageView) gridLayout.getChildAt(i);

            apple.setImageDrawable(null);


        }

        for(int i = 0; i < gameState.length; i++){
            gameState[i] = 2;
        }

     activePlayer = 0;
        gameActive = true;


}

    //    public void  playAgain(View view){
//
//        Button playAgain = (Button)findViewById(R.id.PlayAgainBtn);
//        TextView winningText = (TextView)findViewById(R.id.winningText);
//        winningText.setVisibility(View.INVISIBLE);
//        playAgain.setVisibility(View.INVISIBLE);
//        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridlayout);
//
//        for(int i=0; i<gridLayout.getChildCount(); i++) {
//            ImageView apple = (ImageView) gridLayout.getChildAt(i);
//
//            apple.setImageDrawable(null);
//
//
//        }
//       null int activePlayer = 0;
//        int[] gameState = {2,2,2,2,2,2,2,2,2};
//        boolean gameActive = true;
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connectgame);
        nextPage = findViewById(R.id.next);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getApplicationContext(),GridPhrases.class);
                startActivity(next);
            }
        });
    }
}
