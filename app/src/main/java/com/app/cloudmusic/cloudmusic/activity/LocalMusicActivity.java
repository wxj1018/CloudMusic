package com.app.cloudmusic.cloudmusic.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.ViewpagerAdapter.LocalMusicViewpagerAdapter;

/**
 * Created by Administrator on 2016/10/13.
 */
public class LocalMusicActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,RadioGroup.OnCheckedChangeListener{

    static final int PAGE_SINGLE = 0;
    static final int PAGE_SINNER = 1;
    static final int PAGE_SPECIAL = 2;
    static final int PAGE_FOLDER = 3;

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private RadioButton rbtnSingle,rbtnSinner,rbtnSpecial,rbtnFolder;
    private LocalMusicViewpagerAdapter lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localmusic);

        radioGroup = (RadioGroup)findViewById(R.id.rg_activity_localmusic);
        rbtnSingle = (RadioButton)findViewById(R.id.rbtn_single_localmusic);
        rbtnSinner = (RadioButton)findViewById(R.id.rbtn_sinner_localmusic);
        rbtnSpecial = (RadioButton)findViewById(R.id.rbtn_special_localmusic);
        rbtnFolder = (RadioButton)findViewById(R.id.rbtn_folder_localmusic);
        radioGroup.setOnCheckedChangeListener(this);

        viewPager = (ViewPager)findViewById(R.id.vp_localmusic);
        lAdapter = new LocalMusicViewpagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(lAdapter);

        viewPager.setOnPageChangeListener(this);
    }

    public void backToMyMusic(View view){
        finish();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

        if (state==2){
            switch (viewPager.getCurrentItem()){
                case PAGE_SINGLE:
                    rbtnSingle.setChecked(true);
                    break;
                case PAGE_SINNER:
                    rbtnSinner.setChecked(true);
                    break;
                case PAGE_SPECIAL:
                    rbtnSpecial.setChecked(true);
                    break;
                case PAGE_FOLDER:
                    rbtnFolder.setChecked(true);
                    break;
            }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rbtn_single_localmusic:
                viewPager.setCurrentItem(PAGE_SINGLE);
                break;
            case R.id.rbtn_sinner_localmusic:
                viewPager.setCurrentItem(PAGE_SINNER);
                break;
            case R.id.rbtn_special_localmusic:
                viewPager.setCurrentItem(PAGE_SPECIAL);
                break;
            case R.id.rbtn_folder_localmusic:
                viewPager.setCurrentItem(PAGE_FOLDER);
                break;
        }
    }
}
