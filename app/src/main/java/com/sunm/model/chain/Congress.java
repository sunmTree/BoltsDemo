package com.sunm.model.chain;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/30.
 */

public class Congress extends Approver {
    public Congress(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (DEBUG) {
            Log.d(TAG, "董事会 " + mName + " 审批采购单 " + request.toString());
        }
    }
}
