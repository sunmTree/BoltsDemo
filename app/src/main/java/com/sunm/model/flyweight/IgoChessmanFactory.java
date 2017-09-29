package com.sunm.model.flyweight;

import com.sunm.AppConfig;

import java.util.Hashtable;

/**
 * Created by Administrator on 2017/9/29.
 */

public class IgoChessmanFactory {

    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "IgoChessmanFactory";

    private static Hashtable ht; // 享元池

    private static class InnerHolder {
        private static final IgoChessmanFactory sInstance = new IgoChessmanFactory();
    }

    // IoDL
    public static IgoChessmanFactory getInstance() {
        return InnerHolder.sInstance;
    }

    private IgoChessmanFactory() {
        ht = new Hashtable();
        IgoChessman black, white;
        black = new BlackIgoChessman();
        ht.put("black", black);
        white = new WhiteIgoChessman();
        ht.put("white", white);
    }

    public IgoChessman getIgoChessman(String color) {
        return (IgoChessman) ht.get(color);
    }

}
