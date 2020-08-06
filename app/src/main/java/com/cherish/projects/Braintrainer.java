package com.cherish.projects;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Braintrainer extends AppCompatActivity {
    LinearLayout gameTemplate;
    LinearLayout goTemplate;
    TextView countDown;
    TextView question;
    TextView resultText;
    TextView displayScores;
    ImageView resultImage;
    TextView timeUpText;
    ImageView timeUpImage;
    int locationOfCorrectAnswer;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    int scores;
    int numberOfQuestions = 0;
    MediaPlayer myplayer;
    MediaPlayer stopPlayer;
    Button playagainBtn;
    CountDownTimer countDownTimer;
//    String[] questions = {"2 + 2", "3 + 3", "4 + 4", "5 + 5", "7 + 7" };


    ArrayList<Integer>answers = new ArrayList<Integer>();

    public  void  playAgain(View view){
        timeUpText.setVisibility(View.INVISIBLE);
        timeUpImage.setVisibility(View.INVISIBLE);
        resultImage.setVisibility(View.VISIBLE);
        resultText.setVisibility(View.VISIBLE);
        scores = 0;
        numberOfQuestions = 0;
        countDown.setText("0:0");
        displayScores.setText("0/0");
        playagainBtn.setVisibility(View.INVISIBLE);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        displayScores.setText(Integer.toString(scores) + "/" + Integer.toString(numberOfQuestions));
        newQuestion();


        countDownTimer = new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
//                countDown.setText((int) millisUntilFinished / 1000 + "s");
                countDown.setText(String.valueOf(millisUntilFinished/1000) + "s");
                resultImage.setVisibility(View.INVISIBLE);
                resultText.setVisibility(View.INVISIBLE);
                myplayer.start();
            }

            @Override
            public void onFinish() {

                timeUpText.setVisibility(View.VISIBLE);
                timeUpImage.setVisibility(View.VISIBLE);
                resultText.setVisibility(View.INVISIBLE);
                resultImage.setVisibility(View.INVISIBLE);
                myplayer.pause();
                stopPlayer.start();
                playagainBtn.setVisibility(View.VISIBLE);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);


            }
        }.start();





    }

    public void changeQuestion(View view){
        if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())){

            resultText.setText("CORRECT");
            resultImage.setImageResource(R.drawable.correct1);
            scores++;
        } else{
            resultText.setText("WRONG");
            resultImage.setImageResource(R.drawable.wrong1);
        }
        resultImage.setVisibility(View.VISIBLE);
        resultText.setVisibility(View.VISIBLE);
        numberOfQuestions++;
        displayScores.setText(Integer.toString(scores) + "/" + Integer.toString(numberOfQuestions));
        newQuestion();
    }

    public  void gameShow(final View view){
        gameTemplate.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.resultText));
        goTemplate.setVisibility(View.INVISIBLE);

//        countDownTimer = new CountDownTimer(31000, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
////                countDown.setText((int) millisUntilFinished / 1000 + "s");
//                countDown.setText(String.valueOf(millisUntilFinished/1000) + "s");
//                myplayer.start();
//            }
//
//            @Override
//            public void onFinish() {
//                timeUpText.setVisibility(view.getVisibility());
//                timeUpImage.setVisibility(View.VISIBLE);
//                resultText.setVisibility(View.INVISIBLE);
//                resultImage.setVisibility(View.INVISIBLE);
//                myplayer.pause();
//                stopPlayer.start();
//                playagainBtn.setVisibility(View.VISIBLE);
//
//
//            }
//        }.start();
////
    }


    public  void newQuestion(){
        Random randomNumbers = new Random();
        int a = randomNumbers.nextInt(10);
        int b = randomNumbers.nextInt(10);
        String aString = Integer.toString(a);
        String bString = Integer.toString(b);
        question.setText(aString + "+" + bString);

        locationOfCorrectAnswer = randomNumbers.nextInt(4);
        answers.clear();

        for (int i= 0; i<4; i++){
            if (i == locationOfCorrectAnswer){
                answers.add(a+b);
            }else {
                int wrongAnswer = randomNumbers.nextInt(25);
                while (wrongAnswer == a+b){
                    wrongAnswer = randomNumbers.nextInt(25);
                }
                answers.add(wrongAnswer);
            }
        }
        button1.setText(Integer.toString(answers.get(0)));
        button2.setText(Integer.toString(answers.get(1)));
        button3.setText(Integer.toString(answers.get(2)));
        button4.setText(Integer.toString(answers.get(3)));
    }




//    public void countdown(int secondsLeft){n
//        int  seconds = secondsLeft;
//        String  stringSeconds = Integer.toString(seconds);
//
//        if(seconds<=9){
//            stringSeconds = "0" + seconds;
//        }
//        countDown.setText( stringSeconds);
//    }

//    public void random(){
//        Random randomQuestion = new Random();
//        String random = questions[randomQuestion.nextInt(5)];
//        question.setText(random);
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braintrainer);
        displayScores = findViewById(R.id.displayScores);
        gameTemplate = findViewById(R.id.gameTemplate);
        goTemplate = findViewById(R.id.goTemplate);
        countDown = (TextView)findViewById(R.id.countDown);
        question = findViewById(R.id.question);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        resultText = findViewById(R.id.resultText);
        resultImage = findViewById(R.id.resultImage);
        displayScores = findViewById(R.id.displayScores);
        timeUpText = findViewById(R.id.timeUpText);
        timeUpImage = findViewById(R.id.timeUpImage);
        myplayer = MediaPlayer.create(getApplicationContext(),R.raw.game);
        stopPlayer = MediaPlayer.create(getApplicationContext(),R.raw.endgame);
        playagainBtn = findViewById(R.id.PlayAgainBtn);





    }
}
