package com.example.broadcastreceiverdemo;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String mess = "";
        if (Intent.ACTION_BATTERY_LOW.equals(intent.getAction())) {
            mess = "Pin yếu! Đề nghị sạc đầy pin!";
        } else if (intent.getAction() == MainActivity.MY_CUSTOM_BROADCAST) {
            mess = intent.getStringExtra("data");
        }
        AlertDialog d = new AlertDialog.Builder(context).setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Thông báo!")
                .setMessage(mess)
                .create();
        d.show();
    }
}