package com.sunm.model.command;

import android.nfc.Tag;
import android.util.Log;

import com.sunm.AppConfig;

import java.util.ArrayList;

import javax.crypto.spec.DESedeKeySpec;

/**
 * Created by Administrator on 2017/9/30.
 */

public class FBSettingWindow {

    private String title; // 窗口标题
    private ArrayList<FunctionButton> functionButtons = new ArrayList<>();

    public FBSettingWindow(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addFunctionButton(FunctionButton button) {
        functionButtons.add(button);
    }

    public void removeFunctionButton(FunctionButton button) {
        functionButtons.remove(button);
    }

    public void display() {
        if (AppConfig.DEBUG) {
            Log.d("Window", " ---------------" + title + "-------------");
            for (FunctionButton button : functionButtons) {
                Log.d("Window", "FunctionButton " + button.getName());
            }
            Log.d("Window", "----------------end------------------");
        }
    }
}
