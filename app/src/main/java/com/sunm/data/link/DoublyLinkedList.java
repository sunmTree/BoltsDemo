package com.sunm.data.link;

import com.sunm.AppConfig;

/**
 * 双向链表
 */

public class DoublyLinkedList {
    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "DoublyLinkedList";

    private LinkInfo first;
    private LinkInfo last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long data) {
        LinkInfo linkInfo = new LinkInfo(data);
        if (isEmpty()) {
            last = linkInfo;
        } else {
            first.previous = linkInfo;
        }
        linkInfo.next = first;
        first = linkInfo;
    }

    public void insertLast(long data) {
        LinkInfo linkInfo = new LinkInfo(data);
        if (isEmpty()) {
            first = linkInfo;
        } else {
            last.next = linkInfo;
            linkInfo.previous = last;
        }

        last = linkInfo;
    }

    public LinkInfo deleteFirst() {
        LinkInfo temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    public LinkInfo deleteLast() {
        LinkInfo temp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }

    public boolean insertAfter(long key, long data) {
        LinkInfo current = first;
        while (current.dData != key) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }

        LinkInfo linkInfo = new LinkInfo(data);

        if (current == last) {
            linkInfo.next = null;
            last = linkInfo;
        } else {
            linkInfo.next = current.next;
            current.next.previous = linkInfo;
        }

        linkInfo.previous = current;
        current.next = linkInfo;
        return true;
    }

    public LinkInfo deleteKey(long key) {
        LinkInfo current = first;
        while (current.dData != key) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }

        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }

        return current;
    }

    public void displayForward() {
        LinkInfo current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    public void displayBackward() {
        LinkInfo current = last;
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
    }
}
