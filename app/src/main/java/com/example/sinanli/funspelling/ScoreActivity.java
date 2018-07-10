package com.example.sinanli.funspelling;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private TextView textView;

    private int highestScore;
    private int newScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView = (TextView) findViewById(R.id.highestScore);

        prefs = getSharedPreferences("value", MODE_PRIVATE);
        newScore = prefs.getInt("Score", 0);
        highestScore = prefs.getInt("highestScore", 0);


        if (newScore > highestScore){
            highestScore = newScore;
        }

        prefs.edit().putInt("highestScore", highestScore).apply();
        textView.setText("" + highestScore);
    }
}
