package com.example.rombolie.notifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID = 1256432;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }

    public void jellesButtonClicked(View view){
        notification.setSmallIcon(R.drawable.ic_stat_image_colorize);
        notification.setTicker("hello tech support?");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Potato Master");
        notification.setContentText("try tunring it of and on again");

        Intent intent = new Intent (this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0 ,intent ,PendingIntent.FLAG_UPDATE_CURRENT  );
        notification.setContentIntent(pendingIntent);

        //build notification
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());

    }
}
