package com.sunm.model.decorate;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/29.
 */

public class ListBox extends Component {
    @Override
    public void display() {
        if (DEBUG) {
            Log.d(TAG, " list box display");
        }
    }
}
