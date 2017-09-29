package com.sunm.model.singleton;

/**
 * Created by Administrator on 2017/9/28.
 */

public class Singleton {

    private Singleton() {}

    private static class HolderClass {
        private final static Singleton sInstance = new Singleton();
    }

    public static Singleton getInstance() {
        return HolderClass.sInstance;
    }



}
