package com.sunm.model.interpreter;

/**
 * Created by Administrator on 2017/9/30.
 */

public class SentenceNode extends AbstractNode {

    private AbstractNode diection;
    private AbstractNode action;
    private AbstractNode distance;

    public SentenceNode(AbstractNode diection, AbstractNode action, AbstractNode distance) {
        this.diection = diection;
        this.action = action;
        this.distance = distance;
    }

    @Override
    public String interpret() {
        return diection.interpret() + action.interpret() + distance.interpret();
    }
}
