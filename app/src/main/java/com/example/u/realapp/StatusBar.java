package com.example.u.realapp;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by U on 10/30/2016.
 */
public class StatusBar extends Activity implements View.OnClickListener {
    Button bt;
    NotificationManager nm;
    final static int unique = 125489;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_bar);
        bt = (Button)findViewById(R.id.bNotification);
        bt.setOnClickListener(this);
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, StatusBar.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
        String body = "Season 7 of  Game of throns is comming";
        String Title = "Winter is Comming";
        Notification nf = new Notification(R.drawable.life,body,System.currentTimeMillis());

        nf.defaults = Notification.DEFAULT_ALL;

    }
}
