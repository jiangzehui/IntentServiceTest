package com.example.app.intentservicetest;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ProgressBar pb;
    MyReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        pb = (ProgressBar) findViewById(R.id.pb);
        pb.setMax(100);
        pb.setProgress(0);
        receiver = new MyReceiver(callBack);
        IntentFilter filter = new IntentFilter();
        filter.addAction("pro");
        registerReceiver(receiver,filter);
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }


    public MyReceiver.CallBack callBack = new MyReceiver.CallBack() {
        @Override
        public void updateUi(int progress) {
            tv.setText(progress + "%");
            pb.setProgress(progress);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
