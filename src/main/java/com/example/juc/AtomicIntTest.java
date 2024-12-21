package com.example.juc;

import java.util.concurrent.atomic.AtomicInteger;

/*
Atomic原子类保证可见性与原子性,线程安全
适合以下代码场景
*/
public class AtomicIntTest {
    private static AtomicInteger inc = new AtomicInteger();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    inc.getAndIncrement();
                    System.out.println("Thread: " + Thread.currentThread() + " inc: " + inc);
                }
            });
            thread.start();
        }
    }

}
