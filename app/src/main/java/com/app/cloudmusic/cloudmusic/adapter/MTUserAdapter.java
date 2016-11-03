package com.app.cloudmusic.cloudmusic.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.javabeen.JBUser;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by yg on 2016/10/21.
 */
public class MTUserAdapter extends BaseAdapter {
    LayoutInflater inflater;
    ArrayList<JBUser> list;
    private TextView tvName,tvUnderWrite;
    private ImageView ivUser;

    public MTUserAdapter(ArrayList<JBUser> list,Context context) {
        inflater = LayoutInflater.from(context);
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.item_user, parent, false);
        tvName= (TextView) convertView.findViewById(R.id.tv_uname_u);
        tvUnderWrite= (TextView) convertView.findViewById(R.id.tv_underwrite_u);
        ivUser= (ImageView) convertView.findViewById(R.id.iv_user_u);

        tvName.setText(list.get(position).getUname());
        tvUnderWrite.setText(list.get(position).getUunderwrite());
        Bitmap bitmap= getHttpBitmap("http://192.168.56.1/cloudmusic2/image/1.png");
        ivUser.setImageBitmap(bitmap);
        return convertView;
    }

    public static Bitmap getHttpBitmap(String url) {
        URL myFileUrl = null;
        Bitmap bitmap = null;
        try {
            myFileUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) myFileUrl.openConnection();
            conn.setConnectTimeout(0);
            conn.setDoInput(true);
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
