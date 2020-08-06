package com.cherish.projects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class TimesTable extends AppCompatActivity {
    ListView listView;
    int TimesTableNumber;

    public  void generateTimesTable(int TimesTableNumber) {
        ArrayList<String>TimesTable = new ArrayList<String>();
        for(int j = 0; j<=50; j++){
            TimesTable.add(Integer.toString(j*TimesTableNumber));
        }
        ArrayAdapter<String>TimesTableAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, TimesTable);
        listView.setAdapter(TimesTableAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times_table);
        Button nextPage = (Button)findViewById(R.id.next);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getApplicationContext(), EggTimer.class);
                startActivity(next);
            }
        });



        SeekBar seekBar = (SeekBar) findViewById(R.id.TableSeekBar);
        listView = (ListView) findViewById(R.id.TableListView);
        seekBar.setMax(50);
        seekBar.setProgress(10);
        generateTimesTable(TimesTableNumber = 50);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                if (progress < min){
                    TimesTableNumber = min;
                    seekBar.setProgress(min);
                }else{
                    TimesTableNumber  = progress;
                }
                Log.i("seekbar",Integer.toString(TimesTableNumber));
                generateTimesTable(TimesTableNumber);

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
