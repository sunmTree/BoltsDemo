package com.sunm.bolts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sunm.AppConfig;
import com.sunm.data.link.DoublyLinkedList;
import com.sunm.data.link.FirstLastList;
import com.sunm.data.link.Link;
import com.sunm.data.link.LinkList;
import com.sunm.data.link.LinkQueue;
import com.sunm.data.link.LinkStack;
import com.sunm.data.recursion.DataUtils;
import com.sunm.data.sort.ArraySh;

public class DataActivity extends AppCompatActivity {

    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "DataActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        linkMethod();
        firstLastLink();
        linkStack();
        linkQueue();
        doublyLink();
        recursion();
        arraySh();
    }

    // 单链表
    private void linkMethod() {
        LinkList linkList = new LinkList();

        linkList.insertFirst(1, 12.0);
        linkList.insertFirst(2, 15.0);
        linkList.insertFirst(3, 17.0);
        linkList.insertFirst(4, 21.0);

        linkList.displayList();

        Link link1 = linkList.find(3);
        if (DEBUG) {
            Log.i(TAG, "find key 3 with " + link1.d);
        }

        Link delete = linkList.delete(2);
        if (DEBUG) {
            Log.i(TAG, "delete key 2 with " + delete.d);
        }

        while (!linkList.isEmpty()) {
            Link link = linkList.deleteFirst();
            if (DEBUG) {
                Log.w(TAG, "Deleted");
                if (link != null)
                    link.displayLink();
            }
        }
    }

    // 双端链表
    private void firstLastLink() {
        FirstLastList firstLastList = new FirstLastList();

        firstLastList.insertFirst(1, 13);
//        firstLastList.insertFirst(2, 16);
//        firstLastList.insertFirst(3, 19);
//        firstLastList.insertFirst(4, 23);

        firstLastList.insertLast(5, 30);
//        firstLastList.insertLast(6, 35);
//        firstLastList.insertLast(7, 40);
//        firstLastList.insertLast(8, 50);

        firstLastList.displayList();
        Link link = firstLastList.deleteFirst();
        Link link1 = firstLastList.deleteFirst();
        if (DEBUG) {
            Log.d(TAG, "delete " + (link != null ? link.data : "null"));
            Log.d(TAG, "delete " + (link1 != null ? link1.data : "null"));
        }
        firstLastList.displayList();
    }

    // 链表实现的栈
    private void linkStack() {
        LinkStack linkStack = new LinkStack();
        linkStack.push(1, 20);
        linkStack.push(2, 25);

        linkStack.displayStack();

        linkStack.push(3, 30);

        linkStack.displayStack();

        linkStack.pop();
        linkStack.pop();
        linkStack.displayStack();
    }

    // 链表实现的队列
    private void linkQueue() {
        LinkQueue linkQueue = new LinkQueue();

        linkQueue.insert(1, 10);
        linkQueue.insert(2, 13);
        linkQueue.displayQueue();

        linkQueue.insert(3, 19);
        linkQueue.insert(4, 27);
        linkQueue.displayQueue();

        linkQueue.remove();
        linkQueue.remove();
        linkQueue.displayQueue();
    }

    // 双向链表
    private void doublyLink() {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertFirst(22);
        list.insertFirst(44);
        list.insertFirst(66);

        list.insertLast(11);
        list.insertLast(33);
        list.insertLast(55);

        if (DEBUG) {
            Log.d(TAG, "0--------------------1-------------------2------------------");
        }
        list.displayForward();
        if (DEBUG) {
            Log.d(TAG, "0--------------------1-------------------2------------------");
        }
        list.displayBackward();

        list.deleteFirst();
        list.deleteLast();
        list.deleteKey(11);
        if (DEBUG) {
            Log.d(TAG, "0--------------------1-------------------2------------------");
        }
        list.displayForward();

        list.insertAfter(22, 77);
        list.insertAfter(33, 88);
        if (DEBUG) {
            Log.d(TAG, "0--------------------1-------------------2------------------");
        }
        list.displayForward();
    }

    // 递归
    private void recursion() {
        DataUtils dataUtils = new DataUtils();

        int sum4 = dataUtils.triangle(4);
        int sum10 = dataUtils.triangle(10);

        if (DEBUG) {
            Log.d(TAG, "sum4 " + sum4 + " sum10 " + sum10);
        }

        dataUtils.doTowers(3, 'A', 'B', 'C');
    }

    // 希尔排序
    private void arraySh() {
        int maxSize = 10;
        ArraySh arraySh = new ArraySh(maxSize);

        for (int i = 0; i < maxSize; i++) {
            long n = (long) (Math.random() * 100.00);
            arraySh.insert(n);
        }

        arraySh.display();
        arraySh.shellSort();
        arraySh.display();
    }
}
