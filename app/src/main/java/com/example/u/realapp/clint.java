package com.example.u.realapp;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by U on 10/28/2016.
 */
public class clint extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView v, String url) {
        v.loadUrl(url);
        return true;
    }
}
