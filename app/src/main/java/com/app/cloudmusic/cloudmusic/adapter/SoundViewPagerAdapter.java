package com.app.cloudmusic.cloudmusic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.fragment.SoundStopKnowFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 */
public class SoundViewPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragments;
    public SoundViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
