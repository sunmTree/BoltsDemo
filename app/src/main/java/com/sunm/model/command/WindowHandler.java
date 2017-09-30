package com.sunm.model.command;

import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/30.
 */

public class WindowHandler {
    public void minimize() {
        if (AppConfig.DEBUG) {
            Log.d("WindowHandler", "最小化到托盘");
        }
    }
}
