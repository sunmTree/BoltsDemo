package com.sunm.model.bridge;

import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/29.
 */

public class Matrix {

    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "Matrix";

    public void transform(String type) {
        if (DEBUG) {
            Log.d(TAG, "transform " + type);
        }
    }

    public void show(String type) {
        if (DEBUG) {
            Log.d(TAG, "show " + type);
        }
    }

}
