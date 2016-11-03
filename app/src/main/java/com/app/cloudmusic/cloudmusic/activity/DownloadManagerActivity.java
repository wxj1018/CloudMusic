package com.app.cloudmusic.cloudmusic.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.ViewpagerAdapter.DownloadManagerViewpagerAdapter;

/**
 * Created by Administrator on 2016/10/12.
 */
public class DownloadManagerActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,RadioGroup.OnCheckedChangeListener{

    static final int PAGE_SINGLE2 = 0;
    static final int PAGE_BROADCASTING_STATION = 1;
    static final int PAGE_MV = 2;
    static final int PAGE_DOWNLOADING = 3;

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private RadioButton rbtnSingle2,rbtnBroadcasting_station,rbtnMv,rbtnDownloading;
    private DownloadManagerViewpagerAdapter dAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_manager);

        radioGroup = (RadioGroup)findViewById(R.id.rg_activity_download_manager);
        rbtnSingle2 = (RadioButton)findViewById(R.id.rbtn_single2_download_manager);
        rbtnBroadcasting_station = (RadioButton)findViewById(R.id.rbtn_broadcasting_station_download_manager);
        rbtnMv = (RadioButton)findViewById(R.id.rbtn_mv_download_manager);
        rbtnDownloading = (RadioButton)findViewById(R.id.rbtn_downloading_download_manager);
        radioGroup.setOnCheckedChangeListener(this);

        viewPager = (ViewPager)findViewById(R.id.vp_download_manager);
        dAdapter = new DownloadManagerViewpagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(dAdapter);

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

        if (state == 2){
            switch (viewPager.getCurrentItem()){
                case PAGE_SINGLE2:
                    rbtnSingle2.setChecked(true);
                    break;
                case PAGE_BROADCASTING_STATION:
                    rbtnBroadcasting_station.setChecked(true);
                    break;
                case PAGE_MV:
                    rbtnMv.setChecked(true);
                    break;
                case PAGE_DOWNLOADING:
                    rbtnDownloading.setChecked(true);
                    break;
            }
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){
            case R.id.rbtn_single2_download_manager:
                viewPager.setCurrentItem(PAGE_SINGLE2);
                break;
            case R.id.rbtn_broadcasting_station_download_manager:
                viewPager.setCurrentItem(PAGE_BROADCASTING_STATION);
                break;
            case R.id.rbtn_mv_download_manager:
                viewPager.setCurrentItem(PAGE_MV);
                break;
            case R.id.rbtn_downloading_download_manager:
                viewPager.setCurrentItem(PAGE_DOWNLOADING);
                break;
        }

    }
}
