package com.aibei.lixue.lixueandroids.Hook;

import com.aibei.lixue.lixuelib.utils.LogUtil;

import java.lang.reflect.Field;

/**
 * 作者：lixue on 2019/7/16 10:58
 */

public class ReflectTest {
    private static final String TAG = "ReflectTest";

    public static void main(String[] args){
        PrivatePlane privatePlane = new PrivatePlane();
        LogUtil.i(TAG,"-------------反射替换前---------------");
        privatePlane.showMaxSpeed();

        try {
            Field carEnginField = PrivatePlane.class.getDeclaredField("privatePlane");
            carEnginField.setAccessible(true);
            PrivatePlaneEngine privatePlaneEngine = (PrivatePlaneEngine) carEnginField.get(privatePlane);
            carEnginField.set(privatePlane,new ReflectPrivatePlane(privatePlaneEngine));
        }catch (Exception e){
            e.printStackTrace();
        }
        LogUtil.i(TAG,"--------------反射替换后--------------");
        privatePlane.showMaxSpeed();
    }
}
