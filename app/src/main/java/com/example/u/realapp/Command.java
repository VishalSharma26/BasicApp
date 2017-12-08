package com.example.u.realapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

/**
 * Created by U on 10/26/2016.
 */
public class Command extends Activity {
    TextView tv,valid;
    Button bt;
    ToggleButton tb;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.command);
        inilialization();
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tb.isChecked()) {
                    et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    et.setInputType(InputType.TYPE_CLASS_TEXT);
                }
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String command = et.getText().toString();
                if(command.contentEquals("red") || command.contentEquals("01")){
                    tv.setTextColor(Color.RED);
                    valid.setText("valid");
                    valid.setTextColor(Color.rgb(11, 245, 105));
                } else if(command.contentEquals("blue") || command.contentEquals("02")){
                    tv.setTextColor(Color.BLUE);
                    valid.setText("valid");
                    valid.setTextColor(Color.rgb(11, 245, 105));
                } else if(command.contentEquals("green") || command.contentEquals("03")){
                    tv.setTextColor(Color.GREEN);
                    valid.setText("valid");
                    valid.setTextColor(Color.rgb(11, 245, 105));
                } else if(command.contentEquals("left") || command.contentEquals("04")){
                    tv.setGravity(Gravity.LEFT);
                    valid.setText("valid");
                    valid.setTextColor(Color.rgb(11, 245, 105));
                } else if(command.contentEquals("center") || command.contentEquals("05")){
                    tv.setGravity(Gravity.CENTER);
                    valid.setText("valid");
                    valid.setTextColor(Color.rgb(11, 245, 105));
                } else if(command.contentEquals("right") || command.contentEquals("06")){
                    tv.setGravity(Gravity.RIGHT);
                    valid.setText("valid");
                    valid.setTextColor(Color.rgb(11, 245, 105));
                } else if(command.contentEquals("random") || command.contentEquals("07")){
                    Random c = new Random();
                    tv.setTextColor(Color.rgb(c.nextInt(256),c.nextInt(256),c.nextInt(256)));
                    tv.setTextSize(c.nextInt(75));
                    valid.setText("valid");
                    valid.setTextColor(Color.rgb(11, 245, 105));
                } else {
                    tv.setText(et.getText().toString());
                    valid.setText("Invalid command!!");
                    valid.setTextColor(Color.rgb(244, 56, 78));

                }

            }
        });
    }

    private void inilialization() {
        tv = (TextView) findViewById(R.id.tvCommand);
        bt = (Button)findViewById(R.id.bCommand);
        tb = (ToggleButton)findViewById(R.id.tbCommand);
        et = (EditText)findViewById(R.id.etCommand);
        valid = (TextView)findViewById(R.id.tvValid);
    }

}
