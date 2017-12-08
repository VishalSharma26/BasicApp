package com.example.u.realapp.SQLiteDatabase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.u.realapp.R;

import java.sql.SQLDataException;

/**
 * Created by U on 10/29/2016.
 */
public class SQLView extends Activity implements View.OnClickListener{
    TextView tv;
    Button bt;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sql_view);
        bt = (Button)findViewById(R.id.uploadId);
        tv = (TextView)findViewById(R.id.textViewId);
        Database info = new Database(this);
        try {
            info.open();
             data = info.getData();
            info.close();
            tv.setText(data);
        } catch (SQLDataException e) {
            e.printStackTrace();
        }
        bt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("plain/text");
        i.putExtra(Intent.EXTRA_SUBJECT, "My Record");
        i.putExtra(Intent.EXTRA_TEXT,data);
        startActivity(i);

    }
}
