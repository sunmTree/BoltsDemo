package com.sunm.data.tree;

import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/10/8.
 */

public class Node {
    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "Node";
    public int iData;
    public double dData;
    public Node leftNode;
    public Node rightNode;

    public void displayNode() {
        if (DEBUG) {
            Log.d(TAG, "{ " + iData + " , " + dData + " }");
        }
    }
}
