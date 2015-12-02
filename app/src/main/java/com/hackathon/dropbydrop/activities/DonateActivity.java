package com.hackathon.dropbydrop.activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hackathon.dropbydrop.DropByDropApplication;
import com.hackathon.dropbydrop.R;
import com.hackathon.dropbydrop.data.NotificationDTO;
import com.hackathon.dropbydrop.reusable.constants.StringConstants;
import com.hackathon.dropbydrop.utils.MapWrapperLayout;
import com.hackathon.dropbydrop.utils.UIUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DonateActivity extends AppCompatActivity {

    MapWrapperLayout mWrapperLayout;
    MapView mMapView;
    GoogleMap map;

    EditText location;
    EditText etDate;
    EditText etFromTime;
    EditText etToTime;
    Button mBtnMoreDetails;
    String selectedDate;
    String selectedFromTime;
    String selectedToTime;
    private RelativeLayout rrHeader;
    private ImageView iv_noti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        mMapView = (MapView) findViewById(R.id.stop_details_map);
        mWrapperLayout = (MapWrapperLayout) findViewById(R.id.wrapperlayout_stop_details_map);
        mMapView.onCreate(savedInstanceState);


        location = (EditText) findViewById(R.id.et_location);
        location.setText("3rd phase, JP Nagar, Bangalore");
        etDate = (EditText) findViewById(R.id.et_date);
        etFromTime = (EditText) findViewById(R.id.from_picker);
        etToTime = (EditText) findViewById(R.id.to_picker);
        TextView textViewHeaderText = (TextView) findViewById(R.id.header_text);
        textViewHeaderText.setText(R.string.lbl_donate_blood);
        rrHeader = (RelativeLayout) findViewById(R.id.main_header);
        rrHeader.setBackgroundColor(getResources().getColor(R.color.color_E6D13C3C));
        iv_noti = (ImageView) findViewById(R.id.notification);
        iv_noti.setBackground(getResources().getDrawable(R.mipmap.notification_white_complete));
        mBtnMoreDetails = (Button) findViewById(R.id.more_details);
        mBtnMoreDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DonateActivity.this, BackGroundActivity.class);
                intent.putExtra(StringConstants.DONATE_DATE, selectedDate);
                intent.putExtra(StringConstants.DONATE_FROM_TIME, selectedFromTime);
                intent.putExtra(StringConstants.DONATE_TO_TIME, selectedToTime);
                intent.putExtra(StringConstants.DONATE_AT_LAT, DropByDropApplication.currentLat);
                intent.putExtra(StringConstants.DONATE_AT_LONG, DropByDropApplication.currentLong);
                startActivity(intent);
                DonateActivity.this.finish();
            }
        });
        etDate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    final Calendar c = Calendar.getInstance();
                    int year = c.get(Calendar.YEAR);
                    int month = c.get(Calendar.MONTH);
                    int day = c.get(Calendar.DAY_OF_MONTH);
                    new DatePickerDialog(DonateActivity.this, myDateListener, year, month, day).show();
                }
                return true;
            }

        });
        etFromTime.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    final Calendar c = Calendar.getInstance();
                    int hour = c.get(Calendar.HOUR_OF_DAY);
                    int minute = c.get(Calendar.MINUTE);

                    // Create a new instance of TimePickerDialog and return it
                    new TimePickerDialog(DonateActivity.this, myTimeListener, hour, minute,
                            DateFormat.is24HourFormat(DonateActivity.this)).show();
                }
                return true;
            }
        });

        etToTime.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    final Calendar c = Calendar.getInstance();
                    int hour = c.get(Calendar.HOUR_OF_DAY);
                    int minute = c.get(Calendar.MINUTE);

                    // Create a new instance of TimePickerDialog and return it
                    new TimePickerDialog(DonateActivity.this, toTimeListener, hour, minute,
                            DateFormat.is24HourFormat(DonateActivity.this)).show();
                }
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
        try {
            MapsInitializer.initialize(getApplicationContext());
            map = mMapView.getMap();
            mWrapperLayout.init(map, getPixelsFromDp(this, 39 + 20));
            map.getUiSettings().setMyLocationButtonEnabled(true);
            map.getUiSettings().setZoomControlsEnabled(false);
            map.setMyLocationEnabled(false);
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            map.addMarker(new MarkerOptions().position(new LatLng(DropByDropApplication.currentLat,
                    DropByDropApplication.currentLong)))
                    .setIcon(
                            BitmapDescriptorFactory
                                    .fromResource(R.mipmap.current_location_ico_mpl));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(DropByDropApplication.currentLat,
                            DropByDropApplication.currentLong), 10));
        } catch (Exception exception) {

        }

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    public static int getPixelsFromDp(final Context context, final float dpixel) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpixel * scale + 0.5f);
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int month, int day) {
            month = month+1;
            SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
            SimpleDateFormat formatter1 = new SimpleDateFormat("MMMM dd, yyyy");
            String dateInString = day+" "+month+" "+year;

            try {

                Date date = formatter.parse(dateInString);
                selectedDate = date.getTime()+"";
                System.out.println(date);
                System.out.println(formatter.format(date));

                etDate.setText(formatter1.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    };

    private TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener(){
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            SimpleDateFormat formatter1 = new SimpleDateFormat("hh:mm a");
            String dateInString = i+":"+i1;

            try {

                Date date = formatter.parse(dateInString);
                selectedFromTime = date.getTime()+"";
                System.out.println(date);
                System.out.println(formatter.format(date));

                etFromTime.setText(formatter1.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    };

    private TimePickerDialog.OnTimeSetListener toTimeListener = new TimePickerDialog.OnTimeSetListener(){
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            SimpleDateFormat formatter1 = new SimpleDateFormat("hh:mm a");
            String dateInString = i+":"+i1;

            try {

                Date date = formatter.parse(dateInString);
                selectedToTime = date.getTime()+"";
                System.out.println(date);
                System.out.println(formatter.format(date));

                etToTime.setText(formatter1.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    };
}