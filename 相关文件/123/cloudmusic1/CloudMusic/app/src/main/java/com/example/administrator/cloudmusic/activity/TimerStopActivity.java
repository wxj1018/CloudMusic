package com.example.administrator.cloudmusic.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.cloudmusic.R;
import com.example.administrator.cloudmusic.TimerService;

public class TimerStopActivity extends Activity implements View.OnClickListener{

    private LinearLayout ll;
    private int width, height;
    private TextView timer_do_not_open_activity_timer, timer_10_minute_activity_timer,
            timer_20_minute_activity_timer, timer_30_minute_activity_timer,
            timer_45_minute_activity_timer, timer_60_minute_activity_timer,
            timer_myself_activity_timer, timer_setting_activity_timer;
    private int position;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private Intent intentService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_stop);
        initScreen();
        init();
        sharedPreferences = getSharedPreferences("timer_position",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        position = sharedPreferences.getInt("position", 0);
        setDrawableLeft(position);
        intentService = new Intent(TimerStopActivity.this, TimerService.class);

    }
    private void initScreen(){
        //获取屏幕信息
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        //得到显示屏幕宽度
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        //1/5屏幕宽度
        width = metrics.widthPixels/5*4;
        height = metrics.heightPixels/7*5;
        ll = (LinearLayout) findViewById(R.id.timer_ll_activity_timer);
        ViewGroup.LayoutParams lp = ll.getLayoutParams();
        lp.height = height;
        lp.width = width;
        ll.setLayoutParams(lp);
    }
    //初始化控件
    private void init(){
        timer_do_not_open_activity_timer = (TextView) findViewById(R.id.timer_do_not_open_activity_timer);
        timer_do_not_open_activity_timer.setOnClickListener(this);
        timer_10_minute_activity_timer = (TextView) findViewById(R.id.timer_10_minute_activity_timer);
        timer_10_minute_activity_timer.setOnClickListener(this);
        timer_20_minute_activity_timer = (TextView) findViewById(R.id.timer_20_minute_activity_timer);
        timer_20_minute_activity_timer.setOnClickListener(this);
        timer_30_minute_activity_timer = (TextView) findViewById(R.id.timer_30_minute_activity_timer);
        timer_30_minute_activity_timer.setOnClickListener(this);
        timer_45_minute_activity_timer = (TextView) findViewById(R.id.timer_45_minute_activity_timer);
        timer_45_minute_activity_timer.setOnClickListener(this);
        timer_60_minute_activity_timer = (TextView) findViewById(R.id.timer_60_minute_activity_timer);
        timer_60_minute_activity_timer.setOnClickListener(this);
        timer_myself_activity_timer = (TextView) findViewById(R.id.timer_myself_activity_timer);
        timer_myself_activity_timer.setOnClickListener(this);
        timer_setting_activity_timer = (TextView) findViewById(R.id.timer_setting_activity_timer);
        timer_setting_activity_timer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.timer_do_not_open_activity_timer:
                editor.putInt("position", 0);
                editor.putInt("timer", 0);
                editor.commit();
                setDrawableLeft(0);
                finish();
                Toast.makeText(TimerStopActivity.this, "定时停止播放已取消", Toast.LENGTH_SHORT).show();
                break;
            case R.id.timer_10_minute_activity_timer:
                editor.putInt("position", 1);
                editor.putInt("timer", 10*60);
                editor.commit();
                startService(intentService);
                setDrawableLeft(1);
                finish();
                Toast.makeText(TimerStopActivity.this, "设置成功，将于十分钟后关闭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.timer_20_minute_activity_timer:
                editor.putInt("position", 2);
                editor.putInt("timer", 20*60);
                editor.commit();
                startService(intentService);
                setDrawableLeft(2);
                finish();
                Toast.makeText(TimerStopActivity.this, "设置成功，将于二十分钟后关闭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.timer_30_minute_activity_timer:
                editor.putInt("position", 3);
                editor.putInt("timer", 30*60);
                editor.commit();
                startService(intentService);
                setDrawableLeft(3);
                finish();
                Toast.makeText(TimerStopActivity.this, "设置成功，将于三十分钟后关闭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.timer_45_minute_activity_timer:
                editor.putInt("position", 4);
                editor.putInt("timer", 45*60);
                editor.commit();
                startService(intentService);
                setDrawableLeft(4);
                finish();
                Toast.makeText(TimerStopActivity.this, "设置成功，将于四十五分钟后关闭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.timer_60_minute_activity_timer:
                 editor.commit();
                setDrawableLeft(5);
                startService(intentService);
                finish();
                Toast.makeText(TimerStopActivity.this, "设置成功，将于六十分钟后关闭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.timer_myself_activity_timer:
                editor.putInt("position", 6);
                editor.putInt("timer", 60*60);
                editor.commit();
                startService(intentService);
                setDrawableLeft(6);
                finish();
                Toast.makeText(TimerStopActivity.this, "设置成功，将于六十分钟后关闭", Toast.LENGTH_SHORT).show();
                break;
            case R.id.timer_setting_activity_timer:
                if (sharedPreferences.getBoolean("play_end_stop", false)){
                    Drawable nav_up4=getResources().getDrawable(R.drawable.timer_stop_right_no_chosed_activity_timer);
                    nav_up4.setBounds(0, 0, nav_up4.getMinimumWidth(), nav_up4.getMinimumHeight());
                    timer_setting_activity_timer.setCompoundDrawables(nav_up4, null, null, null);
                    editor.putBoolean("play_end_stop", false);
                    editor.commit();
                }else {
                    Drawable nav_up4=getResources().getDrawable(R.drawable.timer_stop_right_chosed_activity_timer);
                    nav_up4.setBounds(0, 0, nav_up4.getMinimumWidth(), nav_up4.getMinimumHeight());
                    timer_setting_activity_timer.setCompoundDrawables(nav_up4, null, null, null);
                    editor.putBoolean("play_end_stop", true);
                    editor.commit();
                }
                break;
        }
    }

    private void setDrawableLeft(int position){
        if (!sharedPreferences.getBoolean("play_end_stop", false)){
            Drawable nav_up4=getResources().getDrawable(R.drawable.timer_stop_right_no_chosed_activity_timer);
            nav_up4.setBounds(0, 0, nav_up4.getMinimumWidth(), nav_up4.getMinimumHeight());
            timer_setting_activity_timer.setCompoundDrawables(nav_up4, null, null, null);
        }else {
            Drawable nav_up4=getResources().getDrawable(R.drawable.timer_stop_right_chosed_activity_timer);
            nav_up4.setBounds(0, 0, nav_up4.getMinimumWidth(), nav_up4.getMinimumHeight());
            timer_setting_activity_timer.setCompoundDrawables(nav_up4, null, null, null);
        }
        switch (position){
            case 0:
                updateImage(R.drawable.timer_stop_right_chosed_activity_timer, timer_do_not_open_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_10_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_20_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_30_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_45_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_60_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_myself_activity_timer);
                editor.putInt("position", 0);
                editor.commit();
                break;
            case 1:
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_do_not_open_activity_timer);
                updateImage(R.drawable.timer_stop_right_chosed_activity_timer, timer_10_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_20_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_30_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_45_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_60_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_myself_activity_timer);
                editor.putInt("position", 1);
                editor.commit();
                break;
            case 2:
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_do_not_open_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_10_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_chosed_activity_timer, timer_20_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_30_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_45_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_60_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_myself_activity_timer);
                editor.putInt("position", 2);
                editor.commit();
                break;
            case 3:
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_do_not_open_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_10_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_20_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_chosed_activity_timer, timer_30_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_45_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_60_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_myself_activity_timer);
                editor.putInt("position", 3);
                editor.commit();
                break;
            case 4:
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_do_not_open_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_10_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_20_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_30_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_chosed_activity_timer, timer_45_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_60_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_myself_activity_timer);
                editor.putInt("position", 4);
                editor.commit();
                break;
            case 5:
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_do_not_open_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_10_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_20_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_30_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_45_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_chosed_activity_timer, timer_60_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_myself_activity_timer);
                editor.putInt("position", 5);
                editor.commit();
                break;
            case 6:
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_do_not_open_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_10_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_20_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_30_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_45_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_no_chosed_activity_timer, timer_60_minute_activity_timer);
                updateImage(R.drawable.timer_stop_right_chosed_activity_timer, timer_myself_activity_timer);
                editor.putInt("position", 6);
                editor.commit();
                break;
        }
    }
    private void updateImage(int id, TextView view){
        Drawable nav_up4=getResources().getDrawable(id);
        nav_up4.setBounds(0, 0, nav_up4.getMinimumWidth(), nav_up4.getMinimumHeight());
        view.setCompoundDrawables(null, null, nav_up4, null);
    }
}
