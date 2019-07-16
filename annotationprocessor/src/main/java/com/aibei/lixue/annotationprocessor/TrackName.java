package com.aibei.lixue.annotationprocessor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：lixue on 2019/7/12 11:50
 */
//retention作用时机及生成的文件的保留时间，class会被保留在class文件中，但是在运行时期就不会识别这个注解，用于辅助代码，
//辅助代码，辅助代码生成之后，该注解的任务就结束了。如ARouter ButterKnife等
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)//target定义所修饰的对象范围；ElementType.TYPE用于描述类、接口(包括注解类型) 或enum声明
public @interface TrackName {
    String name() default "";
}
