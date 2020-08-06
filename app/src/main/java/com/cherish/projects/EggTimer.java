package com.cherish.projects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class EggTimer extends AppCompatActivity {
    Button next;
    TextView textView;
    SeekBar seekBar;
    boolean timerWatchIsActive = false;
    Button startTimer;
    CountDownTimer countDownTimer;
    MediaPlayer myplayer;

        public  void  resetTimer(){
            textView.setText("00:10");
            seekBar.setProgress(10);
            seekBar.setEnabled(true);
            countDownTimer.cancel();
            startTimer.setText("GO");
            timerWatchIsActive=false;


        }

    public  void start(View view){
        if(timerWatchIsActive){
             resetTimer();



        }else {

            timerWatchIsActive = true;
            seekBar.setEnabled(false);
            startTimer.setText("STOP");

             countDownTimer = new CountDownTimer(seekBar.getProgress() * 1000 + 100, 1000) {


                @Override
                public void onTick(long millisUntilFinished) {


                }

                @Override
                public void onFinish() {
                     myplayer= MediaPlayer.create(EggTimer.this, R.raw.alarm);
                    myplayer.start();
                    resetTimer();
                }
            }.start();
        }


    }


    public void  updateTimer(int secondsLeft){
        int  minutes = secondsLeft/ 60;
        int seconds = secondsLeft - (minutes * 60);

        String stringMinutes = Integer.toString(minutes);
        String  stringSeconds = Integer.toString(seconds);

        if(minutes<=9){
            stringMinutes = "0" + minutes;
        }
        if(seconds<=9){
            stringSeconds = "0" + seconds;
        }
        textView.setText(stringMinutes + ":" + stringSeconds);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg_timer);
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next  = new Intent(getApplicationContext(),Braintrainer.class);
                startActivity(next);
            }
        });
            startTimer = findViewById(R.id.start_button);
         seekBar= (SeekBar) findViewById(R.id.seek_bar);
         textView = (TextView)findViewById(R.id.stop_watch);
        seekBar.setMax(600);
        seekBar.setProgress(10);
         seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
             @Override
             public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                 updateTimer(progress);

             }

             @Override
             public void onStartTrackingTouch(SeekBar seekBar) {

             }

             @Override
             public void onStopTrackingTouch(SeekBar seekBar) {

             }
         });



    }
}
