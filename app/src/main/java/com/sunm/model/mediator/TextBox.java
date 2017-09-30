package com.sunm.model.mediator;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/30.
 */

public class TextBox extends Component {
    @Override
    public void update() {
        if (DEBUG) {
            Log.d(TAG, "客户信息增加成功后文本框清空");
        }
    }

    public void setText() {
        if (DEBUG) {
            Log.d(TAG, "文本框显示： 小龙女");
        }
    }
}
