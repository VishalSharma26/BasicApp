package com.example.u.realapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by U on 11/1/2016.
 */
public class Tabs extends Activity implements View.OnClickListener{
    TabHost th;
    Button bStart,bStop,bNewTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);
        bStart = (Button)findViewById(R.id.bStartTab);
        bStop = (Button)findViewById(R.id.bStopTab);
        bNewTab = (Button)findViewById(R.id.bCreateTab);
        bNewTab.setOnClickListener(this);
        bStart.setOnClickListener(this);
        bStop.setOnClickListener(this);
        th = (TabHost)findViewById(R.id.tabHost);
        th.setup();
        TabHost.TabSpec spec = th.newTabSpec("tag1");
        spec.setContent(R.id.tabA);
        spec.setIndicator("StopWatch");
        th.addTab(spec);

        spec = th.newTabSpec("tag2");
        spec.setContent(R.id.tabB);
        spec.setIndicator("Tab 2");
        th.addTab(spec);

        spec = th.newTabSpec("tag3");
        spec.setContent(R.id.tabC);
        spec.setIndicator("Add a Tab");
        th.addTab(spec);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bCreateTab:
                TabHost.TabSpec ourSpec = th.newTabSpec("Tag1");
                ourSpec.setContent(new TabHost.TabContentFactory(){

                    public View createTabContent(String tag){
                        TextView text = new TextView(Tabs.this);
                        text.setText("You have created a new tab!!");
                        return (text);
                    }
                });
                ourSpec.setIndicator("New");
                th.addTab(ourSpec);
                break;
            case R.id.bStartTab:
                break;
            case R.id.bStopTab:
                break;
        }
    }
}
