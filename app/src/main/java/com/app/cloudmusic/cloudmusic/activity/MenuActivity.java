package com.app.cloudmusic.cloudmusic.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.ViewpagerAdapter.ListViewAdapter;

/**
 * Created by Administrator on 2016/10/14.
 */
public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_next_play;
    private Button btn_join;
    private Button btn_upload;
    private Button btn_delete;

    private ListView listView;
    private ListViewAdapter adapter;
    private String[] beans = new String[]{"1","2","3","4","5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_next_play = (Button)findViewById(R.id.btn_next_play);
        btn_join = (Button)findViewById(R.id.btn_join);
        btn_upload = (Button)findViewById(R.id.btn_upload);
        btn_delete = (Button)findViewById(R.id.btn_delete);
        btn_next_play.setOnClickListener(this);
        btn_join.setOnClickListener(this);
        btn_upload.setOnClickListener(this);
        btn_delete.setOnClickListener(this);

        initview();
    }

    private void initview() {
        Log.i("htp","beans.size:" + beans.length);
        listView = (ListView)findViewById(R.id.lv_menu1);
        adapter = new ListViewAdapter(MenuActivity.this,beans);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }




    public void backToMyMusic(View view){
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_next_play:
                Toast.makeText(this, "已播放下一首歌曲", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_join:
                Toast.makeText(this, "已加入了歌单", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_upload:
                Toast.makeText(this, "已上传到了云盘", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_delete:
                Toast.makeText(this, "已删除选中歌曲", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
