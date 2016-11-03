package com.app.cloudmusic.cloudmusic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.activity.GedanActivity;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public class MainMusicFragment_one_dujia extends Fragment implements View.OnClickListener{

    private ImageButton ib4;
    private  View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_one_dujia,container,false);
        initView();
        return view;
    }

    public void initView(){
        ib4 = (ImageButton)view.findViewById(R.id.iv_4_dujia_fragment);
        ib4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_4_dujia_fragment:
                Intent intent = new Intent(getContext(), GedanActivity.class);
                startActivity(intent);
                break;
        }
    }
}
