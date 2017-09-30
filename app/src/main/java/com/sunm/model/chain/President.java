package com.sunm.model.chain;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/30.
 */

public class President extends Approver {

    public President(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 50000) {
            if (DEBUG) {
                Log.d(TAG, "董事长 " + mName + " 审批采购单 " + request.toString());
            }
        } else {
            mSuccessor.processRequest(request);
        }
    }
}
