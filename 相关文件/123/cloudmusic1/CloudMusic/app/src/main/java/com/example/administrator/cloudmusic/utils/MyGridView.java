package com.example.administrator.cloudmusic.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 自定义GridView解决与ScrollView的冲突
 * Created by Administrator on 2016/10/15.
 */
public class MyGridView extends GridView {

        public MyGridView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }
        public MyGridView(Context context) {
            super(context);
        }
        public MyGridView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }
        @Override
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int expandSpec = MeasureSpec.makeMeasureSpec(
                    Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, expandSpec);
        }

}
