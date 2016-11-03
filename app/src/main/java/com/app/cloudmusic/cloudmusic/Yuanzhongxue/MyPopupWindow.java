package com.app.cloudmusic.cloudmusic.Yuanzhongxue;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.Yuanzhongxue.SearchActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class MyPopupWindow extends PopupWindow {
    // 扫描
    ScanMusic scan;
    List<Map<String,Object>>list;
    BaseAdapter myAdapter;
    //动态数组
    ArrayList<Modle> arrlist;
    ArrayList<String> context_sing = new ArrayList<String>();
    ArrayList<String> context_singer = new ArrayList<String>();
    ArrayList<String> context_path = new ArrayList<String>();
    // 列表对象
    private Context mContext;
    private TextView tv;
    private int height;
    View view ;
    ListView mylist;
    static MediaPlayer mediaPlayer;
    PlayerService playerService;


    public MyPopupWindow(final Context mContext,int height){
        this.view = LayoutInflater.from(mContext).inflate(R.layout.lyr_singer,null);
        tv = (TextView) view.findViewById(R.id.tv_lyr_singer);
        mylist = (ListView)view.findViewById(R.id.lv_lyr_singer);
        this.mContext=mContext;
        setTest((SearchActivity)mContext);
        if(MyPopupWindow.mediaPlayer==null) {
            mediaPlayer = new MediaPlayer();
        }
        this.height=height;
        this.setOutsideTouchable(true);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        this.view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = view.findViewById(R.id.rll_lyr_singer).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });
        /* 设置弹出窗口特征 */     // 设置视图
        this.setContentView(this.view);
        // 设置弹出窗体的宽和高

        this.setHeight(height*2/3);
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        // 设置弹出窗体可点击
        this.setFocusable(true);
        // 实例化一个ColorDrawable颜色
        ColorDrawable dw = new ColorDrawable(0xffaa0ff0);
        // 设置弹出窗体的背景
        this.setBackgroundDrawable(dw);
        // 设置弹出窗体显示时的动画，从底部向上弹出
        this.setAnimationStyle(R.style.take_photo_anim);

        scan = new ScanMusic();
        new Thread(new Runnable() {
            @Override
            public void run() {
                list = new ArrayList<Map<String, Object>>();
                arrlist=scan.query(arrlist,mContext);
                for (int i = 0; i < arrlist.size(); i++) {
                    context_sing.add(arrlist.get(i).getSing());
                    context_singer.add(arrlist.get(i).getSinger());
                    context_path.add(arrlist.get(i).getPath());

                    Log.i("223",arrlist.get(i).getSing());
                    Log.i("223",arrlist.get(i).getPath());
                }
                mHandler.sendEmptyMessage(0);

            }
        }).start();

    }

private Handler mHandler = new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        tv.setText("歌曲总数"+"（"+context_singer.size()+")");
        myAdapter = new MyAdapter(mContext,arrlist);
        mylist.setAdapter(myAdapter);
        mylistListener();
    }
};
    private void mylistListener(){
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                if (!mediaPlayer.isPlaying()){
                    try {

                        String path = arrlist.get(position).getPath();
                        Log.i("123",path);
                        mediaPlayer.setDataSource(""+path);
                        mediaPlayer.prepare();
                        mediaPlayer.start();

                        String sin = arrlist.get(position).getSing();
                        String siner = arrlist.get(position).getSinger();
                        Bundle bundle = new Bundle();
                        bundle.putString("key",sin+"");
                        bundle.putString("key1",siner+"");
                        test.getTest(bundle);

                    } catch (IOException e) {
                    e.printStackTrace();
                    }
                }else if( mediaPlayer.isPlaying()) {

                    mediaPlayer.stop();
                    mediaPlayer.reset();
//                    mediaPlayer.release();
                    try {

                        String path = arrlist.get(position).getPath();
                        mediaPlayer.setDataSource(""+path);
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                    }
                    String sin = arrlist.get(position).getSing();
                    String siner = arrlist.get(position).getSinger();
                    mediaPlayer.start();
                    Bundle bundle = new Bundle();
                    bundle.putString("key",sin+"");
                    bundle.putString("key1",siner+"");
                    test.getTest(bundle);

                }
            }
        });
    }

    private ITest test;

    public void setTest(ITest test) {
        this.test = test;
    }

    public interface ITest {

        void getTest(Bundle bundle);
    }

}
