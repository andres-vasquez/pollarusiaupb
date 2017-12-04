package com.pollarusia2018.pollaupb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StatisticsActivity extends AppCompatActivity {

    private TextView titleTextView, scoreTextView, statisticsTextView;
    private ImageView teamOneImageView, teamTwoImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        titleTextView = (TextView) findViewById(R.id.titleTextView);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        statisticsTextView = (TextView) findViewById(R.id.statisticsTextView);
        teamOneImageView = (ImageView) findViewById(R.id.teamOneImageView);
        teamTwoImageView = (ImageView) findViewById(R.id.teamTwoImageView);
    }
}
