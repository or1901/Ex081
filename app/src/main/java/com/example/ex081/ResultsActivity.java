package com.example.ex081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author    Ori Roitzaid <or1901 @ bs.amalnet.k12.il>
 * @version	  1
 * @since	  20/5/2023
 * An activity of the game results - it contains how much points each player gained in the previous
 * activity, and who won the game.
 */
public class ResultsActivity extends AppCompatActivity implements View.OnClickListener {
    TextView redTxt, blueTxt, winnerTxt;
    Intent gi;
    Button backBtn;
    int redResult, blueResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        redTxt = findViewById(R.id.redTxt);
        blueTxt = findViewById(R.id.blueTxt);
        winnerTxt = findViewById(R.id.winnerTxt);
        backBtn = findViewById(R.id.backBtn);

        gi = getIntent();

        redResult = gi.getIntExtra("Red", 0);
        blueResult = gi.getIntExtra("Blue", 0);

        redTxt.setText("" + redResult);
        blueTxt.setText("" + blueResult);

        showWinner(redResult, blueResult);

        backBtn.setOnClickListener(this);
    }

    /**
     * This function puts in the screen the message of declaration on the winner in the game.
     * @param redResult The red button overall points.
     * @param blueResult The blue button overall points.
     */
    public void showWinner(int redResult, int blueResult) {
        if(redResult > blueResult) {
            winnerTxt.setText("Red won!");
            winnerTxt.setTextColor(Color.parseColor("#E41505"));
        }
        else if(blueResult > redResult) {
            winnerTxt.setText("Blue won!");
            winnerTxt.setTextColor(Color.parseColor("#425AE1"));
        }
        else {
            winnerTxt.setText("It's a tie!");
            winnerTxt.setTextColor(Color.parseColor("#757171"));
        }
    }

    /**
     * This function moves the user back to the game activity.
     * <p>
     *
     * @param v The view object of the clicked button.
     */
    @Override
    public void onClick(View v) {
        finish();
    }
}