package com.os;

import java.util.Iterator;
/**
 *
 * The following class contains a bubble sorting algorithms for 4 different data structures:
 * LinkedList
 * DoublyLinkedList
 * Stack
 * Queue
 *
 * All of the methods have the same name, and are overloaded
 */
public class BubbleSorter {
    public MyLinkedList<Pokemon> bubbleSort(MyLinkedList<Pokemon> list){

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
    public MyDoublyLinkedList<Pokemon> bubbleSort(MyDoublyLinkedList<Pokemon> myDoublyLinkedList){
        int listSize = myDoublyLinkedList.size();
        for (int i = 0; i < listSize; i++) {

            for (int j = 0; j < listSize-1; j++){
                if (myDoublyLinkedList.get(j).getData().compareTo(myDoublyLinkedList.get(j + 1).getData()) > 0) {
                    myDoublyLinkedList.swapRight(myDoublyLinkedList.get(j));

                }
            }
        }
        return myDoublyLinkedList;
    }



    public Stack<Pokemon> bubbleSort(Stack<Pokemon> stack) {

        //sorted stack which will be altered with a min elements one by one
        Stack<Pokemon> sorted = new Stack<>();

        int size = stack.size();

        for (int i = 0; i < size; i++) {
            Iterator<Pokemon> iterator = stack.iterator();
            if(iterator.hasNext()) {
            Pokemon min = iterator.next();

            for (int j = 0; j < stack.size() - 1; j++) {  //looking for the minimum
                Pokemon current = iterator.next();

                if (min.compareTo(current) < 0) {

                    min = current;

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
                if (q == min) {
                    //the elements we're searching for
                } else {
                    stack.push(q);
                }
            }

            sorted.push(min);
        }
    }

        return sorted;
    }


    public MyQueue<Pokemon> bubbleSort(MyQueue<Pokemon> queue) {

        //sorted queue which will be altered with a min elements one by one
        MyQueue<Pokemon> sorted = new MyQueue<>();

        int size = queue.size();

        for (int i=0; i<size;i++)
        {
            Iterator<Pokemon> iterator = queue.iterator();
            if(iterator.hasNext()) {
                Pokemon min = iterator.next();


                for (int j = 0; j < queue.size()-1; j++) {  //looking for the minimum
                    Pokemon current = iterator.next();

                    if (min.compareTo(current) >= 1 ) {

                        min = current;

                    }

                }
            //min is found

            //copy of the original queue
            MyQueue<Pokemon> queue1 = new MyQueue<>();
            for(Pokemon q: queue){
                queue1.insert(q);
            }
            //clear of the original queue
            queue.deleteAll();

            //search of the min element by inserting everything that is not the min element back to the queue
            for (Pokemon q : queue1)
            {
                if(q == min){
                    //the elements we're searching for
                }else{
                    queue.insert(q);
                }
            }

            sorted.insert(min);
        }

        }

        return sorted;
    }
}
