package com.framgia.movieapp;

import android.app.Application;

/**
 * Created by FRAMGIA\pham.duc.nam on 23/06/2017.
 */

public class MovieApplication extends Application {
    private static MovieApplication mInstance;
    public static MovieApplication getInstance(){
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
