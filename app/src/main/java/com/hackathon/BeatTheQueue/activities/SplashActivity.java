package com.hackathon.BeatTheQueue.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.hackathon.BeatTheQueue.R;
import com.hackathon.BeatTheQueue.repo.BTQSharedPreferences;
import com.hackathon.BeatTheQueue.reusable.constants.StringConstants;
import com.hackathon.BeatTheQueue.reusable.gcm.GCMManager;


public class SplashActivity extends AppCompatActivity {

    private GCMManager mGcmManager;
    private BTQSharedPreferences mBTQSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        messageHandler.sendEmptyMessageDelayed(0, 2000);
        mGcmManager = new GCMManager();
        mBTQSharedPreferences = new BTQSharedPreferences(this);
        if (mBTQSharedPreferences.getString(StringConstants.PREF_GCM_REG_ID, "").equals(""))
            mGcmManager.registerToGCM(this);
        System.out.print("GCM ID: "+ mBTQSharedPreferences.getString(StringConstants.PREF_GCM_REG_ID, ""));
    }

    private Handler messageHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            SplashActivity.this.finish();
        }
    };

}
