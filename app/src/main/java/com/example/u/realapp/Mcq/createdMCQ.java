package com.example.u.realapp.Mcq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.u.realapp.R;

/**
 * Created by U on 10/27/2016.
 */
public class createdMCQ extends Activity implements RadioGroup.OnCheckedChangeListener {

    TextView questionPrinted,wid10;
    RadioButton r1,r2,r3;
    RadioGroup rg;
    Button rgdoneButton;
    Bundle getBread;
    String getb1,getb2,getb3,getq,ss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.created_mcq);
        variablesDecleared();
        getBread = getIntent().getExtras();
        getb1 = getBread.getString("keyO1");
        getb2 = getBread.getString("keyO2");
        getb3 = getBread.getString("keyO3");
        getq = getBread.getString("keyQ");

        questionPrinted.setText(getq);
        r1.setText(getb1);
        r2.setText(getb2);
        r3.setText(getb3);

    }


    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rgid1 :
                ss = "You have selected option  ' "+getb1 + " '";
                break;
            case R.id.rgid2 :
                ss = "You have selected option  ' "+getb2 + " '";
                break;
            case R.id.rgid3 :
                ss = "You have selected option  ' "+getb3 + " '";
                break;
        }
        wid10.setText(ss);
    }



    private void variablesDecleared() {
        questionPrinted = (TextView)findViewById(R.id.textView11);
        r1 = (RadioButton)findViewById(R.id.rgid1);
        r2 = (RadioButton)findViewById(R.id.rgid2);
        r3 = (RadioButton)findViewById(R.id.rgid3);
        rg = (RadioGroup)findViewById(R.id.rgid);
        wid10 = (TextView)findViewById(R.id.id10);
        rgdoneButton = (Button)findViewById(R.id.bmcqid);
        rg.setOnCheckedChangeListener(this);

        rgdoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im = new Intent();
                getBread.putString("ke",ss);
                im.putExtras(getBread);
                setResult(RESULT_OK, im);
                finish();
            }
        });
    }

}
