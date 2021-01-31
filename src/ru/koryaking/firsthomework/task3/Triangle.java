package ru.koryaking.firsthomework.task3;

public class Triangle extends Figure{

    private double footing;
    private double height;
    private double leftSide;
    private double rightSide;


    @Override
    public double area() {
        return 1/2*footing*height;
    }

    @Override
    public double perimeter() {
        return footing+leftSide+rightSide;
    }
}
