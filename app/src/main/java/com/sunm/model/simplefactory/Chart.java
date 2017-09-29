package com.sunm.model.simplefactory;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * 职责过重，包括所有图表的创建和展示
 * 大量的if else 使得代码阅读，维护，测试变得困难，而且影响性能
 * 需要有新的类增加时需要修改代码，违背了开闭原则
 * 当chart需要开始设置颜色，宽度，数据，等参数时没有默认值容易出错
 */

public class Chart {

    // 柱状图
    public static final String TYPE_HISTOGRAM_CHART = "histogram";
    // 饼状图
    public static final String TYPE_PIE_CHART = "pie";
    // 折现图
    public static final String TYPE_LINE_CHART = "line";

    private String mType;
    private Context mContext;

    public Chart(Context context, String type) {
        this.mType = type;
        this.mContext = context;
        if (TextUtils.equals(type, TYPE_HISTOGRAM_CHART)) {
            // 初始化柱状图
        } else if (TextUtils.equals(type, TYPE_PIE_CHART)) {
            // 初始化饼状图
        } else if (TextUtils.equals(type, TYPE_LINE_CHART)) {
            // 初始化折线图
        }
    }

    public void display() {
        String message = null;
        if (TextUtils.equals(mType, TYPE_HISTOGRAM_CHART)) {
            // 初始化柱状图
            message = "柱状图";
        } else if (TextUtils.equals(mType, TYPE_PIE_CHART)) {
            // 初始化饼状图
            message = "饼状图";
        } else if (TextUtils.equals(mType, TYPE_LINE_CHART)) {
            // 初始化折线图
            message = "折线图";
        }

        if (! TextUtils.isEmpty(message)) {
            String toastStr = "用户使用了%s来显示数据";
            String format = String.format(toastStr, message);
            Toast.makeText(mContext, format, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "未设置图标", Toast.LENGTH_SHORT).show();
        }
    }
}
