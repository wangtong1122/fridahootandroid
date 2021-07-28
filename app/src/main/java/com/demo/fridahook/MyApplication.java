package com.demo.fridahook;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {
    static {
        Log.d("MyApplication","load gadget");
        System.loadLibrary("gadget");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyApplication", "onCreate");
    }
}
