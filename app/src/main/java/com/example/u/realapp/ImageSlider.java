package com.example.u.realapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by U on 5/4/2017.
 */

public class ImageSlider extends AppCompatActivity{
    ViewPager viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_slider);

        viewPager = (ViewPager)findViewById(R.id.viewPagerImage);

        ImageSliderAdapter imageSliderAdapter = new ImageSliderAdapter(this);
        viewPager.setAdapter(imageSliderAdapter);
    }
}

