package com.example.httpsample.app;

import android.app.Application;

import com.example.httpsample.R;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

public class HttpSampleApp extends Application {
    private static HttpSampleApp instance;

    public static synchronized HttpSampleApp getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initLogger();
    }

    private void initLogger() {

        Logger.addLogAdapter(new AndroidLogAdapter(PrettyFormatStrategy.newBuilder().
                tag(getString(R.string.app_name)).build()));

    }
}
