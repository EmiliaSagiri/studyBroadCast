package com.example.broadcaststudy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class StaticBroadCast extends BroadcastReceiver {
    public static final String TAG = StaticBroadCast.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "StaticBroadCast 接收成功", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onReceive:  静态");
    }
}
