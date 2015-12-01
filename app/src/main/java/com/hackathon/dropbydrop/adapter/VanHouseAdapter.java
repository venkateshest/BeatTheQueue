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

import java.util.List;


public class VanHouseAdapter extends ArrayAdapter<String> {

    private final Context context;

    public VanHouseAdapter(final Context context, final int resourceId, final List<String> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    public View getView(final int position, final View convertView, final ViewGroup parent) {

        ViewHolder holder = null;
        final String rowItem = getItem(position);
        View view = convertView;

        final LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            view = mInflater.inflate(R.layout.item_details, null);
            holder = new ViewHolder(view);
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }


        return view;
    }

    /* private view holder class */
    class ViewHolder {

        TextView txtDonarName;
        TextView txtDonarTime;
        TextView txtDonarAddress;


        public ViewHolder(final View view) {
            txtDonarName=(TextView)view.findViewById(R.id.tv_donar_name);
            txtDonarTime=(TextView)view.findViewById(R.id.tv_item_schedule_time);
            txtDonarAddress=(TextView)view.findViewById(R.id.tv_item_addres);
        }
    }
}

