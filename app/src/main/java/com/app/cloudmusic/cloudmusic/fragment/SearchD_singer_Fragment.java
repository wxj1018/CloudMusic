package com.app.cloudmusic.cloudmusic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.cloudmusic.cloudmusic.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class SearchD_singer_Fragment extends Fragment {

    private ImageView img_singer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_detail_singer, container, false);
        img_singer= (ImageView) view.findViewById(R.id.img_singer);
        Picasso.with(view.getContext()).load("http://192.168.191.1:9096/cloudmusic/zhoujielun.jpg").into(img_singer);
        return view;
    }
}
