package com.example.Singleton;
//懒汉式(非线程安全)
public class Lazy {
    private static Lazy instance;
    private Lazy(){}
//    线程安全
//    public static synchronized  Lazy getInstance(){
    public static Lazy getInstance(){
        if(null == instance){
            instance = new Lazy();
        }
        return instance;
    }
}
