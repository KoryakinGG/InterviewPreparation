package ru.koryaking.secondhomework.task1;

public interface LinkedList<E> {

    void addToTop(E value);

    void addToTheEnd(E value);

    E getElement(int index);

    E getElement(E value);

    void removeElement(int index);

    void removeElement(E value);

    void removeTheLastElement();

    void removeTheFirstElement();

    boolean contains(E value);

    int getSize();

    boolean isEmpty();

    void display();

    E getFirst();

    E getLast();


}
