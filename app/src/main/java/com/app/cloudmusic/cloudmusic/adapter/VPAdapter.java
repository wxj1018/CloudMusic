package com.app.cloudmusic.cloudmusic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by yg on 2016/10/21.
 */
public class VPAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> list;

    public VPAdapter(ArrayList<Fragment> list, FragmentManager fm) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
