package com.example.administrator.cloudmusic.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.administrator.cloudmusic.R;
import com.example.administrator.cloudmusic.adapter.MyShopGridViewAdapter;
import com.example.administrator.cloudmusic.shopactivity.BillActivity;
import com.example.administrator.cloudmusic.shopactivity.HowActivity;
import com.example.administrator.cloudmusic.shopactivity.IntegralActivity;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener{
    private Button back;//返回headertitle
    private TextView tv_headertitle;//标题hewdertitle
    private ViewFlipper vf_activity_shop;//轮播图ViewFlipper
    private GridView shop_gb_activity_shop;
    private ScrollView shop_scrollview_activity_shop;
    List<Bitmap> images;
    List<String> discriptions;
    List<String> prices;
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
        shop_scrollview_activity_shop = (ScrollView) findViewById(R.id.shop_scrollview_activity_shop);

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

        shop_gb_activity_shop = (GridView) findViewById(R.id.shop_gb_activity_shop);
        images = new ArrayList<Bitmap>();
        discriptions = new ArrayList<String>();
        prices = new ArrayList<String>();
        for (int i = 0; i < 50; i++){
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.shop_gv_item_image);
            images.add(bitmap);
            discriptions.add("网易云音乐今年最流行图标");
            prices.add("￥99");
        }

        BaseAdapter adapter = new MyShopGridViewAdapter(ShopActivity.this, images, discriptions, prices);
        shop_gb_activity_shop.setAdapter(adapter);
        shop_gb_activity_shop.setNumColumns(2);
        shop_gb_activity_shop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ShopActivity.this, "您选中了第" + position + "个商品", Toast.LENGTH_SHORT).show();
            }
        });
        shop_scrollview_activity_shop.scrollTo(0, 0);
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
