package com.example.administrator.cloudmusic.utils;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class MyHorizontalScrollView extends HorizontalScrollView{
    private static final String TAG = "MyHorizontalScrollView";
    private Handler mHandler;
    private ScrollViewListener mScrollViewListener;
    /*
    * 滚动状态
    * IDLE=停止滚动
    * TOUCH_SCROLL= 手指拖动滚动
    * FLING = 滚动
     * */
    public enum  ScrollType{IDLE, TOUCH_SCROLL, FLING};
    //记录当前滚动的距离
    private int currentX = -9999999;
    //当前滚动状态

    private ScrollType scrollType = ScrollType.IDLE;
    public interface ScrollViewListener{
        void onScrollChanged(ScrollType scrollType);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHandler = new Handler();
        mScrollViewListener = new ScrollViewListener() {
            @Override
            public void onScrollChanged(ScrollType scrollType) {
                Log.i("aaaaa", "currentX"+currentX );
                if (scrollType == ScrollType.FLING && currentX > 200){
                    MYConfiguration.CAN_FINISH = true;
                    Log.i("aaaaa", "ddddddddddddddddddddddddddddddddddddd");
                }
//                    MYConfiguration.CAN_FINISH = false;
//                    scrollTo(0,0);
//                    scrollBy(-currentX,0);

            }
        };
    }
    //监听runnable
    private Runnable scrollRunnable = new Runnable() {
        @Override
        public void run() {while (true){
            if (getScrollX() == currentX){
                //停止滚动，取消监听线程
                scrollType = ScrollType.IDLE;
                if (mScrollViewListener != null){
                    mScrollViewListener.onScrollChanged(scrollType);
                }
                mHandler.removeCallbacks(this);
                return;
            }else {
                //手指离开屏幕，但是View还在滚动
                scrollType = ScrollType.FLING;
                if (mScrollViewListener != null){
                    mScrollViewListener.onScrollChanged(scrollType);
                }
            }
            currentX = getScrollX();
            //滚动监听间隔：milliseconds
            mHandler.postDelayed(this, 50);
        }}
    };

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_MOVE:
                this.scrollType = ScrollType.TOUCH_SCROLL;
                mScrollViewListener.onScrollChanged(scrollType);
                mHandler.removeCallbacks(scrollRunnable);
                break;
            case MotionEvent.ACTION_UP:
                mHandler.post(scrollRunnable);
                break;
        }
        return super.onTouchEvent(ev);
    }
}
