package com.example.administrator.cloudmusic.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.cloudmusic.R;
import com.example.administrator.cloudmusic.secondactivity.LoginActivity;
import com.example.administrator.cloudmusic.secondactivity.OpenVipActivity;
import com.example.administrator.cloudmusic.secondactivity.SQActivity;
import com.example.administrator.cloudmusic.secondactivity.ToFriendActivity;
import com.example.administrator.cloudmusic.secondactivity.VipLotteryActivity;
import com.example.administrator.cloudmusic.secondactivity.VipMyBuyMusicActivity;
import com.example.administrator.cloudmusic.secondactivity.VipSaleActivity;
import com.example.administrator.cloudmusic.secondactivity.VipSuperTagActivity;
import com.example.administrator.cloudmusic.secondactivity.VipUpdateActivity;
import com.example.administrator.cloudmusic.secondactivity.VipUseActivity;
import com.example.administrator.cloudmusic.secondactivity.VipUseRedeemCodeActivity;

public class VipActivity extends AppCompatActivity implements View.OnClickListener{
    private Button back;//标题栏返回
    private TextView tv_headertitle;//标题栏文字
    private LinearLayout tips_ll_activity_vip;//提示栏，点击后跳转到登录界面
    private Button im_open_activity_vip;//立即开通
    private Button supervip_activity_vip;//豪华会员
    private Button commondvip_activity_vip;//普通会员
    private Button vip_sp_activity_vip, vip_music_packge_activity_vip, vip_sale_activity_vip,
            vip_tag_activity_vip, vip_lottery_activity_vip, vip_update_activity_vip;
    private TextView line_left_activity_vip, line_right_activity_vip;
    private LinearLayout tofriend_buy_activity_vip, ues_redeem_code, buy_music_activity_vip;
    private TextView vip_tv_foot_tips_activity_vip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip);
        init();
    }

    private void init(){
        //初始化标题栏
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
        tv_headertitle = (TextView) findViewById(R.id.tv_headertitle);
        tv_headertitle.setText("会员中心");
        //提示栏
        tips_ll_activity_vip = (LinearLayout) findViewById(R.id.tips_ll_activity_vip);
        tips_ll_activity_vip.setOnClickListener(this);
        //立即开通
        im_open_activity_vip = (Button) findViewById(R.id.im_open_activity_vip);
        im_open_activity_vip.setOnClickListener(this);
        //会员分类
        commondvip_activity_vip = (Button) findViewById(R.id.commondvip_activity_vip);
        commondvip_activity_vip.setOnClickListener(this);
        supervip_activity_vip = (Button) findViewById(R.id.supervip_activity_vip);
        supervip_activity_vip.setOnClickListener(this);

        //两行button
        vip_sp_activity_vip = (Button) findViewById(R.id.vip_sp_activity_vip);
        vip_sp_activity_vip.setOnClickListener(this);
        vip_music_packge_activity_vip = (Button) findViewById(R.id.vip_music_packge_activity_vip);
        vip_music_packge_activity_vip.setOnClickListener(this);
        vip_sale_activity_vip = (Button) findViewById(R.id.vip_sale_activity_vip);
        vip_sale_activity_vip.setOnClickListener(this);
        vip_tag_activity_vip = (Button) findViewById(R.id.vip_tag_activity_vip);
        vip_tag_activity_vip.setOnClickListener(this);
        vip_lottery_activity_vip = (Button) findViewById(R.id.vip_lottery_activity_vip);
        vip_lottery_activity_vip.setOnClickListener(this);
        vip_update_activity_vip = (Button) findViewById(R.id.vip_update_activity_vip);
        vip_update_activity_vip.setOnClickListener(this);

        //两个下划线
        line_left_activity_vip = (TextView) findViewById(R.id.line_left_activity_vip);
        line_right_activity_vip = (TextView) findViewById(R.id.line_right_activity_vip);

        //三个LinearLayout
        tofriend_buy_activity_vip = (LinearLayout) findViewById(R.id.tofriend_buy_activity_vip);
        tofriend_buy_activity_vip.setOnClickListener(this);
        ues_redeem_code = (LinearLayout) findViewById(R.id.ues_redeem_code);
        ues_redeem_code.setOnClickListener(this);
        buy_music_activity_vip = (LinearLayout) findViewById(R.id.buy_music_activity_vip);
        buy_music_activity_vip.setOnClickListener(this);

        //底部提示
        vip_tv_foot_tips_activity_vip = (TextView) findViewById(R.id.vip_tv_foot_tips_activity_vip);
        vip_tv_foot_tips_activity_vip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back://标题栏返回
                finish();
                break;


            case R.id.tips_ll_activity_vip://提示警告栏
                startActivity(new Intent(VipActivity.this, LoginActivity.class));
                break;
            case R.id.im_open_activity_vip://立即开通会员
                startActivity(new Intent(VipActivity.this, OpenVipActivity.class));
                break;


            case R.id.commondvip_activity_vip://普通会员
                line_right_activity_vip.setBackgroundResource(R.color.textcolor_checked);
                line_left_activity_vip.setBackgroundResource(R.color.white);
                updateImage(R.drawable.vip_black_sale_activity_vip, vip_sale_activity_vip);
                updateImage(R.drawable.vip_black_tag_activity_vip, vip_tag_activity_vip);
                updateImage(R.drawable.vip_black_lottery_activity_vip, vip_lottery_activity_vip);
                updateImage(R.drawable.vip_black_update_activity_vip, vip_update_activity_vip);

                Log.i("aaaaa", "commondvip_activity_vip");
                break;
            case R.id.supervip_activity_vip://豪华会员
                line_right_activity_vip.setBackgroundResource(R.color.white);
                line_left_activity_vip.setBackgroundResource(R.color.textcolor_checked);
                updateImage(R.drawable.vip_sale_activity_vip, vip_sale_activity_vip);
                updateImage(R.drawable.vip_tag_activity_vip, vip_tag_activity_vip);
                updateImage(R.drawable.vip_lottery_activity_vip, vip_lottery_activity_vip);
                updateImage(R.drawable.vip_update_activity_vip, vip_update_activity_vip);
                break;


            case R.id.vip_sp_activity_vip:
                Log.i("aaaaa", "vip_sp_activity_vip");
                startActivity(new Intent(VipActivity.this, SQActivity.class));
                break;
            case R.id.vip_music_packge_activity_vip:
                startActivity(new Intent(VipActivity.this, VipUseActivity.class));
                break;
            case R.id.vip_sale_activity_vip:
                startActivity(new Intent(VipActivity.this, VipSaleActivity.class));
                break;
            case R.id.vip_tag_activity_vip:
                startActivity(new Intent(VipActivity.this, VipSuperTagActivity.class));
                break;
            case R.id.vip_lottery_activity_vip:
                startActivity(new Intent(VipActivity.this, VipLotteryActivity.class));
                break;
            case R.id.vip_update_activity_vip:
                startActivity(new Intent(VipActivity.this, VipUpdateActivity.class));
                break;

            case R.id.tofriend_buy_activity_vip:
                startActivity(new Intent(VipActivity.this, ToFriendActivity.class));
                break;
            case R.id.ues_redeem_code:
                startActivity(new Intent(VipActivity.this, VipUseRedeemCodeActivity.class));
                break;
            case R.id.buy_music_activity_vip:
                startActivity(new Intent(VipActivity.this, VipMyBuyMusicActivity.class));
                break;

            case R.id.vip_tv_foot_tips_activity_vip:
                Log.i("aaaaa", "vip_tv_foot_tips_activity_vip");
                startActivity(new Intent(VipActivity.this, FootTipsActivity.class));
                break;
        }
    }
    //改变Button的DrawableTop
    private void updateImage(int id, Button view){
        Drawable nav_up4=getResources().getDrawable(id);
        nav_up4.setBounds(0, 0, nav_up4.getMinimumWidth(), nav_up4.getMinimumHeight());
        view.setCompoundDrawables(null, nav_up4, null, null);
    }
}
