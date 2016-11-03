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
 * Created by Administrator on 2016/10/11 0011.
 */
public class SingerMusicZJListAdapter extends RecyclerView.Adapter {

    private List<String> data = new ArrayList<String>();

    public SingerMusicZJListAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_music_zj_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView t = (TextView) holder.itemView.findViewById(R.id.tv_singer_zj_name);
        t.setText(data.get(position));
        setPic(holder, position);


    }

    private void setPic(RecyclerView.ViewHolder holder, int position) {
        if (position==0){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj0.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
        }else if (position==1){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj1.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
        }else if (position==2){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj2.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
        }else if (position==3){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj3.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
        }else if (position==4){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj4.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
        }else if (position==5){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj5.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
        }else if (position==6){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj6.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
        }else if (position==7){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj7.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
        }else if (position==8){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj8.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
        }else if (position==9){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj9.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
        }else if (position==10){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj10.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
        }else if (position==11){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj11.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
        }else if (position==12){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj12.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
        }else if (position==13){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj13.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
        }else if (position==14){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj14.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
        }else if (position==15){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj15.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
        }else if (position==16){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj16.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
        }else if (position==17){
            Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj17.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_zj));
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
            textView = (TextView) itemView.findViewById(R.id.tv_singer_zj_name);
            img = (ImageView) itemView.findViewById(R.id.img_zj);
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(v, getPosition());
            }
        }

    }
}
