package com.example.u.realapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by U on 6/4/2017.
 */

public class JSONLoad extends AppCompatActivity {
    TextView tv;
    String quest,ans1,ans2,ans3,ans4,ans,print;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_load);
        tv = (TextView)findViewById(R.id.tvJson);

    }



    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("puberty_JSON.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    public void onJsonLoadClick(View view) {
        ArrayList<String> mylist = new ArrayList<String>();
        String json_return_by_the_function = loadJSONFromAsset();
        Random random = new Random();

        try {
            JSONObject obj = new JSONObject(json_return_by_the_function);
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
        Random r1 = new Random();
        Integer j = r1.nextInt(mylist.size());
        tv.setText(mylist.get(j));
    }

}
