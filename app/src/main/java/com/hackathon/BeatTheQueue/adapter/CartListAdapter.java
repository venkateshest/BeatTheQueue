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
    private String type;


    public CartListAdapter(final Context context, final int resourceId, final List<CartItemsDTO> items, String type) {
        super(context, resourceId, items);
        this.context = context;
        this.type = type;
    }

    public CartListAdapter(final Context context, final int resourceId, final List<CartItemsDTO> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    public View getView(final int position, final View convertView, final ViewGroup parent) {


        final CartItemsDTO rowItem = getItem(position);


        final LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);


        View view = mInflater.inflate(R.layout.item_details, null);

        TextView txtItemName = (TextView) view.findViewById(R.id.tv_item_name);
        TextView txtAmount = (TextView) view.findViewById(R.id.tv_item_amount);
        final TextView totalAmount = (TextView) view.findViewById(R.id.tv_total_amt);
        TextView txtMinus = (TextView) view.findViewById(R.id.tv_quantity_minus);
        final TextView txtNoOfQuantity = (TextView) view.findViewById(R.id.tv_quantity_amount);
        TextView txtPlus = (TextView) view.findViewById(R.id.tv_quantity_plus);


        txtItemName.setText(rowItem.name);
        txtAmount.setText(rowItem.perKGPrice + "/kg");
        txtNoOfQuantity.setText(rowItem.quantity);
        totalAmount.setText("" + (rowItem.quantity * rowItem.perKGPrice));


        txtMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qty = rowItem.quantity;
                if (qty >= 1) {
                    qty = qty - 1;
                }
                txtNoOfQuantity.setText(qty);
                totalAmount.setText("" + (qty * rowItem.perKGPrice));

            }
        });
        txtPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qty = rowItem.quantity;
                qty = qty + 1;
                txtNoOfQuantity.setText(qty);
                totalAmount.setText("" + (qty * rowItem.perKGPrice));
            }
        });


        return view;
    }


}

