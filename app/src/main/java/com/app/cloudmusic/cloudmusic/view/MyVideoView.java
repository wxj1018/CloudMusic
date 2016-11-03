package com.app.cloudmusic.cloudmusic.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.app.cloudmusic.cloudmusic.R;

/**
 * Created by Administrator on 2016/10/26 0026.
 */
public class MyVideoView extends VideoView  {

//    private Context context;
//    private FrameLayout viewBox;
//    private MyVideoView videoView;
//    private LinearLayout videoPauseBtn;
//    private LinearLayout screenSwitchBtn;
//    private LinearLayout videoControllerLayout;
//    private LinearLayout touchStatusView;
//    private ImageView touchStatusImg,videoPlayImg,videoPauseImg;
//    private TextView touchStatusTime;
//    private TextView videoCurTimeText;
//    private TextView videoTotalTimeText;
//    private SeekBar videoSeekBar;
//    private ProgressBar progressBar;
//
//    //
//    private float touchLastX;
//    private int position;
//    private int touchStep;
//    private int touchPosition;
//    private int duration=videoView.getDuration();


    public MyVideoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public MyVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MyVideoView(Context context) {
        super(context);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        this.getHolder().setFixedSize(width,height);//设置分辨率
        setMeasuredDimension(width, height);
    }

//    @Override
//    protected void onFinishInflate() {
//        super.onFinishInflate();
//        initViews();
//    }
//
//    private void initViews() {
//        View view = LayoutInflater.from(context).inflate(R.layout.test,null);
//        viewBox = (FrameLayout) view.findViewById(R.id.viewBox);
//        videoView = (MyVideoView) view.findViewById(R.id.videoView);
//        videoPauseBtn = (LinearLayout) view.findViewById(R.id.videoPauseBtn);
//        screenSwitchBtn = (LinearLayout) view.findViewById(R.id.screen_status_btn);
//        videoControllerLayout = (LinearLayout) view.findViewById(R.id.videoControllerLayout);
//        touchStatusView = (LinearLayout) view.findViewById(R.id.touch_view);
//        touchStatusImg = (ImageView) view.findViewById(R.id.touchStatusImg);
//        touchStatusTime = (TextView) view.findViewById(R.id.touch_time);
//        videoCurTimeText = (TextView) view.findViewById(R.id.videoCurTime);
//        videoTotalTimeText = (TextView) view.findViewById(R.id.videoTotalTime);
//        videoSeekBar = (SeekBar) view.findViewById(R.id.videoSeekBar);
//        videoPlayImg = (ImageView) view.findViewById(R.id.videoPlayImg);
//        videoPlayImg.setVisibility(GONE);
//        videoPauseImg = (ImageView) view.findViewById(R.id.videoPauseImg);
//        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
//        videoPauseBtn.setOnClickListener(this);
//        videoSeekBar.setOnSeekBarChangeListener(this);
//        videoPauseBtn.setOnClickListener(this);
//        videoView.setOnPreparedListener(this);
//        videoView.setOnCompletionListener(this);
//        screenSwitchBtn.setOnClickListener(this);
//        videoPlayImg.setOnClickListener(this);
////注册在设置或播放过程中发生错误时调用的回调函数。如果未指定回调函数，或回调函数返回false，VideoView 会通知用户发生了错误。
//        videoView.setOnErrorListener(this);
//        viewBox.setOnTouchListener(this);
//        viewBox.setOnClickListener(this);
//        addView(view);
//    }
//
//    @Override
//    public void onClick(View v) {
//
//    }
//
//    @Override
//    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//        int[] time = getMinuteAndSecond(progress);
//        videoCurTimeText.setText(String.format("%02d:%02d", time[0], time[1]));
//    }
//
//    @Override
//    public void onStartTrackingTouch(SeekBar seekBar) {
//        videoView.pause();
//    }
//
//    @Override
//    public void onStopTrackingTouch(SeekBar seekBar) {
//        videoView.seekTo(videoSeekBar.getProgress());
//        videoView.start();
//        videoPlayImg.setVisibility(View.INVISIBLE);
//        videoPauseImg.setImageResource(R.mipmap.ic_launcher);
//    }
//
//    @Override
//    public boolean onError(MediaPlayer mp, int what, int extra) {
//        return false;
//    }
//
//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
////没播放的时候不处理
//                if (!videoView.isPlaying()){
//                    return false;
//                }
//                float downX = event.getRawX();
//                touchLastX = downX;
//                Log.d("FilmDetailActivity", "downX" + downX);
////保存当前播放的位置用与做事件显示
//                this.position = videoView.getCurrentPosition();
//                break;
//            case MotionEvent.ACTION_MOVE:
////没播放的时候不处理
//                if (!videoView.isPlaying()){
//                    return false;
//                }
//                float currentX = event.getRawX();
//                float deltaX = currentX - touchLastX;
//                float deltaXAbs = Math.abs(deltaX);
//                if (deltaXAbs>1){//正向移动，快进
//                    if (touchStatusView.getVisibility()!=View.VISIBLE){
//                        touchStatusView.setVisibility(View.VISIBLE);
////显示快进的时间view
//                    }
//                    touchLastX = currentX;
//                    Log.d("FilmDetailActivity","deltaX"+deltaX);
//                    if (deltaX > 1) {
//                        position += touchStep;
//                        if (position > duration) {
//                            position = duration;
//                        }
//                        touchPosition = position;
//                        touchStatusImg.setImageResource(R.mipmap.ic_launcher);
//                        int[] time = getMinuteAndSecond(position);
//                        touchStatusTime.setText(String.format("%02d:%02d/%s", time[0], time[1],formatTotalTime));
//                    } else if (deltaX < -1) {//快退
//                        position -= touchStep;
//                        if (position < 0) {
//                            position = 0;
//                        }
//                        touchPosition = position;
//                        touchStatusImg.setImageResource(R.mipmap.ic_launcher);
//                        int[] time = getMinuteAndSecond(position);
//                        touchStatusTime.setText(String.format("%02d:%02d/%s", time[0], time[1],formatTotalTime));
////mVideoView.seekTo(position);
//                    }
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                if (touchPosition!=-1){
//                    videoView.seekTo(touchPosition);
////放开手指的时候快进或快退到滑动决定的时间位置 touchStatusView.setVisibility(View.GONE);
//                    touchPosition = -1;
//                    if (videoControllerShow){
//                        return true;
//                    }
//                }
//                break;
//        }
//        return false;
//    }
//
//    //开始播放
//    public void start(String url){
//        videoPauseBtn.setEnabled(false);
//        videoSeekBar.setEnabled(false);
//        videoView.setVideoURI(Uri.parse(url));
//        videoView.start();
//    }
//    //进入全屏时候调用
//    public void setFullScreen(){
//        touchStatusImg.setImageResource(R.mipmap.ic_launcher);
//        this.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        videoView.requestLayout();
//    }
//    //退出全屏时候调用
//    public void setNormalScreen(){
//        touchStatusImg.setImageResource(R.mipmap.ic_launcher);
//        this.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,400));
//        videoView.requestLayout();
//    }
}
