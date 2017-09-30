package com.sunm.model.state;

import android.util.Log;

/**
 * Created by Administrator on 2017/9/30.
 */

public class RestrictedState extends AccountState {

    public RestrictedState(AccountState state) {
        this.account = state.account;
    }

    @Override
    public void withDraw(double amount) {
        if (DEBUG) {
            Log.d(TAG, " 账号受限，取款失败" + getClass().getSimpleName());
        }
    }

    @Override
    public void computeInterest() {
        if (DEBUG) {
            Log.d(TAG, " 计算利息 " + getClass().getSimpleName());
        }
    }

    @Override
    public void stateCheck() {
        if (account.getBalance() > 0) {
            account.setState(new NormalState(this));
        } else if (account.getBalance() > -2000) {
            account.setState(new OverdraftState(this));
        }
    }
}
