package com.app.cloudmusic.cloudmusic.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.cloudmusic.cloudmusic.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SinnerFragment extends Fragment {


    public SinnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sinner, container, false);
        return view;
    }

}
