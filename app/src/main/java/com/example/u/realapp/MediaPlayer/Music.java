package com.example.u.realapp.MediaPlayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.u.realapp.R;

/**
 * Created by U on 10/25/2016.
 */
public class Music  extends Activity implements View.OnClickListener{
    Button song,sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);
        song = (Button)findViewById(R.id.bSong);
        sound = (Button)findViewById(R.id.bSound);
        song.setOnClickListener(this);
        sound.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bSong:
                Intent songActivity = new Intent(Music.this,Song.class);
                startActivity(songActivity);
                break;
            case R.id.bSound:
                Intent soundActivity = new Intent(Music.this,SoundPool.class);
                startActivity(soundActivity);
        }
    }
}
