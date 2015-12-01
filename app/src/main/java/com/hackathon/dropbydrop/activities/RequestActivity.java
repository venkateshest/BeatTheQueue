package com.hackathon.dropbydrop.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.hackathon.dropbydrop.R;
import com.hackathon.dropbydrop.utils.MapWrapperLayout;

/**
 * Created by venkatesh.kolla on 12/1/2015.
 */
public class RequestActivity extends AppCompatActivity {

    MapWrapperLayout mWrapperLayout;
    MapView mMapView;
    GoogleMap map;

    EditText location;
    EditText precription;
    TextView tvForYouStatus;
    Switch switchForYou;
    Button requestNow;
    Button requestLater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        mMapView = (MapView) findViewById(R.id.stop_details_map);
        mWrapperLayout = (MapWrapperLayout) findViewById(R.id.wrapperlayout_stop_details_map);
        mMapView.onCreate(savedInstanceState);
        location = (EditText) findViewById(R.id.et_location);
        precription = (EditText) findViewById(R.id.et_precription);
        tvForYouStatus = (TextView) findViewById(R.id.tv_is_this_for_you);
        switchForYou = (Switch) findViewById(R.id.switch_is_this_for_you);
        requestNow = (Button) findViewById(R.id.request_now);
        requestLater = (Button) findViewById(R.id.request_later);
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
        } catch (Exception exception) {

        }
        requestNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        requestLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

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
}