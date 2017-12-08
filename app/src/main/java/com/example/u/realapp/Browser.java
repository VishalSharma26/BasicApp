package com.example.u.realapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import java.util.EmptyStackException;

/**
 * Created by U on 10/28/2016.
 */
public class Browser extends Activity implements View.OnClickListener{
    EditText text;
    Button b1,b2,b3,b4,b5;
    WebView browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser);
        init();
        browser = (WebView)findViewById(R.id.wbId);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setLoadWithOverviewMode(true);
        browser.getSettings().setUseWideViewPort(true);
        browser.setWebViewClient(new clint());
        try {
            browser.loadUrl("http://www.google.com");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void init() {
        text = (EditText)findViewById(R.id.etHttp);
        b1 = (Button)findViewById(R.id.bGo);
        b2 = (Button)findViewById(R.id.bGB);
        b3 = (Button)findViewById(R.id.bGF);
        b4 = (Button)findViewById(R.id.bRP);
        b5 = (Button)findViewById(R.id.bCH);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bGo:
                String website = text.getText().toString();
                browser.loadUrl(website);
                break;
            case R.id.bGB:
                if(browser.canGoBack())
                    browser.goBack();
                break;
            case R.id.bGF:
                if(browser.canGoForward())
                    browser.goForward();
                break;
            case R.id.bRP:
                browser.reload();
                break;
            case R.id.bCH:
                browser.clearHistory();
                break;
        }

    }
}
