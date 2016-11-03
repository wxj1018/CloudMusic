package com.app.cloudmusic.cloudmusic.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.adapter.VPAdapter;
import com.app.cloudmusic.cloudmusic.fragment.StarUserFragment;

import java.util.ArrayList;



public class StarUserActivity extends AppCompatActivity {

    ViewPager vp;
    ArrayList<Fragment> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_user);
        vp = (ViewPager) findViewById(R.id.vp_staruser);
        list.add(new StarUserFragment());
        list.add(new StarUserFragment());
        list.add(new StarUserFragment());
        VPAdapter adapter = new VPAdapter(list, getSupportFragmentManager());
        vp.setAdapter(adapter);


    }
}
