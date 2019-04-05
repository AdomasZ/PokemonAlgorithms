package com.os;

public class InsertionSorter {
    MyLinkedList<Pokemon> test = new MyLinkedList<>();

    public MyLinkedList<Pokemon> insertionSort(MyLinkedList<Pokemon> list) {
        int n = list.size();
        for(int i = 1; i < n; n++) {
            Pokemon key = list.get(i).getData();
            int j = i - 1;

//            while (j >= 0 && list.get(j) > key) {
//                list.get(j + 1) = list.get(j);
//                j = j - 1;
//            }
//            arr[j + 1] = key;

        }
        insertionSort(list);
        return list;
    }

    //TODO
    public MyDoublyLinkedList insertionSort(MyDoublyLinkedList<Pokemon> list) {
        return null;
    }

    //TODO
    public Stack<Pokemon> insertionSort(Stack<Pokemon> stack) {
        return null;
    }

    //TODO
    public MyQueue<Pokemon> insertionSort(MyQueue<Pokemon> queue) {
        return null;
    }




}
