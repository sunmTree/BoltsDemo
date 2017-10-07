package com.sunm.data.link;

import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/10/7.
 */

public class LinkList {
    protected static final boolean DEBUG = AppConfig.DEBUG;
    protected static final String TAG = "LinkList";

    protected Link first;

    public LinkList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int id, double d) {
        Link newLink = new Link(id, d);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        if (DEBUG) {
            Log.d(TAG, "LinkList first --> end");
        }
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    public Link find(int key) {
        Link current = first;
        while (current.data != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current.data != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }
}
