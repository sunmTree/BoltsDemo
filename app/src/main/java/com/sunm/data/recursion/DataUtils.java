package com.sunm.data.recursion;

import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/10/7.
 */

public class DataUtils {

    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "DataUtils";

    public int triangle(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + triangle(n-1);
        }
    }

    public void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1) {
            if (DEBUG) {
                Log.d(TAG, "Disk 1 from " + from + " to " + to);
            }
        } else {
            doTowers(topN - 1, from, to, inter);

            if (DEBUG) {
                Log.d(TAG, "Disk " + topN + " from " + from + " to " + to);
            }

            doTowers(topN - 1, inter, from, to);
        }
    }

    
}
