package com.example.u.realapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by U on 10/28/2016.
 */
public class InternalData extends Activity implements View.OnClickListener{
    EditText et;
    TextView tv;
    FileOutputStream fos;
    SharedPreferences sp;
    public static String folder = "MyFolder";
    String FILENAME = "MyFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpreferences);
        et = (EditText)findViewById(R.id.etData);
        Button save = (Button)findViewById(R.id.bSave);
        Button load = (Button)findViewById(R.id.bLoad);
        Button spLoad = (Button)findViewById(R.id.bLoadfromSp);

        tv = (TextView)findViewById(R.id.tvShow);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
        spLoad.setOnClickListener(this);

        try {
            fos = openFileOutput(FILENAME , Context.MODE_PRIVATE);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bSave:
                String Data = et.getText().toString();
                try {
                    fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    fos.write(Data.getBytes());
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.bLoad:
                new loadSomeStuff().execute(FILENAME);
                break;

            case R.id.bLoadfromSp:
                sp = getSharedPreferences(folder,0);
                String receiveData = sp.getString("data","Sorry!!  Can't Load.");
                tv.setText(receiveData);
                break;
        }
    }

    private class loadSomeStuff extends AsyncTask<String , Integer , String>{

        ProgressDialog pd;
        protected void onPreExecute() {
            pd = new ProgressDialog(InternalData.this);
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.setMax(100);
            pd.show();
        }

        @Override
        protected String doInBackground(String... params) {
            String collected = null;
            FileInputStream fis = null;

            for(int i=0 ; i<20 ; i++){
                publishProgress(5);
                try {
                    Thread.sleep(68);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            pd.dismiss();

            try {
                fis = openFileInput(FILENAME);
                byte[] arrayData = new byte[fis.available()];
                while (fis.read(arrayData)!= -1){
                    collected = new String(arrayData);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                    return collected;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        protected void onProgressUpdate(Integer...values) {
            pd.incrementProgressBy(values[0]);
        }

        protected void onPostExecute(String s) {
            tv.setText(s);

        }
    }
}
