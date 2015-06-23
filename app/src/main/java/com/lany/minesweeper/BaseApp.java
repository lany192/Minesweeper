package com.lany.minesweeper;

import android.app.Application;

import org.litepal.LitePalApplication;

/**
 * Created by user on 2015/6/23.
 */
public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePalApplication.initialize(this);
    }
}
