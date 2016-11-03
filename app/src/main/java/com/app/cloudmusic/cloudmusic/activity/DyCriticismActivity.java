package com.app.cloudmusic.cloudmusic.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.adapter.DyCriticismAdapter;


public class DyCriticismActivity extends AppCompatActivity {

    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dy_criticism);
        lv= (ListView) findViewById(R.id.lv_dycriticism);
        DyCriticismAdapter adapter=new DyCriticismAdapter(this);
        lv.setAdapter(adapter);

    }
}
