package com.example.u.realapp;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;
import java.util.Random;

/**
 * Created by U on 10/30/2016.
 */
public class TextVoice extends Activity {
    String texts[] = {"Do you need something","Are you ok","Happy Diwali","setting Alarm","opening Cameras"};
    Button b;
    TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_voice);
        b = (Button)findViewById(R.id.bText);

        tts = new TextToSpeech(TextVoice.this, new TextToSpeech.OnInitListener(){
            public void onInit(int n){
                if(n!=TextToSpeech.ERROR){
                    tts.setLanguage(Locale.US);
                }

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                String st = texts[r.nextInt(5)];
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

            }
        });




    }

    @Override
    protected void onPause() {
        if(tts != null){
            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }
}
