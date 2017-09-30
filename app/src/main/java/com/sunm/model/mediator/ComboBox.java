package com.sunm.model.mediator;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/30.
 */

public class ComboBox extends Component {
    @Override
    public void update() {
        if (DEBUG) {
            Log.d(TAG, " 组合框增加一项: 自强");
        }
    }

    public void select() {
        if (DEBUG) {
            Log.d(TAG, " 组合框选择小龙女");
        }
    }
}
