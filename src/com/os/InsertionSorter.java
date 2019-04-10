package com.os;

import java.util.Iterator;

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

                //copy of the original queue
                Stack<Pokemon> tstack = new Stack<>();
                for (Pokemon s : stack) {
                    tstack.push(s);
                }
                //clear of the original queue
                stack.deleteAll();

                //search of the min element by inserting everything that is not the min element back to the queue
                for (Pokemon s : tstack) {
                    if (s.compareTo(min) == 0) {
                        //the elements we're searching for
                    } else {
                        stack.push(s);
                    }
                }

                sorted.push(min);
            }
        }
        return sorted;
    }

    public MyQueue<Pokemon> insertionSort(MyQueue<Pokemon> queue) {

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
