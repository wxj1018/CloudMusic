package com.app.cloudmusic.cloudmusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.app.cloudmusic.cloudmusic.R;


/**
 * Created by yg on 2016/10/24.
 */
public class DyCriticismAdapter extends BaseAdapter {

    LayoutInflater inflater;

    public DyCriticismAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 50;
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
        if (position == 0) {
            convertView = inflater.inflate(R.layout.item_criticismhander, parent, false);
        } else {
            convertView = inflater.inflate(R.layout.item_criticism_dy, parent, false);
        }
        return convertView;
    }
}
