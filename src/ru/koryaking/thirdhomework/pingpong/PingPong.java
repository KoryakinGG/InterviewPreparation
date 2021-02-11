package ru.koryaking.thirdhomework.pingpong;

public class PingPong {
    static volatile String str = "ping";
    public static void main(String[] args) {
        Object lock = new Object();
        class MyClass implements Runnable {
            private String item;
            private String nextItem;
            public MyClass(String item, String nextItem) {
                this.item = item;
                this.nextItem = nextItem;
            }
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 5; i++) {
                        try {
                            while (str != item) {
                                lock.wait();
                            }
                            System.out.println(item);
                            str = nextItem;
                            lock.notify();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    new Thread(new MyClass("ping", "pong")).start();
    new Thread(new MyClass("pong", "ping")).start();
    }
}
