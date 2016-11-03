package com.example.administrator.cloudmusic.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.cloudmusic.R;

/**
 * Created by Administrator on 2016/10/14.
 */
public class SoundStartKnowFragment extends Fragment{
    private static boolean isStart;
    private static boolean isStop;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sound_startknow_fragment, container, false);
        final TextView textView = (TextView) view.findViewById(R.id.start_know_fragment_sound);
        final TextView hideText = (TextView) view.findViewById(R.id.sound_tvtop_activity_sound);
        final ImageView iv = (ImageView) view.findViewById(R.id.iv_red_start_fragment_sound);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart){
                    isStart = !isStart;
                    textView.setText("开始识别");
                    updateImage(R.drawable.sound_start_know_activity_sound, textView);
                    hideText.setVisibility(View.GONE);
                }else {
                    isStart = !isStart;
                    textView.setText("停止识别");
                    updateImage(R.drawable.sound_start_know_2_activity_sound,textView);
                    hideText.setVisibility(View.VISIBLE);                }
            }
        });
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        iv.setImageResource(R.drawable.sound_red_circle_chcked_activity_soudn);
                        break;
                    case MotionEvent.ACTION_UP:
                        iv.setImageResource(R.drawable.sound_red_circle_activity_sound);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        iv.setImageResource(R.drawable.sound_red_circle_activity_sound);
                        break;
                }
                return false;
            }
        });
        return view;
    }
    //改变Button的DrawableTop
    private void updateImage(int id, TextView view){
        Drawable nav_up4=getResources().getDrawable(id);
        nav_up4.setBounds(0, 0, nav_up4.getMinimumWidth(), nav_up4.getMinimumHeight());
        view.setCompoundDrawables(null, nav_up4, null, null);
    }
}
