package com.app.cloudmusic.cloudmusic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class SearchDFragAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentsList;

    public SearchDFragAdapter(FragmentManager fm) {
        super(fm);
    }
    public SearchDFragAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragmentsList = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }
}
