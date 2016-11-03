package com.app.cloudmusic.cloudmusic.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.activity.GedanActivity;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public class MainMusicFragment_one_diantai extends Fragment implements View.OnClickListener {

    private ImageButton ib1,ib2,ib3,ib4,ib5,ib6;
    private TextView tv1,tv2,tv3,tv4,tv5,tv6;
    private  View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_one_diantai,container,false);
        initView();
        return view;
    }

    //初始化控件
    public void initView(){
        //找到控件ID
        ib1 = (ImageButton)view.findViewById(R.id.ib_1_diantai_fragment);
        ib2 = (ImageButton)view.findViewById(R.id.ib_2_diantai_fragment);
        ib3 = (ImageButton)view.findViewById(R.id.ib_3_diantai_fragment);
        ib4 = (ImageButton)view.findViewById(R.id.ib_4_diantai_fragment);
        ib5 = (ImageButton)view.findViewById(R.id.ib_5_diantai_fragment);
        ib6 = (ImageButton)view.findViewById(R.id.ib_6_diantai_fragment);
        ib1.setOnClickListener(this);
        ib2.setOnClickListener(this);
        ib3.setOnClickListener(this);
        ib4.setOnClickListener(this);
        ib5.setOnClickListener(this);
        ib6.setOnClickListener(this);

        tv1 = (TextView)view.findViewById(R.id.tv_1_diantai_fragment);
        tv2 = (TextView)view.findViewById(R.id.tv_2_diantai_fragment);
        tv3 = (TextView)view.findViewById(R.id.tv_3_diantai_fragment);
        tv4 = (TextView)view.findViewById(R.id.tv_4_diantai_fragment);
        tv5 = (TextView)view.findViewById(R.id.tv_5_diantai_fragment);
        tv6 = (TextView)view.findViewById(R.id.tv_6_diantai_fragment);

    }

    //跳转到歌单界面
    public void moveGedan(){
        Intent intent = new Intent(getContext(), GedanActivity.class);
        startActivity(intent);
    }

    //初始化数据来源
    public void getData(){

    }

    //监听控件
    @Override
      public void onClick(View v) {

        switch (v.getId()){

            case R.id.ib_1_diantai_fragment:
                Toast.makeText(getContext(), "点击了图片1", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), GedanActivity.class);
                startActivity(intent);

                break;
            case R.id.ib_2_diantai_fragment:
                Toast.makeText(getContext(), "点击了图片2", Toast.LENGTH_SHORT).show();
                moveGedan();
                break;
            case R.id.ib_3_diantai_fragment:
                Toast.makeText(getContext(), "点击了图片3", Toast.LENGTH_SHORT).show();
                moveGedan();
                break;
            case R.id.ib_4_diantai_fragment:
                Toast.makeText(getContext(), "点击了图片4", Toast.LENGTH_SHORT).show();
                moveGedan();
                break;
            case R.id.ib_5_diantai_fragment:
                Toast.makeText(getContext(), "点击了图片5", Toast.LENGTH_SHORT).show();
                moveGedan();
                break;
            case R.id.ib_6_diantai_fragment:
                Toast.makeText(getContext(), "点击了图片6", Toast.LENGTH_SHORT).show();
                moveGedan();
                break;
        }

    }
}
