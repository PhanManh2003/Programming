package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.text.SimpleDateFormat;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService_LOG", "onStartCommand");
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {

        return new MyBinder();
    }

    public class MyBinder extends Binder {
        public MyService getCurrentService() {
            return MyService.this;
        }
    }

    public String getCurrentTime() {
        long t = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy hh:mm:ss");
        return sdf.format(t);
    }

}