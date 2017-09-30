package com.sunm.model.observer;

import android.util.Log;

import com.sunm.AppConfig;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/30.
 */

public abstract class AllyControllerCenter {
    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "AllyControllerCenter";

    protected String allyName;
    protected ArrayList<Observer> players = new ArrayList<>();

    public void setAllyName(String name) {
        this.allyName = name;
    }

    public void join(Observer observer) {
        if (DEBUG) {
            Log.d(TAG, "observer " + observer.getName() + " 加入" + allyName + "战队");
        }
        players.add(observer);
    }

    public void quit(Observer observer) {
        if (DEBUG) {
            Log.d(TAG, "Observer " + observer.getName() + " 退出" + allyName + "战队");
        }
        players.remove(observer);
    }

    public abstract void notifyObserver(String message);
}
