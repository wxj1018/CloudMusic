package com.app.cloudmusic.cloudmusic.ViewpagerAdapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.CompletionInfo;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.app.cloudmusic.cloudmusic.R;

import java.util.HashMap;


/**
 * Created by Administrator on 2016/10/17.
 */
public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private String[] beans;


    private static HashMap<Integer,Boolean> isSelected;


    class ViewHolder{

        TextView tvName;
        CheckBox cb;
    }


    public ListViewAdapter(Context context, String[] beans) {
        this.beans = beans;
        this.context = context;
        isSelected = new HashMap<Integer, Boolean>();

        initDate();
    }

    private void initDate() {
        for (int i = 0;i < beans.length; i ++){
            getIsSelected().put(i,false);
        }
    }

    public int getCount() {
        return beans.length;
    }

    public Object getItem(int position) {
        return beans[position];
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        String bean = beans[position];
        LayoutInflater inflater = LayoutInflater.from(context);
        if (convertView == null){
            convertView = inflater.inflate(R.layout.adapter_listview,null);
            holder = new ViewHolder();
            holder.cb = (CheckBox) convertView.findViewById(R.id.checkbox1);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_device_name);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText(bean);

        holder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isSelected.get(position)){
                    isSelected.put(position,false);
                    setIsSelected(isSelected);
                }else {
                    isSelected.put(position,true);
                    setIsSelected(isSelected);
                }
            }
        });

        holder.cb.setChecked(getIsSelected().get(position));

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }



    @Override
    public boolean isEmpty() {
        return false;
    }

    public static HashMap<Integer, Boolean> getIsSelected(){
        return isSelected;
    }

    public static void setIsSelected(HashMap<Integer, Boolean> isSelected){
        ListViewAdapter.isSelected = isSelected;
    }
}
