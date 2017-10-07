package com.sunm.data.link;

/**
 * 链表栈
 */

public class LinkStack {

    private LinkList mLinkList;

    public LinkStack() {
        this.mLinkList = new LinkList();
    }

    public void push(int id, double d) {
        mLinkList.insertFirst(id, d);
    }

    public int pop() {
        return mLinkList.deleteFirst().data;
    }

    public boolean isEmpty() {
        return mLinkList.isEmpty();
    }

    public void displayStack() {
        mLinkList.displayList();
    }
}
