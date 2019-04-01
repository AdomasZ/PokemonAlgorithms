package com.os;

import java.util.*;

public class MyQueue<Item> implements Iterable<Item> {
    private Node top, bottom; //begin and end nodes
    private int size; // number of items

    //nested class to define node
    private class Node
    {
        Item item;
        Node next;
    }

    //Zero argument constructor
    public MyQueue()
    {
        top = null;
        bottom = null;
        size = 0;
    }


    public boolean isEmpty()
    {
        return (size == 0);
    }

    //Remove item from the top of the queue.
    public Item delete()
    {
        Item item = top.item;
        top = top.next;
        if (isEmpty())
        {
            bottom = null;
        }
        size--;
        return item;
    }

    public Item peek() {
        return top.item;
    }


    public void deleteAll()
    {
        while(!isEmpty()){
            delete();
        }
    }

    //Add item to the end of the list.
    public void insert(Item item)
    {
        Node oldbottom = bottom;
        bottom = new Node();
        bottom.item = item;
        bottom.next = null;
        if (isEmpty())
        {
            top = bottom;
        }
        else
        {
            oldbottom.next = bottom;
        }
        size++;
    }

    public int size()
    {
        return size;
    }

    @Override
    public String toString() {
        String returnString = "";
        Iterator<Item> it = iterator();
        while(it.hasNext()) {
            returnString += it.next().toString() + "\n";
        }
        return returnString;
    }

    //Iterator for traversing queue items
    public Iterator<Item> iterator()
    {
        return new MyQueueIterator();
    }

    //inner class to implement iterator interface
    private class MyQueueIterator implements Iterator <Item>
    {
        private int i = size;
        private Node first = top; //the first node

        public boolean hasNext()
        {
            return (i > 0);
        }

        public Item next()
        {
            Item item = first.item;
            first = first.next;
            i--;
            return item;
        }

        public void remove()
        {
            // not needed
        }
    }


}
