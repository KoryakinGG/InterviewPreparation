package ru.koryaking.firsthomework.task3;

public class Triangle extends Figure{

    private double footing;
    private double height;
    private double leftSide;
    private double rightSide;

    public Triangle(double footing, double height, double leftSide, double rightSide) {
        this.footing = footing;
        this.height = height;
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    @Override
    public double area() {
        return 0.5*footing*height;
    }

    @Override
    public double perimeter() {
        return footing+leftSide+rightSide;
    }
}
