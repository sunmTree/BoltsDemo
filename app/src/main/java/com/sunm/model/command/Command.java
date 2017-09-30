package com.sunm.model.command;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/30.
 */

public abstract class Command {
    public static final boolean DEBUG = AppConfig.DEBUG;
    public static final String TAG = "Command";

    public abstract void execute();
}
