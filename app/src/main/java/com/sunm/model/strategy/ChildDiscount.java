package com.sunm.model.strategy;

import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/30.
 */

public class ChildDiscount implements Discount {
    @Override
    public double calculate(double price) {
        if (AppConfig.DEBUG) {
            Log.d("Discount", "儿童票");
        }
        return price - 10;
    }
}
