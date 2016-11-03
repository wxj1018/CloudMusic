package com.app.cloudmusic.cloudmusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.cloudmusic.cloudmusic.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class MyBaseAdapter_two extends android.widget.BaseAdapter{


    private List<HashMap<String, Object>> data;
    private Context context;
    private LayoutInflater inflater;
    public MyBaseAdapter_two(LayoutInflater inflater, List<HashMap<String, Object>> data){
        this.data = data;;
        this.inflater = inflater;
     }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //如果没有空闲convertView,创建新的
        if(convertView == null){
            //新建视图
            convertView = inflater.inflate(R.layout.fragment_main_four_item_listview2, null);
            //新建ViewHolder
            ViewHolder holder = new ViewHolder() ;
            //视图保存到ViewHolder中
            holder.tv_name1  = (TextView) convertView.findViewById(R.id.tv_fragment_main_four_2_1) ;
            holder.tv_name2  = (TextView) convertView.findViewById(R.id.tv_fragment_main_four_2_2) ;
            holder.iv_1 = (ImageView) convertView.findViewById(R.id.iv_framgent_main_four_item_two);
            //将ViewHolder再保存到视图中
            convertView.setTag(holder);
        }

        //视图
        ViewHolder holder = (ViewHolder) convertView.getTag() ;
        //数据
        HashMap<String, Object> map = data.get(position) ;
        //
        holder.tv_name1.setText(map.get("name1").toString());
        holder.tv_name2.setText(map.get("name2").toString());
        holder.iv_1.setImageResource((Integer) map.get("imageID"));


        return convertView;
    }

    class ViewHolder {
        ImageView iv_1;
        TextView tv_name1 ;
        TextView tv_name2;
    }

}
