package com.sunm.operation;

import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/10/1.
 */

public class OperationDemo {

    private static final String TAG = "Operation";
    private static final boolean DEBUG = AppConfig.DEBUG;

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void operation() {
        int a = 1 << 3; // 8
        int b = 1 << 4; // 16
        int c = 1 << 30;
        int d = roundUpToPowerOf2(102);
        int e = roundUpToPowerOf2(7);
        int f = roundUpToPowerOf2(9);
        int g = roundUpToPowerOf2(127);
        if (DEBUG) {
            Log.d(TAG, "a " + a + " b " + b + " c " + c);
            Log.d(TAG, "d " + d + " e " + e + " f " + f + " g " + g);
        }
    }

    public static int highestOneBit(int i) {
        // HD, Figure 3-1
        i |= (i >>  1);
        i |= (i >>  2);
        i |= (i >>  4);
        i |= (i >>  8);
        i |= (i >> 16);
        return i - (i >>> 1);
    }

    public static int bitCount(int i) {
        // HD, Figure 5-2
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }

    private static int roundUpToPowerOf2(int number) {
        // assert number >= 0 : "number must be non-negative";
        int rounded = number >= MAXIMUM_CAPACITY
                ? MAXIMUM_CAPACITY
                : (rounded = Integer.highestOneBit(number)) != 0
                ? (Integer.bitCount(number) > 1) ? rounded << 1 : rounded
                : 1;

        return rounded;
    }
}
