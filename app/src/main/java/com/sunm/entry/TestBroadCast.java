package com.sunm.entry;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.sunm.bolts.R;
import com.sunm.bolts.ThirdActivity;

/**
 * Created by Administrator on 2017/9/25.
 */

public class TestBroadCast extends BroadcastReceiver {
    private static final String TAG = "TestBroadCast";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "receive " + intent.getAction());


        Intent actIntent = new Intent(context, ThirdActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,
                1023, actIntent, PendingIntent.FLAG_ONE_SHOT);

        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle("Title").setContentText("Receive BroadCast");
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        Notification notification = builder.build();
        NotificationManager manager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(12, notification);
    }
}
