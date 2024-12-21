package com.example.juc;
/*
volatile可使多线程下的可见性，但不具有原子性
volatile禁止指令重排
volatile不适合以下代码场景
*/
public class VolatileTest {
    public static volatile int inc = 0;
//    public static  int inc = 0;
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    inc++;
                    System.out.println("Thread: "+Thread.currentThread().getId()+" inc: " + inc);
                }
            });
            thread.start();
        }
    }

//    public void increase() {
//        inc++;
//        System.out.println(inc);
//    }
//
//    public static void main(String[] args) {
//        final Volatile test = new Volatile();
//        for (int i = 0; i < 15; i++) {
//            new Thread() {
//                public void run() {
//                    for (int j = 0; j < 10; j++)
//                        test.increase();
//
//                }
//            }.start();
//        }
//    }
}

