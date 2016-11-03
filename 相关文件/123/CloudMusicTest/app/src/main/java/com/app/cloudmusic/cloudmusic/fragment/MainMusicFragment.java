package com.app.cloudmusic.cloudmusic.fragment;
import com.app.cloudmusic.cloudmusic.R;
import  com.app.cloudmusic.cloudmusic.fragment.*;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/10/9 0009.
 *
 * 主音乐界面
 */
public class MainMusicFragment extends Fragment implements View.OnClickListener{
    private ViewPager viewPager;// 声明一个viewpager对象
    private RadioButton rb_tuijian,rb_gedan,rb_diantai,rb_paihang;
    private ImageView iv_tabline;
    private List<android.support.v4.app.Fragment> fragmentList;// 声明一个list集合存放Fragment（数据源）
    private int tabLineLength;// 1/4屏幕宽
    private int currentPage = 0;// 初始化当前页为0（第一页
    private View view;
    private android.support.v4.app.FragmentTransaction transaction;
    private MainMusicFragment_one fragment_one;
    private MainMusicFragment_two fragment_two;
    private  MainMusicFragment_three fragment_three;
    private MainMusicFragment_four fragment_four;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main,container,false);
        ininView();
        initTabLine();
        return view;
    }

    private void initTabLine() {
        // 获取显示屏信息
        Display display = getActivity().getWindow().getWindowManager().getDefaultDisplay();
        // 得到显示屏宽度
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        // 1/3屏幕宽度
        tabLineLength = metrics.widthPixels / 4;
        // 获取控件实例
        iv_tabline = (ImageView)view.findViewById(R.id.iv_tabline_fragment);
        // 控件参数
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) iv_tabline.getLayoutParams();
        lp.width = tabLineLength;
        iv_tabline.setLayoutParams(lp);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void ininView() {
        //实例化对象
        viewPager = (ViewPager) view.findViewById(R.id.vp_fragment_main);
        rb_tuijian = (RadioButton) view.findViewById(R.id.rb_tuijian_fragment_main);
        rb_gedan = (RadioButton) view.findViewById(R.id.rb_gedan_fragment_main);
        rb_diantai = (RadioButton) view.findViewById(R.id.rb_diantai_fragment_main);
        rb_paihang = (RadioButton) view.findViewById(R.id.rb_paihang_fragment_main);
        rb_tuijian.setOnClickListener(this);
        rb_gedan.setOnClickListener(this);
        rb_diantai.setOnClickListener(this);
        rb_paihang.setOnClickListener(this);
        fragmentList = new ArrayList<android.support.v4.app.Fragment>();

        //设置数据源
        fragment_one = new MainMusicFragment_one();
        fragment_two = new MainMusicFragment_two();
        fragment_three = new MainMusicFragment_three();
        fragment_four = new MainMusicFragment_four();

        fragmentList.add(fragment_one);
        fragmentList.add(fragment_two);
        fragmentList.add(fragment_three);
        fragmentList.add(fragment_four);

        //设置适配器
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        //绑定适配器
        viewPager.setAdapter(adapter);

        //设置监听
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                LinearLayout.LayoutParams ll = (LinearLayout.LayoutParams) iv_tabline
                                       .getLayoutParams();
                currentPage=viewPager.getCurrentItem();
                if (currentPage == 0 && position == 0) { // 0->1移动(第一页到第二页)
                    ll.leftMargin = (int) (currentPage * tabLineLength + positionOffset * tabLineLength);
                } else if (currentPage == 1 && position == 1) { // 1->2移动（第二页到第三页）
                    ll.leftMargin = (int) (currentPage * tabLineLength + positionOffset * tabLineLength);
                } else if (currentPage == 2 && position == 2) { // 1->0移动（第二页到第一页）
                    ll.leftMargin = (int) (currentPage * tabLineLength + positionOffset * tabLineLength);
                } else if (currentPage == 3 && position == 2) { // 2->1移动（第三页到第二页）
                    ll.leftMargin = (int) (currentPage * tabLineLength - (1 - positionOffset) * tabLineLength);
                }else if (currentPage == 2 && position == 1){
                    ll.leftMargin = (int) (currentPage * tabLineLength - (1 - positionOffset) * tabLineLength);
                }else if (currentPage == 1 && position == 0){
                    ll.leftMargin = (int) (currentPage * tabLineLength - (1 - positionOffset) * tabLineLength);
                }

                iv_tabline.setLayoutParams(ll);
            }

            @Override
            public void onPageSelected(int position) {

                switch (position){
                    case 0:
                        rb_tuijian.setTextColor(Color.RED);
                        rb_gedan.setTextColor(Color.BLACK);
                        rb_diantai.setTextColor(Color.BLACK);
                        rb_paihang.setTextColor(Color.BLACK);
                    break;
                    case 1:
                        rb_tuijian.setTextColor(Color.BLACK);
                        rb_gedan.setTextColor(Color.RED);
                        rb_diantai.setTextColor(Color.BLACK);
                        rb_paihang.setTextColor(Color.BLACK);
                        break;
                    case 2:
                        rb_tuijian.setTextColor(Color.BLACK);
                        rb_gedan.setTextColor(Color.BLACK);
                        rb_diantai.setTextColor(Color.RED);
                        rb_paihang.setTextColor(Color.BLACK);
                        break;
                    case 3:
                        rb_tuijian.setTextColor(Color.BLACK);
                        rb_gedan.setTextColor(Color.BLACK);
                        rb_diantai.setTextColor(Color.BLACK);
                        rb_paihang.setTextColor(Color.RED);
                        break;
                }

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }




    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.rb_tuijian_fragment_main:
                viewPager.setCurrentItem(0);
                break;
            case R.id.rb_gedan_fragment_main:
                viewPager.setCurrentItem(1);
                break;
            case R.id.rb_diantai_fragment_main:
                viewPager.setCurrentItem(2);
                break;
            case R.id.rb_paihang_fragment_main:
                viewPager.setCurrentItem(3);
                break;


        }
    }

}