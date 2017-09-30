package com.sunm.model.chain;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/30.
 */

public class VicePresident extends Approver{

    public VicePresident(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 10000) {
            if (DEBUG) {
                Log.d(TAG, "副董事长 " + mName + " 审批采购单 " + request.toString());
            }
        } else {
            mSuccessor.processRequest(request);
        }
    }
}
