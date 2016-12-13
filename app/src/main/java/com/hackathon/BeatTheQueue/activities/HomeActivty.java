package com.hackathon.BeatTheQueue.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hackathon.BeatTheQueue.R;


public class HomeActivty extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        (findViewById(R.id.take_away)).setOnClickListener(this);
        (findViewById(R.id.home_delivery)).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(HomeActivty.this, SimpleScannerActivity.class);
        if (v.getId() == R.id.take_away) {
            intent.putExtra("take_away", true);
        } else {
            intent.putExtra("take_away", false);
        }
        startActivity(intent);
    }
}
