package com.example.u.realapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by U on 6/5/2017.
 */

public class JSONLoadFromServer extends AppCompatActivity{
    TextView httpTv;
    HttpURLConnection connection;
    BufferedReader reader;
    TextView tv;
    ProgressDialog pd;
    String Result;
    String quest,ans1,ans2,ans3,ans4,ans,print;
    Boolean Load = false;
    ArrayList<String> mylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_load);
        tv = (TextView)findViewById(R.id.tvJson);
        mylist = new ArrayList<String>();
        pd = new ProgressDialog(this);

    }

    public class ActorsAsyncTask extends AsyncTask<String,Void,Boolean>{


        @Override
        protected Boolean doInBackground(String... params) {
            try {
                HttpClient client = new DefaultHttpClient();
                HttpPost post = new HttpPost(params[0]);
                HttpResponse response = client.execute(post);
                int status = response.getStatusLine().getStatusCode();

                if(status == 200){    //  2xx ==> success

                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);

                    try {
                        JSONObject obj = new JSONObject(data);
                        JSONArray quiz = obj.getJSONArray("quiz");

                        for (int i =0;i<quiz.length();i++) {

                            JSONObject jRealObjext = quiz.getJSONObject(i);

                            quest = (jRealObjext.getString("question"));
                            ans1 = (jRealObjext.getString("optionA"));
                            ans2 = (jRealObjext.getString("optionB"));
                            ans3 = (jRealObjext.getString("optionC"));
                            ans4 =(jRealObjext.getString("optionD"));
                            ans = (jRealObjext.getString("answer"));

                            print = quest+ "\n(A)  " + ans1 + "\n(B)  " + ans2 + "\n(C)  " + ans3 + "\n(D)  " + ans4
                                    + "\n(Answer) :  " +ans + "\n\n";

                            mylist.add(print);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return true;
                }
            } catch (ClientProtocolException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            pd.dismiss();
            if(aBoolean == false){
                // data was not paarsed
                Toast.makeText(JSONLoadFromServer.this, "Something went wrong!!", Toast.LENGTH_SHORT).show();
            } else{
                Random r1 = new Random();
                Integer j = r1.nextInt(mylist.size());
                tv.setText(mylist.get(j));
            }


        }
    }

    public void onJsonLoadClick(View view) {
        if(!Load) {
            pd.setMessage("Loading Question...");
            pd.show();
            Load = true;
            new ActorsAsyncTask().execute("https://vishal26developer.000webhostapp.com/puberty_JSON.txt");
        }else {
            Random r1 = new Random();
            Integer j = r1.nextInt(mylist.size());
            tv.setText(mylist.get(j));
        }
    }

}
