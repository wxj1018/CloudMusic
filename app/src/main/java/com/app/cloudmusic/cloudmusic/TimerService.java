package com.app.cloudmusic.cloudmusic;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class TimerService extends Service {
    public TimerService() {
    }

    @Override
    public void onCreate() {
        Log.i("aaaaa", "onCreate");
        super.onCreate();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("timer_position", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                int timer = sharedPreferences.getInt("timer", 0);
                if (timer == 0){
                    Log.i("aaaaa", "dddddddddddddd");
                    stopSelf();
                }else {
//                    Log.i("aaaaa", "ffffffff");
                    timer = timer -1;
                    Log.i("aaaaa", timer + "?");
                    editor.putInt("timer", timer--);
                    editor.commit();
                }
            }
        }, 1000, 1000);
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
