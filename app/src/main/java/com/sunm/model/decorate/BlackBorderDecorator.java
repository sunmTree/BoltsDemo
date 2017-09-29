package com.sunm.model.decorate;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/29.
 */

public class BlackBorderDecorator extends ComponentDecorator {

    public BlackBorderDecorator(Component component) {
        super(component);
    }

    public void setBlackBorder() {
        if (DEBUG) {
            Log.d(TAG, "set black border for component");
        }
    }

    @Override
    public void display() {
        setBlackBorder();
        super.display();
    }
}
