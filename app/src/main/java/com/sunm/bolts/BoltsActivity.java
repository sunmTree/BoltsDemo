package com.sunm.bolts;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.apache.http.params.HttpParams;

import java.net.HttpURLConnection;
import java.util.List;

public class BoltsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "BoltsActivity";

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolts);

        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);

        queryInstallApps();
    }

    private void queryInstallApps() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> resolveInfos = getPackageManager().queryIntentActivities(intent, 0);
        for (int i=0; i< resolveInfos.size(); i++) {
            ResolveInfo resolveInfo = resolveInfos.get(i);
            Log.d(TAG, resolveInfo.resolvePackageName + " resolveInfo " + resolveInfo.toString());
            if (!TextUtils.isEmpty(resolveInfo.resolvePackageName)) {
                if (resolveInfo.resolvePackageName.contains("ledongli")) {
                    Log.e("TAG", "tarAppUri " +
                            resolveInfo.activityInfo.applicationInfo.sourceDir +
                            " dataDir " + resolveInfo.activityInfo.applicationInfo.toString());
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.button) {
            testMethod();
            Intent intent = new Intent(BoltsActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    }

    private void testMethod() {
        long firstTime = System.currentTimeMillis();
        String str = "0";
        for (int i = 0; i < 1000; i++) {
            str += " - " + i;
        }
        long secondTime = System.currentTimeMillis();
        StringBuilder strBuild = new StringBuilder("0");
        for (int i = 0; i < 1000; i++) {
            strBuild.append(" - " + i);
        }
        long thirdTime = System.currentTimeMillis();
        Log.d(TAG, "\n cast time [ " + (secondTime - firstTime) + " ] ms " + " str " + str);
        Log.d(TAG, "\n cast time [ " + (thirdTime - secondTime) + " ] ms " + " strBuild " + strBuild);
    }
}
