package com.sunm.data.link;


import android.util.Log;

/**
 * 双端链表，添加对最后一个链结点的引用
 */

public class FirstLastList extends LinkList{

    private Link last;

    public FirstLastList() {
        super();
        this.last = null;
    }

    @Override
    public void insertFirst(int id, double d) {
        Link newLink = new Link(id, d);
        if (isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        if (DEBUG) {
            Log.i(TAG, "insertFirst newLink " + newLink + " newLink.next " + newLink.next);
        }
        first = newLink;
    }

    public void insertLast(int id, double d) {
        Link link = new Link(id, d);
        if (isEmpty()) {
            first = link;
        } else {
            last.next = link;
        }
        last = link;
    }

    @Override
    public Link deleteFirst() {
        Link temp = first;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
    }
}
