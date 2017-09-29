package com.sunm.model.compose;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/29.
 */

public abstract class AbstractFile {

    public static final boolean DEBUG = AppConfig.DEBUG;
    public static final String TAG = "AbstractFile";

    public abstract void add(AbstractFile file);
    public abstract void remove(AbstractFile file);
    public abstract AbstractFile getChild(int i);
    public abstract void killVirus();
}
