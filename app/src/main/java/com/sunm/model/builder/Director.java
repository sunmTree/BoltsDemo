package com.sunm.model.builder;

/**
 * Created by Administrator on 2017/9/28.
 */

public class Director {

    private Builder mBuilder;

    public void setBuilder(Builder builder) {
        mBuilder = builder;
    }

    public Product construct() {
        mBuilder.buildPartA();
        mBuilder.buildPartB();
        mBuilder.buildPartC();
        return mBuilder.getResult();
    }
}
