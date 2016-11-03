package com.app.cloudmusic.cloudmusic.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import com.app.cloudmusic.cloudmusic.R;
import com.app.cloudmusic.cloudmusic.view.MyVideoView;

public class PlayMusicMVActivity extends AppCompatActivity {

    private MyVideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music_mv);

        videoView= (MyVideoView) findViewById(R.id.video_play_mv);
        Uri uri = Uri.parse("http://192.168.191.1:9096/CloudMusic/mv1.mp4");
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.requestFocus();
    }


}
