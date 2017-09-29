package com.sunm.utils;

import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by Administrator on 2017/9/29.
 */

public class SortUtils {

    /**
     * 简单排序算法 int[] array = {3,9,0,1,4};
     */
    public static int[] sortArray(@NonNull int[] array) {
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            logArray("sortArray", array);
            for (int j = i + 1; j < array.length; j++) {
                int nextNum = array[j];
                if (num > nextNum) {
                    swap(array, i , j);
                }
            }
        }
        return array;
    }

    private static void logArray(String logName, int[] array) {
        StringBuffer sBuf = new StringBuffer();
        for (Integer i : array) {
            sBuf.append(" " + i);
        }
        Log.i(logName, sBuf.toString());
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
