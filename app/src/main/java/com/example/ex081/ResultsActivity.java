package com.example.ex081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ResultsActivity extends AppCompatActivity {
    Intent gi;
    int redResult, blueResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        gi = getIntent();

        redResult = gi.getIntExtra("Red", 0);
        blueResult = gi.getIntExtra("Blue", 0);
    }
}