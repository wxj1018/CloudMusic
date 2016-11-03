package com.app.cloudmusic.cloudmusic.Yuanzhongxue;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.activity.SearchActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
class MyAdapter<E> extends BaseAdapter {

    // 扫描
    ScanMusic scan;
    private List<Modle> date;
    private Context context;


    private LayoutInflater inflater;

    public MyAdapter(Context context, List<Modle> date) {
        this.context = context;
        this.date = date;

//        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater=((Activity)context).getLayoutInflater();

    }

    @Override
    public int getCount() {
        return date.size();
    }

    @Override
    public Object getItem(int position) {
        return date.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView ==null){
            convertView =inflater.inflate(R.layout.music_list,null);
            holder=new ViewHolder();
            holder.view_sing= (TextView) convertView.findViewById(R.id.music_singe_tv);
            holder.view_singer= (TextView) convertView.findViewById(R.id.music_singer_tv);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Modle music = date.get(position%date.size());
            //保存TextView
        holder.view_singer.setText("" +music.getSinger());
        holder.view_sing.setText("" + music.getSing());
        return convertView;
    }
    class ViewHolder{
        TextView view_sing,view_singer;
    }
}

