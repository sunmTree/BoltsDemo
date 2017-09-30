package com.sunm.model.command;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/30.
 */

public class WindowCommand extends Command {

    private WindowHandler mHandler;

    public WindowCommand() {
        mHandler = new WindowHandler();
    }

    @Override
    public void execute() {
        if (DEBUG) {
            Log.d(TAG, " 最小化到托盘");
        }
        mHandler.minimize();
    }
}
