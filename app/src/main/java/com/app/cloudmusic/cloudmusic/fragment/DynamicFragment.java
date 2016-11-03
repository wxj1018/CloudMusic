package com.app.cloudmusic.cloudmusic.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.activity.ChooseMusicActivity;
import com.app.cloudmusic.cloudmusic.activity.DyCriticismActivity;
import com.app.cloudmusic.cloudmusic.adapter.DynamicAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class DynamicFragment extends Fragment {

    private ListView lv;
    private ImageButton imageButton;
    private DynamicAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic, container, false);

        lv = (ListView) view.findViewById(R.id.lv_d_mf);
        adapter = new DynamicAdapter(getActivity().getApplicationContext());
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity().getApplication(), DyCriticismActivity.class));
            }
        });

        imageButton = (ImageButton) view.findViewById(R.id.ibtn_dy);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplication(), ChooseMusicActivity.class));
            }
        });


        return view;
    }

}
