package com.example.javieraltmann.nightplan;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.multidex.MultiDexApplication;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.facebook.drawee.backends.pipeline.Fresco;

public class Application extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
