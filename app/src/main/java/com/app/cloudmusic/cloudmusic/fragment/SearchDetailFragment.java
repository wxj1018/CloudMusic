package com.app.cloudmusic.cloudmusic.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.adapter.SearchDFragAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class SearchDetailFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener {

    //viewpager
    private ViewPager mPager;
    private ArrayList<Fragment> fragmentsList;
    private FragmentManager manager;
    private TextView tv_singermusic_tag, tv_singer, tv_singerzj_tag, tv_singermlist_tag, tv_mv_tag;
    private HorizontalScrollView hs;
    private ArrayList<View> downlines;
    private ArrayList<TextView> tag_name;
    private View v1, v2, v3, v4, v5;
    private int width;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_detail, container, false);

        mPager = (ViewPager) view.findViewById(R.id.id_page_vp);

        //initData();
        initViewPager();
        tv_singermusic_tag = (TextView) view.findViewById(R.id.tv_singermusic_tag);
        tv_singer = (TextView) view.findViewById(R.id.tv_singer_tag);
        tv_singerzj_tag = (TextView) view.findViewById(R.id.tv_singerzj_tag);
        tv_singermlist_tag = (TextView) view.findViewById(R.id.tv_singermlist_tag);
        tv_mv_tag = (TextView) view.findViewById(R.id.tv_mv_tag);
        tv_singermusic_tag.setOnClickListener(this);
        tv_singer.setOnClickListener(this);
        tv_singerzj_tag.setOnClickListener(this);
        tv_mv_tag.setOnClickListener(this);
        tv_singermlist_tag.setOnClickListener(this);
        hs = (HorizontalScrollView) view.findViewById(R.id.navibar_search);
        v1 = view.findViewById(R.id.view_v1);
        v2 = view.findViewById(R.id.view_v2);
        v3 = view.findViewById(R.id.view_v3);
        v4 = view.findViewById(R.id.view_v4);
        v5 = view.findViewById(R.id.view_v5);
        width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        return view;
    }

    private void initData() {
        tag_name = new ArrayList<TextView>();
        tag_name.add(tv_singermusic_tag);
        tag_name.add(tv_singer);
        tag_name.add(tv_singerzj_tag);
        tag_name.add(tv_singermlist_tag);
        tag_name.add(tv_mv_tag);
        downlines = new ArrayList<View>();
        downlines.add(v1);
        downlines.add(v2);
        downlines.add(v3);
        downlines.add(v4);
        downlines.add(v5);
    }

    private void initViewPager() {
        manager = getFragmentManager();
        fragmentsList = new ArrayList<Fragment>();
        Fragment frag2 = new SearchD_singer_Fragment();
        Fragment frag1 = new SearchD_singlemusic_Fragment();
        Fragment frag3 = new SearchD_singerZJ_Fragment();
        Fragment frag4 = new SearchD_singerMlist_Fragment();
        Fragment frag5 = new SearchD_MV_Fragment();
        fragmentsList.add(frag1);
        fragmentsList.add(frag2);
        fragmentsList.add(frag3);
        fragmentsList.add(frag4);
        fragmentsList.add(frag5);
        mPager.setAdapter(new SearchDFragAdapter(manager, fragmentsList));
        mPager.setCurrentItem(0);
        mPager.setOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        hs.scrollTo((width * position + positionOffsetPixels) / 8, 0);
    }

    @Override
    public void onPageSelected(int position) {
        resetTextColorAndView();
        switch (position) {
            case 0:
                tv_singermusic_tag.setTextColor(Color.parseColor("#EA2000"));
                v1.setVisibility(View.VISIBLE);

                break;
            case 1:

                tv_singer.setTextColor(Color.parseColor("#EA2000"));
                v2.setVisibility(View.VISIBLE);

                break;
            case 2:

                tv_singerzj_tag.setTextColor(Color.parseColor("#EA2000"));
                v3.setVisibility(View.VISIBLE);

                break;
            case 3:
                tv_singermlist_tag.setTextColor(Color.parseColor("#EA2000"));
                v4.setVisibility(View.VISIBLE);

                break;
            case 4:

                tv_mv_tag.setTextColor(Color.parseColor("#EA2000"));
                v5.setVisibility(View.VISIBLE);

                break;
            default:
                break;
        }
    }

    private void resetTextColorAndView() {
        tv_singermusic_tag.setTextColor(Color.BLACK);
        tv_singer.setTextColor(Color.BLACK);
        tv_singerzj_tag.setTextColor(Color.BLACK);
        tv_singermlist_tag.setTextColor(Color.BLACK);
        tv_mv_tag.setTextColor(Color.BLACK);
        v1.setVisibility(View.GONE);
        v2.setVisibility(View.GONE);
        v3.setVisibility(View.GONE);
        v4.setVisibility(View.GONE);
        v5.setVisibility(View.GONE);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        resetTextColorAndView();
        switch (v.getId()) {
            case R.id.tv_singermusic_tag:
                mPager.setCurrentItem(0);
                tv_singermusic_tag.setTextColor(Color.parseColor("#EA2000"));
                v1.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_singer_tag:
                mPager.setCurrentItem(1);
                tv_singer.setTextColor(Color.parseColor("#EA2000"));
                v2.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_singerzj_tag:
                mPager.setCurrentItem(2);
                tv_singerzj_tag.setTextColor(Color.parseColor("#EA2000"));
                v3.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_singermlist_tag:
                mPager.setCurrentItem(3);
                tv_singermlist_tag.setTextColor(Color.parseColor("#EA2000"));
                v4.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_mv_tag:
                mPager.setCurrentItem(4);
                tv_mv_tag.setTextColor(Color.parseColor("#EA2000"));
                v5.setVisibility(View.VISIBLE);
                break;
        }
    }
}
