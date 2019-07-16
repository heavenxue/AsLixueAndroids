package com.aibei.lixue.lixueandroids.Hook;

import com.aibei.lixue.lixuelib.utils.LogUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/**
 * 作者：lixue on 2019/7/16 11:08
 */

public class ProxyTest {
    private static final String TAG = "ProxyTest";

    public static void main(String[] args){
        PrivatePlane privatePlane = new PrivatePlane();
        LogUtil.i(TAG,"-----------动态代理替换前----------------");
        privatePlane.showMaxSpeed();

        try {
            Field carEnginField = PrivatePlane.class.getDeclaredField("privatePlaneEngine");
            carEnginField.setAccessible(true);
            PrivatePlane carEngin = (PrivatePlane) carEnginField.get(privatePlane);
            PrivatePlaneEngineInterface carEnginProxy = (PrivatePlaneEngineInterface) Proxy.newProxyInstance(PrivatePlaneEngine.class.getClassLoader(),
                    new Class[]{PrivatePlaneEngineInterface.class},
                    new PrivatePlaneProxyHandler(carEngin));
            carEnginField.set(privatePlane,carEnginProxy);
            LogUtil.i(TAG,"-----------动态代理替换后----------------");
            carEngin.showMaxSpeed();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
