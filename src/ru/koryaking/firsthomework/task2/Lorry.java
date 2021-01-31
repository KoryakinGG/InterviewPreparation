package ru.koryaking.firsthomework.task2;

public class Lorry extends Car {
    @Override
    public void move(){
        System.out.println(getName() + " is moving");
    }
    @Override
    public void stop(){
        System.out.println(getName() + " is stop");
    }
    @Override
    void open() {
        System.out.println(getName() + " is open");
    }

}
