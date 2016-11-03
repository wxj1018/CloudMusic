package com.app.cloudmusic.cloudmusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.fragment.SearchDetailFragment;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout singer_classify;
    //fragment
    private FragmentManager manager;
    private FragmentTransaction transaction;
    //控件
    private Button btn_music1;
    private ImageView search_activity_back;
    private TextView tv_history1;
    private LinearLayout lin_search_content;
    private HorizontalScrollView hor_tag;
    private EditText et_music_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //初始化控件
        initViews();

    }



    private void initViews() {
        singer_classify = (LinearLayout) findViewById(R.id.lin_singer_classify);
        singer_classify.setOnClickListener(this);
        btn_music1 = (Button) findViewById(R.id.btn_music1);
        btn_music1.setOnClickListener(this);
        tv_history1 = (TextView) findViewById(R.id.tv_historymusic1);
        tv_history1.setOnClickListener(this);
        search_activity_back = (ImageView) findViewById(R.id.img_search_activity_back);
        search_activity_back.setOnClickListener(this);
        lin_search_content = (LinearLayout) findViewById(R.id.lin_search_content);
        et_music_name = (EditText) findViewById(R.id.et_music_name);
        //mPager = (ViewPager) findViewById(R.id.id_page_vp);
        //hor_tag = (HorizontalScrollView) findViewById(R.id.hor_tab);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lin_singer_classify:
                startActivity(new Intent(this, SearchSingerListActivity.class));
                break;
            case R.id.img_search_activity_back:
                finish();
                break;
            case R.id.btn_music1:
                manager = getSupportFragmentManager();
                transaction = manager.beginTransaction();
                transaction.replace(R.id.lin_search_container, new SearchDetailFragment());
                transaction.commit();
                et_music_name.setText(btn_music1.getText());
                lin_search_content.setVisibility(View.GONE);
//                hor_tag.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_historymusic1:
                manager = getSupportFragmentManager();
                transaction = manager.beginTransaction();
                transaction.replace(R.id.lin_search_container, new SearchDetailFragment());
                transaction.commit();
                et_music_name.setText(tv_history1.getText());
                lin_search_content.setVisibility(View.GONE);
//                hor_tag.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }



}
