package com.sunm.model.bridge;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/29.
 */

public class PNGImage extends Image {
    @Override
    public void parseFile(String fileName) {
        Matrix matrix = new Matrix();
        matrix.transform("PNG");
        impl.doPaint(matrix);
        if (DEBUG) {
            Log.d(TAG, "PNGImage transform");
        }
    }
}
