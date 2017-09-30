package com.sunm.model.iteration;

import android.animation.ObjectAnimator;

import com.sunm.AppConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/30.
 */

public abstract class AbstractObjectList {
    public static final boolean DEBUG = AppConfig.DEBUG;
    public static final String TAG = "AbstractObjectList";

    private List objects = new ArrayList();

    public AbstractObjectList(List objects) {
        this.objects = objects;
    }

    public void addObject(Object object) {
        objects.add(object);
    }

    public void remove(Object object) {
        objects.remove(object);
    }

    public List getObjects() {
        return objects;
    }

    public abstract AbstractIteration createIteration();
}
