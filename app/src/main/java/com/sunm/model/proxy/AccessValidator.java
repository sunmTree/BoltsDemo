package com.sunm.model.proxy;

import android.text.TextUtils;
import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/30.
 */

public class AccessValidator {
    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "AccessValidator";

    public boolean validator(String userId) {
        if (DEBUG) {
            Log.d(TAG, "validator userId accessibility");
        }

        if (TextUtils.equals("Sunny", userId)) {
            if (DEBUG) {
                Log.i(TAG, "access");
            }
            return true;
        }
        return false;
    }
}
