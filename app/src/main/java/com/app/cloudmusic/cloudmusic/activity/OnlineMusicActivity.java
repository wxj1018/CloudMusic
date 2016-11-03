package com.app.cloudmusic.cloudmusic.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.onlineactivity.DianxinActivity;
import com.app.cloudmusic.cloudmusic.onlineactivity.LiantongActivity;
import com.app.cloudmusic.cloudmusic.onlineactivity.TipsActivity;

public class OnlineMusicActivity extends AppCompatActivity implements View.OnClickListener{
    private Button back;//标题栏的返回键
    private TextView tv_headertitle;//标题栏的TextView
    private LinearLayout online_liantong_activity_online;
    private LinearLayout online_dianxin_activity_online;
    private TextView online_tv_tips_activity_online;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_music);
        init();
    }

    private void init(){
        //标题栏
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
        tv_headertitle = (TextView) findViewById(R.id.tv_headertitle);
        tv_headertitle.setText("在线听歌免流量");
        //联通用户点击开通流量包
        online_liantong_activity_online = (LinearLayout) findViewById(R.id.online_liantong_activity_online);
        online_liantong_activity_online.setOnClickListener(this);
        //电信用户点击开通流量包
        online_dianxin_activity_online = (LinearLayout) findViewById(R.id.online_dianxin_activity_online);
        online_dianxin_activity_online.setOnClickListener(this);
        //最下面的提示
        online_tv_tips_activity_online = (TextView) findViewById(R.id.online_tv_tips_activity_online);
        online_tv_tips_activity_online.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.online_liantong_activity_online:
                startActivity(new Intent(OnlineMusicActivity.this, LiantongActivity.class));
                break;
            case R.id.online_dianxin_activity_online:
                startActivity(new Intent(OnlineMusicActivity.this, DianxinActivity.class));
                break;
            case R.id.online_tv_tips_activity_online:
                startActivity(new Intent(OnlineMusicActivity.this, TipsActivity.class));
                break;
        }
    }
}
