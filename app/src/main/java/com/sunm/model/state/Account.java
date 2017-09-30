package com.sunm.model.state;

import android.util.Log;

import com.sunm.AppConfig;

import javax.crypto.spec.DESedeKeySpec;

/**
 * Created by Administrator on 2017/9/30.
 */

public class Account {
    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "Account";
    private AccountState state;
    private String owner;
    private double balance = 0;

    public Account(String owner, double init) {
        this.owner = owner;
        this.state = new NormalState(this);
        this.balance += init;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (DEBUG) {
            Log.d(TAG, owner + "存款" + amount);
        }
        state.deposit(amount);
        if (DEBUG) {
            Log.d(TAG, "现在账户金额： " + balance);
            Log.d(TAG, "现在账户状态： " + state.getClass().getSimpleName());
        }
    }

    public void withDraw(double amount) {
        if (DEBUG) {
            Log.d(TAG, owner + " 取款 " + amount);
        }
        state.withDraw(amount);
        if (DEBUG) {
            Log.d(TAG, "现在账户金额： " + balance);
            Log.d(TAG, "现在账户状态： " + state.getClass().getSimpleName());
        }
    }

    public void computeInterest() {
        state.computeInterest();
    }
}
