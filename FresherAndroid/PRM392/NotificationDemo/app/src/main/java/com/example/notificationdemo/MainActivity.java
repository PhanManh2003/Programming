package com.example.notificationdemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String CHANNEL_ID_1 = "first_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle b = RemoteInput.getResultsFromIntent(getIntent());
        if (b != null) {
            String s = b.getString("my_message");
            ((TextView) findViewById(R.id.textView)).setText(s);
        }
    }

    public void onPushNotification(View view) {
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID_1, "First Channel",
                NotificationManager.IMPORTANCE_HIGH);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);


        Intent i = new Intent(this, MainActivity.class);
        PendingIntent pd = PendingIntent.getActivity(this, 100, i,
                PendingIntent.FLAG_MUTABLE);

        RemoteInput rm = new RemoteInput.Builder("my_message")
                .setLabel("Input your message").build();

        NotificationCompat.Action action = new NotificationCompat.Action.
                Builder(android.R.drawable.ic_dialog_info,
                "Click", pd).addRemoteInput(rm).build();


        Notification n = new NotificationCompat.Builder(this, CHANNEL_ID_1)
                .setContentTitle("thông báo").setSmallIcon(R.mipmap.ic_launcher)
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentText("Bạn vừa nhận 1vtb")
                .addAction(action)
                .setContentIntent(pd)
                .build();
        manager.notify(1, n);
    }
}