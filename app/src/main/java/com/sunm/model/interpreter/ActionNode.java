package com.sunm.model.interpreter;

import java.util.Locale;

/**
 * Created by Administrator on 2017/9/30.
 */

public class ActionNode extends AbstractNode {

    public enum Action {
        MOVE,
        RUN
    }

    private String action;

    public ActionNode(String action) {
        this.action = action;
    }

    @Override
    public String interpret() {
        if (action.equals(Action.MOVE.name().toLowerCase(Locale.ENGLISH))) {
            return "移动";
        }
        if (action.equals(Action.RUN.name().toLowerCase(Locale.ENGLISH))) {
            return "快速移动";
        }
        return "无效指令";
    }
}
