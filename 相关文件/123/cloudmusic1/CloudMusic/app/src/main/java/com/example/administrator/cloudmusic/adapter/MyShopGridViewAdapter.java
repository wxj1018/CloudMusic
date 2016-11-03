package com.example.administrator.cloudmusic.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.cloudmusic.R;

import java.util.List;

/**
 * Created by Administrator on 2016/10/15.
 */
public class MyShopGridViewAdapter extends BaseAdapter{
    private List<Bitmap> images;
    private List<String> discriptions;
    private List<String> prices;
    private Context context;

    public MyShopGridViewAdapter(Context context, List<Bitmap> images, List<String> discriptions, List<String> prices) {
        this.images = images;
        this.discriptions = discriptions;
        this.prices = prices;
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.size();
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
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.shop_gv_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) convertView.findViewById(R.id.shop_gv_item_image);
            viewHolder.discription = (TextView) convertView.findViewById(R.id.shop_gv_item_discription);
            viewHolder.price = (TextView) convertView.findViewById(R.id.shop_gv_item_price);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.image.setImageBitmap(images.get(position));
        viewHolder.discription.setText(discriptions.get(position));
        viewHolder.price.setText(prices.get(position));
        return convertView;
    }
    class ViewHolder{
        private ImageView image;
        private TextView discription;
        private TextView price;
    }
}
