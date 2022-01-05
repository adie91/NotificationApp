package com.fittnesss.notification;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button notify;
EditText e;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint(value = "ObsoleteSdkInt")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notify = findViewById(R.id.button);
        e= (EditText) findViewById(R.id.editText);
        if(VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("MY Notification","MY Notification",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        notify.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(MainActivity.this,"MY Notification");
                mbuilder.setContentText(e.getText().toString());
                mbuilder.setSmallIcon(R.drawable.ic_launcher_background);
                mbuilder.setAutoCancel(true);
                NotificationManagerCompat managerCompat= NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1,mbuilder.build());
            }
        });

    }
}