package com.os;

public class InsertionSorter {
    MyLinkedList<Pokemon> test = new MyLinkedList<>();

    public MyLinkedList<Pokemon> insertionSort(MyLinkedList<Pokemon> list) {
        int n = list.size();
        for(int i = 1; i < n; ++i) {
            Pokemon key = list.get(i).getData();
            int j = i - 1;

            while(j >= 0 && list.get(j).getData().compareTo(key) > 0) {
                Pokemon pokemon = list.get(j).getData();
                list.get(j + 1).setData(pokemon);
                j = j - 1;
            }
            list.get(j + 1).setData(key);
        }
        return list;
    }

    //TODO
    public MyDoublyLinkedList insertionSort(MyDoublyLinkedList<Pokemon> list) {
        int n = list.size();
        for(int i = 1; i < n; ++i) {
            Pokemon key = list.get(i).getData();
            int j = i - 1;

            while(j >= 0 && list.get(j).getData().compareTo(key) > 0) {
                Pokemon pokemon = list.get(j).getData();
                list.get(j + 1).setData(pokemon);
                j = j - 1;
            }
            list.get(j + 1).setData(key);
        }
        return list;
    }

    public Stack<Pokemon> insertionSort(Stack<Pokemon> stack) {




        return stack;
    }

    public MyQueue<Pokemon> insertionSort(MyQueue<Pokemon> queue) {
        return null;
    }
}
