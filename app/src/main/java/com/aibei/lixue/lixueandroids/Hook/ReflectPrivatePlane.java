package com.aibei.lixue.lixueandroids.Hook;

/**
 * 作者：lixue on 2019/7/16 10:56
 */

public class ReflectPrivatePlane extends PrivatePlaneEngine {
    private PrivatePlaneEngineInterface start;

    public ReflectPrivatePlane(PrivatePlaneEngineInterface start){
        this.start = start;
    }

    @Override
    public int maxSpeed() {
        return 3 * start.maxSpeed();
    }
}
