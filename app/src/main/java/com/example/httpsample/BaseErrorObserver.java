package com.example.httpsample;

import android.content.Context;

import io.reactivex.observers.ResourceObserver;

public abstract class BaseErrorObserver<T> extends ResourceObserver<T> {
    private Context context;
    private String errorStr;

    public BaseErrorObserver(Context context) {
        this.context = context;
    }

    public BaseErrorObserver(Context context, String errorStr) {
        this.context = context;
        this.errorStr = errorStr;

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
