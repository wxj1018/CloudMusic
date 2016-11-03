package com.app.cloudmusic.cloudmusic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.cloudmusic.cloudmusic.R;

import java.util.LinkedList;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class MyPagerAdapter extends android.support.v4.view.PagerAdapter{

    private LinkedList<View> freeViewList;
    private LayoutInflater inflater;
    private int [] imageIDs;


    public MyPagerAdapter(LayoutInflater inflater,int [] imageIDs){
        freeViewList = new LinkedList<>();
        this.inflater = inflater;
        this.imageIDs = imageIDs;
    }

    @Override
    public int getCount() {
        return imageIDs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //找到View
        //先获取空闲视图
        View convertView = null ;
			/*
			 *部分JAVAAPI，在LinekdList中没有数据时，会触发NoSuchElementException，所以我们要执行安全检查
			 */
        if(freeViewList.size()>0){
            convertView = freeViewList.remove() ;
        }
        if (convertView==null){
            convertView = inflater.inflate(R.layout.fragment_main_one_viewpager_item,null);
            ViewHolder holder = new ViewHolder();
            holder.iv_item = (ImageView)convertView.findViewById(R.id.iv_item);
            convertView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.iv_item.setImageResource(imageIDs[position%imageIDs.length]);
        container.addView(convertView);

        return convertView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    private class ViewHolder{
        ImageView iv_item;
    }

}
