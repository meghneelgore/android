package com.example.meghneelgore.handlerlooperexample;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    LooperThread mLooperThread;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLooperThread = new LooperThread();
        mLooperThread.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (mLooperThread.mHandler != null) {
                        System.out.println("Enqueueing " + count);
                        Message message = mLooperThread.mHandler.obtainMessage(count++);
                        mLooperThread.mHandler.dispatchMessage(message);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        mLooperThread.mHandler.getLooper().quit();
        super.onDestroy();
    }

    public void onClick(View v) {
        mLooperThread.mHandler.getLooper().quit();
    }
}
