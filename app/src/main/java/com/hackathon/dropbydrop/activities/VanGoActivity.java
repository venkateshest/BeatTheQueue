package com.hackathon.dropbydrop.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.hackathon.dropbydrop.DropByDropApplication;
import com.hackathon.dropbydrop.R;
import com.hackathon.dropbydrop.data.GooglePathDTO;
import com.hackathon.dropbydrop.data.NotificationDTO;
import com.hackathon.dropbydrop.data.ResponseDTO;
import com.hackathon.dropbydrop.reusable.constants.StringConstants;
import com.hackathon.dropbydrop.utils.Constants;
import com.hackathon.dropbydrop.utils.MapWrapperLayout;
import com.hackathon.dropbydrop.utils.NetworkUtils;
import com.hackathon.dropbydrop.utils.RequestCallbackListener;

import java.util.List;

/**
 * Created by venkatesh.kolla on 12/1/2015.
 */
public class VanGoActivity extends AppCompatActivity {

    MapWrapperLayout mWrapperLayout;
    MapView mMapView;
    GoogleMap map;
    public static GooglePathDTO mGooglePathDTO;
    EditText location;
    TextView phoneNo;
    Button start;
    NotificationDTO mNotificationDTO;
    ImageView navigation;
    private ProgressDialog progress;

    private ImageView mImgViewHeadBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_go);

        int position = 0;
        if (getIntent().getExtras() != null) {
            position = getIntent().getIntExtra(Constants.SELECTED_ITEM_POSITION, 0);
        }
        mNotificationDTO = DropByDropApplication.mVanNotifications.get(position);
        initHeader();
        mMapView = (MapView) findViewById(R.id.stop_details_map);
        mWrapperLayout = (MapWrapperLayout) findViewById(R.id.wrapperlayout_stop_details_map);
        mMapView.onCreate(savedInstanceState);
        location = (EditText) findViewById(R.id.et_address);
        location.setText(mNotificationDTO.getAddress());
        phoneNo = (TextView) findViewById(R.id.tv_contact_no);
        phoneNo.setText(mNotificationDTO.getPhoneNo());

        start = (Button) findViewById(R.id.start);
        navigation = (ImageView) findViewById(R.id.navigation);

    }
    private void initHeader(){
        RelativeLayout mMain=(RelativeLayout)findViewById(R.id.main_header);
        mMain.setBackgroundColor(getResources().getColor(R.color.color_B3D13C3C));
        mImgViewHeadBack = (ImageView) findViewById(R.id.iv_head_back);
        TextView textViewHeaderText = (TextView) findViewById(R.id.header_text);
        ImageView ivNotification = (ImageView) findViewById(R.id.notification);
        textViewHeaderText.setText(mNotificationDTO.getName());
        mImgViewHeadBack.setBackground(getDrawable(R.mipmap.back_white));
        mImgViewHeadBack.setVisibility(View.VISIBLE);
        ivNotification.setVisibility(View.GONE);
        mImgViewHeadBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
        } catch (Exception exception) {

        }
        if (mNotificationDTO != null) {

            drawLocation();
        }
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VanGoActivity.this, BackGroundActivity.class);
                intent.putExtra(StringConstants.DONATE_DATE, mNotificationDTO.getDateTime());
                intent.putExtra(StringConstants.DONATE_FROM_TIME, mNotificationDTO.getDateTime());
                intent.putExtra(StringConstants.DONATE_TO_TIME, mNotificationDTO.getDateTime());
                intent.putExtra(StringConstants.DONATE_AT_LAT, "");
                intent.putExtra(StringConstants.DONATE_AT_LONG, "");
                startActivity(intent);
            }
        });
        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String uriBegin = "geo:" + mNotificationDTO.getLat() + "," + mNotificationDTO.getLongt();
                final String query = mNotificationDTO.getLat() + "," + mNotificationDTO.getLongt() + "(" + "Your Place to Go" + ")";
                final String encodedQuery = Uri.encode(query);
                final String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                final Uri uri = Uri.parse(uriString);
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });
    }
    private void drawLocation() {


                map.addMarker(new MarkerOptions().position(new LatLng(mNotificationDTO.getLat(),
                        mNotificationDTO.getLongt())))
                        .setIcon(
                                BitmapDescriptorFactory
                                        .fromResource(R.mipmap.current_location_ico_mpl));

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(mNotificationDTO.getLat(),
                        mNotificationDTO.getLongt()), 10));
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