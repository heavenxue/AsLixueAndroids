package com.aibei.lixue.lixueandroids.Hook;

import com.aibei.lixue.lixuelib.utils.LogUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 作者：lixue on 2019/7/16 11:05
 */

public class PrivatePlaneProxyHandler implements InvocationHandler {
    private static final String TAG = "PrivatePlaneProxyHandle";
    private Object object;

    public PrivatePlaneProxyHandler(Object o){
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("maxSpeed".equals(method.getName())){
            LogUtil.i(TAG,"动态代理，拦截 maxSpeed 方法");
            return 180;
        }
        return method.invoke(object,args);
    }
}
