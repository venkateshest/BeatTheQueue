package com.hackathon.BeatTheQueue.adapter;

/**
 * Created by venkatesh.kolla
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hackathon.BeatTheQueue.R;
import com.hackathon.BeatTheQueue.data.CartItemsDTO;
import com.hackathon.BeatTheQueue.utils.Constants;

import java.util.List;


public class CartListAdapter extends ArrayAdapter<CartItemsDTO> {

    private final Context context;
    private final String type;


    public CartListAdapter(final Context context, final int resourceId, final List<CartItemsDTO> items, String type) {
        super(context, resourceId, items);
        this.context = context;
        this.type = type;
    }

    public View getView(final int position, final View convertView, final ViewGroup parent) {


        final CartItemsDTO rowItem = getItem(position);


        final LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);


        View view = mInflater.inflate(R.layout.item_details, null);

        TextView txtDonarName = (TextView) view.findViewById(R.id.tv_donor_name);
        TextView txtDonarTime = (TextView) view.findViewById(R.id.tv_item_schedule_time);
        TextView txtDonarAddress = (TextView) view.findViewById(R.id.tv_item_addres);


        if (type.equalsIgnoreCase(Constants.NOTIFICATIONS)) {
            txtDonarName.setText(rowItem.name);
            txtDonarTime.setText(rowItem.price);
            txtDonarAddress.setText(rowItem.quantity);
        }


        return view;
    }


}

