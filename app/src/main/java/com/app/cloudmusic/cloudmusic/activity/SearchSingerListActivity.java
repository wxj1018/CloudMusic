package com.app.cloudmusic.cloudmusic.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
import com.app.cloudmusic.cloudmusic.adapter.SearchSingerListAdapter;
import com.app.cloudmusic.cloudmusic.divider.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class SearchSingerListActivity extends Activity implements View.OnClickListener {

    private RecyclerView recyclerview_singerlist;
    private LinearLayoutManager layoutManager;
    private List<String> mData = new ArrayList<String>();
    private SearchSingerListAdapter adapter;

    //控件
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singer_list);

        initViews();
    }

    private void initViews() {
        back = (ImageView) findViewById(R.id.img_singerlist_back);
        back.setOnClickListener(this);
        recyclerview_singerlist = (RecyclerView) findViewById(R.id.recyclerview_singerlist);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview_singerlist.setLayoutManager(layoutManager);
        recyclerview_singerlist.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));
        recyclerview_singerlist.setHasFixedSize(true);
        //设置默认动画
        recyclerview_singerlist.setItemAnimator(new DefaultItemAnimator());
        //增加数据
        addData();
        adapter = new SearchSingerListAdapter(mData);
        recyclerview_singerlist.setAdapter(adapter);

        //添加自定的点击事件
        adapter.setOnItemClickListener(new SearchSingerListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int positon) {
                if (positon < mData.size()) {
                    Toast.makeText(view.getContext(), "选择了" + mData.get(positon).toString(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(view.getContext(),ChinaManSingerList.class));
                }
            }
        });
    }

    /**
     * 给list添加显示的数据
     */
    private void addData() {
        mData.add("华语男歌手");
        mData.add("华语女歌手");
        mData.add("华语乐队/组合");
        mData.add("华语乐队/组合");
        mData.add("欧美男歌手");
        mData.add("欧美女歌手");
        mData.add("欧美乐队/组合");
        mData.add("欧美乐队/组合");
        mData.add("日本男歌手");
        mData.add("日本女歌手");
        mData.add("日本乐队/组合");
        mData.add("日本乐队/组合");
        mData.add("韩国男歌手");
        mData.add("韩国女歌手");
        mData.add("韩国乐队/组合");
        mData.add("韩国乐队/组合");
        mData.add("其他男歌手");
        mData.add("其他女歌手");
        mData.add("其他乐队/组合");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_singerlist_back:
                finish();
                break;
            default:
                break;
        }
    }
}
