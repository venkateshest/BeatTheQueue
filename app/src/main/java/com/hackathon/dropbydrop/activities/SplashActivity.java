package com.hackathon.dropbydrop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.hackathon.dropbydrop.R;
import com.hackathon.dropbydrop.repo.DRDSharedPreferences;
import com.hackathon.dropbydrop.reusable.constants.StringConstants;
import com.hackathon.dropbydrop.reusable.gcm.GCMManager;


public class SplashActivity extends AppCompatActivity {

    private GCMManager mGcmManager;
    private DRDSharedPreferences mDrdSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        messageHandler.sendEmptyMessageDelayed(0, 2000);
        mGcmManager = new GCMManager();
        mDrdSharedPreferences = new DRDSharedPreferences(this);
        if (mDrdSharedPreferences.getString(StringConstants.PREF_GCM_REG_ID, "").equals(""))
            mGcmManager.registerToGCM(this);
    }

    private Handler messageHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            SplashActivity.this.finish();
        }
    };

}
