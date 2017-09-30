package com.sunm.model.command;

import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/30.
 */

public class HelpHandler {
    public void display() {
        if (AppConfig.DEBUG) {
            Log.d("HELP_HANDLER", "显示帮助文档");
        }
    }
}
