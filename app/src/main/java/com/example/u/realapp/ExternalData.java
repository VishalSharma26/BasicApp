package com.example.u.realapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by U on 10/28/2016.
 */
public class ExternalData extends Activity implements AdapterView.OnItemSelectedListener , View.OnClickListener{
    TextView read,write;
    private String state;
    Boolean canR,canW;
    Spinner spin;
    String[] paths = {"Music", "Pictures", "Download"};
    File path = null;
    EditText saveFile;
    Button done,save;
    File filename = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.external_data);
        read = (TextView)findViewById(R.id.tvRead);
        write = (TextView)findViewById(R.id.tvWrite);
        saveFile = (EditText)findViewById(R.id.etItem);
        done = (Button)findViewById(R.id.bDoneItem);
        save = (Button)findViewById(R.id.bSaveItem);
        done.setOnClickListener(this);
        save.setOnClickListener(this);
        state = Environment.getExternalStorageState();
        checkState();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ExternalData.this, android.R.layout.simple_list_item_1,paths);
        spin = (Spinner)findViewById(R.id.spinner);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
    }

    private void checkState() {
        if(state.contentEquals(Environment.MEDIA_MOUNTED)){
            read.setText("true");
            write.setText("true");
            canR = canW = true;
        } else if(state.contentEquals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            read.setText("true");
            write.setText("false");
            canR = true;
            canW = false;
        } else{
            read.setText("false");
            write.setText("false");
            canW = canR = false;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int positive = spin.getSelectedItemPosition();
        switch (positive){
            case 0: path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
                break;
            case 1: path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                break;
            case 2: path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bDoneItem:
                save.setVisibility(View.VISIBLE);
                break;
            case R.id.bSaveItem:
                String st = saveFile.getText().toString();
                filename = new File(path,st);
                checkState();
                if(canW == canR ==true){
                    path.mkdirs();

                    try {
                        InputStream is = getResources().openRawResource(R.drawable.mt);
                        OutputStream os = new FileOutputStream(filename);
                        byte [] data = new byte[is.available()];
                        is.read(data);
                        os.write(data);
                        is.close();
                        os.close();
                        Toast t = Toast.makeText(ExternalData.this,"File has been saved",Toast.LENGTH_LONG);
                        t.show();
                        // Media scanner
                        MediaScannerConnection.scanFile(ExternalData.this, new String[]{filename.toString()}, null,
                                new MediaScannerConnection.OnScanCompletedListener() {
                                    @Override
                                    public void onScanCompleted(String path, Uri uri) {
                                        Toast t = Toast.makeText(ExternalData.this,"Scan Complete",Toast.LENGTH_LONG);
                                        t.show();
                                    }
                                }
                        );

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

        }

    }
}
