package com.app.cloudmusic.cloudmusic.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.cloudmusic.cloudmusic.R;


/**
 * 侧滑菜单中ListView的适配器
 * Created by Administrator on 2016/10/9 0009.
 */
public class SideSlipLVAdapter extends BaseAdapter {
    private Context context;
    private int[] icon;
    private String[] dcs;
    private SharedPreferences mSharedPreferences;

    public SideSlipLVAdapter(int[] icon, String[] dcs, Context context) {
        this.icon = icon;
        this.dcs = dcs;
        this.context = context;
        mSharedPreferences = context.getSharedPreferences("timer_position", Context.MODE_PRIVATE);
    }

    @Override
    public int getCount() {
        return icon.length;
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
        ViewHolder v = null;
        //convertView的复用优化
        if (convertView == null){
            //注入布局
            convertView = LayoutInflater.from(context).inflate(R.layout.side_slip_lv_item, parent, false);
            //获得每个Item中的子控件
            ImageView iv = (ImageView) convertView.findViewById(R.id.iv_side_slip_lv_item);
            TextView tvLeft = (TextView) convertView.findViewById(R.id.tv_side_slip_lv_item);
            TextView tvRight = (TextView) convertView.findViewById(R.id.tv_right_side_slip_lv_item);
            //viewHolder 中有convertView一一对应的控件，并把convertView的控件传递给viewHolder
            v = new ViewHolder();
            v.iv = iv;
            v.tvLeft = tvLeft;
            v.tvRight = tvRight;
            //将ViewHolder添加到convertView中
            convertView.setTag(v);
        }
        //减少findViewById优化
        v = (ViewHolder) convertView.getTag();
        //取出对应Item中的子控件并操作
//        int item = position%icon.length;
        int item = position;
        v.iv.setImageResource(icon[item]);
        v.tvLeft.setText(dcs[item]);
        v.tvRight.setVisibility(View.GONE);
        if (position == 5){
            v.tvRight.setVisibility(View.VISIBLE);
            v.tvRight.setText("官方红");
        }
        if (position == 6){
            v.tvRight.setVisibility(View.VISIBLE);
//            v.tvRight.setBackgroundResource(R.drawable.stop);
            if (mSharedPreferences.getBoolean("mode", true)){
                v.tvRight.setBackgroundResource(R.drawable.stop);
            }else {
                v.tvRight.setBackgroundResource(R.drawable.open);
            }
        }
        if (position == 7) {
            v.tvRight.setVisibility(View.VISIBLE);
            v.tvRight.setBackgroundColor(Color.YELLOW);
            v.tvRight.setTextColor(Color.RED);
            int time = mSharedPreferences.getInt("timer", 0);
            if (time == 0){
                 v.tvRight.setVisibility(View.GONE);
            }else {
                int hour = time/(60);
                int minute = time%60;
                if (hour == 0){
                    v.tvRight.setText(minute + "");
                }else {
                    v.tvRight.setText(hour + " : " +minute );
                }
            }
        }

        return convertView;
    }
 public  class ViewHolder{
        ImageView iv;
        TextView tvLeft;
      public  TextView tvRight;
    }
}
