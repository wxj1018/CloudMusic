package com.app.cloudmusic.cloudmusic.ViewpagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.app.cloudmusic.cloudmusic.fragment.Broadcasting_stationFragment;
import com.app.cloudmusic.cloudmusic.fragment.DownloadingFragment;
import com.app.cloudmusic.cloudmusic.fragment.MVFragment;
import com.app.cloudmusic.cloudmusic.fragment.Single2Fragment;

/**
 * Created by Administrator on 2016/10/13.
 */
public class DownloadManagerViewpagerAdapter extends FragmentPagerAdapter{

    private Single2Fragment single2Fragment;
    private Broadcasting_stationFragment broadcasting_stationFragment;
    private MVFragment mvFragment;
    private DownloadingFragment downloadingFragment;
    private final int PAGER_COUNT = 4;

    public DownloadManagerViewpagerAdapter(FragmentManager fm) {
        super(fm);
        single2Fragment = new Single2Fragment();
        broadcasting_stationFragment = new Broadcasting_stationFragment();
        mvFragment = new MVFragment();
        downloadingFragment = new DownloadingFragment();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = single2Fragment;
                break;
            case 1:
                fragment = broadcasting_stationFragment;
                break;
            case 2:
                fragment = mvFragment;
                break;
            case 3:
                fragment = downloadingFragment;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }
}
