package com.hackathon.dropbydrop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hackathon.dropbydrop.R;
import com.hackathon.dropbydrop.repo.DRDSharedPreferences;
import com.hackathon.dropbydrop.reusable.constants.StringConstants;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private DRDSharedPreferences drdSharedPreferences;
    private Button mBtnSignIn;
    private EditText mETUsername;
    private EditText mETPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        drdSharedPreferences = new DRDSharedPreferences(this);
        if (drdSharedPreferences.getString(StringConstants.PREF_DONAR_USERNAME, "").equals("")) {
            setSPValues();
        }
        mBtnSignIn = (Button) findViewById(R.id.btn_sign_in);
        mBtnSignIn.setOnClickListener(this);
        mETUsername = (EditText) findViewById(R.id.et_usernmae);
        mETPassword = (EditText) findViewById(R.id.et_pwd);

       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    private void setSPValues() {
        drdSharedPreferences.putString(StringConstants.PREF_DONAR_USERNAME, "donar@gmail.com");
        drdSharedPreferences.putString(StringConstants.PREF_DONAR_PASSWORD, "donar");
        drdSharedPreferences.putString(StringConstants.PREF_DONAR_GCM_REG_ID, "");
        drdSharedPreferences.putString(StringConstants.PREF_REQUESTER_USERNAME, "requester@gmail.com");
        drdSharedPreferences.putString(StringConstants.PREF_REQUESTER_PASSWORD, "requester");
        drdSharedPreferences.putString(StringConstants.PREF_REQUESTER_GCM_REG_ID, "APA91bFzPYdjYG5hcjPkLm6fGlToclwCbYs0iOlZeY-LDpbFCf-Jv17QhvHoL7fynKnYb2Hk0vtKsHYbeZjWNbka0Ky1JM2EAIhU46M20_ACfCj3ybmoEGWjqAFVCYOU3OU22UkPuTfJ");
        drdSharedPreferences.putString(StringConstants.PREF_AMBULANCE_USERNAME, "ambulance@gmail.com");
        drdSharedPreferences.putString(StringConstants.PREF_AMBULANCE_PASSWORD, "ambulance");
        drdSharedPreferences.putString(StringConstants.PREF_AMBULANCE_GCM_REG_ID, "");

    }

    @Override
    public void onClick(View view) {
        if (mETUsername.getText().toString().contains(drdSharedPreferences.getString(StringConstants.PREF_DONAR_USERNAME, ""))
                && mETPassword.getText().toString().contains(drdSharedPreferences.getString(StringConstants.PREF_DONAR_PASSWORD, ""))) {
            startActivity(new Intent(LoginActivity.this, HomeActivty.class));
            drdSharedPreferences.putString(StringConstants.PREF_APP_TYPE, StringConstants.APP_TYPE_NON_AMBULANCE);
        } else if (mETUsername.getText().toString().contains(drdSharedPreferences.getString(StringConstants.PREF_REQUESTER_USERNAME, ""))
                && mETPassword.getText().toString().contains(drdSharedPreferences.getString(StringConstants.PREF_REQUESTER_PASSWORD, ""))) {
            startActivity(new Intent(LoginActivity.this, HomeActivty.class));
            drdSharedPreferences.putString(StringConstants.PREF_APP_TYPE, StringConstants.APP_TYPE_NON_AMBULANCE);
        } else if (mETUsername.getText().toString().contains(drdSharedPreferences.getString(StringConstants.PREF_AMBULANCE_USERNAME, ""))
                && mETPassword.getText().toString().contains(drdSharedPreferences.getString(StringConstants.PREF_AMBULANCE_PASSWORD, ""))) {
            drdSharedPreferences.putString(StringConstants.PREF_APP_TYPE, StringConstants.APP_TYPE_AMBULANCE);
            startActivity(new Intent(LoginActivity.this, VanHomeActivity.class));
        } else {
            mETUsername.setText("");
            mETPassword.setText("");
        }
    }
}
