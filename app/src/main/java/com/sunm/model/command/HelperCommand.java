package com.sunm.model.command;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/30.
 */

public class HelperCommand extends Command {

    private HelpHandler mHandler;

    public HelperCommand() {
        mHandler = new HelpHandler();
    }

    @Override
    public void execute() {
        if (DEBUG) {
            Log.d(TAG, "帮助文档显示命令被调用");
        }
        mHandler.display();
    }
}
