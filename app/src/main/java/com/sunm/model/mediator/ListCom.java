package com.sunm.model.mediator;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/30.
 */

public class ListCom extends Component {
    @Override
    public void update() {
        if (DEBUG) {
            Log.d(TAG, "列表框增加一项： 自强");
        }
    }

    public void select() {
        if (DEBUG) {
            Log.d(TAG, " 选择列表中的小龙女");
        }
    }
}
