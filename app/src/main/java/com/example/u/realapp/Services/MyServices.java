package com.example.u.realapp.Services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.u.realapp.R;

/**
 * Created by U on 1/28/2017.
 */
public class MyServices extends Service{
    MediaPlayer mp;
    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(this, R.raw.flash);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Start Services",Toast.LENGTH_LONG).show();
        mp.start();
        return START_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Stop Services",Toast.LENGTH_LONG).show();
        mp.release();
    }

}
