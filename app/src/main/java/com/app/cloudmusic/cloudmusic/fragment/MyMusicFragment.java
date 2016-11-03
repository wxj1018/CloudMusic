package com.app.cloudmusic.cloudmusic.fragment;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.activity.DownloadManagerActivity;
import com.app.cloudmusic.cloudmusic.activity.LocalMusicActivity;
import com.app.cloudmusic.cloudmusic.activity.MySinnerActivity;
import com.app.cloudmusic.cloudmusic.activity.RecentPlayActivity;


/**
 * Created by Administrator on 2016/10/9 0009.
 *
 * 我的音乐界面
 */
public class MyMusicFragment extends Fragment implements View.OnClickListener{

    private Button button1,button2,button3,button4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mymusic,container,false);

        this.init(view);

        return view;
    }

    private void init(View view) {
        button1 = (Button) view.findViewById(R.id.button1);
        button2 = (Button) view.findViewById(R.id.button2);
        button3 = (Button) view.findViewById(R.id.button3);
        button4 = (Button) view.findViewById(R.id.button4);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                Intent intent1 = new Intent(getActivity().getApplication(), LocalMusicActivity.class);
                startActivity(intent1);
                break;

            case R.id.button2:
                Intent intent2 = new Intent(getActivity().getApplication(), RecentPlayActivity.class);
                startActivity(intent2);
                break;

            case R.id.button3:
                Intent intent3 = new Intent(getActivity().getApplication(),DownloadManagerActivity.class);
                startActivity(intent3);
                break;

            case R.id.button4:
                Intent intent4 = new Intent(getActivity().getApplication(),MySinnerActivity.class);
                startActivity(intent4);
                break;
        }
    }
}
