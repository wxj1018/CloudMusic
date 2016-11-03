package com.app.cloudmusic.cloudmusic.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.activity.DyCriticismActivity;
import com.app.cloudmusic.cloudmusic.adapter.NearbyAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class NearbyFragment extends Fragment {

    private ListView lv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_nearby, container, false);
        lv= (ListView) view.findViewById(R.id.lv_n_mf);
        NearbyAdapter adapter=new NearbyAdapter(getActivity().getApplicationContext());
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity().getApplication(), DyCriticismActivity.class));
            }
        });
        return view;
    }

}
