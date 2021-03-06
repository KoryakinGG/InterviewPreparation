package ru.koryaking.secondhomework.task2;

import java.util.Comparator;

public class BubbleSort<Item extends Comparable> extends Sort {
    private MyArraylist myArraylist;
    private int size;
    private Item[] list;

    public BubbleSort(MyArraylist myArraylist) {
        super(myArraylist);
        this.myArraylist = myArraylist;
        this.size = myArraylist.size();
        this.list = (Item[]) myArraylist.getList();
    }

    public void sort() {
        bubbleSort(Comparator.naturalOrder());
    }

    private void bubbleSort(Comparator comparator) {
        boolean isSwap;
        for (int i = size - 1; i > 0; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
                if (comparator.compare(list[j + 1], list[j]) < 0) {
                    myArraylist.swap(j + 1, j);
                    isSwap = true;
                }
            }
            if (!isSwap) {

                //TODO временно
                //System.out.println("bubbleSort. i: " + i);

                break;
            }
        }
    }
}
