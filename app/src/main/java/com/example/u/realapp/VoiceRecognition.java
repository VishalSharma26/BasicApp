package com.example.u.realapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.u.realapp.MenuInflater.Setting;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by U on 10/30/2016.
 */
public class VoiceRecognition extends Activity {
    Button b1;
    ListView lv;
    final static int check = 1111;
    String st,camera = "open camera",gmail =  "open Gmail", exit = "exit", google = "open Google",set = "open settings",back = "back";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice_recognition);
        b1 = (Button)findViewById(R.id.bSpeak);
        lv = (ListView)findViewById(R.id.listView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                i.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speek up soon!");
                startActivityForResult(i, check);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == check && resultCode == RESULT_OK){
            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,result));
            st = result.get(0).toString();
            if(st.contentEquals(camera)){
                Intent i1 =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(i1);
            } else if(st.contentEquals(gmail)){
                Intent i2 = new Intent(VoiceRecognition.this,Email.class);
                startActivity(i2);
            } else if(st.contentEquals(google)){
                Intent i3 = new Intent(VoiceRecognition.this,Browser.class);
                startActivity(i3);
            } else if(st.contentEquals(set)){
                Intent i4 = new Intent(VoiceRecognition.this, Setting.class);
                startActivity(i4);
            } else if(st.contentEquals(back)){
                Toast t1 = Toast.makeText(VoiceRecognition.this,"Back",Toast.LENGTH_LONG);
                t1.show();
                finish();
            }  else if(st.contentEquals(exit)){
                Toast t1 = Toast.makeText(VoiceRecognition.this,"Exit",Toast.LENGTH_LONG);
                t1.show();
                System.exit(0);
            } else{
                Toast t2 = Toast.makeText(VoiceRecognition.this,"Try again",Toast.LENGTH_LONG);
                t2.show();
            }
        }
    }
}
