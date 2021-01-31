package ru.koryaking.firsthomework.task3;

public class Square extends Figure{

    private double footing;

    @Override
    public double area() {
        return footing*footing;
    }

    @Override
    public double perimeter() {
        return 4*footing;
    }
}
