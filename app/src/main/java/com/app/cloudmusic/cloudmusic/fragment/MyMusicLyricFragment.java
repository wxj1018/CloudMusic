package com.app.cloudmusic.cloudmusic.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.app.cloudmusic.cloudmusic.Yuanzhongxue.Change;
import com.app.cloudmusic.cloudmusic.Yuanzhongxue.MyView;
import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.activity.SearchActivity;

import java.util.Random;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public class MyMusicLyricFragment extends Fragment {
    public Change mChange;

    LinearLayout sllv;
    com.app.cloudmusic.cloudmusic.Yuanzhongxue.MyView myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lyric,container,false);
        myView = (MyView) view.findViewById(R.id.tv_fragment_lyric);
        sllv = (LinearLayout) view.findViewById(R.id.llt_fragment_lyric);
        sllv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
//                mChange= (Change) getActivity();
//                mChange.changeFragment("lyric");
            }
        });
        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });

        return view;
    }
    private void init(){
        mChange= (Change) getActivity();
        mChange.changeFragment("lyric");

    }
    public void lyric(String s){
//        text_gc.setText(s);
    }
}
