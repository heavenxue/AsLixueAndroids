package com.aibei.lixue.lixueandroids.singletonDemo;

/**
 * 作者：lixue on 2019/7/24 18:12
 */

public class SingletonVolatile {
    private static volatile SingletonVolatile instance;
    private SingletonVolatile(){}

    public static SingletonVolatile getInstance(){
        if (instance == null){
            synchronized (SingletonVolatile.class){
                if (instance == null){
                    instance = new SingletonVolatile();
                }
            }
        }
        return instance;
    }
}
