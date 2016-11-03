package com.app.cloudmusic.cloudmusic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.app.cloudmusic.cloudmusic.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class MainMusicFragment_two extends Fragment{

    private ListView listView;
    private GridView gridView;
    private ImageView iv;
    private TextView tv;
    private View view;

    //ListView设置数据
    private String [] names = {"撞击心脏的顶级重磅电音（心脏病者勿听）"};
    private int [] imageIDs = {R.drawable.b};

    //GridView设置数据


    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_two,container,false);
        //为精品歌单添加ListView
        List<Map<String ,Object>> list1 = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("image",imageIDs[0]);
        map.put("name",names[0]);
        list1.add(map);

        SimpleAdapter adapter = new SimpleAdapter(getActivity(),list1,R.layout.fragment_main_two_simple_item,
                new String[]{"image","name"},new int[]{R.id.iv_jingpin_fragment_main_two_simple_item,
        R.id.tv_message_fragment_main_two_simple_item});
        listView = (ListView)view.findViewById(R.id.lv_jingpin_fragment_main_two);
        listView.setAdapter(adapter);

      //  为上拉刷新歌单添加GridView
        SimpleAdapter adapter1 = new SimpleAdapter(getActivity(),getData(),R.layout.fragment_main_two_item_gridview,
                new String[]{"image","message"},new int[]{R.id.ib_image_fragment_main_two_gridview,
        R.id.tv_message_fragment_main_two_gridview}) ;
        gridView = (GridView)view.findViewById(R.id.gv_fragment_main_two);
        gridView.setAdapter(adapter1);
        return view;
    }

    public List<Map<String, Object>> getData(){
        int [] imageIDs = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,
                R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,};
        String [] messages = {"撞击心脏的顶级重磅电音（心脏病者勿听）","撞击心脏的顶级重磅电音（心脏病者勿听）","撞击心脏的顶级重磅电音（心脏病者勿听）","撞击心脏的顶级重磅电音（心脏病者勿听）",
                "撞击心脏的顶级重磅电音（心脏病者勿听）","撞击心脏的顶级重磅电音（心脏病者勿听）","撞击心脏的顶级重磅电音（心脏病者勿听）","撞击心脏的顶级重磅电音（心脏病者勿听）","撞击心脏的顶级重磅电音（心脏病者勿听）",
                "撞击心脏的顶级重磅电音（心脏病者勿听）","撞击心脏的顶级重磅电音（心脏病者勿听）","撞击心脏的顶级重磅电音（心脏病者勿听）","撞击心脏的顶级重磅电音（心脏病者勿听）",
                "撞击心脏的顶级重磅电音（心脏病者勿听）","撞击心脏的顶级重磅电音（心脏病者勿听）","撞击心脏的顶级重磅电音（心脏病者勿听）","撞击心脏的顶级重磅电音（心脏病者勿听）",
                "撞击心脏的顶级重磅电音（心脏病者勿听）","撞击心脏的顶级重磅电音（心脏病者勿听）","撞击心脏的顶级重磅电音（心脏病者勿听）",};

        List<Map<String,Object>> list = new ArrayList<>();
        for (int i = 0;i < imageIDs.length;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("image",imageIDs[i]);
            map.put("message",messages[i]);
            list.add(map);
        }
        return list;
    }
}
