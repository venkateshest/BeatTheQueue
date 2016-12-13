package com.hackathon.BeatTheQueue.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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
        items = getIntent().getParcelableArrayListExtra("items");

        cartList = (ListView) findViewById(R.id.ll_item_list);

        CartListAdapter adapter = new CartListAdapter(this, R.layout.item_details, items);
        cartList.setAdapter(adapter);

    }
}
