package com.app.cloudmusic.cloudmusic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.app.cloudmusic.cloudmusic.activity.GuideActivity;
import com.app.cloudmusic.cloudmusic.activity.LoginActivity;
import com.app.cloudmusic.cloudmusic.activity.SearchActivity;
import com.app.cloudmusic.cloudmusic.fragment.MainMusicFragment;
import com.app.cloudmusic.cloudmusic.fragment.MyFriendFragment;
import com.app.cloudmusic.cloudmusic.fragment.MyMusicFragment;

public class HomeActivity extends AppCompatActivity {

    private FragmentManager manager;
    private android.support.v4.app.FragmentTransaction transaction;
    private Fragment mainMusicFragment, myFriendFragment, myMusicFragment;

    //初始化布局
    private FrameLayout fragment_container;

    //first
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
//        preferences = getPreferences(0);

        preferences = getSharedPreferences("isFirst", Context.MODE_PRIVATE);
        isFirstIn();

        //实例化fragment
        mainMusicFragment = new MainMusicFragment();
        myFriendFragment = new MyFriendFragment();
        myMusicFragment = new MyMusicFragment();
//初始化布局
        initViews();
    }

    private void isFirstIn() {
        int count = preferences.getInt("count",0);
        //判断程序是第几次运行，如果是第一次运行则跳转到引导页面
        if (count == 0){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("count",++count);
            editor.commit();
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(), GuideActivity.class);
            startActivity(intent);
            this.finish();
        }
    }

    private void initViews() {
        //开启fragment事务
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, mainMusicFragment);
        transaction.commit();
    }


    public void sideMenu(View view) {
        Toast.makeText(this, "点击了侧滑菜单", Toast.LENGTH_SHORT).show();
        //在这里实现侧滑菜单
        startActivity(new Intent(HomeActivity.this, SideSlipActivity.class));
    }

    public void mainMusic(View view) {
        Toast.makeText(this, "点击了主界面", Toast.LENGTH_SHORT).show();
        //开启fragment事务
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, mainMusicFragment);
        transaction.commit();
    }

    public void myMusic(View view) {
        Toast.makeText(this, "点击了我的音乐", Toast.LENGTH_SHORT).show();
        //开启fragment事务
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, myMusicFragment);
        transaction.commit();
    }

    public void myFriend(View view) {
        Toast.makeText(this, "点击了我的好友", Toast.LENGTH_SHORT).show();
        //开启fragment事务
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, myFriendFragment);
        transaction.commit();
    }

    public void search(View view) {
        Toast.makeText(this, "点击了搜索", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, SearchActivity.class));
    }

}
