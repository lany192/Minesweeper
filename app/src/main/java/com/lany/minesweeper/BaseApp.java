package com.lany.minesweeper;

import org.litepal.LitePalApplication;

/**
 * Created by user on 2015/6/23.
 */
public class BaseApp extends com.lany.box.BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePalApplication.initialize(this);
    }
}
