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
public class ChinaManSingerListAdapter extends RecyclerView.Adapter {


    private List<String> data = new ArrayList<String>();

    public ChinaManSingerListAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.china_man_singerlist_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView t = (TextView) holder.itemView.findViewById(R.id.tv_chinaman_singer_name);
        t.setText(data.get(position));
        Picasso.with(holder.itemView.getContext()).load("http://192.168.191.1:9096/cloudmusic/baoman.jpg").into((ImageView) holder.itemView.findViewById(R.id.img_chinaman_singer));
//        if (position == 3 || position == 7 || position == 11 || position == 15 && position != 0) {
//            t.setText("");
//            t.setBackgroundColor(Color.parseColor("#E6E6E6"));
//            t.setHeight(1);
//        } else {
//            t.setBackgroundColor(Color.parseColor("#ffffff"));
//        }

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

        public ImageView img;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_chinaman_singer_name);
            img = (ImageView) itemView.findViewById(R.id.img_chinaman_singer);
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
