package com.sunm.data.link;

/**
 * 链表实现抽象数据类型 --》 队列
 */

public class LinkQueue {

    private FirstLastList mList;

    public LinkQueue() {
        mList = new FirstLastList();
    }

    public boolean isEmpty() {
        return mList.isEmpty();
    }

    public void insert(int id, double d) {
        mList.insertLast(id, d);
    }

    public int remove() {
        return mList.deleteFirst().data;
    }

    public void displayQueue() {
        mList.displayList();
    }
}
