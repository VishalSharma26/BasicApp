package com.example.u.realapp.Services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.u.realapp.R;

/**
 * Created by U on 1/28/2017.
 */
public class MainServices extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_services);
    }
    public void startServices(View view){
        Intent i = new Intent(this,MyServices.class);
        startService(i);
    }
    public void stopServices(View view){
        Intent j = new Intent(this,MyServices.class);
        stopService(j);
    }
}
