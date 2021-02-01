package ru.koryaking.firsthomework.task2;


/**
 * 1. Ошибка № 1: не было написано слово implements в классе Lorry для интерфейсов Moveable, Stopable
 * 2. Ошибка № 2: в классе Lorry не было переопределенного метода open() из абстрактного класса Car
 * 3. Ошибка № 3: не был создан отдельный класс Engine
 * 4. Оптимизация № 1: в LightWeightCar и Lorry использовал getter
 * 5. Оптимизация № 2: добавил интерфейс для старта машины
 * 6. Оптимизация № 3: разделил класс Engine на 2 класса для каждой машины
 * 7. Оптимизация № 4: Возможно нужно сделать фабрику для класса Car?
 */

public class Main {

    public static void main(String[] args) {

        LightWeightCar lightWeightCar = new LightWeightCar();
        lightWeightCar.setColor("черный");
        lightWeightCar.setEngine(new EngineLightWeightCar(200, "бензиновый", 8));
        lightWeightCar.setName("Мазерати");

        System.out.println("Данные о машине: " + lightWeightCar.getColor() + " " + lightWeightCar.getName());
        lightWeightCar.open();
        lightWeightCar.start();
        lightWeightCar.move();
        lightWeightCar.stop();

        System.out.println();

        Lorry lorry = new Lorry();
        lorry.setColor("красный");
        lorry.setEngine(new EngineLorry(350, "дизельный", 12));
        lorry.setName("Камаз");
        System.out.println("Данные о машине: " + lorry.getColor() + " " + lorry.getName());
        lorry.open();
        lorry.start();
        lorry.move();
        lorry.stop();
    }
}
