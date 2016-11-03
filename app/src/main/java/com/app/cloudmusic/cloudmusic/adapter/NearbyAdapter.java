package com.app.cloudmusic.cloudmusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.app.cloudmusic.cloudmusic.R;

import java.util.ArrayList;



/**
 * Created by yg on 2016/10/21.
 */
public class NearbyAdapter extends BaseAdapter {
    LayoutInflater inflater;

    public NearbyAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_nearby, parent, false);
        return convertView;
    }
}
