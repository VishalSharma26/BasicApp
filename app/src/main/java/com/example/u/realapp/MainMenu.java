package com.example.u.realapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.u.realapp.MenuInflater.AboutUs;
import com.example.u.realapp.MenuInflater.Help;
import com.example.u.realapp.MenuInflater.Setting;

/**
 * Created by U on 10/26/2016.
 */
public class MainMenu extends ListActivity {
    String activity[] = {"Addition", "Music", "Command", "Email", "Camera", "MCQ", "Setting","Tabs", "Browser", "Flipper",
            "SharedPrefereneces", "InternalData", "ExternalData", "SQLiteDatabase", "VoiceRecognition", "TextVoice", "StatusBar","HttpExample",
            "MainServices","Fragments","Swipe","ImageSlider","Search","GestureDetector","AddNote","RotateAnimations","JSONLoad",
            "JSONLoadFromServer","DialogBox"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(MainMenu.this, android.R.layout.simple_list_item_1, activity));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String openActivity = activity[position];
        if (openActivity.contentEquals("Music")){
            openActivity = "MediaPlayer.Music";
        } else if (openActivity.contentEquals("MCQ")){
            openActivity = "Mcq.MCQ";
        } else if (openActivity.contentEquals("Setting")){
            openActivity = "MenuInflater.Setting";
        } else if(openActivity.contentEquals("SQLiteDatabase")){
            openActivity = "SQLiteDatabase.SQLiteDatabae";
        }else if(openActivity.contentEquals("MainServices")){
            openActivity = "Services.MainServices";
        }else if(openActivity.contentEquals("Fragments")){
            openActivity = "Fragments.MainFragmentClass";
        }else if(openActivity.contentEquals("Swipe")){
            openActivity = "Swipe.Swipe";
        }else if(openActivity.contentEquals("GestureDetector")){
            openActivity = "GestureDetectorActivity";
        }
        try {
            Class ourClass = Class.forName("com.example.u.realapp." + openActivity);
            Intent ourIntent = new Intent(MainMenu.this, ourClass);
            startActivity(ourIntent);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.aboutUs:
                Intent us = new Intent(MainMenu.this,AboutUs.class);
                startActivity(us);
                break;
            case R.id.setting :
                Intent set = new Intent(MainMenu.this, Setting.class);
                startActivity(set);
                break;
            case R.id.help:
                Intent hp = new Intent(MainMenu.this, Help.class);
                startActivity(hp);
                break;
            case R.id.exit:
                finish();
        }
        return false;
    }
}
