package ru.koryaking.thirdhomework.counter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class CounterMain {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        AtomicInteger atomicInteger = new AtomicInteger(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <5; i++) {
                    reentrantLock.lock();
                    atomicInteger.incrementAndGet();
                    System.out.println(atomicInteger);
                    reentrantLock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <5; i++) {
                    reentrantLock.lock();
                    atomicInteger.incrementAndGet();
                    System.out.println(atomicInteger);
                    reentrantLock.unlock();
                }
            }
        }).start();
    }
}



