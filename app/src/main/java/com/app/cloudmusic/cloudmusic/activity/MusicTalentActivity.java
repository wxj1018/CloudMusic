package com.app.cloudmusic.cloudmusic.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.app.cloudmusic.cloudmusic.GetJson;
import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.adapter.MTTypeAdapter;
import com.app.cloudmusic.cloudmusic.adapter.MTUserAdapter;
import com.app.cloudmusic.cloudmusic.javabeen.JBMtType;
import com.app.cloudmusic.cloudmusic.javabeen.JBUser;

import java.util.ArrayList;


public class MusicTalentActivity extends AppCompatActivity {

    private ListView lvmttype, lvUser;
    private ArrayList<JBMtType> jbMtTypeArrayList = new ArrayList<>();
    private ArrayList<JBUser> jbUserArrayList = new ArrayList<>();
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){

                case 1:
                    MTTypeAdapter mtTypeAdapter=new MTTypeAdapter(jbMtTypeArrayList,MusicTalentActivity.this);
                    lvmttype.setAdapter(mtTypeAdapter);
                    break;

                case 2:
                    MTUserAdapter mtUserAdapter=new MTUserAdapter(jbUserArrayList,MusicTalentActivity.this);
                    lvUser.setAdapter(mtUserAdapter);
                    break;

            }

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_talent);
        this.getMtType();
        lvUser = (ListView) findViewById(R.id.lv_user_mt);
        lvmttype = (ListView) findViewById(R.id.lv_mt_mt);
        lvmttype.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int mttypeid=jbMtTypeArrayList.get(position).getId();
                getUser(mttypeid);
            }
        });
    }

    private void getMtType() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                final String result = GetJson.getJson("mttype", "&where", 1024);
                jbMtTypeArrayList = GetJson.getMttype(result);
                mHandler.sendEmptyMessage(1);
                Log.i("FSLog",result);
                Log.i("FSLog",""+result.length());
            }
        }.start();
    }
    private void getUser(final int id){
        new Thread(){
            @Override
            public void run() {
                super.run();
                final String result=GetJson.getJson("user","&where=where%20mttype_id="+ id ,1024);
                jbUserArrayList=GetJson.getUser(result);
                mHandler.sendEmptyMessage(2);
                Log.i("FSLog",result);

            }
        }.start();
    }



    public void onBack(View view) {
        finish();
    }
}



