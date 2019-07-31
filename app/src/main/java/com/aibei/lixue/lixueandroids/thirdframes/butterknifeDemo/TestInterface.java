package com.aibei.lixue.lixueandroids.thirdframes.butterknifeDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：lixue on 2019/7/24 10:27
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestInterface {
    int value() default 100;
}
