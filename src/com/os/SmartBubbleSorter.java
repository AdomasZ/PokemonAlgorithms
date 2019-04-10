package com.os;

import java.util.Iterator;

public class SmartBubbleSorter {


    public MyLinkedList<Pokemon> smartBubbleSort(MyLinkedList<Pokemon> list) {

        int listSize = list.size();
        boolean didSwap = false;
        for (int i = 0; i < listSize - 1; i++) {
            didSwap = false;
            for (int j = 0; j < listSize-1-i; j++){
                if (list.get(j).getData().compareTo(list.get(j + 1).getData()) > 0) {
                    list.swap(list.get(j), list.get(j+1));
                    didSwap = true;
                }
            }
            if(!didSwap){
                break;
            }
        }
        return list;
    }


    public MyDoublyLinkedList<Pokemon> smartBubbleSort(MyDoublyLinkedList<Pokemon> myLinkedList)
    {
        int listSize = myLinkedList.size();

        boolean didSwap = false;
        for (int i = 0; i < listSize - 1; i++) {
            didSwap = false;
            for (int j = 0; j < listSize-1-i; j++){
                if (myLinkedList.get(j).getData().compareTo(myLinkedList.get(j + 1).getData()) > 0) {
                    myLinkedList.swap(myLinkedList.get(j), myLinkedList.get(j + 1));
                    didSwap = true;
                }
            }
            if(!didSwap){
                break;
            }
        }
        return myLinkedList;
    }


    public Stack<Pokemon> smartBubbleSort(Stack<Pokemon> stack) {

        //sorted stack which will be altered with a min elements one by one
        Stack<Pokemon> sorted = new Stack<>();

        int size = stack.size();

        for (int i=0; i<size-1;i++) {
            Iterator<Pokemon> iterator = stack.iterator();

            boolean isSwaped = false;
                Pokemon min = iterator.next();
                for (int j = 0; j < stack.size() - 1 - i; j++) {  //looking for the minimum
                    Pokemon current = iterator.next();

                    if (min.compareTo(current) < 0) {

                        min = current;

                        isSwaped = true;

                    }

                }
                //min is found


                //copy of the original stack
                Stack<Pokemon> stack1 = new Stack<>();
                for (Pokemon q : stack) {
                    stack1.push(q);
                }
                //clear of the original stack
                stack.deleteAll();

                //search of the min element by inserting everything that is not the min element back to the stack
                for (Pokemon q : stack1) {
                    if (q.compareTo(min) == 0) {
                        //the elements we're searching for
                    } else {
                        stack.push(q);
                    }
                }

                sorted.push(min);
                if (!isSwaped) {
                    break;
                }
            }

        return sorted;
    }


    public MyQueue<Pokemon> smartBubbleSort(MyQueue<Pokemon> queue) {

        //sorted queue which will be altered with a min elements one by one
        MyQueue<Pokemon> sorted = new MyQueue<>();

        int size = queue.size();

        for (int i=0; i<size;i++) {
            Iterator<Pokemon> iterator = queue.iterator();
            if (iterator.hasNext()) {
                Pokemon min = iterator.next();

                for (int j = 0; j < queue.size() - 1; j++) {  //looking for the minimum
                    Pokemon current = iterator.next();

                    if (min.compareTo(current) >= 1) {

                        min = current;

                    }

                }
                //min is found

                //copy of the original queue
                MyQueue<Pokemon> queue1 = new MyQueue<>();
                for (Pokemon q : queue) {
                    queue1.insert(q);
                }
                //clear of the original queue
                queue.deleteAll();

                //search of the min element by inserting everything that is not the min element back to the queue
                for (Pokemon q : queue1) {
                    if (q.compareTo(min) == 0) {
                        //the elements we're searching for
                    } else {
                        queue.insert(q);
                    }
                }

                sorted.insert(min);
            }
        }

        return sorted;
    }
}
