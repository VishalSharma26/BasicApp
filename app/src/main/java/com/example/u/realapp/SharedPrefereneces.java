package com.example.u.realapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by U on 10/28/2016.
 */
public class SharedPrefereneces extends Activity implements View.OnClickListener{
    EditText et;
    String Data,receiveData;
    Button save,load;
    TextView tv;
    SharedPreferences sp;
    public static String folder = "MyFolder";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpreferences);
        et = (EditText)findViewById(R.id.etData);
        save = (Button)findViewById(R.id.bSave);
        load = (Button)findViewById(R.id.bLoad);
        tv = (TextView)findViewById(R.id.tvShow);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
        sp = getSharedPreferences(folder,0);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bSave:
                Data = et.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("data",Data);
                editor.commit();
                break;
            case R.id.bLoad:
                sp = getSharedPreferences(folder,0);
                receiveData = sp.getString("data","Sorry!!  Can't Load.");
                tv.setText(receiveData);
                break;
        }
    }
}
