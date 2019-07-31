package com.aibei.lixue.lixueandroids.thirdframes.butterknifeDemo;

import java.lang.reflect.Field;

/**
 * 作者：lixue on 2019/7/24 11:31
 */

public class ReflectMain {
    @TestInterface(12)
    public int age;

    public static void main(String[] args){
        ReflectMain main = new ReflectMain();
        TestInterface testInterface = null;
        try {
            Class clazz = main.getClass();
            Field field = clazz.getField("age");
            testInterface = field.getAnnotation(TestInterface.class);
            System.out.println(testInterface.value());
        } catch (Exception e) {
            System.out.println("no such field");
        }

    }
}
