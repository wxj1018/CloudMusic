package com.app.cloudmusic.cloudmusic.Yuanzhongxue;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/13 0013.
 */
public class MyView extends View {

    private float width;		//歌词视图宽度
    private float height;		//歌词视图高度
    private Paint currentPaint;	//当前画笔对象
    private Paint notCurrentPaint;	//非当前画笔对象
    private float textHeight = 25;	//文本高度
    private float textSize = 18;		//文本大小
    private int index = 0;		//list集合下标


    private List<LrcContent> mLrcList = new ArrayList<LrcContent>();

    public void setmLrcList(List<LrcContent> mLrcList){
        this.mLrcList = mLrcList;

    }

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setFocusable(true);
        //高亮部分
        currentPaint =new Paint();
        currentPaint.setAntiAlias(true);
        currentPaint.setTextAlign(Paint.Align.CENTER);

        notCurrentPaint = new Paint();
        notCurrentPaint.setAntiAlias(true);
        notCurrentPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas==null){
            return;
        }
        currentPaint.setColor(Color.argb(210, 251, 248, 29));
        notCurrentPaint.setColor(Color.argb(140, 255, 255, 255));

        currentPaint.setTextSize(24);
        currentPaint.setTypeface(Typeface.SERIF);

        notCurrentPaint.setTextSize(textSize);
        notCurrentPaint.setTypeface(Typeface.DEFAULT);


//        canvas.drawText(mLrcList.get(index).getLrcStr(),width/2,height/2,currentPaint);
        float tempY =height/2;
        //画出本句之后的句子
        for (int i = index - 1;i>=0;i --){
            tempY =tempY - textHeight;
            canvas.drawText(mLrcList.get(i).getLrcStr(),width/2,height/2,notCurrentPaint);
        }

        tempY = height/2;
        //画出之后的句子
        for (int i=index+1;i<mLrcList.size();i++){
            tempY = tempY+textHeight;
            canvas.drawText(mLrcList.get(i).getLrcStr(),width/2,height/2,notCurrentPaint);
        }
    }


    //view改变的情况
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.width=w;
        this.height=h;

    }
    public void setIndex (int index){
        this.index = index;
    }
}
