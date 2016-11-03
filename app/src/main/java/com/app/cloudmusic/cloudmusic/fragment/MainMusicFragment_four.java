package com.app.cloudmusic.cloudmusic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.adapter.MyBaseAdapter;
import com.app.cloudmusic.cloudmusic.adapter.MyBaseAdapter_two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class MainMusicFragment_four extends Fragment{

    private ListView lv_guanfang,lv_quanqiu,lv_yongh;
    private View view;
    List<HashMap<String, Object>> data1,data2,data3;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_four,container,false);
        data1 = new ArrayList<HashMap<String, Object>>() ;
        HashMap<String, Object> map1 = new HashMap() ;
        map1.put("image1",R.drawable.panghaibang_1);
        map1.put("name1","1.蓝瘦 香菇 - 王小梓");
        map1.put("name2","2.败将 - 陈势安");
        map1.put("name3","3.下完这场雨 - 后弦");

        HashMap<String, Object> map2 = new HashMap() ;
        map2.put("image1",R.drawable.panghaibang_2);
        map2.put("name1","1.全世界谁倾听你 - 林宥嘉");
        map2.put("name2","2.你在终点等我 - 王菲");
        map2.put("name3","3.Pen Pineapple Apple Pen - PPAP");

        HashMap<String, Object> map3 = new HashMap() ;
        map3.put("image1",R.drawable.panghaibang_3);
        map3.put("name1","1.致姗姗来迟的你 - 阿肆/林宥嘉");
        map3.put("name2","2.月 - 好妹妹乐队");
        map3.put("name3","3.如斯 - 丢火车");

        HashMap<String, Object> map4 = new HashMap() ;
        map4.put("image1",R.drawable.panghaibang_4);
        map4.put("name1","1.全世界谁倾听你 - 林宥嘉");
        map4.put("name2","2.告白气球 - 周杰伦");
        map4.put("name3","3.一万个伤心的理由 - 张学友");

        HashMap<String, Object> map5 = new HashMap() ;
        map5.put("image1",R.drawable.panghaibang_5);
        map5.put("name1","1.周杰伦");
        map5.put("name2","2.薛之谦");
        map5.put("name3","3.陈奕迅");

        data1.add(map1);
        data1.add(map2);
        data1.add(map3);
        data1.add(map4);
        data1.add(map5);

        data2 = new ArrayList<HashMap<String, Object>>() ;
        String [] name1 = {"云音乐电音榜","Beatport全球电子舞曲榜","UK排行榜周榜","美国Billboard周榜","法国 NRJ Vos Hits周榜",
                "iTunes榜","云音乐ACG音乐榜","韩国Melon原声周榜","韩国Mnet原声周榜","韩国Ment排行榜周榜","日本Oricon周榜","云音乐古典音乐榜",
                "Hit FM Top榜","KTV唛榜","台湾Hito排行榜","中国Top排行榜（港台榜）","中国Top排行榜（内地榜）","香港电台中文歌曲龙虎榜",
                "华语金曲榜","中国嘻哈榜"};
        String [] name2 ={"每周五更新","每周四更新","每周一更新","每周三更新","每周五更新","每周一更新","每周四更新","每周一更新",
                "每周一更新","每周一更新","每周三更新","每周四更新","每周一更新","每周五更新","每周一更新","每周一更新",
                "每周一更新","每周五更新","每周一更新","每周五更新"};
        int [] imageIDs = {R.drawable.panghaibang_y,R.drawable.panghaibang_g,R.drawable.panghaibang_y,R.drawable.panghaibang_g,R.drawable.panghaibang_y,R.drawable.panghaibang_g,
                R.drawable.panghaibang_y,R.drawable.panghaibang_g,R.drawable.panghaibang_y,R.drawable.panghaibang_g,R.drawable.panghaibang_y,R.drawable.panghaibang_g,
                R.drawable.panghaibang_y,R.drawable.panghaibang_g,R.drawable.panghaibang_y,R.drawable.panghaibang_g,R.drawable.panghaibang_y,R.drawable.panghaibang_g,
                R.drawable.panghaibang_y,R.drawable.panghaibang_g};
        for (int i= 0;i<name1.length;i++){
            HashMap<String, Object> map = new HashMap() ;
            map.put("name1",name1[i]);
            map.put("name2",name2[i]);
            map.put("imageID",imageIDs[i]);
            data2.add(map);
        }

        data3 = new ArrayList<HashMap<String, Object>>() ;
        String [] string1 = {"音乐达人榜","音乐新人榜"};
        String [] string2 = {"每周一更新","每周一更新"};
        int [] id = {R.drawable.panghaibang_y,R.drawable.panghaibang_g};
        for (int i= 0;i<string1.length;i++){
            HashMap<String, Object> map = new HashMap() ;
            map.put("name1",name1[i]);
            map.put("name2",name2[i]);
            map.put("imageID",id[i]);
            data3.add(map);
        }

        lv_guanfang = (ListView)view.findViewById(R.id.lv_fragment_main_four_guanfang);
        lv_quanqiu = (ListView)view.findViewById(R.id.lv_fragment_main_four_quanqiu);
        lv_yongh = (ListView)view.findViewById(R.id.lv_fragment_main_four_yonghu);
        MyBaseAdapter adapter = new MyBaseAdapter(inflater,data1);
        MyBaseAdapter_two adapter_two = new MyBaseAdapter_two(inflater,data2);
        MyBaseAdapter_two adapter_three = new MyBaseAdapter_two(inflater,data3);
        lv_guanfang.setAdapter(adapter);
        setListViewHeightBasedOnChildren(lv_guanfang);
        lv_quanqiu.setAdapter(adapter_two);
        lv_yongh.setAdapter(adapter_three);
        setListViewHeightBasedOnChildrenTwo(lv_quanqiu);
        setListViewHeightBasedOnChildrenTwo(lv_yongh);
        return view;
    }


    //为ListView设置滚动
    public void setListViewHeightBasedOnChildren(ListView listView) {
        MyBaseAdapter baseAdapter = (MyBaseAdapter) listView.getAdapter();
        if (baseAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < baseAdapter.getCount(); i++) {
            View listItem = baseAdapter.getView(i, null, listView);
            listItem.measure(0, 0);  //<span style="font-family: Helvetica, Tahoma, Arial, sans-serif; font-size: 14px; line-height: 25px; text-align: left; ">在还没有构建View 之前无法取得View的度宽。 </span><span style="font-family: Helvetica, Tahoma, Arial, sans-serif; font-size: 14px; line-height: 25px; text-align: left; ">在此之前我们必须选 measure 一下. </span><br style="font-family: Helvetica, Tahoma, Arial, sans-serif; font-size: 14px; line-height: 25px; text-align: left; ">
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (baseAdapter.getCount() - 1));
        // params.height += 5;// if without this statement,the listview will be
        // a
        // little short
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }
    public void setListViewHeightBasedOnChildrenTwo(ListView listView) {
        MyBaseAdapter_two baseAdapter = (MyBaseAdapter_two) listView.getAdapter();
        if (baseAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < baseAdapter.getCount(); i++) {
            View listItem = baseAdapter.getView(i, null, listView);
            listItem.measure(0, 0);  //<span style="font-family: Helvetica, Tahoma, Arial, sans-serif; font-size: 14px; line-height: 25px; text-align: left; ">在还没有构建View 之前无法取得View的度宽。 </span><span style="font-family: Helvetica, Tahoma, Arial, sans-serif; font-size: 14px; line-height: 25px; text-align: left; ">在此之前我们必须选 measure 一下. </span><br style="font-family: Helvetica, Tahoma, Arial, sans-serif; font-size: 14px; line-height: 25px; text-align: left; ">
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (baseAdapter.getCount() - 1));
        // params.height += 5;// if without this statement,the listview will be
        // a
        // little short
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }


}
