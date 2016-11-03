package com.app.cloudmusic.cloudmusic.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.adapter.VPAdapter;

import java.util.ArrayList;



public class MyFriendFragment extends Fragment implements ViewPager.OnPageChangeListener,RadioGroup.OnCheckedChangeListener{

    private ViewPager vp;
    private ArrayList<Fragment> list=new ArrayList<>();
    private RadioButton rbtnDynamic,rbtnNearby,rbtnFriends;
    private RadioGroup rg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_my_friend, container, false);

        rbtnDynamic= (RadioButton) view.findViewById(R.id.rbtn_d_mf);
        rbtnNearby= (RadioButton) view.findViewById(R.id.rbtn_n_mf);
        rbtnFriends= (RadioButton) view.findViewById(R.id.rbtn_f_mf);
        rg= (RadioGroup) view.findViewById(R.id.rg_mf);
        rg.setOnCheckedChangeListener(this);


        vp= (ViewPager) view.findViewById(R.id.vp_myfriend);
        list.add(new DynamicFragment());
        list.add(new NearbyFragment());
        list.add(new FriendsFragment());
        VPAdapter adapter=new VPAdapter(list,getChildFragmentManager());
        vp.setAdapter(adapter);
        vp.setOnPageChangeListener(this);
        return view;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rbtn_d_mf:
                vp.setCurrentItem(0);
                break;
            case R.id.rbtn_n_mf:
                vp.setCurrentItem(1);
                break;
            case R.id.rbtn_f_mf:
                vp.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state==2){
            switch (vp.getCurrentItem()){
                case 0:
                    rbtnDynamic.setChecked(true);
                    break;
                case 1:
                    rbtnNearby.setChecked(true);
                    break;
                case 2:
                    rbtnFriends.setChecked(true);
                    break;
            }
        }
    }
}
