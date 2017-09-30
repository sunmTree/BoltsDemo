package com.sunm.model.mediator;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/30.
 */

public abstract class Component {

    public static final boolean DEBUG = AppConfig.DEBUG;
    public static final String TAG = "Component";

    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void changed() {
        mediator.componentChanged(this);
    }

    public abstract void update();

}
