package com.hackathon.dropbydrop.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hackathon.dropbydrop.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProfileActivity extends AppCompatActivity {

    private ImageView mImgViewHeadBack;
    private RelativeLayout rrHeader;
    private ImageView iv_noti;
    private ImageView iv_options;
    private TextView textViewdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initHeader();
        textViewdate = (TextView) findViewById(R.id.tv_birth_day);
        textViewdate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    final Calendar c = Calendar.getInstance();
                    int year = c.get(Calendar.YEAR);
                    int month = c.get(Calendar.MONTH);
                    int day = c.get(Calendar.DAY_OF_MONTH);
                    new DatePickerDialog(ProfileActivity.this, myDateListener, year, month, day).show();
                }
                return true;
            }

        });
    }
    private void initHeader(){
        mImgViewHeadBack = (ImageView) findViewById(R.id.iv_head_back);
        TextView textViewHeaderText = (TextView) findViewById(R.id.header_text);
        textViewHeaderText.setText(R.string.lbl_your_profile);
        textViewHeaderText.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        mImgViewHeadBack.setBackground(getResources().getDrawable(R.mipmap.back_red));
        rrHeader = (RelativeLayout)findViewById(R.id.main_header);
        rrHeader.setBackgroundColor(getResources().getColor(R.color.white));
        iv_noti = (ImageView)findViewById(R.id.notification);
        iv_noti.setBackground(getResources().getDrawable(R.mipmap.notification_red_complete));
        iv_options=(ImageView) findViewById(R.id.option_menu);
        iv_options.setBackground(getResources().getDrawable(R.mipmap.more_red));
        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileActivity.this.finish();
            }
        });
       // mImgViewHeadBack.setOnClickListener(this);
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int month, int day) {
            month = month+1;
            SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
            String dateInString = day+" "+month+" "+year;

            try {

                Date date = formatter.parse(dateInString);
                System.out.println(date);
                System.out.println(formatter.format(date));

                textViewdate.setText(formatter1.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    };
}
