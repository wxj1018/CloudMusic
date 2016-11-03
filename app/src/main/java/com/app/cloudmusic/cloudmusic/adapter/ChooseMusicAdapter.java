package com.app.cloudmusic.cloudmusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.app.cloudmusic.cloudmusic.R;


/**
 * Created by yg on 2016/10/23.
 */
public class ChooseMusicAdapter extends BaseAdapter {

    LayoutInflater inflater;

    public ChooseMusicAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
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
        convertView=inflater.inflate(R.layout.item_music,parent,false);
        return convertView;
    }
}
