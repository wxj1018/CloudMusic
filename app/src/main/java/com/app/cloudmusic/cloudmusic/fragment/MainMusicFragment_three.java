package com.app.cloudmusic.cloudmusic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.app.cloudmusic.cloudmusic.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class MainMusicFragment_three extends Fragment{

    private View view;
    private ViewPager viewPager;
    private ListView listView1,listView2;
    private List<Fragment> fragmentList;
    private MainMusicFragment_three_one fragment_three_one;
    private MainMusicFragment_three_two fragment_three_two ;
    private MainMusicFragment_three_three fragment_three_three;
    

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_three,container,false);

        //为电台排行榜加ListView
        int [] imageIDs1 = {R.drawable.panghaibang_g};
        int [] imageIDs2 = {R.drawable.panghaibang_y,};
        int [] imageIDs3 = {R.drawable.panghaibang_2};
        List<Map<String ,Object>> list1 = new ArrayList<>();
            Map<String,Object> map = new HashMap<>();
            map.put("image1",imageIDs1[0]);
            map.put("image2",imageIDs2[0]);
            map.put("image3",imageIDs3[0]);
            list1.add(map);


        //设置适配器
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),list1,R.layout.fragment_main_three_simple_item,
                new String[]{"image1","image2","image3"},new int[]{R.id.iv_1_fragment_main_three,R.id.iv_2_fragment_main_three,R.id.iv_3_fragment_main_three});
        listView1 = (ListView)view.findViewById(R.id.lv_one_fragment_main_three);
        listView1.setAdapter(adapter);

        //设置ViewPager
        initView();


        return view;
    }

    public void initView(){
        fragmentList = new ArrayList<>();
        viewPager = (ViewPager)view.findViewById(R.id.vp_fragment_main_three);
        fragment_three_one = new MainMusicFragment_three_one();
        fragment_three_two = new MainMusicFragment_three_two();
        fragment_three_three = new MainMusicFragment_three_three();

        fragmentList.add(fragment_three_one);
        fragmentList.add(fragment_three_two);
        fragmentList.add(fragment_three_three);

        //设置适配器
        FragmentPagerAdapter adapter =new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        viewPager.setAdapter(adapter);

    }
}
