package com.example.broadcaststudy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class OrderBroadCast extends BroadcastReceiver {
public static final String TAG = OrderBroadCast.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"有序广播接收",Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onReceive:  有序广播" );
        abortBroadcast();
    }
}
