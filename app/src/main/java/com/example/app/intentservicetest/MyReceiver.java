package com.example.app.intentservicetest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by jiangzehui on 18/2/27.
 */

public class MyReceiver extends BroadcastReceiver {

    CallBack callBack;

    public MyReceiver(CallBack back) {
        callBack = back;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        int progress = intent.getIntExtra("progress", 0);
        callBack.updateUi(progress);
    }


    public interface CallBack {
        void updateUi(int progress);
    }
}
