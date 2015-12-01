package com.hackathon.dropbydrop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hackathon.dropbydrop.DropByDropApplication;
import com.hackathon.dropbydrop.R;
import com.hackathon.dropbydrop.data.NotificationDTO;
import com.hackathon.dropbydrop.repo.DRDSharedPreferences;
import com.hackathon.dropbydrop.reusable.constants.StringConstants;
import com.google.gson.Gson;
import com.hackathon.dropbydrop.reusable.gcm.PushNotification;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class BackGroundActivity extends AppCompatActivity implements OnClickListener {

    private ImageView mImgViewHeadBack;
    private TextView mTextViewDonarAge;
    private TextView mTextViewDonarBloodGroup;
    private TextView mTextViewDonarName;
    private ImageView mImgViewDonarImage;
    private Switch mSwitchEmptyStomach;
    private Switch mSwitchIndulgence;
    private Switch mSwitchRecentSur;
    private Switch mSwitchAlcoholCon;
    private Switch mSwitchAnyDis;
    private TextView mTxtViewEmptySto;
    private TextView mTxtViewAnyDis;
    private TextView mTxtViewIndulgence;
    private TextView mTxtViewRecentSur;
    private TextView mTxtViewAlcohol;
    private Button mBtnDone;
    private DRDSharedPreferences drdSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_ground);
        init();
    }

    private void init() {
        initHeader();
        drdSharedPreferences = new DRDSharedPreferences(this);
        mTextViewDonarAge = (TextView) findViewById(R.id.tv_donar_age);
        mTextViewDonarBloodGroup = (TextView) findViewById(R.id.tv_donar_blood_group);
        mTextViewDonarName = (TextView) findViewById(R.id.tv_donar_name);
        mImgViewDonarImage = (ImageView) findViewById(R.id.iv_donar_image);
        mSwitchEmptyStomach = (Switch)findViewById(R.id.swtich_empty_stomach);
        mTxtViewEmptySto = (TextView)findViewById(R.id.tv_yes_empty_stomach);
        mSwitchEmptyStomach.setChecked(true);
        mSwitchEmptyStomach.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mTxtViewEmptySto.setText("YES");
                } else {
                    mTxtViewEmptySto.setText("NO");
                }
            }
        });
        mSwitchIndulgence = (Switch)findViewById(R.id.swtich_indulgence);
        mTxtViewIndulgence = (TextView)findViewById(R.id.tv_yes_indulgence);
        mTxtViewIndulgence.setText("NO");
        mSwitchIndulgence.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mTxtViewIndulgence.setText("YES");
                } else {
                    mTxtViewIndulgence.setText("NO");
                }
            }
        });
        mSwitchRecentSur = (Switch)findViewById(R.id.swtich_recent_surgeries);
        mTxtViewRecentSur = (TextView)findViewById(R.id.tv_yes_recent_surgeries);
        mTxtViewRecentSur.setText("NO");
        mSwitchRecentSur.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mTxtViewRecentSur.setText("YES");
                } else {
                    mTxtViewRecentSur.setText("NO");
                }
            }
        });
        mSwitchAlcoholCon = (Switch)findViewById(R.id.swtich_alcohol_consumption);
        mTxtViewAlcohol = (TextView)findViewById(R.id.tv_yes_alcohol_consumption);
        mTxtViewAlcohol.setText("NO");
        mSwitchAlcoholCon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mTxtViewAlcohol.setText("YES");
                } else {
                    mTxtViewAlcohol.setText("NO");
                }
            }
        });
        mSwitchAnyDis = (Switch)findViewById(R.id.swtich_any_diseases);
        mTxtViewAnyDis = (TextView)findViewById(R.id.tv_yes_any_diseases);
        mTxtViewAnyDis.setText("NO");
        mSwitchAnyDis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mTxtViewAnyDis.setText("YES");
                } else {
                    mTxtViewAnyDis.setText("NO");
                }
            }
        });

        mBtnDone = (Button)findViewById(R.id.btn_done);
        mBtnDone.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drdSharedPreferences.getString(StringConstants.PREF_APP_TYPE, "").contains(StringConstants.APP_TYPE_NON_AMBULANCE)) {
                    Intent intent = getIntent();
                    NotificationDTO dto = new NotificationDTO();
                    dto.setName("Srikanth");
                    dto.setAddress("JP nagar, Bangalore");
                    dto.setPhoneNo("+91-9036546774");
                    dto.setBloodGroup("B+ve blood donor");
                    dto.setLat(DropByDropApplication.currentLat);
                    dto.setStatus("Pending");
                    dto.setLongt(DropByDropApplication.currentLong);
                    dto.setDate(intent.getStringExtra(StringConstants.DONATE_DATE));
                    dto.setToTime(intent.getStringExtra(StringConstants.DONATE_TO_TIME));
                    dto.setFromTime(intent.getStringExtra(StringConstants.DONATE_FROM_TIME));
                    Gson gson = new Gson();
                    String stringDonateJson = gson.toJson(dto);
                    JSONObject jsonObj = null;
                    try {
                        jsonObj = new JSONObject(stringDonateJson);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                        JSONArray regIds = new JSONArray();
                        regIds.put(StringConstants.GCM_OFFICE_NEXUS);
                    PushNotification pushNoti = new PushNotification(jsonObj, regIds);
                    pushNoti.sendPush();
                } else {
                    // For Ambulance
                }
            }
        });

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
