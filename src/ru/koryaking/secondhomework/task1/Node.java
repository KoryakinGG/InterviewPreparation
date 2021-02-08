package ru.koryaking.secondhomework.task1;

class Node <E> {
    protected E item;
    protected Node<E> next;
    protected Node<E> last;


    public Node(E item, Node<E> next, Node<E> last) {
        this.item = item;
        this.next = next;
        this.last = last;

    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getLast() {
        return last;
    }

    public void setLast(Node<E> last) {
        this.last = last;
    }



}
