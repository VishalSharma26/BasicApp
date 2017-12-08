package com.example.u.realapp.SQLiteDatabase;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.u.realapp.R;

import java.sql.SQLDataException;

public class SQLiteDatabae extends Activity implements View.OnClickListener , RadioGroup.OnCheckedChangeListener {
    EditText name,regNo,email,phone,get;
    RadioGroup rg;
    Button buttonDone,buttonView,bg,bm,bd;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sql_input);
        name = (EditText)findViewById(R.id.nameId);
        regNo = (EditText)findViewById(R.id.regId);
        email = (EditText)findViewById(R.id.emailId);
        phone = (EditText)findViewById(R.id.phoneId);
        get = (EditText)findViewById(R.id.etRow);
        rg = (RadioGroup)findViewById(R.id.rgId);
        buttonDone = (Button)findViewById(R.id.DoneId);
        buttonView = (Button)findViewById(R.id.viewId);
        bg = (Button)findViewById(R.id.bGet);
        bm = (Button)findViewById(R.id.bModify);
        bd = (Button)findViewById(R.id.bDelete);

        buttonView.setOnClickListener(this);
        buttonDone.setOnClickListener(this);
        bg.setOnClickListener(this);
        bm.setOnClickListener(this);
        bd.setOnClickListener(this);
        rg.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.DoneId:
                Boolean diw = true;
                try {
                    String Name = name.getText().toString();
                    String Age = regNo.getText().toString();
                    String Add = email.getText().toString();
                    String Con = phone.getText().toString();
                    String Gen = gender;

                    Database entry = new Database(SQLiteDatabae.this);
                    entry.open();
                    entry.createEntry(Name, Age,Add,Con,Gen);
                    entry.close();
                }catch (Exception e){
                    diw = false;
                }finally {
                    if(diw){
                        Dialog d = new Dialog(this);
                        d.setTitle("Done");
                        TextView tv = new TextView(this);
                        tv.setText("success");
                        d.setContentView(tv);
                        d.show();
                    }
                }

                break;
            case R.id.viewId:
                Intent in = new Intent(this, SQLView.class);
                startActivity(in);
                break;
            case R.id.bGet:
                try {
                    String s = get.getText().toString();
                    long ln = Long.parseLong(s);
                    Database db = new Database(this);
                    db.open();
                    String retName = db.returnName(ln);
                    String retAge = db.returnAge(ln);
                    String retAdd = db.returnAdd(ln);
                    String retCon = db.returnCon(ln);
                    String retGen = db.returnGen(ln);
                    name.setText(retName);
                    regNo.setText(retAge);
                    email.setText(retAdd);
                    phone.setText(retCon);
                    if(retGen.contentEquals("Male")){
                        rg.check(R.id.radioButtonM);
                    }
                    else if(retGen.contentEquals("Femail")){
                        rg.check(R.id.radioButtonF);
                    }
                    db.close();
                } catch (SQLDataException e) {
                    e.printStackTrace();
                }

                break;
            case R.id.bModify:  try {
                String n = name.getText().toString();
                String r = regNo.getText().toString();
                String e = email.getText().toString();
                String p = phone.getText().toString();
                String g = gender;
                String row = get.getText().toString();
                long lng = Long.parseLong(row);
                Database db = new Database(this);
                db.open();
                db.updateEntry(lng,n,r,e,p,g);
                db.close();
            } catch (SQLDataException e) {
                e.printStackTrace();
            }
                break;
            case R.id.bDelete:
                try {
                    String row = get.getText().toString();
                    long lg = Long.parseLong(row);
                    Database db = new Database(this);
                    db.open();
                    db.deleteEntry(lg);
                    db.close();
                } catch (SQLDataException e) {
                    e.printStackTrace();
                }

                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.radioButtonM:
                gender = "Male";
                break;
            case R.id.radioButtonF:
                gender = "Femail";
                break;
        }
    }
}
