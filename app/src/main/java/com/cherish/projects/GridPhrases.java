package com.cherish.projects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class GridPhrases extends AppCompatActivity {
    public void  speak(View view){
        Button voice = (Button)view;
        Log.i("info",voice.getTag().toString());
        MediaPlayer speaking = MediaPlayer.create(this, getResources().getIdentifier(voice.getTag().toString(), "raw", getPackageName()));
        speaking.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_phrases);
        Button back = findViewById(R.id.next);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextPage = new Intent(getApplicationContext(), TimesTable.class);
                startActivity(nextPage);
            }
        });

    }
}
