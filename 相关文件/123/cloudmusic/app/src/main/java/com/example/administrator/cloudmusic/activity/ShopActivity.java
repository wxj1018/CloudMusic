package com.example.administrator.cloudmusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.administrator.cloudmusic.R;
import com.example.administrator.cloudmusic.shopactivity.BillActivity;
import com.example.administrator.cloudmusic.shopactivity.HowActivity;
import com.example.administrator.cloudmusic.shopactivity.IntegralActivity;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener{
    private Button back;//返回headertitle
    private TextView tv_headertitle;//标题hewdertitle
    private ViewFlipper vf_activity_shop;//轮播图ViewFlipper
    private float startX;
    private int[] imageid = {
            R.drawable.play,
            R.drawable.play1,
            R.drawable.play2,
            R.drawable.play3,
            R.drawable.play4,
            R.drawable.play5,
            R.drawable.play6};
    private Button integral_activity_shop, bill_activity_shop, how_activity_shop;
//    private GridView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        init();
    }
    private void init(){
        //获取屏幕信息
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        //得到显示屏幕宽度
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        //屏幕1/5高
        int heightS = metrics.heightPixels/5;
        //获取headertitle控件
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
        tv_headertitle = (TextView) findViewById(R.id.tv_headertitle);
        tv_headertitle.setText("积分商城");

        vf_activity_shop = (ViewFlipper) findViewById(R.id.vf_activity_shop);
        for (int i = 0; i < 6; i++){
            ImageButton ib = new ImageButton(this);
            ib.setBackgroundResource(imageid[i]);
            vf_activity_shop.addView(ib);
            ViewGroup.LayoutParams lp = ib.getLayoutParams();
            lp.height = heightS;
            ib.setLayoutParams(lp);
        }
        vf_activity_shop.startFlipping();
        //初始化控件
        integral_activity_shop = (Button) findViewById(R.id.integral_activity_shop);
        integral_activity_shop.setOnClickListener(this);
        bill_activity_shop = (Button) findViewById(R.id.bill_activity_shop);
        bill_activity_shop.setOnClickListener(this);
        how_activity_shop = (Button) findViewById(R.id.how_activity_shop);
        how_activity_shop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.integral_activity_shop:
                startActivity(new Intent(ShopActivity.this, IntegralActivity.class));
                break;
            case R.id.bill_activity_shop:
                startActivity(new Intent(ShopActivity.this, BillActivity.class));
                break;
            case R.id.how_activity_shop:
                startActivity(new Intent(ShopActivity.this, HowActivity.class));
                break;
        }
    }
}
