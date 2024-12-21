package com.example.Singleton;
//饿汉(线程安全)
//在类加载时按需加载,单例在类加载时实例化一个对象交给自己的引用,在线程访问单例之前就已经创建好
public class Hunger {
    private static Hunger instance = new Hunger();
    private Hunger(){}
    public static  Hunger getInstance(){
        return instance;
    }
}
