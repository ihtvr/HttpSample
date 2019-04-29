package com.example.httpsample.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {
    private static final String BASE_URL = "https://www.wanandroid.com";
    private static final int DEFAULT_TIME_OUT = 10;//超时时间5s
    private static final int DEFAULT_READ_TIME_OUT = 10;//读取时间
    private static final int DEFAULT_WRITE_TIME_OUT = 10;//读取时间
    private Retrofit mRetrofit;

    private HttpManager() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_WRITE_TIME_OUT, TimeUnit.SECONDS);
        addInterceptor(builder);

        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 添加拦截器
     *
     * @param builder
     */
    private void addInterceptor(OkHttpClient.Builder builder) {
        // 添加日志拦截器
        LoggingInterceptor loggingInterceptor = new LoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);

    }


    private static class SingletonHolder {
        private static HttpManager httpManager = new HttpManager();
    }

    public static HttpManager getInstance() {
        return SingletonHolder.httpManager;
    }

    public <T> T create(Class<T> tClass) {
        return mRetrofit.create(tClass);
    }
}
