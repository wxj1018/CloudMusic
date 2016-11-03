package com.app.cloudmusic.cloudmusic.ViewpagerAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.app.cloudmusic.cloudmusic.R;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/26.
 */
public class OtherListViewAdapter extends BaseAdapter{
    
    private Context context1;
    private String[] otherbeans;
    
    private static HashMap<Integer, Boolean> isSelected;

    public HashMap<Integer, Boolean> getIsSelected() {
        return isSelected;
    }

    class ViewOtherHolder{
        TextView tv_name1;
        ImageButton Ibtn_menu;
    }
    
    public OtherListViewAdapter(Context context1,String[] otherbeans){
        this.context1 = context1;
        this.otherbeans = otherbeans;
        isSelected = new HashMap<>();
        
        initData();
    }
    
    private void initData(){
        for (int i = 0;i < otherbeans.length; i ++){
            getIsSelected().put(i,false);
        }
    }
    
    @Override
    public int getCount() {
        return otherbeans.length;
    }

    @Override
    public Object getItem(int position) {
        return otherbeans[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    
    @Override
    public boolean hasStableIds(){
        return false;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewOtherHolder otherHolder;
        String bean = otherbeans[position];
        LayoutInflater  inflater= LayoutInflater.from(context1);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_other_listview, null);
            otherHolder = new ViewOtherHolder();
            otherHolder.Ibtn_menu = (ImageButton) convertView.findViewById(R.id.ibtn_memu);
            otherHolder.tv_name1 = (TextView) convertView.findViewById(R.id.tv_device_name1);
            convertView.setTag(otherHolder);
        }else {
            otherHolder = (ViewOtherHolder) convertView.getTag();
        }

        otherHolder.tv_name1.setText(bean);

        otherHolder.Ibtn_menu.setOnClickListener(new View.OnClickListener(){

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
        return convertView;
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    @Override
    public boolean isEmpty(){
        return false;
    }

    public static void setIsSelected(HashMap<Integer, Boolean> isSelected){
        OtherListViewAdapter.isSelected = isSelected;
    }
}
