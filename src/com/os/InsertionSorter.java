package com.os;

public class InsertionSorter {
    MyLinkedList<Pokemon> test = new MyLinkedList<>();

    public MyLinkedList<Pokemon> insertionSort(MyLinkedList<Pokemon> list) {
        int n = list.size();
        for(int i = 1; i < n; n++) {
            Pokemon key = list.get(i).getData();
            int j = i - 1;

//            while (j >= 0 && list.get(j).getData() > key) {
//                list.get(j + 1) = list.get(j);
//                //list.set(j + 1, list.get(j).getData());
//                j = j - 1;
//            }
//            list.get(j + 1) = key;

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

    private boolean isGreaterThanFirst(Pokemon p1, Pokemon p2) {
        int diff = p1.getName().charAt(0) - p2.getName().charAt(0);
        if(diff > 0) {
            return true;
        }
        return false;
    }



}
