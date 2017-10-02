package com.sunm.data;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/10/1.
 */

public class MapDemo {
    private HashMap<String, Object> maps = new HashMap<>();
    private ArrayList<String> list = new ArrayList<>();
    private int[] array = {2,6,1,8,3};

    public void put(String key, Object value) {
        maps.put(key, value);
        maps.get(key);
    }


}
