package ru.koryaking.secondhomework.task2;

import java.util.Comparator;

public class MyArraylist<Item extends Comparable> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private final double DEFAULT_LOAD_FACTOR = 0.75;

    MyArraylist(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        list = (Item[]) new Comparable[capacity];
    }

    public MyArraylist() {
        list = (Item[]) new Comparable[DEFAULT_CAPACITY];
    }


    void add(Item item) {
        //проверяем не превышена ли вместимость и увеличиваем вместимость
        ensureCapacity(list.length, size);
        list[size] = item;
        size++;
    }


    public void add(int index, Item item) {
        //проверяем не превышена ли вместимость и увеличиваем вместимость
        ensureCapacity(list.length, size);
        //если индекс отрицательный, устанавливаем в начало
        if (index < 0) {
            index = 0;
        }
        //если индекс больше размера, устанавливаем на последней не занятой ячейке
        if (index > size) {
            index = size;
        }
        //сдвигаем вправо все элементы правее индекса вставки
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        //вставляем объект
        list[index] = item;
        //инкрементируем значение текущего индекса
        size++;
    }

    public boolean remove(Item item) {
        int i = 0;
        while (i < size && !list[i].equals(item)) {
            i++;
        }
        if (i == size) {
            return false;
        }
        for (int j = i; j < size - 1; j++) {
            list[j] = list[j + 1];
        }
        size--;
        list[size] = null;
        return true;
    }

    public Item get(int index) {
        return list[index];
    }

    public void set(int index, Item item) {
        list[index] = item;
    }

    public int size() {
        return size;
    }

    public boolean find(Item item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    boolean less(Item item1, Item item2) {
        return item1.compareTo(item2) < 0;
    }

    void swap(int index1, int index2) {
        Item temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }


    private void increaseCapacity(int minCapacity){
        //если требуемый размер больше текущего размера массива
        if(minCapacity > list.length){
            //то увеличиваем размер массива на на требуемое значение + вместимость по умолчанию
            createNewArrayInternal(minCapacity);
        }
    }


    private void trimToSize(){
        //если текущий индекс(первая пустая ячейка) меньше размера массива + вместимость по умолчанию
        if(size < (int)(list.length * DEFAULT_LOAD_FACTOR)){
            //то создаем новый массив с новой вместимостью
            createNewArrayInternal((int)(size * DEFAULT_LOAD_FACTOR + DEFAULT_CAPACITY));
        }
    }


    private void ensureCapacity(int minCapacity, int newSize){
        if(minCapacity * DEFAULT_LOAD_FACTOR <= newSize){
            //если близко переполнение, создаем новый массив
            createNewArrayInternal(newSize);

            //TODO временно
            //System.out.println("new list.length: " + list.length);
        }
    }


    private void createNewArrayInternal(int minCapacity){
        Item[] newList = (Item[]) new Comparable[minCapacity + DEFAULT_CAPACITY];
        //копируем содержимое текущего массива в новый массив
        copyArrayInternal(0, minCapacity, newList);
        //присваиваем переменной массива ссылку на новый массив
        list = newList;
    }


    /*private*/ void copyArrayInternal(int startIndex, int bound, Item[] newList){
        //в цикле копируем содержимое текущего массива в новый массив
        for (int i = startIndex; i < bound; i++) {
            newList[i] = list[i];
        }
    }

    /*void cloneArray(Item[] initList, Item[] newList){
        //в цикле копируем содержимое текущего массива в новый массив
        for (int i = 0; i < initList.length; i++) {
            newList.add(initList.get(i));
        }
    }*/

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(list[i]).append(" ");
        }
        return s.toString();
    }

    public Item[] getList() {
        return list;
    }
}

