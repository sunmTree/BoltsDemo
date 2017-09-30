package com.sunm.model.state;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/30.
 */

public class NormalState extends AccountState {

    public NormalState(Account account) {
        this.account = account;
    }

    public NormalState(AccountState state) {
        this.account = state.account;
    }

    @Override
    public void computeInterest() {
        if (DEBUG) {
            Log.d(TAG, " 正常状态，无须支付利息");
        }
    }

    @Override
    public void stateCheck() {
        double balance = account.getBalance();
        if (balance >= -2000 && balance <= 0) {
            account.setState(new OverdraftState(this));
        } else if (balance == -2000) {
            account.setState(new RestrictedState(this));
        } else if (balance < -2000) {
            if (DEBUG) {
                Log.d(TAG, " 操作受限");
            }
        }
    }
}
