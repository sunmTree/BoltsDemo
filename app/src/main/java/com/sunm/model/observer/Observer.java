package com.sunm.model.observer;

/**
 * Created by Administrator on 2017/9/30.
 */

public interface Observer {
    public String getName();
    public void setName(String name);
    public void help();
    public void beAttacked(AllyControllerCenter acc);
}
