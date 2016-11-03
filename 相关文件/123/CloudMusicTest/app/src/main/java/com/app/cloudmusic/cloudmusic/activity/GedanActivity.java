package com.app.cloudmusic.cloudmusic.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.app.cloudmusic.cloudmusic.R;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class GedanActivity extends Activity implements View.OnClickListener{

    private Button bt_fanhui,bt_shoucang,bt_pinglun,bt_fengxiang,bt_xiazai;
    private ImageButton ib_tupian;
    private TextView tv_gedanming,tv_name;
    String [] items = new  String [] {"标准（128kbit/s）","较高（192kbit/s）","极高（320kbit/s）","无损音质"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gedan);
        initView();
    }

    public void initView(){
        bt_fanhui = (Button)findViewById(R.id.bt_fanhui_tool_bar);
        bt_shoucang = (Button)findViewById(R.id.bt_shoucang_activity_gedan);
        bt_pinglun = (Button)findViewById(R.id.bt_pinglun_activity_gedan);
        bt_fengxiang = (Button)findViewById(R.id.bt_fenxiang_activity_gedan);
        bt_xiazai = (Button)findViewById(R.id.bt_xiazai_activity_gedan);
        ib_tupian = (ImageButton)findViewById(R.id.ib_tupian_activity_gedan);
        tv_gedanming = (TextView)findViewById(R.id.tv_gedanming_activity_gedan);
        tv_name = (TextView)findViewById(R.id.tv_name_activity_gedan);

        bt_fanhui.setOnClickListener(this);
        bt_shoucang.setOnClickListener(this);
        bt_pinglun.setOnClickListener(this);
        bt_fengxiang.setOnClickListener(this);
        bt_xiazai.setOnClickListener(this);
        ib_tupian.setOnClickListener(this);
        tv_name.setOnClickListener(this);
        tv_gedanming.setOnClickListener(this);
    }

    //数据源
    public void getDate(){

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_fanhui_tool_bar:
                GedanActivity.this.finish();
            break;
            case R.id.bt_shoucang_activity_gedan:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("确定不再收藏此类歌单吗？");
                builder.setPositiveButton("不再收藏", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(GedanActivity.this,"取消收藏",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消",null);
                builder.create().show();

                break;
            case R.id.bt_pinglun_activity_gedan:
                break;
            case R.id.bt_fenxiang_activity_gedan:
                break;
            case R.id.bt_xiazai_activity_gedan:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setTitle("选择默认下载音质");
                builder1.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(GedanActivity.this,"你选中了《"+items[which]+"》",Toast.LENGTH_SHORT).show();
                    }
                });
                builder1.create().show();
                break;
        }
    }

}
