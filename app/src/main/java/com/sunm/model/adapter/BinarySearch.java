package com.sunm.model.adapter;

/**
 * Created by Administrator on 2017/9/29.
 */

public class BinarySearch {

    public int binarySearch(int array[], int key) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            int midVal = array[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return 1; // 找到返回元素1
            }
        }
        return -1;
    }
}
