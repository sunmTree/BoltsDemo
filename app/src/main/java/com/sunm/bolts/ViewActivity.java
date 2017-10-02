package com.sunm.bolts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sunm.AppConfig;
import com.sunm.view.ProgressView;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ViewActivity";
    private static final boolean DEBUG = AppConfig.DEBUG;

    private ProgressView mProgress;
    private Button mStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        mProgress = (ProgressView) findViewById(R.id.progress_view);
        mStart = (Button) findViewById(R.id.start_progress);
        mStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mProgress.startProgress();
    }
}
