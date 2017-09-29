package com.sunm.model.decorate;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/29.
 */

public class TextBox extends Component {
    @Override
    public void display() {
        if (DEBUG) {
            Log.d(TAG, "text box display");
        }
    }
}
