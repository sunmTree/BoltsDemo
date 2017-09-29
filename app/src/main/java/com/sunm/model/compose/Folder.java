package com.sunm.model.compose;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/29.
 */

public class Folder extends AbstractFile {

    // 定义集合，用于存储AbstractFile成员
    private ArrayList<AbstractFile> mFileList = new ArrayList<>();
    private String mFileName;

    public Folder(String name) {
        this.mFileName = name;
    }

    @Override
    public void add(AbstractFile file) {
        if (file == this) {
            if (DEBUG) {
                Log.e(TAG, "you can't add yourself");
                throw new AddErrorException("you can't add yourself");
            }
            return;
        }
        mFileList.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        mFileList.remove(file);
    }

    @Override
    public AbstractFile getChild(int i) {
        return mFileList.get(i);
    }

    @Override
    public void killVirus() {
        if (DEBUG) {
            Log.d(TAG, "对文件夹" + mFileName + "进行杀毒");
        }
        for (AbstractFile file : mFileList) {
            file.killVirus();
        }
    }
}
