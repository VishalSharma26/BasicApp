package com.example.u.realapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by U on 10/27/2016.
 */
public class Camera extends Activity implements View.OnClickListener {

    final static int cameraData = 0;
    Intent i;
    ImageView iv;
    ImageButton ib;
    Button setwallpaper;
    Bitmap bm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        iv = (ImageView) findViewById(R.id.imv);
        ib = (ImageButton) findViewById(R.id.imb);
        setwallpaper = (Button)findViewById(R.id.swid);
        ib.setOnClickListener(this);
        setwallpaper.setOnClickListener(this);
        InputStream is = getResources().openRawResource(R.raw.flash);
        bm = BitmapFactory.decodeStream(is);

    }

    public void onClick(View a) {
        switch (a.getId()) {
            case R.id.imb:
                i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, cameraData);
                break;
            case R.id.swid:
                try {
                    getApplicationContext().setWallpaper(bm);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    @Override
    protected void onActivityResult(int resquestCode, int resultCode ,Intent data){
        super.onActivityResult(resquestCode,resultCode,data);
        if(resultCode == RESULT_OK){

            Bundle pic = data.getExtras();
            bm = (Bitmap)pic.get("data");
            iv.setImageBitmap(bm);
        }


    }

}
