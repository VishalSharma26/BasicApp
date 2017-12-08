package com.example.u.realapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * Created by U on 12/1/2016.
 */
public class  HttpExample extends Activity {
    TextView httpTv;
    HttpURLConnection connection;
    BufferedReader reader;
    EditText et;
    String web = "virzion";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.http_example);
        httpTv = (TextView)findViewById(R.id.tvHttp1);
        et = (EditText)findViewById(R.id.editTextHttp);
        web = et.getText().toString();
        Button bt = (Button)findViewById(R.id.btHttp);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                httpTv.setText("Loading Data...");
                new JSONTask().execute("https://www.google.co.in/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q="+web);
            }
        });
    }

    public class JSONTask extends AsyncTask<String , String , String> {


        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                } else if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            httpTv.setText(result);
        }
    }
}
