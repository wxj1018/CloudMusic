package com.app.cloudmusic.cloudmusic.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.adapter.MyMessageViewPagerAdapter;
import com.app.cloudmusic.cloudmusic.fragment.AtMeFragment;

import java.util.ArrayList;
import java.util.List;

public class MyMessageActivity extends FragmentActivity implements View.OnClickListener{
    private Button back;
    private ViewPager vp;
    private ImageView tabline;
    private List<Fragment> contentlist;//adapter 提供内容
    private int tableLenght;//tabline的长度
    private int currentPager;//viewPager当前的选中项
    private RadioButton atme, inbox, comment, notification;//RadioButton
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_message);
        //初始化
       init();
        //为viewPager设置适配器
      MyMessageViewPagerAdapter adapter = new MyMessageViewPagerAdapter(getSupportFragmentManager(), contentlist);
        vp.setAdapter(adapter);
        vp.setCurrentItem(1);

        //为viewPager设置监听
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            //滑动监听，滑动的时候tabline会跟着一起动
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //获取该控件实例
                LinearLayout.LayoutParams ll = (LinearLayout.LayoutParams) tabline.getLayoutParams();
                if (currentPager == 0 && position == 0){
                    ll.leftMargin = (int) (currentPager*tableLenght + positionOffset*tableLenght);
                }
                else if (currentPager == 1 && position == 1){
                    ll.leftMargin = (int) (currentPager*tableLenght + positionOffset*tableLenght);
                }
                else if (currentPager == 2 && position == 2){
                    ll.leftMargin = (int) (currentPager*tableLenght + positionOffset*tableLenght);
                }
                else if (currentPager == 3 && position == 2){
                    ll.leftMargin = (int) (currentPager*tableLenght - (1-positionOffset)*tableLenght);
                }
                else if (currentPager == 2 && position == 1){
                    ll.leftMargin = (int) (currentPager*tableLenght - (1-positionOffset)*tableLenght);
                }
                else if (currentPager == 1 && position == 0){
                    ll.leftMargin = (int) (currentPager*tableLenght - (1-positionOffset)*tableLenght);
                }
                tabline.setLayoutParams(ll);
                radioGroupChangeTextcolor();

            }
            //选中监听，position是当前选中的item
            @Override
            public void onPageSelected(int position) {
                //改变后初始化所有radioButton的颜色，否则会都变成同一种颜色
                atme.setTextColor(Color.WHITE);
                inbox.setTextColor(Color.WHITE);
                comment.setTextColor(Color.WHITE);
                notification.setTextColor(Color.WHITE);
                switch (position){
                    case 0:
                        atme.setChecked(true);
                        atme.setTextColor(Color.RED);
                    break;
                    case 1:
                        inbox.setChecked(true);
                        inbox.setTextColor(Color.RED);
                        break;
                    case 2:
                        comment.setChecked(true);
                        comment.setTextColor(Color.RED);
                        break;
                    case 3:
                        notification.setChecked(true);
                        notification.setTextColor(Color.RED);
                        break;
                }
                currentPager = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //判断RadioButton是否被选中，被选中后变换字体颜色
    private void radioGroupChangeTextcolor(){
        if (atme.isChecked()){
            currentPager = 0;
            atme.setTextColor(Color.RED);
        }else if (inbox.isChecked()){
            inbox.setTextColor(Color.RED);
            currentPager = 1;
        }else if ((comment.isChecked())){
            comment.setTextColor(Color.RED);
            currentPager = 2;
        }else if ((notification.isChecked())){
            currentPager = 3;
            notification.setTextColor(Color.RED);
        }
    }

    private void init(){
        atme = (RadioButton) findViewById(R.id.atme);
        atme.setOnClickListener(this);
        inbox = (RadioButton) findViewById(R.id.inbox);
        inbox.setOnClickListener(this);
        comment = (RadioButton) findViewById(R.id.comment);
        comment.setOnClickListener(this);
        notification = (RadioButton) findViewById(R.id.notification);
        notification.setOnClickListener(this);

        radioGroupChangeTextcolor();

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);

        vp = (ViewPager) findViewById(R.id.vp_activity_mymessage);
        //获取屏幕信息
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        //得到显示屏幕宽度
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        //1/4屏幕宽度
        tableLenght = metrics.widthPixels/4;
        //获取控件实例
        tabline = (ImageView) findViewById(R.id.tabline_activity_mymessage);
        //控件参数
       ViewGroup.LayoutParams params = tabline.getLayoutParams();
        params.width = tableLenght;
        tabline.setLayoutParams(params);
        //初始化List
        contentlist = new ArrayList<Fragment>();
        for (int i = 0; i < 4; i++){
            AtMeFragment fragment1 = new AtMeFragment();
            contentlist.add(fragment1);
        }


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.atme://监听是否被点中，点中的话，ViewPager跳到对应的位置
                atme.setChecked(true);
                vp.setCurrentItem(0);
                break;
            case R.id.comment:
                comment.setChecked(true);
                vp.setCurrentItem(2);
                break;
            case R.id.inbox:
                inbox.setChecked(true);
                vp.setCurrentItem(1);
                break;
            case R.id.notification:
                notification.setChecked(true);
                vp.setCurrentItem(3);
                break;


            default:
                break;
        }
    }
}
