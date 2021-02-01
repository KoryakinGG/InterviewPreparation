package ru.koryaking.firsthomework.task3;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(12.12);

        System.out.println(circle.area());
        System.out.println(circle.perimeter());

        Square square =new Square(5.1);
        System.out.println(square.area());
        System.out.println(square.perimeter());

        Triangle triangle = new Triangle(12.7, 8, 9, 10);
        System.out.println(triangle.area());
        System.out.println(triangle.perimeter());
    }

}
