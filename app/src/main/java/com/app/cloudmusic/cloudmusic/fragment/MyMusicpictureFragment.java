package com.app.cloudmusic.cloudmusic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.cloudmusic.cloudmusic.Yuanzhongxue.Change;
import com.app.cloudmusic.cloudmusic.R;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/10/10 0010.
 */
public class MyMusicpictureFragment extends Fragment {

    public Change mChange;
    private ImageView iv1,iv2,iv3,iv4,iv5;
    private List<View>listview;
    private RelativeLayout rl,r2;
    private ViewPager vp;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_picture, container, false);
        rl = (RelativeLayout) view.findViewById(R.id.ll_fragment_picture);
        r2 = (RelativeLayout) view.findViewById(R.id.rll_picture_ui_1);



        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
//                mChange=(Change)  MyMusicpictureFragment.this.getActivity();
//                mChange.changeFragment("pic");
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });
        return view;
    }
    private void init(){
        mChange=(Change)  MyMusicpictureFragment.this.getActivity();
        mChange.changeFragment("pic");
    }


    }
