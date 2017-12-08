package com.example.u.realapp.Swipe;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.u.realapp.R;

/**
 * Created by U on 5/2/2017.
 */

public class Swipe extends FragmentActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe);
        viewPager = (ViewPager)findViewById(R.id.ViewPagerId);
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdapter);

    }
}
