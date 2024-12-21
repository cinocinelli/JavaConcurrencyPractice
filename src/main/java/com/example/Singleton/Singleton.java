package com.example.Singleton;
//静态内部类实现
//静态内部类不会随着外部类的加载而加载 ，只有静态内部类的静态成员被调用时才会进行加载 , 这样既保证了惰性初始化，又由JVM保证了多线程并发访问的正确性
public class Singleton {
    private static class SingletonHolder{
        private static final Singleton instance = new Singleton();
    }
    private Singleton(){}
    public static final Singleton getInstance(){
        return SingletonHolder.instance;
    }
}
