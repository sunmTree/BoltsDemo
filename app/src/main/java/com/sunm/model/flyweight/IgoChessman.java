package com.sunm.model.flyweight;

import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/29.
 */

public abstract class IgoChessman {
    public static final boolean DEBUG = AppConfig.DEBUG;
    public static final String TAG = "IgoChessman";

    public abstract String getColor();

    public void display(Coordinates coor) {
        if (DEBUG) {
            Log.d(TAG, "chessman color " + getColor() + " Coordinates "
                    + coor.toString());
        }
    }
}
