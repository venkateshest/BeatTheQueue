package com.hackathon.dropbydrop.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.hackathon.dropbydrop.R;
import com.hackathon.dropbydrop.adapter.VanHouseAdapter;

/**
 * Created by venkatesh.kolla on 12/1/2015.
 */
public class NotificationActivity extends AppCompatActivity {

    ListView mListView;
    VanHouseAdapter mVanHouseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        mListView=(ListView)findViewById(R.id.listView_notification);
    }
}
