package ru.koryaking.firsthomework.task2;

public abstract class Car {
    private AbstractEngine abstractEngine;
    private String color;
    private String name;

    abstract void open();

    public AbstractEngine getEngine() {
        return abstractEngine;
    }

    public void setEngine(AbstractEngine abstractEngine) {
        this.abstractEngine = abstractEngine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
