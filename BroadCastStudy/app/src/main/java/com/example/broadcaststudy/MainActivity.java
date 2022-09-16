package com.example.broadcaststudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private IntentFilter intentFilter;
    private TestReceiver testReceiver;
    private Button btnBroadCastDynamic;
    private Button btnBroadCastStatic;
    private Button btnBroadCastOrder;
    private Button btnBroadCastLocal;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBroadCast();
        initView();
    }

    private void initBroadCast(){
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.test.study");
        testReceiver = new TestReceiver();
        registerReceiver(testReceiver,intentFilter);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction("android.test.local");
        LocalReceiver localReceiver = new LocalReceiver();
        registerReceiver(localReceiver,intentFilter1);
    }

    private void initView(){
        btnBroadCastDynamic = findViewById(R.id.broadcast_dynamic);
        btnBroadCastStatic = findViewById(R.id.broadcast_static);
        btnBroadCastOrder = findViewById(R.id.broadcast_order);
        btnBroadCastLocal = findViewById(R.id.broadcast_local);

        btnBroadCastDynamic.setOnClickListener(this);
        btnBroadCastStatic.setOnClickListener(this);
        btnBroadCastOrder.setOnClickListener(this);
        btnBroadCastLocal.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.broadcast_dynamic:
                Intent intentDynamic = new Intent("android.test.study");
                sendBroadcast(intentDynamic);
                break;
            case R.id.broadcast_static:
                Intent intentStatic = new Intent("android.intent.action.static");
                intentStatic.setPackage(getPackageName());
                sendBroadcast(intentStatic);
                break;
            case R.id.broadcast_order:
                Intent intentOrder = new Intent("android.intent.action.static");
                intentOrder.setPackage(getPackageName());
                sendOrderedBroadcast(intentOrder,null);
                break;
            case R.id.broadcast_local:
                Intent intentLocal = new Intent("android.test.local");
                intentLocal.setPackage(getPackageName());
                sendBroadcast(intentLocal);
                break;
            default:
        }
    }

    //内部类
   class TestReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "广播001", Toast.LENGTH_SHORT).show();
        }
    }

    class LocalReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "本地广播", Toast.LENGTH_SHORT).show();
        }
    }


}