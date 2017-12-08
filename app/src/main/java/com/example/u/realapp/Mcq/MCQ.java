package com.example.u.realapp.Mcq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.u.realapp.R;

/**
 * Created by U on 10/27/2016.
 */
public class MCQ extends Activity {
    EditText question,optionA,optionB,optionC;
    Button buttonToCreateMCQ;
    TextView tvt;
    String jam,butter1,butter2,butter3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcq);
        initializing();
    }

    public void onLClick(View a){
        jam   =   question.getText().toString();
        butter1 = optionA.getText().toString();
        butter2 = optionB.getText().toString();
        butter3 = optionC.getText().toString();
        Bundle bread = new Bundle();
        bread.putString("keyQ",jam);
        bread.putString("keyO1",butter1);
        bread.putString("keyO2",butter2);
        bread.putString("keyO3", butter3);
        Intent mi = new Intent(MCQ.this,createdMCQ.class);
        mi.putExtras(bread);
        startActivity(mi);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bundle bun = data.getExtras();
            String fs = bun.getString("ke");
            tvt.setText(fs);
        }
    }

    private void initializing(){
        question = (EditText)findViewById(R.id.etQ);
        optionA = (EditText) findViewById(R.id.et1);
        optionB = (EditText) findViewById(R.id.et2);
        optionC = (EditText) findViewById(R.id.et3);
        buttonToCreateMCQ = (Button)findViewById(R.id.bMCQ);
        tvt = (TextView)findViewById(R.id.tvans);

    }
}

