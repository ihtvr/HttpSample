package com.example.httpsample.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.example.httpsample.app.HttpSampleApp;

public class CommonUtils {
    /**
     * 检查是否有可用网络
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) HttpSampleApp.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        return connectivityManager.getActiveNetworkInfo() != null;
    }

    /**
     * 简单判断是否json格式
     *
     * @param json
     * @return
     */
    public static boolean isJson(String json) {
        try {
            if (json.startsWith("{")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
