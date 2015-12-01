package com.hackathon.dropbydrop.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.hackathon.dropbydrop.DropByDropApplication;
import com.hackathon.dropbydrop.R;
import com.hackathon.dropbydrop.adapter.VanHouseAdapter;
import com.hackathon.dropbydrop.data.NotificationDTO;
import com.hackathon.dropbydrop.utils.Constants;

import java.util.ArrayList;

/**
 * Created by venkatesh.kolla on 12/1/2015.
 */
public class VanHomeActivity extends AppCompatActivity {

    TextView tvPendingCount;
    TextView tvCompleteCount;
    TextView tvReScheduleCount;
    TextView tvPendingStatus;
    TextView tvCompleteStatus;
    TextView tvReScheduleStatus;
    LinearLayout mllPending;
    LinearLayout mllCompleted;
    LinearLayout mllRescheduled;
    ImageView ivPending;
    ImageView ivCompleted;
    ImageView ivReScheduled;
    ListView mListView;
    VanHouseAdapter mVanHouseAdapter;
    String status = "pending";

    private ImageView mImgViewHeadBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_home);
initHeader();
        tvCompleteCount = (TextView) findViewById(R.id.tv_completed_count);
        tvPendingCount = (TextView) findViewById(R.id.tv_pending_count);
        tvReScheduleCount = (TextView) findViewById(R.id.tv_reschedule_count);
        tvCompleteStatus = (TextView) findViewById(R.id.tv_completed_status);
        tvPendingStatus = (TextView) findViewById(R.id.tv_pending_status);
        tvReScheduleStatus = (TextView) findViewById(R.id.tv_reschedule_status);
        mllPending = (LinearLayout) findViewById(R.id.ll_pending);
        mllCompleted = (LinearLayout) findViewById(R.id.ll_completed);
        mllRescheduled = (LinearLayout) findViewById(R.id.ll_re_schedule);
        ivPending = (ImageView) findViewById(R.id.iv_pending);
        ivCompleted = (ImageView) findViewById(R.id.iv_completed);
        ivReScheduled = (ImageView) findViewById(R.id.iv_re_schedule);

        tvPendingCount.setTextColor(Color.WHITE);
        tvPendingStatus.setTextColor(Color.WHITE);
        mllPending.setBackgroundColor(getResources().getColor(R.color.color_50d2c2));
        mllCompleted.setBackgroundColor(getResources().getColor(R.color.color_f8f8f9));
        mllRescheduled.setBackgroundColor(getResources().getColor(R.color.color_f8f8f9));
        mListView = (ListView) findViewById(R.id.listview_van_home);
        mVanHouseAdapter = new VanHouseAdapter(this, R.layout.item_details, getItems(status), Constants.VANNOTIFICATIONHOME);
        mListView.setAdapter(mVanHouseAdapter);
        mllPending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = "Pending";
                mVanHouseAdapter = new VanHouseAdapter(VanHomeActivity.this, R.layout.item_details, getItems(status), Constants.VANNOTIFICATIONHOME);
                mListView.setAdapter(mVanHouseAdapter);
                mllPending.setBackgroundColor(getResources().getColor(R.color.color_50d2c2));
                mllCompleted.setBackgroundColor(getResources().getColor(R.color.color_f8f8f9));
                mllRescheduled.setBackgroundColor(getResources().getColor(R.color.color_f8f8f9));
                tvPendingCount.setTextColor(Color.WHITE);
                tvPendingStatus.setTextColor(Color.WHITE);
                tvCompleteCount.setTextColor(getResources().getColor(R.color.color_000000));
                tvCompleteStatus.setTextColor(getResources().getColor(R.color.color_801D1D26));
                tvReScheduleCount.setTextColor(getResources().getColor(R.color.color_000000));
                tvReScheduleStatus.setTextColor(getResources().getColor(R.color.color_801D1D26));
            }
        });
        mllCompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = "Completed";
                mVanHouseAdapter = new VanHouseAdapter(VanHomeActivity.this, R.layout.item_details, getItems(status), Constants.VANNOTIFICATIONHOME);
                mListView.setAdapter(mVanHouseAdapter);
                mllPending.setBackgroundColor(getResources().getColor(R.color.color_f8f8f9));
                mllCompleted.setBackgroundColor(getResources().getColor(R.color.color_50d2c2));
                mllRescheduled.setBackgroundColor(getResources().getColor(R.color.color_f8f8f9));
                tvCompleteCount.setTextColor(Color.WHITE);
                tvCompleteStatus.setTextColor(Color.WHITE);
                tvPendingCount.setTextColor(getResources().getColor(R.color.color_000000));
                tvPendingStatus.setTextColor(getResources().getColor(R.color.color_801D1D26));

                tvReScheduleCount.setTextColor(getResources().getColor(R.color.color_000000));
                tvReScheduleStatus.setTextColor(getResources().getColor(R.color.color_801D1D26));
            }
        });
        mllRescheduled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status = "Re-scheduled";
                mVanHouseAdapter = new VanHouseAdapter(VanHomeActivity.this, R.layout.item_details, getItems(status), Constants.VANNOTIFICATIONHOME);
                mListView.setAdapter(mVanHouseAdapter);
                mllPending.setBackgroundColor(getResources().getColor(R.color.color_f8f8f9));
                mllCompleted.setBackgroundColor(getResources().getColor(R.color.color_f8f8f9));
                mllRescheduled.setBackgroundColor(getResources().getColor(R.color.color_50d2c2));
                tvReScheduleCount.setTextColor(Color.WHITE);
                tvReScheduleStatus.setTextColor(Color.WHITE);
                tvCompleteCount.setTextColor(getResources().getColor(R.color.color_000000));
                tvCompleteStatus.setTextColor(getResources().getColor(R.color.color_801D1D26));
                tvPendingCount.setTextColor(getResources().getColor(R.color.color_000000));
                tvPendingStatus.setTextColor(getResources().getColor(R.color.color_801D1D26));


            }
        });
        tvPendingCount.setText(String.valueOf(getStatusCount("Pending")));
        tvCompleteCount.setText(String.valueOf(getStatusCount("Completed")));
        tvReScheduleCount.setText(String.valueOf(getStatusCount("Re-scheduled")));
    }

    private int getStatusCount(String status) {

        int count = 0;
        for (int i = 0; i < DropByDropApplication.mVanNotifications.size(); i++) {
            if (DropByDropApplication.mVanNotifications.get(i).getStatus().equalsIgnoreCase(status)) {
                count++;
            }
        }
        return count;
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
    private void initHeader(){
        mImgViewHeadBack = (ImageView) findViewById(R.id.iv_head_back);
        TextView textViewHeaderText = (TextView) findViewById(R.id.header_text);
        ImageView ivNotification = (ImageView) findViewById(R.id.notification);
        textViewHeaderText.setText("Donors for today");
        mImgViewHeadBack.setBackground(getDrawable(R.mipmap.back_white));
        mImgViewHeadBack.setVisibility(View.GONE);
        ivNotification.setVisibility(View.GONE);
    }
}
