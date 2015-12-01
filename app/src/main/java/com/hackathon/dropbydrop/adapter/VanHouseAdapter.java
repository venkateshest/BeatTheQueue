package com.hackathon.dropbydrop.adapter;

/**
 * Created by venkatesh.kolla on 12/1/2015.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hackathon.dropbydrop.R;
import com.hackathon.dropbydrop.data.NotificationDTO;
import com.hackathon.dropbydrop.utils.Constants;

import java.util.List;


public class VanHouseAdapter extends ArrayAdapter<NotificationDTO> {

    private final Context context;
    private final String type;


    public VanHouseAdapter(final Context context, final int resourceId, final List<NotificationDTO> items, String type) {
        super(context, resourceId, items);
        this.context = context;
        this.type = type;
    }

    public View getView(final int position, final View convertView, final ViewGroup parent) {


        final NotificationDTO rowItem = getItem(position);


        final LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);


           View view = mInflater.inflate(R.layout.item_details, null);

            TextView txtDonarName = (TextView) view.findViewById(R.id.tv_donor_name);
            TextView txtDonarTime = (TextView) view.findViewById(R.id.tv_item_schedule_time);
            TextView txtDonarAddress = (TextView) view.findViewById(R.id.tv_item_addres);


                if (type.equalsIgnoreCase(Constants.NOTIFICATIONS)) {
                    txtDonarName.setText(rowItem.getName());
                    txtDonarTime.setText("8-9 AM");
                    txtDonarAddress.setText(rowItem.getBloodGroup());
                } else if (type.equalsIgnoreCase(Constants.VANNOTIFICATIONHOME)) {
                    txtDonarName.setText(rowItem.getName());
                    txtDonarTime.setText("8-9 AM");
                    txtDonarAddress.setText(rowItem.getAddress());
                }


        return view;
    }


}

