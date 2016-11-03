package com.app.cloudmusic.cloudmusic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.activity.PlayMusicMVActivity;
import com.app.cloudmusic.cloudmusic.adapter.SingerMusicZJListAdapter;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class SearchD_MV_Fragment extends Fragment implements View.OnClickListener {

    private View view;
    private LinearLayout mv1, mv2,mv3,mv4,mv5,mv6,mv7,mv8,mv9,mv10;
    private ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search_detail_mv, container, false);
        initView();

        return view;
    }

    private void initView() {
        mv1 = (LinearLayout) view.findViewById(R.id.lin_mv1);
        mv2 = (LinearLayout) view.findViewById(R.id.lin_mv2);
        mv3 = (LinearLayout) view.findViewById(R.id.lin_mv3);
        mv4 = (LinearLayout) view.findViewById(R.id.lin_mv4);
        mv5 = (LinearLayout) view.findViewById(R.id.lin_mv5);
        mv6 = (LinearLayout) view.findViewById(R.id.lin_mv6);
        mv7 = (LinearLayout) view.findViewById(R.id.lin_mv7);
        mv8 = (LinearLayout) view.findViewById(R.id.lin_mv8);
        mv9 = (LinearLayout) view.findViewById(R.id.lin_mv9);
        mv10 = (LinearLayout) view.findViewById(R.id.lin_mv10);
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(metrics.widthPixels / 2, ViewGroup.LayoutParams.WRAP_CONTENT);
        mv1.setLayoutParams(layoutParams);
        mv2.setLayoutParams(layoutParams);
        mv3.setLayoutParams(layoutParams);
        mv4.setLayoutParams(layoutParams);
        mv5.setLayoutParams(layoutParams);
        mv6.setLayoutParams(layoutParams);
        mv7.setLayoutParams(layoutParams);
        mv8.setLayoutParams(layoutParams);
        mv9.setLayoutParams(layoutParams);
        mv10.setLayoutParams(layoutParams);
        img1= (ImageView) view.findViewById(R.id.img_mv1);
        img2= (ImageView) view.findViewById(R.id.img_mv2);
        img3= (ImageView) view.findViewById(R.id.img_mv3);
        img4= (ImageView) view.findViewById(R.id.img_mv4);
        img5= (ImageView) view.findViewById(R.id.img_mv5);
        img6= (ImageView) view.findViewById(R.id.img_mv6);
        img7= (ImageView) view.findViewById(R.id.img_mv7);
        img8= (ImageView) view.findViewById(R.id.img_mv8);
        img9= (ImageView) view.findViewById(R.id.img_mv9);
        img10= (ImageView) view.findViewById(R.id.img_mv10);
        img1.setOnClickListener(this);
        Picasso.with(view.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj0.jpg").into(img1);
        Picasso.with(view.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj1.jpg").into(img2);
        Picasso.with(view.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj0.jpg").into(img3);
        Picasso.with(view.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj0.jpg").into(img4);
        Picasso.with(view.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj0.jpg").into(img5);
        Picasso.with(view.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj0.jpg").into(img6);
        Picasso.with(view.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj0.jpg").into(img7);
        Picasso.with(view.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj9.jpg").into(img8);
        Picasso.with(view.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj0.jpg").into(img9);
        Picasso.with(view.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj9.jpg").into(img10);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_mv1:
                startActivity(new Intent(SearchD_MV_Fragment.this.getActivity(), PlayMusicMVActivity.class));
                break;
        }
    }
}
