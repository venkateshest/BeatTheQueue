package com.hackathon.BeatTheQueue;

import android.app.Application;
import android.content.Context;

import com.hackathon.BeatTheQueue.data.CartItemsDTO;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by venkatesh.kolla
 */
public class BTQApplication extends Application {

    public static Context mContext;

    public static HashMap<String, CartItemsDTO> cartItemsDTOs = new HashMap<>();

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
        addItems();

    }

    private void addItems() {
        cartItemsDTOs.put("9780000000002", new CartItemsDTO("Dove Soap 200 gm", 1, 50.00, 50.00));
        cartItemsDTOs.put("719410300029", new CartItemsDTO("Colgate 100 gm", 1, 30.00, 30.00));
        cartItemsDTOs.put("461052176530", new CartItemsDTO("Oil 1 kg", 1, 123.00, 123.00));
        cartItemsDTOs.put("5012345678900", new CartItemsDTO("Apples 1kg", 1, 180.00, 180.00));
        cartItemsDTOs.put("123456", new CartItemsDTO("Oranges 1 kg", 1, 120.00, 120.00));
        cartItemsDTOs.put("060123456788", new CartItemsDTO("Dove Shampoo l lt", 1, 130.00, 130.00));

    }

}
