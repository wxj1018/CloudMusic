package com.app.cloudmusic.cloudmusic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.adapter.SingerMusicListAdapter;
import com.app.cloudmusic.cloudmusic.divider.DividerItemDecoration;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class SearchD_singlemusic_Fragment extends Fragment{

    private RecyclerView recyclerview_singerlist;
    private LinearLayoutManager layoutManager;
    private List<String> mData = new ArrayList<String>();
    private SingerMusicListAdapter adapter;
    private View view;
    private ImageView img1,img2;
    private Button btn_pop_window;

    //private int screenHeight = this.getActivity().getWindowManager().getDefaultDisplay().getHeight();
    //private int screenWeight = this.getActivity().getWindowManager().getDefaultDisplay().getWidth();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search_detail_singlemusic, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        img1= (ImageView) view.findViewById(R.id.img_singlemusic_singerpic);
        img2= (ImageView) view.findViewById(R.id.img_singlemusic_singerzjpic);
        Picasso.with(view.getContext()).load("http://192.168.191.1:9096/cloudmusic/zhoujielun.jpg").into(img1);
        Picasso.with(view.getContext()).load("http://192.168.191.1:9096/cloudmusic/zj0.jpg").into(img2);
        recyclerview_singerlist = (RecyclerView) view.findViewById(R.id.list_single_music);
        layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview_singerlist.setLayoutManager(layoutManager);
        recyclerview_singerlist.addItemDecoration(new DividerItemDecoration(view.getContext(), layoutManager.getOrientation()));
        recyclerview_singerlist.setHasFixedSize(true);
        //设置默认动画
        recyclerview_singerlist.setItemAnimator(new DefaultItemAnimator());
        //增加数据
        addData();
        adapter = new SingerMusicListAdapter(mData,getContext());
        recyclerview_singerlist.setAdapter(adapter);

        //添加自定的点击事件
        adapter.setOnItemClickListener(new SingerMusicListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int positon) {

            }
        });
    }

    /**
     * 给list添加显示的数据
     */
    private void addData() {
        mData.add("告白气球");
        mData.add("晴天");
        mData.add("爱情废柴");
        mData.add("七里香");
        mData.add("不该(with aMEI)");
        mData.add("彩虹");
        mData.add("安静");
        mData.add("最长的电影");
        mData.add("一点点");
        mData.add("枫");
        mData.add("稻香");
        mData.add("算什么男人");
        mData.add("一路向北");
        mData.add("前世情人");
        mData.add("夜曲");
        mData.add("不能说的秘密");
        mData.add("搁浅");
        mData.add("床边故事");
        mData.add("简单爱");
        mData.add("说好的幸福呢");
    }


}
