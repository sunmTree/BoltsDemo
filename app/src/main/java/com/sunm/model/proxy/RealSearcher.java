package com.sunm.model.proxy;

import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/30.
 */

public class RealSearcher implements Searcher {
    @Override
    public String doSearch(String userId, String keyword) {
        if (AppConfig.DEBUG) {
            Log.d("RealSearch", "userId " + userId + " keyword " + keyword);
        }
        return "具体内容";
    }
}
