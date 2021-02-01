package ru.koryaking.firsthomework.task2;

public class LightWeightCar extends Car implements Moveable, Started, Stopable {

    @Override
    void open() {
        System.out.println(getName() + " is open");
    }

    @Override
    public void move() {
        System.out.println(getName() + " is moving");
    }

    @Override
    public void stop() {
        System.out.println(getName() + " is stop");
    }

    @Override
    public void start() { System.out.println(getName() + " is start"); }
}
