package com.app.cloudmusic.cloudmusic.Yuanzhongxue;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.cloudmusic.cloudmusic.Yuanzhongxue.Change;
import com.app.cloudmusic.cloudmusic.Yuanzhongxue.Modle;

import com.app.cloudmusic.cloudmusic.Yuanzhongxue.MyPopupWindow;
import com.app.cloudmusic.cloudmusic.Yuanzhongxue.PlayerService;
import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.Yuanzhongxue.ScanMusic;
import com.app.cloudmusic.cloudmusic.fragment.MyMusicLyricFragment;
import com.app.cloudmusic.cloudmusic.fragment.MyMusicpictureFragment;


import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class SearchActivity extends FragmentActivity implements View.OnClickListener ,Change,MyPopupWindow.ITest{


    private Fragment myMusicLyricFragment,myMusicpictureFragment;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    // 负责交互的动作
    Intent intent;
    // 扫描
    ScanMusic scan;
    // 动态数组
    ArrayList<Modle> arrlist;
    // 多媒体系统类
    MediaPlayer media;
    // 播放/下一曲/上一曲
    private ImageView  demo_img,play_img , next_img,repeat_img,recend_img;
    // 是否播放
    boolean isplay;
    // 时间和歌词
    TextView stop_time, start_time;
    // 进度条
    SeekBar my_seekbar;
    // 广播接收
   MyBrodcastRecriver mybrodcast;
    private float re;

    // 循环标志
    int repeatState = 0;
    Animation animation1;
    ImageView ivt1;
    TextView singer,sing;

    MyPopupWindow myPopupWindow;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicui);
        //循环
        demo_img = (ImageView) findViewById(R.id.previous_music);
        //上一首
        repeat_img = (ImageView) findViewById(R.id.repeat_music);
        //play或暂停
        play_img = (ImageView) findViewById(R.id.play_music);
        //下一首
        next_img = (ImageView) findViewById(R.id.next_music);
        //扫描本地音乐的列表
        recend_img = (ImageView) findViewById(R.id.list_music);

        //播放总时间
        stop_time = (TextView) findViewById(R.id.stop_time);
        //现在时间
        start_time = (TextView) findViewById(R.id.start_time);
        //进度条
        my_seekbar = (SeekBar) findViewById(R.id.bar_time);

        sing = (TextView)findViewById(R.id.tv_sing_activity_musicui);
        singer = (TextView)findViewById(R.id.tv_singer_activity_musicui);


        re=0.0f;


//两个碎片的实例
        myMusicLyricFragment = new MyMusicLyricFragment();
        myMusicpictureFragment = new MyMusicpictureFragment();
//        list_view = (ListView) findViewById(R.id.music_list);
//      关于播放等的监听
        demo_img.setOnClickListener(this);
        repeat_img.setOnClickListener(this);
        play_img.setOnClickListener(this);
        next_img.setOnClickListener(this);
        recend_img.setOnClickListener(this);
//实例化广播
        mybrodcast = new MyBrodcastRecriver();





    //进度条改变的监听
        my_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            //拖动进度条事件
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser == true){
                    Intent intent1 = new Intent();
                    intent1.setAction("ACTION_SEEKBAR_DRANG");
                    intent1.putExtra("progress",progress);
                    sendBroadcast(intent1);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        pictureViews();
        register();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, PlayerService.class);
        bindService(intent,connection,BIND_AUTO_CREATE);
    }
    private PlayerService.MyBind myBind;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBind = (PlayerService.MyBind) service;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public void register(){
        IntentFilter mintentfilter = new IntentFilter();
        mintentfilter.addAction("ACTION_ALLTIME");
        mintentfilter.addAction("ACTION_CURRENTTIME");
        mintentfilter.addAction("ACTION_TEXTGC");
        mintentfilter.addAction("ACTION");
        registerReceiver(mybrodcast, mintentfilter);
    }
    public void pictureViews() {
        //开启fragment事务
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.music_list, myMusicpictureFragment);
        transaction.commit();
    }


    public void lyricView() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.music_list, myMusicLyricFragment);
        transaction.commit();
    }

