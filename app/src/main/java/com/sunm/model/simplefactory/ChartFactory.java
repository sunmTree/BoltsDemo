package com.sunm.model.simplefactory;

import android.text.TextUtils;
import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/28.
 */

public class ChartFactory {

    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "ChartFactory";

    // 柱状图
    public static final String TYPE_HISTOGRAM_CHART = "histogram";
    // 饼状图
    public static final String TYPE_PIE_CHART = "pie";
    // 折现图
    public static final String TYPE_LINE_CHART = "line";

    public static Chart getChart(String type) {
        Chart chart = null;
        if (TextUtils.equals(type, TYPE_HISTOGRAM_CHART)) {
            chart = new HistogramChart();
        }
        if (TextUtils.equals(type, TYPE_LINE_CHART)) {
            chart = new LineChart();
        }
        if (TextUtils.equals(type, TYPE_PIE_CHART)) {
            chart = new PieChart();
        }
        return chart;
    }

    public interface Chart {
        void display();
    }

    static class PieChart implements Chart{

        public PieChart() {
            if (DEBUG) {
                Log.d(TAG, "创建饼状图");
            }
        }

        @Override
        public void display() {
            if (DEBUG) {
                Log.d(TAG, "显示饼状图");
            }
        }
    }

    static class HistogramChart implements Chart{

        public HistogramChart() {
            if (DEBUG) {
                Log.d(TAG, "创建柱状图");
            }
        }

        @Override
        public void display() {
            if (DEBUG) {
                Log.d(TAG, "显示柱状图");
            }
        }
    }

    static class LineChart implements Chart {

        public LineChart() {
            if (DEBUG) {
                Log.d(TAG, "创建折线图");
            }
        }

        @Override
        public void display() {
            if (DEBUG) {
                Log.d(TAG, "显示折线图");
            }
        }
    }
}
