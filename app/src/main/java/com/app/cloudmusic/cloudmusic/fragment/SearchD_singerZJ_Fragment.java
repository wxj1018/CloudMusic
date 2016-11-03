package com.app.cloudmusic.cloudmusic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.adapter.SingerMusicZJListAdapter;
import com.app.cloudmusic.cloudmusic.divider.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class SearchD_singerZJ_Fragment extends Fragment {

    private RecyclerView recyclerview_singerlist;
    private LinearLayoutManager layoutManager;
    private List<String> mData = new ArrayList<String>();
    private SingerMusicZJListAdapter adapter;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search_detail_singerzj, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        recyclerview_singerlist = (RecyclerView) view.findViewById(R.id.list_single_music_zj);
        layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview_singerlist.setLayoutManager(layoutManager);
        recyclerview_singerlist.addItemDecoration(new DividerItemDecoration(view.getContext(), layoutManager.getOrientation()));
        recyclerview_singerlist.setHasFixedSize(true);
        //设置默认动画
        recyclerview_singerlist.setItemAnimator(new DefaultItemAnimator());
        //增加数据
        addData();
        adapter = new SingerMusicZJListAdapter(mData);
        recyclerview_singerlist.setAdapter(adapter);

        //添加自定的点击事件
        adapter.setOnItemClickListener(new SingerMusicZJListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int positon) {
                Toast.makeText(view.getContext(), "选择了" + mData.get(positon).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 给list添加显示的数据
     */
    private void addData() {
        mData.add("周杰伦的床边故事");
        mData.add("叶惠美");
        mData.add("七里香");
        mData.add("范特西");
        mData.add("十一月的萧邦");
        mData.add("我很忙");
        mData.add("魔杰座");
        mData.add("八度空间");
        mData.add("Jay同名专辑");
        mData.add("哎哟不错哦");
        mData.add("依然范特西");
        mData.add("十二新作");
        mData.add("跨时代");
        mData.add("不能说的秘密");
        mData.add("惊叹号");
        mData.add("魔杰座 世界巡回演唱会");
        mData.add("Fantasy Plus");
        mData.add("寻找周杰伦");

    }
}
