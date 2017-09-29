package com.sunm.model.decorate;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/29.
 */

public class ScrollBarDecorator extends ComponentDecorator {

    public ScrollBarDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        setScrollBar();
        super.display();
    }

    public void setScrollBar() {
        if (DEBUG) {
            Log.d(TAG, "add scroll bar for component");
        }
    }
}
