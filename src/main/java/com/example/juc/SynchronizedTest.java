package com.example.juc;

public class SynchronizedTest {

    private static  int inc = 0;

    private static synchronized void increase() {
        inc++;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    increase();
                    System.out.println("Thread: " + Thread.currentThread() + " inc : " + inc);
                }
            });
            thread.start();
        }

    }
}
