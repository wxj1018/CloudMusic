package com.app.cloudmusic.cloudmusic.fragment;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.ViewpagerAdapter.OtherListViewAdapter;
import com.app.cloudmusic.cloudmusic.activity.MenuActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleFragment extends Fragment implements View.OnClickListener{
    private ImageButton ibtnMemu;

    private ListView listView1;
    private OtherListViewAdapter otherAdapter;
    private String[] otherbeans = new String[]{"1","2","3"};

    public SingleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_single, container, false);

        this.init(view);

        return view;
    }


    private void init(View view){
        ibtnMemu = (ImageButton)view.findViewById(R.id.ibtn_memu);
        ibtnMemu.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibtn_memu:
                Intent intent = new Intent(getActivity().getApplication(), MenuActivity.class);
                startActivity(intent);
        }
    }

    private void initview(){
        Log.i("htp","otherbeans.size:"+ otherbeans.length);
        listView1 = (ListView) listView1.findViewById(R.id.lv_other_menu);
    }


}
