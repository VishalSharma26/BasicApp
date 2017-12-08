package com.example.u.realapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

/**
 * Created by U on 10/28/2016.
 */
public class Flipper extends Activity implements View.OnClickListener {
    ViewFlipper flip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flipper);
        flip = (ViewFlipper)findViewById(R.id.viewFlipperId);
        flip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        flip.showNext();
    }
}
