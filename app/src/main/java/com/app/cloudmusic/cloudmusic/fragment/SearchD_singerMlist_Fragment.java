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
import com.app.cloudmusic.cloudmusic.adapter.SingerMusicGDListAdapter;
import com.app.cloudmusic.cloudmusic.adapter.SingerMusicZJListAdapter;
import com.app.cloudmusic.cloudmusic.divider.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class SearchD_singerMlist_Fragment extends Fragment {

    private View view;

    private RecyclerView recyclerview_singerlist;
    private LinearLayoutManager layoutManager;
    private List<String> mData = new ArrayList<String>();
    private SingerMusicGDListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search_detail_singermlist, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        recyclerview_singerlist = (RecyclerView) view.findViewById(R.id.list_single_music_gd);
        layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview_singerlist.setLayoutManager(layoutManager);
        recyclerview_singerlist.addItemDecoration(new DividerItemDecoration(view.getContext(), layoutManager.getOrientation()));
        recyclerview_singerlist.setHasFixedSize(true);
        //设置默认动画
        recyclerview_singerlist.setItemAnimator(new DefaultItemAnimator());
        //增加数据
        addData();
        adapter = new SingerMusicGDListAdapter(mData);
        recyclerview_singerlist.setAdapter(adapter);

        //添加自定的点击事件
        adapter.setOnItemClickListener(new SingerMusicGDListAdapter.OnItemClickListener() {
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
        mData.add("周杰伦最全演唱正序集");
        mData.add("周杰伦 高音质珍藏版");
        mData.add("那些年，我们听的周杰伦");
        mData.add("周杰伦歌曲集（v2.0）");
        mData.add("周杰伦最虐我心的歌");
        mData.add("周杰伦最全Live正序集");
        mData.add("周杰伦慢歌自选集");
        mData.add("专属你的周杰伦");
        mData.add("你确定没听过周杰伦？");
        mData.add("一个时代一个周杰伦");
        mData.add("永远的周杰伦");
        mData.add("周杰伦唱给所有人听的情书");
        mData.add("周杰伦的登峰造极之作");
        mData.add("必听的周杰伦现场live");

    }
}
