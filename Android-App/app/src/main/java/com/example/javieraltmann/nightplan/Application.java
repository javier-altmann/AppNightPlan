package com.example.javieraltmann.nightplan;

import android.support.multidex.MultiDexApplication;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.drawee.backends.pipeline.Fresco;

public class Application extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }
}
