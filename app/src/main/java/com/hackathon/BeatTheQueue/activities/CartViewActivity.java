package com.hackathon.BeatTheQueue.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.hackathon.BeatTheQueue.R;
import com.hackathon.BeatTheQueue.adapter.CartListAdapter;
import com.hackathon.BeatTheQueue.data.CartItemsDTO;

import java.util.ArrayList;
import java.util.List;

public class CartViewActivity extends AppCompatActivity {


    ListView cartList;

    List<CartItemsDTO> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        items = getIntent().getParcelableArrayListExtra("items");

        cartList = (ListView) findViewById(R.id.ll_item_list);

        CartListAdapter adapter = new CartListAdapter(this, R.layout.item_details, items);
        cartList.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter iff = new IntentFilter("ADDEDTOCART");
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, iff);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
    }

    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String str = intent.getStringExtra("key");
                //Get all your data from intent and do what you want
            }
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
