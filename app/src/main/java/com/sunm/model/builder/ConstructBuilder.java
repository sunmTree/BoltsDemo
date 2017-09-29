package com.sunm.model.builder;

/**
 * Created by Administrator on 2017/9/28.
 */

public class ConstructBuilder extends Builder {

    @Override
    public void buildPartA() {
        mProduct.setPartA("A_For_Area");
    }

    @Override
    public void buildPartB() {
        mProduct.setPartB("B_For_Bank");
    }

    @Override
    public void buildPartC() {
        mProduct.setPartC("C_For_Can");
    }
}
