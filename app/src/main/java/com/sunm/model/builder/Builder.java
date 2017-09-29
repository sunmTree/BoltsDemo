package com.sunm.model.builder;

/**
 * Created by Administrator on 2017/9/28.
 */

public abstract class Builder {

    protected Product mProduct = new Product();

    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();

    public Product getResult() {
        return mProduct;
    }
}
