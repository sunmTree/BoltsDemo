package com.sunm.data.link;

import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/10/7.
 */

public class LinkInfo {
    public long dData;
    public LinkInfo next;
    public LinkInfo previous;

    public LinkInfo(long dData) {
        this.dData = dData;
    }

    public void displayLink() {
        if (AppConfig.DEBUG) {
            Log.d("LinkInfo", "dData [ " + dData + " ]");
        }
    }
}
