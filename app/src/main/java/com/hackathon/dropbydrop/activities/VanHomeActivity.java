package com.hackathon.dropbydrop.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.hackathon.dropbydrop.R;

/**
 * Created by venkatesh.kolla on 12/1/2015.
 */
public class VanHomeActivity extends AppCompatActivity {

    TextView tvPendingCount;
    TextView tvCompleteCount;
    TextView tvReScheduleCount;
    ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvCompleteCount=(TextView)findViewById(R.id.tv_completed_count);
        tvPendingCount=(TextView)findViewById(R.id.tv_pending_count);
        tvReScheduleCount=(TextView)findViewById(R.id.tv_reschedule_count);
        mListView=(ListView)findViewById(R.id.listview_van_home);


    }
}
