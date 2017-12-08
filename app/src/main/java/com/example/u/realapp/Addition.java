package com.example.u.realapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Addition extends AppCompatActivity {
    int count =0;
    Button add,sub;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addition);
        add = (Button)findViewById(R.id.bAdd);
        sub = (Button)findViewById(R.id.bsub);
        result = (TextView)findViewById(R.id.tvResult);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                result.setText("Total is  "+count);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                result.setText("Total is  "+count);
            }
        });
    }
}
