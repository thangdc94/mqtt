package com.example.am.mqtt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String s = intent.getExtras().getString("message");
        Log.d("MyReceiver", s);
//        PushActivity.textView.setText(s);
    }
}
