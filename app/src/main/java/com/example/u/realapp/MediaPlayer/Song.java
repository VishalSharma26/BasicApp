package com.example.u.realapp.MediaPlayer;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import com.example.u.realapp.R;

/**
 * Created by U on 10/25/2016.
 */
public class Song extends Activity implements View.OnClickListener {
    Button startButton, stopButton, replay;
    MediaPlayer mp;
    Boolean start = false, pause = false;
    int length;
    Boolean on;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song);
        mp = MediaPlayer.create(Song.this, R.raw.flash);
        startButton = (Button) findViewById(R.id.bStart);
        stopButton = (Button) findViewById(R.id.bStop);
        replay = (Button) findViewById(R.id.bReplay);
        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        replay.setOnClickListener(this);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        on = sp.getBoolean("soundKey",true);
    }

    @Override
    public void onClick(View v) {
        if(on){
        switch (v.getId()) {
            case R.id.bStart:
                if (start == false) {
                    mp.seekTo(0);
                    mp.start();
                    start = true;
                }
                if (start == true && pause == true) {
                    mp.seekTo(0);
                    mp.start();
                    pause = false;
                    replay.setBackgroundColor(Color.rgb(11, 245, 105));
                }

                break;
            case R.id.bReplay:
                if (start == true) {
                    if (pause == false) {
                        mp.pause();
                        length = mp.getCurrentPosition();
                        pause = true;
                        replay.setBackgroundColor(Color.rgb(244, 56, 78));
                    } else {
                        mp.seekTo(length);
                        mp.start();
                        pause = false;
                        replay.setBackgroundColor(Color.rgb(11, 245, 105));
                    }
                }
                break;
            case R.id.bStop:
                if (start == true) {
                    if (pause == false) {
                        mp.pause();
                        start = false;
                    } else {
                        mp.pause();
                        pause = false;
                        replay.setBackgroundColor(Color.rgb(11, 245, 105));
                        start = false;
                    }
                }

                break;
        }
        }
    }
@Override
protected void onPause() {
    super.onPause();
    mp.release();
}
}