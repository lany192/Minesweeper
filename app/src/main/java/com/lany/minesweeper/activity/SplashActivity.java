package com.lany.minesweeper.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.lany.box.activity.BaseActivity;
import com.lany.minesweeper.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected boolean hasToolbar() {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, GameActivity.class));
                finish();
            }
        }, 2000);
    }

}
