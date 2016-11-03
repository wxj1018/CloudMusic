package com.app.cloudmusic.cloudmusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.javabeen.JBMtType;

import java.util.ArrayList;



/**
 * Created by yg on 2016/10/21.
 */
public class MTTypeAdapter extends BaseAdapter {
    LayoutInflater inflater;
    TextView textView;
    ArrayList<JBMtType> list;
    public MTTypeAdapter(ArrayList<JBMtType> list, Context context) {
        this.list=list;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_mttype, parent, false);
        textView = (TextView) convertView.findViewById(R.id.tv_item_mttype);
        textView.setText(list.get(position).getName());
        return convertView;
    }


}
