package com.example.administrator.cloudmusic;


import android.app.Activity;

import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;

import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.cloudmusic.activity.DriverModeActivity;
import com.example.administrator.cloudmusic.activity.MusicAlarmActivity;
import com.example.administrator.cloudmusic.activity.MyMessageActivity;
import com.example.administrator.cloudmusic.activity.OnlineMusicActivity;
import com.example.administrator.cloudmusic.activity.SettingActivity;
import com.example.administrator.cloudmusic.activity.ShopActivity;
import com.example.administrator.cloudmusic.activity.SoundHoundActivity;
import com.example.administrator.cloudmusic.activity.ThemeChangeActivity;
import com.example.administrator.cloudmusic.activity.TimerStopActivity;
import com.example.administrator.cloudmusic.activity.VipActivity;
import com.example.administrator.cloudmusic.adapter.SideSlipLVAdapter;

import java.util.Timer;
import java.util.TimerTask;


public class SideSlipActivity extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener{

    private int fllength1;
    private HorizontalScrollView hsv;
    private LinearLayout llweigth4;//存放ListView的LinearLayout
    private FrameLayout flweigth1;//实现空白区域的FrameLayout
    private Button setting, exit;
    private ListView lv_side_slip;//侧滑菜单的listview
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private View right_mode;
    private SideSlipLVAdapter sa;
    //侧滑菜单的图标
    private int[] icon = {R.drawable.icon1, R.drawable.icon2, R.drawable.icon3,
            R.drawable.icon4, R.drawable.icon5, R.drawable.icon6, R.drawable.icon7,
            R.drawable.icon8, R.drawable.icon9, R.drawable.icon10};
    //侧滑菜单的文字说明
    private String[] dcs = {"我的消息", "积分商城", "会员中心", "在线听歌免流量",
            "听歌识曲", "主题换肤", "夜间模式", "定时停止播放", "音乐闹钟", "驾驶模式"};
    private String[] timer = {"不开启", "10分钟后",  "20分钟后",  "30分钟后",
            "45分钟后",  "60分钟后", "自定义"};

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0){
//                SideSlipLVAdapter.ViewHolder vh= (SideSlipLVAdapter.ViewHolder) lv_side_slip.getChildAt(8).getTag();
//                lv_side_slip.setAdapter(sa);

//                TextView timerText = (TextView) lv_side_slip.getChildAt(8).findViewById(R.id.tv_right_side_slip_lv_item);
//                int time = mSharedPreferences.getInt("timer", 0);
//                if (time == 0){
//                    timerText.setVisibility(View.GONE);
//                }else {
//                    int hour = time/60;
//                    int minute = time%60;
//                    if (hour == 0){
//                        timerText.setText(minute + "");
//                    }else {
//                        timerText.setText(hour + " : " +minute );
//                    }
//                }
//                lv_side_slip.notifyAll();
            }

            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_slip);
       init();
        setLayout();
        hsv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP:
                        //根据滑动距离来判断是否finish
                        if (hsv.getScrollX()>fllength1*2){
                            finish();
                            overridePendingTransition(0, R.anim.exit_translate);
                        }else{
                            hsv.scrollTo(0,0);
                        }
                        break;
                }
                return false;
            }
        });
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message() ;
                msg.what = 0;
                mHandler.sendMessage(msg);
                Log.i("aaaaa", mSharedPreferences.getInt("timer", 0)+ "");

            }
        }, 3000, 1000);

    }

    private void init(){
        hsv = (HorizontalScrollView) findViewById(R.id.hsv);
        //获取Button控件
        setting = (Button) findViewById(R.id.setting_side_slip);
        setting.setOnClickListener(this);
        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(this);
        //获取ListView控件id
        lv_side_slip = (ListView) findViewById(R.id.lv_activity_side_slip);
        //ListView设置适配器
         sa=new SideSlipLVAdapter(icon, dcs, this);
        lv_side_slip.setAdapter(sa);
        //获得注入器
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        //通过注入器将Xml文件中的布局转换成View控件
        View headerView = inflater.inflate(R.layout.headerview, null);
        //为ListView添加头View
        lv_side_slip.addHeaderView(headerView);
        //为ListView设置Item点击监听
        lv_side_slip.setOnItemClickListener(this);

        //初始化SharedPreferences
        mSharedPreferences = getSharedPreferences("timer_position", MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

    }
    //ListView设置监听，跳转到对应的Activity
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){

            case 1:
                finish();
                overridePendingTransition(0, R.anim.exit_translate);
                startActivity(new Intent(SideSlipActivity.this, MyMessageActivity.class));
                break;
            case 2:
                startActivity(new Intent(SideSlipActivity.this, ShopActivity.class));
                finish();
                overridePendingTransition(0, R.anim.exit_translate);
                break;
            case 3:
                startActivity(new Intent(SideSlipActivity.this, VipActivity.class));
                finish();
                overridePendingTransition(0, R.anim.exit_translate);
                break;
            case 4:
                startActivity(new Intent(SideSlipActivity.this, OnlineMusicActivity.class));
                finish();
                overridePendingTransition(0, R.anim.exit_translate);
                break;
            case 5:
                startActivity(new Intent(SideSlipActivity.this, SoundHoundActivity.class));
                finish();
                overridePendingTransition(0, R.anim.exit_translate);
                break;
            case 6:
                startActivity(new Intent(SideSlipActivity.this, ThemeChangeActivity.class));
                finish();
                overridePendingTransition(0, R.anim.exit_translate);
                break;
            case 7:
                if (mSharedPreferences.getBoolean("mode", false)){//false代表夜间模式， ture代表白天模式
                    mEditor.putBoolean("mode", false);
                    mEditor.commit();
                    right_mode = view.findViewById(R.id.tv_right_side_slip_lv_item);
                    right_mode.setBackgroundResource(R.drawable.open);
                }else {
                    mEditor.putBoolean("mode", true);
                    mEditor.commit();
                    right_mode = view.findViewById(R.id.tv_right_side_slip_lv_item);
                    right_mode.setBackgroundResource(R.drawable.stop);
                }
                break;
            case 8:
               startActivity(new Intent(SideSlipActivity.this, TimerStopActivity.class));
                finish();

                overridePendingTransition(0, R.anim.exit_translate);
                break;
            case 9:
                startActivity(new Intent(SideSlipActivity.this, MusicAlarmActivity.class));
                finish();
                overridePendingTransition(0, R.anim.exit_translate);
                break;
            case 10:
                startActivity(new Intent(SideSlipActivity.this, DriverModeActivity.class));
                finish();
                overridePendingTransition(0, R.anim.exit_translate);
                break;
        }
    }
