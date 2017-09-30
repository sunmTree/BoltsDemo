package com.sunm.model.chain;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/30.
 */

public abstract class Approver {

    public static final boolean DEBUG = AppConfig.DEBUG;
    public static final String TAG = "Approver";

    protected Approver mSuccessor;
    protected String mName; // 审批者姓名

    public Approver(String name) {
        this.mName = name;
    }

    public void setSuccessor(Approver successor) {
        this.mSuccessor = successor;
    }

    public abstract void processRequest(PurchaseRequest request);
}
