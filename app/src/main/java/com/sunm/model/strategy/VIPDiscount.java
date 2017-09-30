package com.sunm.model.strategy;

import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/30.
 */

public class VIPDiscount implements Discount {
    @Override
    public double calculate(double price) {
        if (AppConfig.DEBUG) {
            Log.d("Discount", "会员票");
            Log.d("Discount", "增加积分");
        }
        return price * 0.5;
    }
}
