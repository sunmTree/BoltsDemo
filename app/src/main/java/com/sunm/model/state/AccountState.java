package com.sunm.model.state;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/30.
 */

public abstract class AccountState {
    protected static final String TAG = "AccountState";
    protected static final boolean DEBUG = AppConfig.DEBUG;

    protected Account account;
    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        stateCheck();
    }
    public void withDraw(double amount) {
        account.setBalance(account.getBalance() - amount);
        stateCheck();
    }
    public abstract void computeInterest();
    public abstract void stateCheck();
}
