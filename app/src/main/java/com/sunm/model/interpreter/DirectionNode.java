package com.sunm.model.interpreter;

import java.util.Locale;

/**
 * Created by Administrator on 2017/9/30.
 */

public class DirectionNode extends AbstractNode {

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    private String direction;

    public DirectionNode(String direction) {
        this.direction = direction;
    }

    @Override
    public String interpret() {
        if (direction.equals(Direction.UP.name().toLowerCase(Locale.ENGLISH))) {
            return "向上";
        }
        if (direction.equals(Direction.DOWN.name().toLowerCase(Locale.ENGLISH))) {
            return "向下";
        }
        if (direction.equals(Direction.LEFT.name().toLowerCase(Locale.ENGLISH))) {
            return "向左";
        }
        if (direction.equals(Direction.RIGHT.name().toLowerCase(Locale.ENGLISH))) {
            return "向右";
        }
        return "无效指令";
    }
}
