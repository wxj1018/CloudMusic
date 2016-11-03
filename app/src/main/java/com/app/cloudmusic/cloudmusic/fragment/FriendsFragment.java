package com.app.cloudmusic.cloudmusic.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.activity.MaybeKnowActivity;
import com.app.cloudmusic.cloudmusic.activity.MusicTalentActivity;
import com.app.cloudmusic.cloudmusic.activity.StarUserActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsFragment extends Fragment implements View.OnClickListener {

    private Button btnKnow, btnStar, btnTalent;
    private ListView lvmyfriends;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);
        btnKnow = (Button) view.findViewById(R.id.btn_know_f);
        btnStar = (Button) view.findViewById(R.id.btn_star_f);
        btnTalent = (Button) view.findViewById(R.id.btn_talent_f);
        btnKnow.setOnClickListener(this);
        btnStar.setOnClickListener(this);
        btnTalent.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_know_f:
                startActivity(new Intent(getActivity().getApplication(), MaybeKnowActivity.class));
                break;
            case R.id.btn_star_f:
                startActivity(new Intent(getActivity().getApplication(), StarUserActivity.class));
                break;
            case R.id.btn_talent_f:
                startActivity(new Intent(getActivity().getApplication(), MusicTalentActivity.class));
                break;
        }
    }

}
