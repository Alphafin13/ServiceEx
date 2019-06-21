package com.example.serviceex;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;


public class MyIntentService extends IntentService {

    public MyIntentService()
    {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        String message = intent.getStringExtra("message");
        intent.setAction(IntentActivity.FILTER_ACTION_KEY);
        SystemClock.sleep(3000);
        String echoMessage = "IntentService after a pause of 3 seconds echoes " + message;
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent.putExtra("broadcastMessage", echoMessage));
    }
}
