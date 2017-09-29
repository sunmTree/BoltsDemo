package com.sunm.prop;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.sunm.AppConfig;
import com.sunm.utils.FileUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/9/28.
 */

public class ModelProp {

    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "ModelProp";

    private static final String CHART_TYPE = "chart_type";
    private static final String LOG_FACTORY_TYPE = "log_factory_type";

    private static ModelProp sInstance;
    private Context mContext;
    private static final String M_FILE_NAME = "model.txt";

    private HashMap<String, String> mPropMaps;

    private ModelProp(Context context) {
        mContext = context;
        mPropMaps = FileUtils.loadPropFile(context, M_FILE_NAME);
    }

    public static ModelProp getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new ModelProp(context.getApplicationContext());
        }
        return sInstance;
    }

    public String getChartType() {
        return mPropMaps.get(CHART_TYPE);
    }

    public String getLogFactoryType() {
        return mPropMaps.get(LOG_FACTORY_TYPE);
    }

}
