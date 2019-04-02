package com.os;

public class BubbleSorter {
    public MyLinkedList<Pokemon> bubbleSort(MyLinkedList<Pokemon> myLinkedList){
        int listSize = myLinkedList.size();

        for (int i = 0; i < listSize-1; i++) {

            for (int j = 0; j < listSize-i-1; j++){
                if (myLinkedList.get(j).getData().compareTo(myLinkedList.get(j + 1).getData()) > 0) {
                    myLinkedList.swap(myLinkedList.get(j), myLinkedList.get(j+1));

                }
            }
        }
        return myLinkedList;
    }
    public MyDoublyLinkedList<Pokemon> bubbleSort(MyDoublyLinkedList<Pokemon> myLinkedList){
        int listSize = myLinkedList.size();
        for (int i = 0; i < listSize-1; i++) {

            for (int j = 0; j < listSize-i-1; j++){
                if (myLinkedList.get(j).getData().compareTo(myLinkedList.get(j + 1).getData()) > 0) {
                    myLinkedList.swapRight(myLinkedList.get(j));

                }
            }
        }
        return myLinkedList;
    }


    //TODO
    public Stack<Pokemon> bubbleSort(Stack<Pokemon> stack) {
        return null;
    }

    //TODO
    public MyQueue<Pokemon> bubbleSort(MyQueue<Pokemon> queue) {
        return null;
    }
}
