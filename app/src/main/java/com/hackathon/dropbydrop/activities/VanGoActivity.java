package com.hackathon.dropbydrop.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.hackathon.dropbydrop.R;
import com.hackathon.dropbydrop.adapter.VanHouseAdapter;
import com.hackathon.dropbydrop.utils.MapWrapperLayout;

/**
 * Created by venkatesh.kolla on 12/1/2015.
 */
public class VanGoActivity extends AppCompatActivity {

    MapWrapperLayout mWrapperLayout;
    MapView mMapView;
    GoogleMap map;

    EditText location;
    TextView phoneNo;
    Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_go);
        mMapView = (MapView) findViewById(R.id.stop_details_map);
        mWrapperLayout = (MapWrapperLayout) findViewById(R.id.wrapperlayout_stop_details_map);
        mMapView.onCreate(savedInstanceState);
        location = (EditText) findViewById(R.id.et_location);

        phoneNo = (TextView) findViewById(R.id.tv_contact_no);
        start = (Button) findViewById(R.id.start);
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
        start.setOnClickListener(new View.OnClickListener() {
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