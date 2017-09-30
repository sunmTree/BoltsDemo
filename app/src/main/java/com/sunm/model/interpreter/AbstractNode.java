package com.sunm.model.interpreter;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/30.
 * 抽象表达式
 */

public abstract class AbstractNode {

    public static final boolean DEBUG = AppConfig.DEBUG;
    public static final String TAG = "AbstractNode";

    public abstract String interpret();
}
