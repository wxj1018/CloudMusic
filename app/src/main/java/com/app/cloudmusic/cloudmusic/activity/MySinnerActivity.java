package com.app.cloudmusic.cloudmusic.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.app.cloudmusic.cloudmusic.R;

/**
 * Created by Administrator on 2016/10/12.
 */
public class MySinnerActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysinner);
    }

    public void backToMyMusic(View view){
        finish();
    }
}
