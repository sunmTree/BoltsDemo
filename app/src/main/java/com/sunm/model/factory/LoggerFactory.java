package com.sunm.model.factory;

import android.text.TextUtils;
import android.util.Log;

import com.sunm.AppConfig;

/**
 * Created by Administrator on 2017/9/28.
 */

public class LoggerFactory {

    private static final boolean DEBUG = AppConfig.DEBUG;
    private static final String TAG = "LoggerFactory";

    public static final String DB_LOGGER = "db";
    public static final String FILE_LOGGER = "file";

    public static Logger createLogger(String type) {
        if (TextUtils.equals(type, DB_LOGGER)) {
            return new DataLogger();
        }
        if (TextUtils.equals(type, FILE_LOGGER)) {
            return new FileLogger();
        }
        return null;
    }

    public static ILoggerFactory createFileFactory() {
        return new FileFactory();
    }

    public static ILoggerFactory createDataFactory() {
        return new DataFactory();
    }
}

class DataFactory implements ILoggerFactory {

    @Override
    public Logger createLog() {
        return new DataLogger();
    }
}

class FileFactory implements ILoggerFactory {

    @Override
    public Logger createLog() {
        return new FileLogger();
    }
}

class DataLogger implements Logger {

    @Override
    public void writeLog(String message) {
        if (AppConfig.DEBUG) {
            Log.d(this.getClass().getSimpleName(), "message " + message);
        }
    }
}

class FileLogger implements Logger {

    @Override
    public void writeLog(String message) {
        if (AppConfig.DEBUG) {
            Log.d(this.getClass().getSimpleName(), "message " + message);
        }
    }
}
