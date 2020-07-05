package com.example.e_learning.core;

import android.app.Application;

public class MyApplication extends Application {
    private static MyApplication instance;

    public MyApplication getInstance(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
