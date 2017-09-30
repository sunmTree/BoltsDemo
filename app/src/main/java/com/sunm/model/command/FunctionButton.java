package com.sunm.model.command;

import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/30.
 */

public class FunctionButton {
    private String name;
    private Command command;

    public FunctionButton(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void onClick() {
        if (command != null) {
            command.execute();
        }

        if (AppConfig.DEBUG) {
            Log.d("FUNCTION", name + " 按钮被点击");
        }
    }
}
