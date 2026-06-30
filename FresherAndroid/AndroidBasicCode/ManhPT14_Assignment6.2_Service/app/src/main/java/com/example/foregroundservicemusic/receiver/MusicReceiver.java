package com.example.foregroundservicemusic.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import androidx.core.app.NotificationManagerCompat;

import com.example.foregroundservicemusic.service.MusicService;

public class MusicReceiver extends BroadcastReceiver {
    // Action constants — dùng chung với MusicService
    public static final String ACTION_PREV  = "ACTION_PREV";
    public static final String ACTION_PAUSE = "ACTION_PAUSE";
    public static final String ACTION_NEXT  = "ACTION_NEXT";
    public static final String ACTION_CLOSE = "ACTION_CLOSE";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) return;

        // Tạo intent để gửi command đến MusicService
        Intent serviceIntent = new Intent(context, MusicService.class);

        switch (action) {
            case ACTION_PREV:
                // Gửi command prev đến service
                serviceIntent.putExtra("command", "prev");
                context.startService(serviceIntent);
                break;

            case ACTION_PAUSE:
                // Gửi command pause/resume đến service
                serviceIntent.putExtra("command", "toggle");
                context.startService(serviceIntent);
                break;

            case ACTION_NEXT:
                // Gửi command next đến service
                serviceIntent.putExtra("command", "next");
                context.startService(serviceIntent);
                break;

            case ACTION_CLOSE:
                // Dừng service và huỷ notification
                context.stopService(serviceIntent);
                NotificationManagerCompat.from(context)
                        .cancel(MusicService.NOTIF_ID);
                break;
        }
    }
}
