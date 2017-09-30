package com.sunm.model.interpreter;

/**
 * Created by Administrator on 2017/9/30.
 */

public class DistanceNode extends AbstractNode {

    private String distance;

    public DistanceNode(String distance) {
        this.distance = distance;
    }

    @Override
    public String interpret() {
        return distance;
    }
}
