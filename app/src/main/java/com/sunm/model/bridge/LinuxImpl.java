package com.sunm.model.bridge;

/**
 * Created by Administrator on 2017/9/29.
 */

public class LinuxImpl implements ImageImpl {
    @Override
    public void doPaint(Matrix m) {
        m.show("Linux");
    }
}
