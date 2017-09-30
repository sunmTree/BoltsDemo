package com.sunm.model.observer;

import android.text.TextUtils;
import android.util.Log;

import com.sunm.AppConfig;

import javax.crypto.spec.DESedeKeySpec;

/**
 * Created by Administrator on 2017/9/30.
 */

public class ConcreteAllyControllerCenter extends AllyControllerCenter {
    @Override
    public void notifyObserver(String message) {
        if (AppConfig.DEBUG) {
            Log.d("AllyControllerCenter", message + "受到攻击正在请求支援");
        }
        for (Observer ob: players) {
            if (!TextUtils.equals(ob.getName(), message)) {
                ob.help();
            }
        }
    }
}
