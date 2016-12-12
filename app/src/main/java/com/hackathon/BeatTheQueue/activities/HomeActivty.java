package com.hackathon.BeatTheQueue.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hackathon.BeatTheQueue.R;


public class HomeActivty extends AppCompatActivity {

    private ImageView mIvDonate;
    private ImageView mIvRequest;
    private ImageView mIvProfile;
    private ImageView profile_pic;
    private ImageView iv_noti;
    private RelativeLayout rrHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mIvDonate = (ImageView) findViewById(R.id.iv_donate);
        mIvRequest = (ImageView) findViewById(R.id.iv_request);
        mIvProfile = (ImageView) findViewById(R.id.iv_profile);
        profile_pic = (ImageView) findViewById(R.id.profile_pic);
        profile_pic.setBackground(getResources().getDrawable(R.mipmap.image));
        mIvDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

            }
        });

        initHeader();
    }

    private void initHeader(){
       findViewById(R.id.iv_head_back).setVisibility(View.GONE);
        TextView textViewHeaderText = (TextView) findViewById(R.id.header_text);
        textViewHeaderText.setPadding(200,0,0,0);
        rrHeader = (RelativeLayout) findViewById(R.id.main_header);
        rrHeader.setBackgroundColor(getResources().getColor(R.color.color_E6D13C3C));
        iv_noti = (ImageView) findViewById(R.id.notification);
        iv_noti.setBackground(getResources().getDrawable(R.mipmap.notification_white_complete));
    }

}