//播放，上一首，下一首等的监听
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.previous_music:
                repeatState++;
                choice();
                break;
            case R.id.repeat_music:
                NextMuisc(0);
                break;
            case R.id.play_music:
                isplay = !isplay;
                if (isplay==true){
                    v.setBackgroundResource(R.drawable.pause_selecter);

                    setAnimation();


                }else {
                    v.setBackgroundResource(R.drawable.play_selector);
                    Animation animation = AnimationUtils.loadAnimation(this,R.anim.picture_ui_1_pase);
                    LinearInterpolator lin = new LinearInterpolator();
                    animation.setInterpolator(lin);
                    ImageView ivt = (ImageView) findViewById(R.id.imageview_picture_ui_1);
                    ivt.startAnimation(animation);
                    animation.setFillAfter(true);

                    ivt1.clearAnimation();



                }
//                MusicPaly(isplay);

                break;
            case R.id.next_music:
                NextMuisc(1);
                break;
            case R.id.list_music:
                showPopupWindow();

                break;
            default:
                break;
        }
    }


    public void setAnimation(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.picture_ui_1);
        LinearInterpolator lin = new LinearInterpolator();
        animation.setInterpolator(lin);
        ImageView ivt = (ImageView) findViewById(R.id.imageview_picture_ui_1);
        ivt.startAnimation(animation);
        animation.setFillAfter(true);

        animation1 = AnimationUtils.loadAnimation(this,R.anim.picture_ui_1_big);
        LinearInterpolator lin1 = new LinearInterpolator();
        animation.setInterpolator(lin1);
        ivt1 = (ImageView) findViewById(R.id.imageview_picture_ui_1_big);
        ivt1.startAnimation(animation1);

    }
    public void showPopupWindow(){
        int height = getWindowManager().getDefaultDisplay().getHeight();
        myPopupWindow = new MyPopupWindow(this,height);
        myPopupWindow.showAtLocation(findViewById(R.id.rll_activity_musicui), Gravity.BOTTOM,0,0);

    }


    public void MusicPaly(boolean isplay) throws IOException {
//        Intent intent = new Intent();
//        intent.setAction("ACTION_ISPLAY");
//        intent.putExtra("isplay", isplay);
//        sendBroadcast(intent);


    }

    public void NextMuisc(int num) {
        Intent intent = new Intent();
        intent.setAction("ACTION_NEXT");
        intent.putExtra("next", num);
        sendBroadcast(intent);

    }
    //播放模式
    public void choice(){
        switch (repeatState%=3){
            case 0:
                demo_img.setBackgroundResource(R.drawable.previous_music_selector);
                break;
            case 1:
                demo_img.setBackgroundResource(R.drawable.shuffle_selector);
                break;
            case 2:
                demo_img.setBackgroundResource(R.drawable.one_selector);
                break;
            default:
                break;
        }
        setMention();
    }

    public void setMention(){
        Intent intent =new Intent();
        intent.setAction("ACTION_MENTION");
        intent.putExtra("mention", repeatState);
        sendBroadcast(intent);

    }

//图片合歌词界面的切换
    @Override
    public void changeFragment(String flag) {
        if("lyric".equals(flag)){
            Toast.makeText(SearchActivity.this,flag,Toast.LENGTH_LONG).show();
            pictureViews();
//切换成歌词
        }else  if("pic".equals(flag)){
// 切换成图片
            Toast.makeText(SearchActivity.this,flag,Toast.LENGTH_LONG).show();
           lyricView();
        }
    }

    @Override
    public void getTest(Bundle bundle) {
        Log.i("666",bundle.getString("key"));
        sing.setText(bundle.getString("key"));
        singer.setText(bundle.getString("key1"));
        setAnimation();
    }
}
//广播进行进度条，，时间的设置
 class MyBrodcastRecriver extends BroadcastReceiver{

     @Override
     public void onReceive(Context context, Intent intent) {
         if (intent.getAction().equals("ACTION_ALLTIME")){
             int maxtime = intent.getIntExtra("action_time", 0);
                new SearchActivity().my_seekbar.setMax(maxtime);
             new SearchActivity().stop_time.setText(setTime(maxtime));

         }else if (intent.getAction().equals("ACTION_CURRENTTIME")){
             int Currentime = intent.getIntExtra("action_currentime", 0);
             new SearchActivity().my_seekbar.setProgress(Currentime);
             new SearchActivity().start_time.setText(setTime(Currentime));

         }else if (intent.getAction().equals("ACTION_TEXTGC")){
             String str_lrc = intent.getStringExtra("gc");
             new MyMusicLyricFragment().lyric(str_lrc);

         }
     }
     public String setTime(int time) {
         time /= 1000;
         int minute = time / 60;
         int hour = minute / 60;
         int second = time % 60;
         minute %= 60;
         return String.format("%02d:%02d", minute, second);

     }
 }



