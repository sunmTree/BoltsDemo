package com.sunm.model.chain;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/30.
 */

public class Director extends Approver {

    public Director(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 5000) {
            if (DEBUG) {
                Log.d(TAG, "主任 " + mName + " 审批采购单 " + request.toString());
            }
        } else {
            mSuccessor.processRequest(request);
        }
    }
}
