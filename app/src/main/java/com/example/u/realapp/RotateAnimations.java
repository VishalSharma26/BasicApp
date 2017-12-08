package com.example.u.realapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by U on 6/3/2017.
 */

public class RotateAnimations extends AppCompatActivity {
    ImageView imageView;
    int position = 0,finalPosition=0;
    Random r;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rotate_animation);
        imageView = (ImageView)findViewById(R.id.bottle_id);
        r = new Random();

    }

    public void onImageClick(View view) {

        position = finalPosition%360;
        finalPosition = r.nextInt(5000)+360;
        RotateAnimation rotateAnimation = new RotateAnimation(position,finalPosition,RotateAnimation.RELATIVE_TO_SELF,0.5f,
                RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(3000);
        rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

        imageView.startAnimation(rotateAnimation);
    }
}
