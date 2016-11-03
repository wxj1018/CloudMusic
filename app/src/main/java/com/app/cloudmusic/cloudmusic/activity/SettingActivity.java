package com.app.cloudmusic.cloudmusic.activity;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.cloudmusic.cloudmusic.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Button back;
    private TextView title;
    private TextView setting_wifi_activity_setting;
    private TextView setting_paly_activity_setting;
    private TextView setting_download_activity_setting;
    private TextView setting_show_activity_setting;
    private TextView setting_run_activity_setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();
    }
    private void init(){
        sharedPreferences = getSharedPreferences("timer_position", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
        title = (TextView) findViewById(R.id.tv_headertitle);
        title.setText("设置");

        setting_wifi_activity_setting = (TextView) findViewById(R.id.setting_wifi_activity_setting);
        setting_wifi_activity_setting.setOnClickListener(this);
        setting_paly_activity_setting = (TextView) findViewById(R.id.setting_paly_activity_setting);
        setting_paly_activity_setting.setOnClickListener(this);
        setting_download_activity_setting = (TextView) findViewById(R.id.setting_download_activity_setting);
        setting_download_activity_setting.setOnClickListener(this);
        setting_show_activity_setting = (TextView) findViewById(R.id.setting_show_activity_setting);
        setting_show_activity_setting.setOnClickListener(this);
        setting_run_activity_setting = (TextView) findViewById(R.id.setting_run_activity_setting);
        setting_run_activity_setting.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.setting_wifi_activity_setting:
                if (sharedPreferences.getBoolean("wifi_setting", false)){
                    editor.putBoolean("wifi_setting", false);
                    editor.commit();
                    updateImage(R.drawable.open,setting_wifi_activity_setting);
                }else {
                    editor.putBoolean("wifi_setting", true);
                    editor.commit();
                    updateImage(R.drawable.stop,setting_wifi_activity_setting);
                }
                break;
            case R.id.setting_paly_activity_setting:
                if (sharedPreferences.getBoolean("play_setting", false)){
                    editor.putBoolean("play_setting", false);
                    editor.commit();
                    updateImage(R.drawable.open,setting_paly_activity_setting);
                }else {
                    editor.putBoolean("play_setting", true);
                    editor.commit();
                    updateImage(R.drawable.stop,setting_paly_activity_setting);
                }
                break;
            case R.id.setting_download_activity_setting:
                if (sharedPreferences.getBoolean("download_setting", false)){
                    editor.putBoolean("download_setting", false);
                    editor.commit();
                    updateImage(R.drawable.open,setting_download_activity_setting);
                }else {
                    editor.putBoolean("download_setting", true);
                    editor.commit();
                    updateImage(R.drawable.stop,setting_download_activity_setting);
                }
                break;
            case R.id.setting_show_activity_setting:
                if (sharedPreferences.getBoolean("show_setting", false)){
                    editor.putBoolean("show_setting", false);
                    editor.commit();
                    updateImage(R.drawable.open,setting_show_activity_setting);
                }else {
                    editor.putBoolean("show_setting", true);
                    editor.commit();
                    updateImage(R.drawable.stop,setting_show_activity_setting);
                }
                break;
            case R.id.setting_run_activity_setting:
                if (sharedPreferences.getBoolean("run_setting", false)){
                    editor.putBoolean("run_setting", false);
                    editor.commit();
                    updateImage(R.drawable.open,setting_run_activity_setting);
                }else {
                    editor.putBoolean("run_setting", true);
                    editor.commit();
                    updateImage(R.drawable.stop,setting_run_activity_setting);
                }
                break;
        }
    }

    //改变Button的DrawableTop
    private void updateImage(int id, TextView view){
        Drawable nav_up4=getResources().getDrawable(id);
        nav_up4.setBounds(0, 0, nav_up4.getMinimumWidth(), nav_up4.getMinimumHeight());
        view.setCompoundDrawables(null, nav_up4, null, null);
    }
}
