package com.example.juc;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private static int inc = 0;
    private static ReentrantLock lock = new ReentrantLock();
    private static void increase(){
        lock.lock();
        try {
            inc++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    increase();
                    System.out.println("Thread: " + Thread.currentThread() + " inc : " + inc);
                }
            });
            thread.start();
        }
    }

}
