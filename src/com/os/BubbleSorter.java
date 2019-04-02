package com.os;

import java.util.Iterator;

public class BubbleSorter {
    public MyLinkedList<Pokemon> bubbleSort(MyLinkedList<Pokemon> myLinkedList){
        int listSize = myLinkedList.size();

        for (int i = 0; i < listSize; i++) {

            for (int j = 0; j < listSize-1; j++){
                if (myLinkedList.get(j).getData().compareTo(myLinkedList.get(j + 1).getData()) > 0) {
                    myLinkedList.swap(myLinkedList.get(j), myLinkedList.get(j+1));

                }
            }
        }
        return myLinkedList;
    }
    public MyDoublyLinkedList<Pokemon> bubbleSort(MyDoublyLinkedList<Pokemon> myLinkedList){
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



    public Stack<Pokemon> bubbleSort(Stack<Pokemon> stack) {

        //sorted stack which will be altered with a min elements one by one
        Stack<Pokemon> sorted = new Stack<>();

        int size = stack.size();

        for (int i=0; i<size;i++)
        {
            Iterator<Pokemon> iterator = stack.iterator();
            Pokemon min = iterator.next();

            for (int j = 0; j < stack.size()-1; j++) {  //looking for the minimum
                Pokemon current = iterator.next();

                if (min.compareTo(current) < 0 ) {

                    min = current;

                }

            }
            //min is found

            //copy of the original stack
            Stack<Pokemon> stack1 = new Stack<>();
            for(Pokemon q: stack){
                stack1.push(q);
            }
            //clear of the original stack
            stack.deleteAll();

            //search of the min element by inserting everything that is not the min element back to the stack
            for (Pokemon q : stack1)
            {
                if(q.compareTo(min)==0) {
                    //the elements we're searching for
                }
                else{
                    stack.push(q);
                }
            }

            sorted.push(min);
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
                if(q.compareTo(min)==0){
                    //the elements we're searching for
                }else{
                    queue.insert(q);
                }
            }

            sorted.insert(min);
        }

        return sorted;
    }
}
