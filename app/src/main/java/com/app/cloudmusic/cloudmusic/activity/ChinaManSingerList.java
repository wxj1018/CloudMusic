package com.app.cloudmusic.cloudmusic.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.adapter.ChinaManSingerListAdapter;
import com.app.cloudmusic.cloudmusic.divider.DividerItemDecoration;
import com.app.cloudmusic.cloudmusic.model.Song;
import com.app.cloudmusic.cloudmusic.model.SongResponse;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ChinaManSingerList extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerview_chinaman_singerlist;
    private LinearLayoutManager layoutManager;
    private List<String> mData = new ArrayList<String>();
    private ChinaManSingerListAdapter adapter;
    //控件
    private ImageView back;


    private String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china_man_singer_list);
        initViews();
    }

    private void initViews() {
        back = (ImageView) findViewById(R.id.img_chinaman_singerlist_back);
        back.setOnClickListener(this);
        recyclerview_chinaman_singerlist = (RecyclerView) findViewById(R.id.recyclerview_china_man_singerlist);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview_chinaman_singerlist.setLayoutManager(layoutManager);
        recyclerview_chinaman_singerlist.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));
        recyclerview_chinaman_singerlist.setHasFixedSize(true);
        //设置默认动画
        recyclerview_chinaman_singerlist.setItemAnimator(new DefaultItemAnimator());
        //增加数据
        addData();
        adapter = new ChinaManSingerListAdapter(mData);
        recyclerview_chinaman_singerlist.setAdapter(adapter);

        //添加自定的点击事件
        adapter.setOnItemClickListener(new ChinaManSingerListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final View view, int positon) {
                Toast.makeText(view.getContext(), "选择了" + mData.get
                        (positon).toString(), Toast.LENGTH_SHORT).show();
                RequestQueue rq = Volley.newRequestQueue(view.getContext());

                StringRequest sr = new StringRequest(Request.Method.GET, "http://192.168.191.1:9096/cloudmusic/backend/index.php/SearchSinger/serchsinger", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.i("test","sure");
                        Log.i("test", s);
                        String result=s.substring(1,s.indexOf("}")+1);
                        Log.e("test",result);
//                        StringBuffer stringBuffer = new StringBuffer(s);
//                        stringBuffer.insert(0,'{');
//                        stringBuffer.insert(s.length()+1,'}');

                        //Log.e("test",stringBuffer.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(result);
                            Log.i("test",jsonObject.get("address").toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //parseJSONWithGSON(result);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("test", volleyError.toString());
                    }
                }){
                    @Override
                    public Priority getPriority() {
                        Request.Priority mPriority = Priority.HIGH;
                        return mPriority;
                    }
                };
                rq.add(sr);
            }
        });
    }

    private void parseJSONWithGSON(String s) {
        Gson gson = new Gson();
//      List<SingerResponse> singer1 = (List<SingerResponse>) gson.fromJson(s,SingerResponse.class);

        SongResponse ob= gson.fromJson(s,SongResponse.class);
        for (Song singer : ob.getList()){

            Log.e("test","song"+singer.toString());
            Log.e("test","song"+singer.getSinger().getName());
        }
    }

    /**
     * 给list添加显示的数据
     */

    private void addData() {
        mData.add("周杰伦");
        mData.add("陈奕迅");
        mData.add("薛之谦");
        mData.add("林俊杰");
        mData.add("李荣浩");
        mData.add("张学友");
        mData.add("杨宗纬");
        mData.add("许巍");
        mData.add("赵雷");
        mData.add("李志");
        mData.add("宋冬野");
        mData.add("王力宏");
        mData.add("朴树");
        mData.add("李健");
        mData.add("陈小春");
        mData.add("许嵩");
        mData.add("马頔");
        mData.add("张国荣");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_chinaman_singerlist_back:
                finish();
                break;
            default:
                break;
        }
    }

    public static String trimFirstAndLastChar(String source, char element) {
        boolean beginIndexFlag = true;
        boolean endIndexFlag = true;
        do {
            int beginIndex = source.indexOf(element) == 0 ? 1 : 0;
            int endIndex = source.lastIndexOf(element) + 1 == source.length() ? source.lastIndexOf(element) : source.length();
            source = source.substring(beginIndex, endIndex);
            beginIndexFlag = (source.indexOf(element) == 0);
            endIndexFlag = (source.lastIndexOf(element) + 1 == source.length());
        } while (beginIndexFlag || endIndexFlag);
        return source;
    }
}
