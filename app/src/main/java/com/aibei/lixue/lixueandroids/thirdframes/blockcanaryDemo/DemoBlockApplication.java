package com.aibei.lixue.lixueandroids.thirdframes.blockcanaryDemo;

import android.app.Application;

import com.github.moduth.blockcanary.BlockCanary;

/**
 * 作者：lixue on 2019/7/24 14:47
 */

public class DemoBlockApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BlockCanary.install(this,new AppBlockContext()).start();
    }
}
