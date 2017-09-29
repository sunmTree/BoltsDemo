package com.sunm.bolts;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sunm.entry.TestBroadCast;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.e(TAG, "SecondActivity onCreate");
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "start send broad cast");
                Intent intent = new Intent(getApplicationContext(), TestBroadCast.class);
                getApplicationContext().sendBroadcast(intent);
            }
        }, 2000);

    }
}
