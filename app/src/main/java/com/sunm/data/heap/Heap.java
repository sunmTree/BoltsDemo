package com.sunm.data.heap;

import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/10/9.
 */

public class Heap {
    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "HEAP";

    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int max) {
        this.maxSize = max;
        currentSize = 0;
        heapArray = new Node[max];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key) {
        if (currentSize == maxSize) {
            return false;
        }
        if (DEBUG) {
            Log.d(TAG, "insert method " + key + " currentSize " + currentSize);
        }
        Node node = new Node(key);
        heapArray[currentSize] = node;
        trickleUp(currentSize++);
        return true;
    }

    private void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];

        if (DEBUG) {
            Log.d(TAG, "trickleUp index " + index + " bottom " + bottom.getData());
        }

        while (index > 0 &&
                heapArray[parent].getData() < bottom.getData()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (index - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    private void trickleDown(int index) {
        if (index < 0 || index > currentSize) {
            return;
        }
        int largerChild;
        Node top = heapArray[index];

        while (index < currentSize / 2) {
            // 获取两个子节点
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = leftChildIndex + 1;
            // 对比左右，看看那个值更大
            if (rightChildIndex < currentSize &&
                    heapArray[leftChildIndex].getData() < heapArray[rightChildIndex].getData()) {
                largerChild = rightChildIndex;
            } else {
                largerChild = leftChildIndex;
            }
            // 大的值和根植替换
            if (heapArray[largerChild].getData() > top.getData()) {
                heapArray[index] = heapArray[largerChild];
                index = largerChild;
            } else {
                return;
            }
        }

        heapArray[index] = top;
    }

    public boolean change(int index, int newValue) {
        if (index < 0 || index > currentSize) {
            return false;
        }

        int oldValue = heapArray[index].getData();
        heapArray[index].setData(newValue);

        if (oldValue < newValue) {
            trickleUp(index);
        } else {
            trickleDown(index);
        }
        return true;
    }

    public void displayHeap() {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i< currentSize; i++) {
            sBuilder.append("Index " + i + " [ " + heapArray[i].getData() + " ] " );
        }
        if (DEBUG) {
            Log.d(TAG, "displayHeap " + sBuilder.toString());
        }
    }
}
