package com.sunm.model.observer;

import android.util.Log;

import com.sunm.AppConfig;

import javax.crypto.spec.DESedeKeySpec;

/**
 * Created by Administrator on 2017/9/30.
 */

public class Player implements Observer {
    private String name;
    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "Player";

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void help() {
        if (DEBUG) {
            Log.d(TAG, " Holder On " + name + " is coming");
        }
    }

    @Override
    public void beAttacked(AllyControllerCenter acc) {
        if (DEBUG) {
            Log.d(TAG, " Help Help Help!");
        }
        acc.notifyObserver(name);
    }
}
