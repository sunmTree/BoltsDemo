package com.sunm.model.compose;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/29.
 */

public class VideoFile extends AbstractFile {

    private String mFileName;

    public VideoFile(String name) {
        this.mFileName = name;
    }

    @Override
    public void add(AbstractFile file) {
        if (DEBUG) {
            Log.d(TAG, "sorry, not support");
        }
    }

    @Override
    public void remove(AbstractFile file) {
        if (DEBUG) {
            Log.d(TAG, "sorry, not support");
        }
    }

    @Override
    public AbstractFile getChild(int i) {
        if (DEBUG) {
            Log.d(TAG, "sorry, not support");
        }
        return null;
    }

    @Override
    public void killVirus() {
        if (DEBUG) {
            Log.d(TAG, " ----- --- >> 对  视频文件  进行模拟杀毒 " + mFileName);
        }
    }
}
