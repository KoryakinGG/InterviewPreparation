package ru.koryaking.secondhomework.task1;

/*
Реализовать основные методы связанного списка.
 */

public class MyLinkedList<E> implements LinkedList<E> {

    protected int size;
    protected Node<E> firstElement;
    protected Node<E> lastElement;


    @Override
    public void addToTop(E value) {
        Node <E> newNode = new Node<>(value, firstElement, null);
        firstElement = newNode;
        size++;
    }

    @Override
    public void addToTheEnd(E value) {
        Node <E> newNode = new Node<>(value, null, lastElement);
        if (isEmpty()) {
            firstElement = newNode;
        } else {
            Node temp = firstElement;
            while (temp.getNext() != null) {
                temp = temp.getNext();

            }
            temp.setNext(newNode);
            size++;
        }
    }

    @Override
    public E getElement(int index) {
        int currentIndex = 0;
        Node <E> temp = firstElement;
        while (temp != null) {
            if (currentIndex == index) {
                return temp.getItem();
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public E getElement(E value) {
        Node <E> temp = firstElement;
        while (temp != null) {
            if (temp.getItem().equals(value)) {
                return temp.getItem();
            }
            temp = temp.getNext();
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void removeElement(int index) {
        int currentIndex = 0;
        Node <E> temp = firstElement;
        if (index == 0) {
            firstElement = firstElement.getNext();
            size--;
        }
        while (temp != null) {
            if (currentIndex == index - 1) {
                temp.setNext(temp.getNext().getNext());
                size--;
            }
            temp = temp.getNext();
            currentIndex++;
        }
        return;
    }

    @Override
    public void removeElement(E value) {
        if (isEmpty()) {
            return;
        }
        Node <E> temp = firstElement;
        while (temp != null) {
            if (temp.getItem() == value) {
                temp = temp.getNext().getNext();
                size--;
            } else {
                temp = temp.getNext();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void removeTheLastElement() {
        Node <E> temp = firstElement;
        while (temp != null){
           if (temp.getNext().getNext() == null){
               temp.setNext(lastElement);
               size--;
               return;
           }else {
            temp = temp.getNext();}
        }
    }

    @Override
    public void removeTheFirstElement() {
        firstElement = firstElement.getNext();
        size--;
    }

    @Override
    public boolean contains(E value) {
        Node<E> temp = firstElement;
        while (temp != null) {
            if (temp.getItem().equals(value)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public void display() {
        System.out.println("-----------");
        Node <E> current = firstElement;
        while (current != null) {
            System.out.print(current.getItem() + " ");
            current = current.getNext();
        }
        System.out.println();
        System.out.println("-----------");
    }

    @Override
    public E getFirst() {
        return firstElement.getItem();
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            return null;
        }
        Node temp = firstElement;
        while (temp != null) {
            if (temp.getNext() == null) {
                lastElement = temp;
            }
            temp = temp.getNext();
        }
        return lastElement.getItem();
    }


}

