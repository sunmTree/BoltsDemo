package com.sunm.data.link;

import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/10/7.
 */

public class Link {

    public int data;
    public double d;
    public Link next = null;

    public Link(int data, double d) {
        this.data = data;
        this.d = d;
    }

    public void displayLink() {
        if (AppConfig.DEBUG) {
            Log.d("Link", "data " + data + " double " + d);
        }
    }
}
