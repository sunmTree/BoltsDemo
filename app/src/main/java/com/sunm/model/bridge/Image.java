package com.sunm.model.bridge;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/29.
 */

public abstract class Image {

    public static final boolean DEBUG = AppConfig.DEBUG;
    public static final String TAG = "Image";

    protected ImageImpl impl;

    public void setImpl(ImageImpl impl) {
        this.impl = impl;
    }

    public abstract void parseFile(String fileName);

}
