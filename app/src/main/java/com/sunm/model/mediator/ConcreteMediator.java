package com.sunm.model.mediator;

import android.util.Log;

import com.sunm.AppConfig;

import javax.crypto.spec.DESedeKeySpec;

/**
 * Created by Administrator on 2017/9/30.
 */

public class ConcreteMediator extends Mediator {
    private static final String TAG = "ConcreteMediator";

    public Buton buton;
    public ListCom listCom;
    public TextBox userName;
    public ComboBox comboBox;

    @Override
    public void componentChanged(Component c) {
        if (c == buton) {
            if (AppConfig.DEBUG) {
                Log.d(TAG, " -----单击增加按钮--------");
            }
            listCom.update();
            comboBox.update();
            userName.update();
        } else if (c == listCom) {
            if (AppConfig.DEBUG) {
                Log.d(TAG, " ----------从列表框选择用户-----------");
            }
            comboBox.select();
            userName.setText();
        }
    }
}
