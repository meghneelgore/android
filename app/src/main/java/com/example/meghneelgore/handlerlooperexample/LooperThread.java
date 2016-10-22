package com.example.meghneelgore.handlerlooperexample;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by meghneel.gore on 10/22/16.
 */
public class LooperThread extends Thread {
    public Handler mHandler;

    public void run() {
        Looper.prepare();
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                System.out.println(msg.what);
            }
        };
        Looper.loop();
        System.out.println("Looper quit");
    }
}
