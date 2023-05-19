package com.example.ex081;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author    Ori Roitzaid <or1901 @ bs.amalnet.k12.il>
 * @version	  1
 * @since	  20/5/2023
 * An activity of game with two buttons - one with long click, and the other with short click.
 * Also there is a button which moves the user to the results activity.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        View.OnLongClickListener {
    Button redBtn;
    Button blueBtn;
    Button resultsBtn;
    int redCounter, blueCounter;
    Intent si;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redBtn = findViewById(R.id.redBtn);
        blueBtn = findViewById(R.id.blueBtn);
        resultsBtn = findViewById(R.id.resultBtn);

        redBtn.setOnClickListener(this);
        blueBtn.setOnLongClickListener(this);
        resultsBtn.setOnClickListener(this);

        redCounter = blueCounter = 0;
    }

    /**
     * This function updates the counter of the red button, and also moves to the next activity
     * when the gray button is clicked.
     * <p>
     *
     * @param v The view object of the clicked button.
     */
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.redBtn)
            redCounter++;
        else
        {
            si = new Intent(this, ResultsActivity.class);

            si.putExtra("Red", redCounter);
            si.putExtra("Blue", blueCounter);
            startActivity(si);
        }
    }

    /**
     * This function updates the counter of the blue button when it's clicked.
     * <p>
     *
     * @param v The view object of the clicked button.
     */
    @Override
    public boolean onLongClick(View v) {
        blueCounter += 2;
        return false;
    }
}