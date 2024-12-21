package com.example.Singleton;
//DCL双检锁/双重校验锁（DCL，即 double-checked locking）线程安全，效率高
//* 区别于懒汉的加锁
//* dcl只锁创建单例，不锁获取单例，如果已经创建好了则不会加锁
public class DCL {
    private volatile static DCL instance;
    private DCL(){}
    public  static DCL getInstance(){
        if(null==instance){
            synchronized (DCL.class){
//                区别在于获取到锁是否直接创建实例，如果没有这个if别的线程等待释放锁之后直接创建实例
                if(null==instance){
//                    volatile 作用点
//                    instance= new DCL();其实是分为三步执⾏的：
//                    1. 为 instance 分配内存空间
//                    2. 初始化 instance
//                    3. 将 instance指向分配的内存地址
//                    多线程环境下,指令重排在单线程环境下不会出现问题,但是在多线程环境下会导致⼀个线程获得还没有初始化的实例.
                    instance = new DCL();
                }

            }
        }
        return instance;
    }
}
