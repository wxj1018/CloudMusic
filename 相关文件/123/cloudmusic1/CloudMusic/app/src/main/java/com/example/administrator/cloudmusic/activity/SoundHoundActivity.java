package com.example.administrator.cloudmusic.activity;

import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.cloudmusic.R;
import com.example.administrator.cloudmusic.adapter.SoundViewPagerAdapter;
import com.example.administrator.cloudmusic.fragment.SoundHistoryFragment;
import com.example.administrator.cloudmusic.fragment.SoundStartKnowFragment;
import com.example.administrator.cloudmusic.fragment.SoundStopKnowFragment;

import java.util.ArrayList;
import java.util.List;

public class SoundHoundActivity extends AppCompatActivity implements View.OnClickListener{
    private Button back;//返回
    private TextView sound_know_activity_sound;//听歌识曲
    private TextView sound_history_activity_sound;//识别历史
    private Button sound_clear_activity_sound;//清空
    private ViewPager sound_vp_activity_sound;
    private List<Fragment> fragments;
    private ImageView tableline_sound;//下滑红线
    private int halfScreenWidth;//屏幕的一半宽度
    private LinearLayout.LayoutParams lp;
    private int currentPosition;//ViewPager当前被选中的位置
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_hound);
        init();
        getScreenMsg();
    }

    private void init(){
        //初始化控件
        back = (Button) findViewById(R.id.back);
        sound_know_activity_sound = (TextView) findViewById(R.id.sound_know_activity_sound);
        sound_know_activity_sound.setOnClickListener(this);
        sound_history_activity_sound = (TextView) findViewById(R.id.sound_history_activity_sound);
        sound_history_activity_sound.setOnClickListener(this);
        sound_vp_activity_sound = (ViewPager) findViewById(R.id.sound_vp_activity_sound);
        sound_clear_activity_sound = (Button) findViewById(R.id.sound_clear_activity_sound);
        sound_clear_activity_sound.setOnClickListener(this);
        //初始化Fragment
        Fragment startKnow = new SoundStartKnowFragment();
        Fragment history = new SoundHistoryFragment();
        //创建数据
        fragments = new ArrayList<Fragment>();
        fragments.add(startKnow);
        fragments.add(history);
        //为ViewPager添加适配器
        SoundViewPagerAdapter adapter = new SoundViewPagerAdapter(this.getSupportFragmentManager(), (ArrayList<Fragment>) fragments);
        sound_vp_activity_sound.setAdapter(adapter);
        sound_vp_activity_sound.setCurrentItem(0);
        sound_vp_activity_sound.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (currentPosition == 0 && position == 0){
                   lp.leftMargin = (int)(currentPosition*halfScreenWidth + positionOffset*halfScreenWidth);
                }
                if (currentPosition == 1 && position == 0){
                    lp.leftMargin = (int)(currentPosition*halfScreenWidth - (1-positionOffset)*halfScreenWidth);
                }
                tableline_sound.setLayoutParams(lp);
            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        sound_know_activity_sound.setTextColor(Color.RED);
                        sound_history_activity_sound.setTextColor(Color.BLACK);
                        lp.leftMargin = 0;
                        sound_clear_activity_sound.setVisibility(View.GONE);
                        break;
                    case 1:
                        sound_know_activity_sound.setTextColor(Color.BLACK);
                        sound_history_activity_sound.setTextColor(Color.RED);
                        lp.leftMargin = halfScreenWidth;
                        sound_clear_activity_sound.setVisibility(View.VISIBLE);
                        break;
                }
                currentPosition = position;
                tableline_sound.setLayoutParams(lp);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void getScreenMsg(){
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        tableline_sound = (ImageView) findViewById(R.id.tableline_sound);
        lp = (LinearLayout.LayoutParams) tableline_sound.getLayoutParams();
        halfScreenWidth= display.getWidth()/2;
        lp.width = halfScreenWidth;
        tableline_sound.setLayoutParams(lp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.sound_know_activity_sound:
                sound_clear_activity_sound.setVisibility(View.GONE);
                sound_vp_activity_sound.setCurrentItem(0);
                break;
            case R.id.sound_history_activity_sound:
                sound_clear_activity_sound.setVisibility(View.VISIBLE);
                sound_vp_activity_sound.setCurrentItem(1);
                break;
            case R.id.sound_clear_activity_sound:
                Toast.makeText(SoundHoundActivity.this, "清空历史记录", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
