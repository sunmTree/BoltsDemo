package com.sunm.model.iteration;

/**
 * Created by Administrator on 2017/9/30.
 */

public interface AbstractIteration {
    void next();
    boolean isLast();
    void previous();
    boolean isFirst();
    Object getNext();
    Object getPreviousItem();
}
