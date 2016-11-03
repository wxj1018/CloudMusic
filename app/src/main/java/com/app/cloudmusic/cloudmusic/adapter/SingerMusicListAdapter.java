package com.app.cloudmusic.cloudmusic.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.Yuanzhongxue.SearchActivity;
import com.app.cloudmusic.cloudmusic.divider.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class SingerMusicListAdapter extends RecyclerView.Adapter {

    private LayoutInflater layoutInflater;
    private Context context;
    private static int screenWeight;
    private static int screenHeight;
    //
    private RecyclerView recyclerView_popwindow;
    private PopWindowAdapter popWindowAdapter;
    private LinearLayoutManager layoutManager;

    private List<String> data = new ArrayList<String>();

    public SingerMusicListAdapter(List<String> data,Context context) {
        this.context=context;
        this.data = data;
        layoutInflater=LayoutInflater.from(context);
        screenWeight = context.getResources().getDisplayMetrics().widthPixels;
        screenHeight = context.getResources().getDisplayMetrics().heightPixels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_music_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView t = (TextView) holder.itemView.findViewById(R.id.tv_single_music_name);
        t.setText(data.get(position));
//        if (position == 3 || position == 7 || position == 11 || position == 15 && position != 0) {
//            t.setText("");
//            t.setBackgroundColor(Color.parseColor("#E6E6E6"));
//            t.setHeight(1);
//        } else {
//            t.setBackgroundColor(Color.parseColor("#ffffff"));
//        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //自己添加点击事件的接口回调
    public interface OnItemClickListener {
        void onItemClick(View view, int positon);
    }

    public OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    //绑定ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView;
        public Button btn;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_single_music_name);
            btn= (Button) itemView.findViewById(R.id.btn_pop_window);
            btn.setOnClickListener(this);
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.btn_pop_window:
//                int height = screenHeight/3;
//                int weight = screenWeight;
                    View view = layoutInflater.inflate(R.layout.popwindow_view,null);
                    recyclerView_popwindow= (RecyclerView) view.findViewById(R.id.recyclerview_in_popwindow);
                    layoutManager = new LinearLayoutManager(view.getContext());
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView_popwindow.setLayoutManager(layoutManager);
                    //recyclerView_popwindow.addItemDecoration(new DividerItemDecoration(view.getContext(), layoutManager.getOrientation()));
                    recyclerView_popwindow.setHasFixedSize(true);
                    //设置默认动画
                    recyclerView_popwindow.setItemAnimator(new DefaultItemAnimator());
                    //增加数据

                    popWindowAdapter = new PopWindowAdapter(addData());
                    recyclerView_popwindow.setAdapter(popWindowAdapter);

                    //添加自定的点击事件
                    popWindowAdapter.setOnItemClickListener(new PopWindowAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int positon) {
                            Toast.makeText(view.getContext(),"选择了"+addData().get(positon).toString(),Toast.LENGTH_SHORT).show();
                        }
                    });
                    PopupWindow popupWindow = new PopupWindow(view,screenWeight,screenHeight/3,true);
                    popupWindow.setAnimationStyle(R.style.popwin_anim_style);
                    popupWindow.showAtLocation(textView, Gravity.BOTTOM,0,0);
                    break;
                case R.id.tv_single_music_name:
                    context.startActivity(new Intent(context, SearchActivity.class));
                    break;
            }
        }

        private List<String> addData() {
            List<String> list = new ArrayList<String>();
            list.add("下一首播放");
            list.add("收藏到歌单");
            list.add("下载");
            list.add("评论");
            list.add("分享");
            list.add("歌手:周杰伦");
            list.add("查看MV");
            list.add("彩铃");
            return list;
        }

    }


}
