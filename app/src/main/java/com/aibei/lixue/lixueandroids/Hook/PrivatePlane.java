package com.aibei.lixue.lixueandroids.Hook;

import com.aibei.lixue.lixuelib.utils.LogUtil;

/**
 * 作者：lixue on 2019/7/16 10:50
 */

public class PrivatePlane {

    private PrivatePlaneEngineInterface privatePlaneEngine;

    PrivatePlane(){
        this.privatePlaneEngine = new PrivatePlaneEngine();
    }

    public void showMaxSpeed(){
        LogUtil.i("PrivatePlane","最大速度可以达到：" + privatePlaneEngine.maxSpeed());
    }
}
