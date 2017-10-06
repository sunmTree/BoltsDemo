package com.sunm.bolts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sunm.AppConfig;
import com.sunm.data.link.Link;
import com.sunm.data.link.LinkList;

public class DataActivity extends AppCompatActivity {

    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "DataActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        linkMethod();
    }

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
                link.displayLink();
            }
        }
    }
}
