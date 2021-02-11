package ru.koryaking.thirdhomework.counter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterMain {

    static class InnerClass {
        public int getCount() {
            return count;
        }

        int count = 0;

        Lock lock;

        public InnerClass(Lock lock) {
            this.lock = lock;
        }

        public void increment () {
            try {
                lock.lock();
                count++;
            } finally {
                lock.unlock();
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        Lock reentrantLock = new ReentrantLock();
        InnerClass innerClass = new InnerClass(reentrantLock);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <5; i++) {
                    innerClass.increment();
                    System.out.println(innerClass.getCount());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <5; i++) {
                    innerClass.increment();
                    System.out.println(innerClass.getCount());
                }
            }
        }).start();
    }
}



