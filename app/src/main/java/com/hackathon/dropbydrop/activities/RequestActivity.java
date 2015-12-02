package com.hackathon.dropbydrop.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.hackathon.dropbydrop.DropByDropApplication;
import com.hackathon.dropbydrop.R;
import com.hackathon.dropbydrop.data.GCMDTO;
import com.hackathon.dropbydrop.reusable.constants.StringConstants;
import com.hackathon.dropbydrop.reusable.gcm.PushNotification;
import com.hackathon.dropbydrop.utils.MapWrapperLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    private TextView tvYes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        mMapView = (MapView) findViewById(R.id.stop_details_map);
        mWrapperLayout = (MapWrapperLayout) findViewById(R.id.wrapperlayout_stop_details_map);
        mMapView.onCreate(savedInstanceState);
        location = (EditText) findViewById(R.id.et_location);
        location.setText("3rd phase, JP Nagar, Bangalore");
        precription = (EditText) findViewById(R.id.et_precription);
        tvForYouStatus = (TextView) findViewById(R.id.tv_is_this_for_you);
        tvYes = (TextView) findViewById(R.id.tv_yes);
        switchForYou = (Switch) findViewById(R.id.switch_is_this_for_you);
        requestNow = (Button) findViewById(R.id.request_now);
        requestLater = (Button) findViewById(R.id.request_later);
        setHeader();
    }

    void setHeader() {
        TextView textViewHeaderText = (TextView) findViewById(R.id.header_text);
        textViewHeaderText.setText(R.string.lbl_request_help);
        RelativeLayout rrHeader = (RelativeLayout) findViewById(R.id.main_header);
        rrHeader.setBackgroundColor(getResources().getColor(R.color.color_E6D13C3C));
        ImageView iv_noti = (ImageView) findViewById(R.id.notification);
        iv_noti.setBackground(getResources().getDrawable(R.mipmap.notification_white_complete));
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
            map.setMyLocationEnabled(true);
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
        requestNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                String stringDonateJson = "Request Blood";
                GCMDTO gcmdto = new GCMDTO();
                gcmdto.setPayLoad(stringDonateJson);
                stringDonateJson = gson.toJson(gcmdto);
                JSONObject jsonObj = null;
                try {
                    jsonObj = new JSONObject(stringDonateJson);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONArray regIds = new JSONArray();
                regIds.put(StringConstants.GCM_OFFICE_NEXUS);
                regIds.put(StringConstants.GCM_MOTO_X);
                regIds.put(StringConstants.GCM_VENKI_NEXUS);
                PushNotification pushNoti = new PushNotification(jsonObj, regIds);
                pushNoti.sendPush();
                RequestActivity.this.finish();
            }
        });
        requestLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                String stringDonateJson = "Request Blood Later";
                GCMDTO gcmdto = new GCMDTO();
                gcmdto.setPayLoad(stringDonateJson);
                stringDonateJson = gson.toJson(gcmdto);
                JSONObject jsonObj = null;
                try {
                    jsonObj = new JSONObject(stringDonateJson);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONArray regIds = new JSONArray();
                regIds.put(StringConstants.GCM_OFFICE_NEXUS);
                regIds.put(StringConstants.GCM_MOTO_X);
                regIds.put(StringConstants.GCM_VENKI_NEXUS);
                PushNotification pushNoti = new PushNotification(jsonObj, regIds);
                pushNoti.sendPush();
                RequestActivity.this.finish();
            }
        });
        tvYes.setText("NO");
        switchForYou.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    tvYes.setText("YES");
                } else {
                    tvYes.setText("NO");
                }
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