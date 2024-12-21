package com.example.DeadLock;

public class Deadlock {
    private Object lockA = new Object();
    private Object lockB = new Object();

    public void execute(){
        new Thread(()->{
            System.out.println("Thread A running");
            synchronized (lockA){
                System.out.println("Thread A get lockA");
                try {
                    Thread.sleep(1000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (lockB){
                    System.out.println("Thread A get lockB");
                }

            }

        },"Thread A").start();
        new Thread(()->{
            System.out.println("Thread B running");
            synchronized (lockB){
                System.out.println("Thread B get lockB");
                try {
                    Thread.sleep(1000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (lockA){
                    System.out.println("Thread B get lockA");
                }

            }

        },"Thread B").start();

    }
}
