package com.app.cloudmusic.cloudmusic.ViewpagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.app.cloudmusic.cloudmusic.fragment.FolderFragment;
import com.app.cloudmusic.cloudmusic.fragment.SingleFragment;
import com.app.cloudmusic.cloudmusic.fragment.SinnerFragment;
import com.app.cloudmusic.cloudmusic.fragment.SpecialFragment;

/**
 * Created by Administrator on 2016/10/13.
 */
public class LocalMusicViewpagerAdapter extends FragmentPagerAdapter{

      private SingleFragment singleFragment;
      private SinnerFragment sinnerFragment;
      private SpecialFragment specialFragment;
      private FolderFragment folderFragment;
      private final int PAGER_COUNT = 4;

    public LocalMusicViewpagerAdapter(FragmentManager fm) {
        super(fm);
        singleFragment = new SingleFragment();
        sinnerFragment = new SinnerFragment();
        specialFragment = new SpecialFragment();
        folderFragment = new FolderFragment();
    }



    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = singleFragment;
                break;
            case 1:
                fragment = sinnerFragment;
                break;
            case 2:
                fragment = specialFragment;
                break;
            case 3:
                fragment = folderFragment;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }
}
