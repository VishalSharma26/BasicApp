package com.example.u.realapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by U on 10/26/2016.
 */
public class Email extends Activity implements View.OnClickListener{
    EditText email,sub,mes;
    String semail,ssub,smes;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        email = (EditText)findViewById(R.id.emailid);
        sub = (EditText)findViewById(R.id.passwordid);
        mes = (EditText)findViewById(R.id.nameid);
        but = (Button)findViewById(R.id.buttonid);
        but.setOnClickListener(this);
    }
    public void onClick(View v){
        convert();
        String emailAddress[] = {semail};
        Intent ei = new Intent(Intent.ACTION_SEND);
        ei.putExtra(Intent.EXTRA_EMAIL, emailAddress);
        ei.putExtra(Intent.EXTRA_SUBJECT, ssub);
        ei.setType("plain/text");
        ei.putExtra(Intent.EXTRA_TEXT, smes);
        startActivity(ei);
    }
    public void convert(){
        semail = email.getText().toString();
        ssub = sub.getText().toString();
        smes = mes.getText().toString();
    }

    @Override
    public void onPause(){
        super.onPause();
        finish();
    }
}
