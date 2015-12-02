package com.hackathon.dropbydrop.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hackathon.dropbydrop.DropByDropApplication;
import com.hackathon.dropbydrop.R;
import com.hackathon.dropbydrop.adapter.VanHouseAdapter;
import com.hackathon.dropbydrop.data.NotificationDTO;
import com.hackathon.dropbydrop.utils.Constants;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class NotificationActivity extends AppCompatActivity {

    ListView mListView;
    VanHouseAdapter mVanHouseAdapter;
    String status = "pending";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String msg = getIntent().getStringExtra("msg");
       /* NotificationDTO notificationDTO = new NotificationDTO();


        try {
            Gson gson = new Gson();
            notificationDTO = gson.fromJson(msg, NotificationDTO.class);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }*/

        setContentView(R.layout.activity_notification);
        mListView=(ListView)findViewById(R.id.listView_notification);

        mVanHouseAdapter = new VanHouseAdapter(this, R.layout.item_details, getItems(status), Constants.VANNOTIFICATIONHOME);
        mListView.setAdapter(mVanHouseAdapter);
       // DropByDropApplication.mVanNotifications.add(notificationDTO);
        mVanHouseAdapter.notifyDataSetChanged();
        setHeader();
    }
    private ArrayList<NotificationDTO> getItems(String status) {

        ArrayList<NotificationDTO> count = new ArrayList<>();
        for (int i = 0; i < DropByDropApplication.mVanNotifications.size(); i++) {
            if (DropByDropApplication.mVanNotifications.get(i).getStatus().equalsIgnoreCase(status)) {
                count.add(DropByDropApplication.mVanNotifications.get(i));
            }
        }
        return count;
    }

    void setHeader() {
        TextView textViewHeaderText = (TextView) findViewById(R.id.header_text);
        textViewHeaderText.setText(R.string.lbl_notifications);
        RelativeLayout rrHeader = (RelativeLayout) findViewById(R.id.main_header);
        rrHeader.setBackgroundColor(getResources().getColor(R.color.color_D13C3C));
        ImageView iv_noti = (ImageView) findViewById(R.id.notification);
        iv_noti.setBackground(getResources().getDrawable(R.mipmap.notification_white_complete));
        iv_noti.setVisibility(View.INVISIBLE);
    }
}
