package com.sunm.data.sort;

import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/10/8.
 */

public class ArraySh {
    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "ArraySh";

    private long[] theArray;
    private int nElems;

    public ArraySh(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {
        if (DEBUG) {
            StringBuilder sBuilder = new StringBuilder();
            for (int j = 0; j < theArray.length; j++) {
                sBuilder.append(" " + theArray[j]);
            }
            Log.d(TAG, "theArray result [ " + sBuilder.toString() + " ]");
        }
    }

    public void shellSort() {
        int inner, outer;
        long temp;

        int h = 1;
        while (h <= nElems / 3) {
            h = h * 3 + 1;
        }
        if (DEBUG) {
            Log.d(TAG, "final h [ " + h + " ]");
        }
        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = theArray[outer];
                inner = outer;

                while (inner > h - 1 && theArray[inner - h] >= temp) {
                    theArray[inner] = theArray[inner - h];
                    inner -= h;
                }

                theArray[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }
}
