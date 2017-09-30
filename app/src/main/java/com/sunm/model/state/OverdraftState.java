package com.sunm.model.state;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/30.
 */

public class OverdraftState extends AccountState {

    public OverdraftState(AccountState state) {
        this.account = state.account;
    }

    @Override
    public void computeInterest() {
        if (DEBUG) {
            Log.d(TAG, " 需要计算利息");
        }
    }

    @Override
    public void stateCheck() {
        double balance = account.getBalance();
        if (balance > 0) {
            account.setState(new NormalState(this));
        } else if (balance == -2000) {
            account.setState(new RestrictedState(this));
        } else if (balance < -2000) {
            if (DEBUG) {
                Log.d(TAG, "操作受限");
            }
        }
    }
}
