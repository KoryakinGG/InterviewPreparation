package ru.koryaking.firsthomework.task3;

public class Circle extends Figure{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return  PI * Math.pow(radius,2);
    }

    @Override
    public double perimeter() {
        return 2*PI*radius;
    }
}
