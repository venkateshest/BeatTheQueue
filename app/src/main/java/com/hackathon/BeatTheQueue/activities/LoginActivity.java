package com.hackathon.BeatTheQueue.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hackathon.BeatTheQueue.R;
import com.hackathon.BeatTheQueue.repo.BTQSharedPreferences;
import com.hackathon.BeatTheQueue.reusable.constants.StringConstants;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private BTQSharedPreferences BTQSharedPreferences;
    private Button mBtnSignIn;
    private EditText mETUsername;
    private EditText mETPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        BTQSharedPreferences = new BTQSharedPreferences(this);
        if (BTQSharedPreferences.getString(StringConstants.PREF_DONAR_USERNAME, "").equals("")) {
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
        BTQSharedPreferences.putString(StringConstants.PREF_DONAR_USERNAME, "salesperson@gmail.com");
        BTQSharedPreferences.putString(StringConstants.PREF_DONAR_PASSWORD, "salesperson");
        BTQSharedPreferences.putString(StringConstants.PREF_DONAR_GCM_REG_ID, "");
        BTQSharedPreferences.putString(StringConstants.PREF_REQUESTER_USERNAME, "customer@gmail.com");
        BTQSharedPreferences.putString(StringConstants.PREF_REQUESTER_PASSWORD, "customer");
        BTQSharedPreferences.putString(StringConstants.PREF_REQUESTER_GCM_REG_ID, "APA91bFzPYdjYG5hcjPkLm6fGlToclwCbYs0iOlZeY-LDpbFCf-Jv17QhvHoL7fynKnYb2Hk0vtKsHYbeZjWNbka0Ky1JM2EAIhU46M20_ACfCj3ybmoEGWjqAFVCYOU3OU22UkPuTfJ");
        BTQSharedPreferences.putString(StringConstants.PREF_AMBULANCE_USERNAME, "ambulance@gmail.com");
        BTQSharedPreferences.putString(StringConstants.PREF_AMBULANCE_PASSWORD, "ambulance");
        BTQSharedPreferences.putString(StringConstants.PREF_AMBULANCE_GCM_REG_ID, "");

    }

    @Override
    public void onClick(View view) {
//        if (mETPassword.getText().toString().isEmpty() || mETUsername.getText().toString().isEmpty()) {
//            Toast.makeText(LoginActivity.this, "Please enter valid credential", Toast.LENGTH_SHORT).show();
//        } else {
//            startActivity(new Intent(LoginActivity.this, CartViewActivity.class));
//        }
        if (mETUsername.getText().toString().contains(BTQSharedPreferences.getString(StringConstants.PREF_DONAR_USERNAME, ""))
                && mETPassword.getText().toString().contains(BTQSharedPreferences.getString(StringConstants.PREF_DONAR_PASSWORD, ""))) {
            startActivity(new Intent(LoginActivity.this, HomeActivty.class));
            BTQSharedPreferences.putString(StringConstants.PREF_APP_TYPE, StringConstants.APP_TYPE_NON_AMBULANCE);
        } else if (mETUsername.getText().toString().contains(BTQSharedPreferences.getString(StringConstants.PREF_REQUESTER_USERNAME, ""))
                && mETPassword.getText().toString().contains(BTQSharedPreferences.getString(StringConstants.PREF_REQUESTER_PASSWORD, ""))) {
            BTQSharedPreferences.putString(StringConstants.PREF_APP_TYPE, StringConstants.APP_TYPE_AMBULANCE);
        startActivity(new Intent(LoginActivity.this, CartViewActivity.class));
        } else {
            mETUsername.setText("");
            mETPassword.setText("");
        }
    }
}
