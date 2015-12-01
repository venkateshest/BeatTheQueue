package com.hackathon.dropbydrop.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackathon.dropbydrop.R;

public class BackGroundActivity extends AppCompatActivity implements OnClickListener {

    private ImageView mImgViewHeadBack;
    private TextView mTextViewDonarAge;
    private TextView mTextViewDonarBloodGroup;
    private TextView mTextViewDonarName;
    private ImageView mImgViewDonarImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_ground);
        init();
    }

    private void init() {
        initHeader();
        mTextViewDonarAge = (TextView) findViewById(R.id.tv_donar_age);
        mTextViewDonarBloodGroup = (TextView) findViewById(R.id.tv_donar_blood_group);
        mTextViewDonarName = (TextView) findViewById(R.id.tv_donar_name);
        mImgViewDonarImage = (ImageView) findViewById(R.id.iv_donar_image);
        setDonarDetails();
    }

    private void initHeader(){
        mImgViewHeadBack = (ImageView) findViewById(R.id.iv_head_back);
        TextView textViewHeaderText = (TextView) findViewById(R.id.header_text);
        textViewHeaderText.setText(R.string.lbl_background_details);
        mImgViewHeadBack.setBackground(getDrawable(R.mipmap.back_white));
        mImgViewHeadBack.setOnClickListener(this);
    }

    private void setDonarDetails() {
        mTextViewDonarAge.setText("asdfasdf");
        mTextViewDonarBloodGroup.setText("sdfsa");
        mTextViewDonarName.setText("dlsfjoas");
        mImgViewDonarImage.setBackground(getDrawable(R.mipmap.lets_save_a_life));
    }

    @Override
    public void onClick(View view) {

    }
}
