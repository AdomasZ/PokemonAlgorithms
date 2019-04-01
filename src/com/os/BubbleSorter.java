package com.os;

public class BubbleSorter {
    public MyLinkedList<Pokemon> bubbleSort(MyLinkedList<Pokemon> myLinkedList){
        int listSize = myLinkedList.size();
        boolean didSwap;
        for (int i = 0; i < listSize-1; i++) {
            didSwap = false;
            // The highest element always ends up at the end of the list after a pass. After every pass and element put in its place at the end to the list.
            // That's why evey time we check one element less.
            for (int j = 0; j < listSize-i-1; j++){
                if (myLinkedList.get(j).getData().compareTo(myLinkedList.get(j + 1).getData()) > 0) {
                    myLinkedList.swap(myLinkedList.get(j), myLinkedList.get(j+1));
                    didSwap= true;
                }
            }
            if(!didSwap){
                break;
            }
        }
        return myLinkedList;
    }
    public MyDoublyLinkedList<Pokemon> bubbleSort(MyDoublyLinkedList<Pokemon> myLinkedList){
        int listSize = myLinkedList.size();
        boolean didSwap;
        for (int i = 0; i < listSize-1; i++) {
            didSwap = false;
            // The highest element always ends up at the end of the list after a pass. After every pass and element put in its place at the end to the list.
            // That's why evey time we check one element less.
            for (int j = 0; j < listSize-i-1; j++){
                if (myLinkedList.get(j).getData().compareTo(myLinkedList.get(j + 1).getData()) > 0) {
                    myLinkedList.swapRight(myLinkedList.get(j));
                    didSwap = true;
                }
            }
            if(!didSwap){
                break;
            }
        }
        return myLinkedList;
    }

}
