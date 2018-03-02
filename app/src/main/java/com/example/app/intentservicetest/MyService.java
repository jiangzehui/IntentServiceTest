package com.example.app.intentservicetest;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jiangzehui on 18/2/27.
 */

public class MyService extends IntentService {


    String TAG = "MyService";
    Intent intent2;
    public MyService() {
        super("MyService");
        Log.d(TAG, "MyService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        intent2 = new Intent();
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d(TAG, "onStart");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent");
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(100);
                intent2.putExtra("progress",i);
                intent2.setAction("pro");
                sendBroadcast(intent2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("i=", i + "");

        }
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