//设置比例，实现4 ：1
    private void setLayout(){
        //获取屏幕信息
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        //得到显示屏幕宽度
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        //1/5屏幕宽度
        fllength1 = metrics.widthPixels/5;
        //获取控件实例
        flweigth1 = (FrameLayout) findViewById(R.id.fl_weight1);
        flweigth1.setOnClickListener(this);
        llweigth4 = (LinearLayout) findViewById(R.id.ll_weight4);
        //控件参数
        ViewGroup.LayoutParams lpfl = flweigth1.getLayoutParams();
        lpfl.width = fllength1;
        flweigth1.setLayoutParams(lpfl);
        ViewGroup.LayoutParams lpll = llweigth4.getLayoutParams();
        lpll.width = fllength1*4;
        llweigth4.setLayoutParams(lpll);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting_side_slip://进入设置
                finish();
                overridePendingTransition(0,R.anim.exit_translate);
                startActivity(new Intent(SideSlipActivity.this, SettingActivity.class));
                break;
            case R.id.exit://退出应用程序
                Toast.makeText(this, "退出。。。", Toast.LENGTH_SHORT).show();
                finish();
                overridePendingTransition(0, R.anim.exit_translate);
                break;
            case R.id.fl_weight1://点击右边透明部分，让侧滑菜单小事
                finish();
                overridePendingTransition(0, R.anim.exit_translate);
                break;
        }
    }

}
