package com.app.cloudmusic.cloudmusic.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.cloudmusic.cloudmusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/28 0028.
 */
public class PopWindowAdapter extends RecyclerView.Adapter {


    private List<String> data = new ArrayList<String>();

    public PopWindowAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popwindow_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView t = (TextView) holder.itemView.findViewById(R.id.tv_popwindow_item_text);
        t.setText(data.get(position));
        if (position==0){
            holder.itemView.findViewById(R.id.img_popwindow_item_pic).setBackgroundResource(R.drawable.menu_next);
        }else if (position==1){
            holder.itemView.findViewById(R.id.img_popwindow_item_pic).setBackgroundResource(R.drawable.menu_love);
        }else if (position==2){
            holder.itemView.findViewById(R.id.img_popwindow_item_pic).setBackgroundResource(R.drawable.menu_download);
        }else if (position==3){
            holder.itemView.findViewById(R.id.img_popwindow_item_pic).setBackgroundResource(R.drawable.menu_discuss);
        }else if (position==4){
            holder.itemView.findViewById(R.id.img_popwindow_item_pic).setBackgroundResource(R.drawable.share_icon);
        }else if (position==5){
            holder.itemView.findViewById(R.id.img_popwindow_item_pic).setBackgroundResource(R.drawable.menu_singer);
        }else if (position==6){
            holder.itemView.findViewById(R.id.img_popwindow_item_pic).setBackgroundResource(R.drawable.menu_mv);
        }else if (position==7){
            holder.itemView.findViewById(R.id.img_popwindow_item_pic).setBackgroundResource(R.drawable.menu_bear);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //自己添加点击事件的接口回调
    public interface OnItemClickListener {
        void onItemClick(View view, int positon);
    }

    public OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    //绑定ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView;
        public ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_popwindow_item_text);
            img = (ImageView) itemView.findViewById(R.id.img_popwindow_item_pic);
            textView.setOnClickListener(this);
            img.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(v, getPosition());
            }
        }

    }

}
