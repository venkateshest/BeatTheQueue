package com.hackathon.BeatTheQueue.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hackathon.BeatTheQueue.R;
import com.hackathon.BeatTheQueue.adapter.CartListAdapter;
import com.hackathon.BeatTheQueue.data.CartItemsDTO;
import com.hackathon.BeatTheQueue.utils.Constants;

import java.util.ArrayList;


public class NotificationActivity extends AppCompatActivity {

    ListView mListView;
    CartListAdapter mCartListAdapter;
    String status = "pending";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String msg = getIntent().getStringExtra("msg");


        setContentView(R.layout.activity_notification);
        mListView=(ListView)findViewById(R.id.listView_notification);

        mCartListAdapter = new CartListAdapter(this, R.layout.item_details, getItems(status), Constants.VANNOTIFICATIONHOME);
        mListView.setAdapter(mCartListAdapter);
       // BTQApplication.mVanNotifications.add(notificationDTO);
        mCartListAdapter.notifyDataSetChanged();
        setHeader();
    }
    private ArrayList<CartItemsDTO> getItems(String status) {

        ArrayList<CartItemsDTO> count = new ArrayList<>();
        /*for (int i = 0; i < BTQApplication.mVanNotifications.size(); i++) {
            if (BTQApplication.mVanNotifications.get(i).getStatus().equalsIgnoreCase(status)) {
                count.add(BTQApplication.mVanNotifications.get(i));
            }
        }*/
        return count;
    }

    void setHeader() {
        TextView textViewHeaderText = (TextView) findViewById(R.id.header_text);
        textViewHeaderText.setText(R.string.lbl_notifications);
        RelativeLayout rrHeader = (RelativeLayout) findViewById(R.id.main_header);
        rrHeader.setBackgroundColor(getResources().getColor(R.color.color_D13C3C));
      //  ImageView iv_noti = (ImageView) findViewById(R.id.notification);
      //  iv_noti.setBackground(getResources().getDrawable(R.mipmap.notification_white_complete));
      //  iv_noti.setVisibility(View.INVISIBLE);
    }
}
