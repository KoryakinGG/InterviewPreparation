package ru.koryaking.firsthomework.task2;


/**
 * 1. Ошибка № 1: не было написано слово implements в классе Lorry для интерфейсов Moveable, Stopable
 * 2. Ошибка № 2: в классе Lorry не было переопределенного метода open() из абстрактного класса Car
 * 3. Ошибка № 3: не был создан отдельный класс Engine
 * 4. Оптимизация № 1: в LightWeightCar и Lorry использовал getter
 * 5. Оптимизация № 2: перенес методы move()и stop() в абстрактный класс, т.к. мы описываем машину и не описываем вообще какие-то предметы которые умеют ехать и останавливаться.
 */

public class Main {

    public static void main(String[] args) {

        LightWeightCar lightWeightCar = new LightWeightCar();
        lightWeightCar.setColor("черный");
        lightWeightCar.setEngine(new Engine(200, "бензиновый", 12));
        lightWeightCar.setName("Мазератти");

        System.out.println("Данные о машине: " + lightWeightCar.getColor() + " " + lightWeightCar.getName());
        lightWeightCar.open();
        lightWeightCar.move();
        lightWeightCar.stop();

        System.out.println();

        Lorry lorry = new Lorry();
        lorry.setColor("красный");
        lorry.setEngine(new Engine(350, "дизельный", 12));
        lorry.setName("Камаз");
        System.out.println("Данные о машине: " + lorry.getColor() + " " + lorry.getName());
        lorry.open();
        lorry.move();
        lorry.stop();
    }


}
