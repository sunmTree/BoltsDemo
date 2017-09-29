package com.sunm.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/9/28.
 */

public class FileUtils {

    public static String getChartType(Context context) {
        try {
            InputStream is = context.getResources().getAssets().open("test.prop");
            InputStreamReader inputReader = new InputStreamReader(is);
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line;
            StringBuffer result = new StringBuffer("");
            while ((line = bufReader.readLine()) != null)
                result.append(line);
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFileContent(@NonNull Context context, @NonNull String fileName) {
        try {
            InputStream inStream = context.getResources().getAssets().open(fileName);
            InputStreamReader reader = new InputStreamReader(inStream);
            BufferedReader bufReader = new BufferedReader(reader);
            String line;
            StringBuffer result = new StringBuffer();
            while ((line = bufReader.readLine()) != null) {
                Log.e("ReadLine", "line " + line);
                result.append(line);
            }
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static HashMap<String, String> loadPropFile(@NonNull Context context,
                                                       @NonNull String fileName) {
        HashMap<String, String> propMaps = new HashMap<>();
        try {
            InputStream inStream = context.getResources().getAssets().open(fileName);
            InputStreamReader reader = new InputStreamReader(inStream);
            BufferedReader bufReader = new BufferedReader(reader);
            String line;
            while ((line = bufReader.readLine()) != null) {
                Log.e("ReadLine", "line " + line);
                // chart_type=line
                String[] split = line.split("=");
                propMaps.put(split[0], split[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propMaps;
    }

}
