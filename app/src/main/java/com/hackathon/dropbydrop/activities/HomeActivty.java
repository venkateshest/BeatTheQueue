package com.hackathon.dropbydrop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.hackathon.dropbydrop.R;


public class HomeActivty extends AppCompatActivity {

    private ImageView mIvDonate;
    private ImageView mIvRequest;
    private ImageView mIvProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mIvDonate = (ImageView) findViewById(R.id.iv_donate);
        mIvRequest = (ImageView) findViewById(R.id.iv_request);
        mIvProfile = (ImageView) findViewById(R.id.iv_profile);

        mIvDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivty.this, DonateActivity.class);
                startActivity(intent);
            }
        });
        mIvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mIvRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivty.this, RequestActivity.class);
                startActivity(intent);
            }
        });
    }

}
