package com.app.cloudmusic.cloudmusic.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.adapter.ChooseMusicAdapter;


public class ChooseMusicActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_music);
        lv= (ListView) findViewById(R.id.lv_cm);
        ChooseMusicAdapter adapter=new ChooseMusicAdapter(this);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(this,EditDynamicActivity.class));
        finish();
    }
}
