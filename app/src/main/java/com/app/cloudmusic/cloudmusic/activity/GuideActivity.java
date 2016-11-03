package com.app.cloudmusic.cloudmusic.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.app.cloudmusic.cloudmusic.HomeActivity;
import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.adapter.GuideAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导页
 */
public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private GuideAdapter adapter;
    private List<View> imgs;
    private LayoutInflater inflater;
    private Button start;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);



        inflater=LayoutInflater.from(this);
        viewPager= (ViewPager) findViewById(R.id.guide_pager);
        start= (Button) findViewById(R.id.btn_startgame);
        imgs=new ArrayList<View>();
        imgs.add(inflater.inflate(R.layout.guide2,null));
        imgs.add(inflater.inflate(R.layout.guide3,null));
        imgs.add(inflater.inflate(R.layout.guide4,null));
        imgs.add(inflater.inflate(R.layout.guide1,null));
        imgs.add(inflater.inflate(R.layout.guide5,null));
        adapter=new GuideAdapter(this,imgs);
        viewPager.setOnPageChangeListener(this);
        viewPager.setAdapter(adapter);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this,HomeActivity.class));
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position==3){
            start.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}