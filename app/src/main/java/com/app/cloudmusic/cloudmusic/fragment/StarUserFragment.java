package com.app.cloudmusic.cloudmusic.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.app.cloudmusic.cloudmusic.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class StarUserFragment extends Fragment {
    private ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_star_user, container, false);
//        lv= (ListView) view.findViewById(R.id.lv_staruser);
//        MTUserAdapter adapter=new MTUserAdapter(getActivity().getApplicationContext());
//        lv.setAdapter(adapter);
        return view;
    }

}
