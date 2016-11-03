package com.app.cloudmusic.cloudmusic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.cloudmusic.cloudmusic.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 *
 * 我的音乐界面
 */
public class MyMusicFragment extends Fragment {

    private ViewGroup viewPager;
    private List<Fragment> fragmentList;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mymusic, container, false);
    }

    private void InitViewPager(View parentView) {

        viewPager = (ViewPager)parentView.findViewById(R.id.vp_fragment_main);
        fragmentList = new ArrayList<Fragment>();
    }
}