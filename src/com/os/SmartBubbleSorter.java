package com.os;

public class SmartBubbleSorter {

    //TODO
    public MyLinkedList<Pokemon> smartBubbleSort(MyLinkedList<Pokemon> list) {

        int listSize = list.size();

        for (int i = 0; i < listSize; i++) {

            for (int j = 0; j < listSize-1; j++){
                if (list.get(j).getData().compareTo(list.get(j + 1).getData()) > 0) {
                    list.swap(list.get(j), list.get(j+1));

                }
            }
        }
        return list;
    }

    //TODO
    public MyDoublyLinkedList<Pokemon> smartBubbleSort(MyDoublyLinkedList<Pokemon> myLinkedList)
    {
        int listSize = myLinkedList.size();
        for (int i = 0; i < listSize; i++) {

            for (int j = 0; j < listSize-1; j++){
                if (myLinkedList.get(j).getData().compareTo(myLinkedList.get(j + 1).getData()) > 0) {
                    myLinkedList.swapRight(myLinkedList.get(j));

                }
            }
        }
        return myLinkedList;
    }

    //TODO
    public Stack<Pokemon> smartBubbleSort(Stack<Pokemon> stack) {
        return null;
    }

    //TODO
    public MyQueue<Pokemon> smartBubbleSort(MyQueue<Pokemon> queue) {
        return null;
    }
}
