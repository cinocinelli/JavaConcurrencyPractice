package com.example.juc;

public class TheadLocalTest {

    private static ThreadLocal<String> local = new ThreadLocal<String>();

    public static void main(String[] args) {

        Thread thread1 = new Thread(()->{
            local.set("t1");
            System.out.println(Thread.currentThread().getName() + " local: "+ local.get());
            },"thread 1");
        Thread thread2 = new Thread(()->{
            local.set("t2");
            System.out.println(Thread.currentThread().getName() + " local: "+ local.get());
        },"thread 2");
        thread1.start();
        thread2.start();
    }


}
