package com.example.administrator.cloudmusic.activity;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.cloudmusic.R;

public class DriverModeActivity extends AppCompatActivity implements View.OnClickListener{
    private static boolean PLAY_STATE = false;//播放状态，播放还是暂停
    private static boolean BROADCAST_STATE = false;//电台状态，歌还是电台
    private static boolean LIKEMODE_STATE = false;//收藏状态，收藏还是不收藏
    private Button driver_back_activity_driver;//返回×
    private Button driver_broadcast_activity_driver;//行车电台
    private  Button driver_likemode_activity_driver;//订阅
    private TextView driver_song_name, driver_singer;
    //分别是上一首，暂停，下一首
    private Button driver_previous_activity_driver, driver_pause_activity_driver, driver_next_activity_driver;
    private Button driver_rotate_activity_driver;//旋转屏幕

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_mode);
        init();
    }

    private void init(){
        //第一行
        driver_back_activity_driver = (Button) findViewById(R.id.driver_back_activity_driver);
        driver_back_activity_driver.setOnClickListener(this);
        driver_broadcast_activity_driver = (Button) findViewById(R.id.driver_broadcast_activity_driver);
        driver_broadcast_activity_driver.setOnClickListener(this);
        driver_likemode_activity_driver = (Button) findViewById(R.id.driver_likemode_activity_driver);
        driver_likemode_activity_driver.setOnClickListener(this);

        //歌曲信息
        driver_song_name = (TextView) findViewById(R.id.driver_song_name);
        driver_singer = (TextView) findViewById(R.id.driver_singer);

        //控制播放状态，上一首，暂停，下一首
        driver_previous_activity_driver = (Button) findViewById(R.id.driver_previous_activity_driver);
        driver_previous_activity_driver.setOnClickListener(this);
        driver_pause_activity_driver = (Button) findViewById(R.id.driver_pause_activity_driver);
        driver_pause_activity_driver.setOnClickListener(this);
        driver_next_activity_driver = (Button) findViewById(R.id.driver_next_activity_driver);
        driver_next_activity_driver.setOnClickListener(this);

        //旋转屏幕
        driver_rotate_activity_driver = (Button) findViewById(R.id.driver_rotate_activity_driver);
        driver_rotate_activity_driver.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //点击返回后finish
            case R.id.driver_back_activity_driver:
                finish();
                break;
            //点击后判断状态来切换电台或者音乐
            case R.id.driver_broadcast_activity_driver:
                if (BROADCAST_STATE){
                    BROADCAST_STATE = !BROADCAST_STATE;//切换状态
                    driver_broadcast_activity_driver.setBackgroundResource(R.drawable.driver_broadcast);
                    driver_song_name.setText("十年");
                    driver_singer.setText("陈奕迅");
                    driver_likemode_activity_driver.setBackgroundResource(R.drawable.driver_likemode);
                }else {
                    BROADCAST_STATE = !BROADCAST_STATE;//切换状态
                    Toast.makeText(DriverModeActivity.this, "正在加载节目，请稍候...", Toast.LENGTH_SHORT).show();
                    driver_broadcast_activity_driver.setBackgroundResource(R.drawable.driver_broadcast_checked_activity_driver);
                    driver_song_name.setText("电台：《跟着电影去旅行》");
                    driver_singer.setText("苍井空跟你聊聊天 记住我是世界的哦");
                    driver_likemode_activity_driver.setBackgroundResource(R.drawable.driver_take_broadcast);
                }
                break;
            //点击后根据状态来收藏或者取消收藏，会先判断是电台还是音乐
            case R.id.driver_likemode_activity_driver:
                if (BROADCAST_STATE){//电台状态
                    if (LIKEMODE_STATE){
                        //取消电台收藏
                        LIKEMODE_STATE = !LIKEMODE_STATE;//切换状态
                        driver_likemode_activity_driver.setBackgroundResource(R.drawable.driver_take_broadcast);
                        //TODO
                        Toast.makeText(DriverModeActivity.this, "这个电台我已经听烦了，不喜欢了...", Toast.LENGTH_SHORT).show();
                    }else {
                        //增加电台收藏
                        LIKEMODE_STATE = !LIKEMODE_STATE;//切换状态
                        driver_likemode_activity_driver.setBackgroundResource(R.drawable.dirver_likemode_broadcast_changed_activity_dirver);
                        //TODO
                        Toast.makeText(DriverModeActivity.this, "这个电台我很喜欢，收藏了...", Toast.LENGTH_SHORT).show();
                    }
                }else {//音乐状态
                    if (LIKEMODE_STATE){
                        //取消歌曲收藏
                        LIKEMODE_STATE = !LIKEMODE_STATE;//切换状态
                        driver_likemode_activity_driver.setBackgroundResource(R.drawable.driver_likemode_song_changed_activity_driver);
                        //TODO
                        Toast.makeText(DriverModeActivity.this, "这首歌我不喜欢了,pass", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        //收藏歌曲
                        LIKEMODE_STATE = !LIKEMODE_STATE;//切换状态
                        driver_likemode_activity_driver.setBackgroundResource(R.drawable.driver_likemode);
                        //TODO
                        Toast.makeText(DriverModeActivity.this, "这首歌我很中意，收藏了", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case R.id.driver_previous_activity_driver://播放上一首
                if (BROADCAST_STATE){
                    driver_song_name.setText("我是上一个电台");
                    driver_singer.setText("陈奕迅：还能不能听我唱歌，听什么电台");
                    Toast.makeText(DriverModeActivity.this, "开始播放上一个电台，脱衣服吗？亲...", Toast.LENGTH_SHORT).show();
                }else {
                    driver_song_name.setText("我是上一首");
                    driver_singer.setText("陈奕迅：还是我的歌");
                    Toast.makeText(DriverModeActivity.this, "开始播放上一首，请脱衣服...", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.driver_pause_activity_driver:
                if (PLAY_STATE){//播放状态转停止状态
                    PLAY_STATE = !PLAY_STATE;
                    driver_pause_activity_driver.setBackgroundResource(R.drawable.driver_pause);
                    Toast.makeText(DriverModeActivity.this, "我停止了", Toast.LENGTH_SHORT).show();
                }else {//停止状态转播放状态
                    PLAY_STATE = !PLAY_STATE;
                    driver_pause_activity_driver.setBackgroundResource(R.drawable.driver_play);
                    Toast.makeText(DriverModeActivity.this, "我开始播放了", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.driver_next_activity_driver:
                if (BROADCAST_STATE){
                    driver_song_name.setText("我下一个电台");
                    driver_singer.setText("陈奕迅：还能不能听我唱歌，听什么电台");
                    Toast.makeText(DriverModeActivity.this, "开始播放下一个电台，脱裤子吗？亲...", Toast.LENGTH_SHORT).show();
                }else {
                    driver_song_name.setText("我是下一首");
                    driver_singer.setText("陈奕迅：还是我的歌");
                    Toast.makeText(DriverModeActivity.this, "开始播放下一首，请脱裤子...", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.driver_rotate_activity_driver:
                if (DriverModeActivity.this.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) {// 无法进行画面的旋转
                    Toast.makeText(DriverModeActivity.this, "无法改变屏幕方向", Toast.LENGTH_SHORT).show();
                } else {
                    if (DriverModeActivity.this.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) { // 现在的方向是横屏显示
                        DriverModeActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 变为竖屏显示
                    } else if (DriverModeActivity.this.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) { // 如果为竖屏显示
                        DriverModeActivity.this
                                .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // 变为横屏显示
                    }
                }
                break;
        }

    }
}
