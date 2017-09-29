package com.sunm.model.decorate;

import com.sunm.AppConfig;

/**
 * 抽象界面构建类，
 */

public abstract class Component {

    public static final boolean DEBUG = AppConfig.DEBUG;
    public static final String TAG = "Component";

    public abstract void display();

}
