package com.app.cloudmusic.cloudmusic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.activity.GedanActivity;
import com.app.cloudmusic.cloudmusic.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class MainMusicFragment_one extends Fragment implements View.OnClickListener{

    private ViewPager viewPager;
    private View view;
    private ImageView iv1,iv2,iv3,iv4,iv5,iv6;
    private ImageButton ib1,ib2,ib3,ib4,ib5,ib6;
    private RadioButton rb_fm,rb_meiri,rb_yunyinyue;

    int []imageIDs = {R.drawable.lay_protype_listen,R.drawable.lay_protype_member,
    R.drawable.lay_protype_offline_bag,R.drawable.lay_protype_runfm,R.drawable.lay_protype_vip,
    R.drawable.lay_protype_vip_pro};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_one,container,false);
        ininView();
        MyPagerAdapter adapter = new MyPagerAdapter(inflater,imageIDs);
        viewPager.setAdapter(adapter);

        return view;
    }

    private void ininView() {
        //实例化对象
        viewPager = (ViewPager)view .findViewById(R.id.vp_fragment_main_one);
        rb_fm = (RadioButton)view.findViewById(R.id.rb_fm_fragment_main_one);
        rb_meiri = (RadioButton)view.findViewById(R.id.rb_meiri_fragment_main_one);
        rb_yunyinyue = (RadioButton)view.findViewById(R.id.rb_yunyinyue_fragment_main_one);
        rb_fm.setOnClickListener(this);
        rb_meiri.setOnClickListener(this);
        rb_yunyinyue.setOnClickListener(this);

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

    }

    //跳转到歌单界面
    public void moveGedan(){
        Intent intent = new Intent(getContext(), GedanActivity.class);
        startActivity(intent);
    }

    //初始化数据来源
    public void getData(){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rb_fm_fragment_main_one:
                Toast.makeText(getContext(), "点击了图片1", Toast.LENGTH_SHORT).show();
                moveGedan();
                break;
            case R.id.rb_meiri_fragment_main_one:
                Toast.makeText(getContext(), "点击了图片2", Toast.LENGTH_SHORT).show();
                moveGedan();
                break;
            case R.id.rb_yunyinyue_fragment_main_one:
                Toast.makeText(getContext(), "点击了图片3", Toast.LENGTH_SHORT).show();
                moveGedan();
                break;
            case R.id.ib_1_diantai_fragment:
                Toast.makeText(getContext(), "点击了图片1", Toast.LENGTH_SHORT).show();
                moveGedan();
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
