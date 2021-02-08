package ru.koryaking.secondhomework.task1;

public class TestMyLinkedList {

    MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();

    void run() {
    test1();
    test2();
    test3();
    test4();
    test5();

    }

    private void test1() {
        System.out.println("Добавляем 3 элемента в начало списка");
        myLinkedList.addToTop(1);
        myLinkedList.addToTop(2);
        myLinkedList.addToTop(3);

        myLinkedList.display();
        System.out.println("Размер списка: " + myLinkedList.getSize());
    }

    private void test2() {
        System.out.println("Добавляем 2 элемента в конец списка");
        myLinkedList.addToTheEnd(4);
        myLinkedList.addToTheEnd(5);

        myLinkedList.display();
        System.out.println("Размер списка: " + myLinkedList.getSize() + "\n");
    }

    private void test3() {
        System.out.println("Удаляем элемент под индексом 2");
        myLinkedList.removeElement(2);

        myLinkedList.display();
        System.out.println("Размер списка: " + myLinkedList.getSize() + "\n");
    }

    private void test4() {
        System.out.println("Удаляем 1-ый элемент");
        myLinkedList.removeTheFirstElement();

        myLinkedList.display();
        System.out.println("Размер списка: " + myLinkedList.getSize() + "\n");
    }

    private void test5() {
        System.out.println("Удаляем последний элемент");
        myLinkedList.removeTheLastElement();

        myLinkedList.display();
        System.out.println("Размер списка: " + myLinkedList.getSize() + "\n");
    }
}


