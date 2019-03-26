package com.os;

import java.io.IOException;

public class MyLinkedList<T>{
    private Node head;
    private Node tail;
    private int size = 0;

    public void testFind(){
        MyLinkedList a = new MyLinkedList<>();
        a.add(0);
        a.add(1);
        Node n1 = a.get(0);
        System.out.println(a.find(n1));
    }
    public void testSwapRight(){
        MyLinkedList a = new MyLinkedList<>();
        a.add(0);
        a.add(1);
        Node n0 = a.get(0);
        Node n1 = a.get(1);
        a.swapRight(n0);
        a.swapRight(n1);
        System.out.println(n0);
    }

    public void testSwap(){
        MyLinkedList a = new MyLinkedList<>();
        a.add(0);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        Node n0 = a.get(0);
        Node n1 = a.get(1);
        a.swap(n0,n1);
        System.out.println(n0);
    }

    public void swapRight(Node node){
        if (node.next == null || size < 2)
            return;
        Node nodeRight = node.next;
        Node nodeRihgtNext = nodeRight.next;
        if(node != head){
            Node nodeRightNext = nodeRight.next;
            Node nodeLeft = get(find(node)-1);
            nodeLeft.next = nodeRight;
            nodeRight.next = node;
            node.next = nodeRightNext;
        } else {
            Node oldHead = head;
            head = nodeRight;
            head.next = oldHead;
            oldHead.next = nodeRihgtNext;
        }
    }

    public void swap(Node node, Node node1){
        int nodeIndex = find(node);
        int node1Index = find(node1);
        int difference = nodeIndex > node1Index? nodeIndex-node1Index:node1Index-nodeIndex;
        if(difference > 1){

            if(node == head){
                Node node1Left = get(node1Index-1);
                Node node1Right = get(node1Index+1);
                Node nodeRight = get(nodeIndex+1);

                head = node1;
                head.next = nodeRight;
                node1Left.next = node;
                node.next = node1Right;
            } else if (node1 == head){
                Node node1Right = get(node1Index+1);
                Node nodeLeft = get(nodeIndex-1);
                Node nodeRight = get(nodeIndex+1);
                head = node;
                head.next = node1Right;
                nodeLeft.next = node1;
                node1.next = nodeRight;
            } else {
                Node node1Right = get(node1Index+1);
                Node node1Left = get(node1Index-1);
                Node nodeRight = get(nodeIndex+1);
                Node nodeLeft = get(nodeIndex-1);

                nodeLeft.next = node1;
                node1.next = nodeRight;

                node1Left.next = node;
                node.next = node1Right;
            }

        } else {
            if(nodeIndex > node1Index){
                swapRight(node1);
            } else{
                swapRight(node);
            }
        }
    }

    public MyLinkedList() {
        head = null;
    }

    public MyLinkedList(T head) {
        this.head = new Node(head);
    }

    public Node get(int index){
        if(index > size-1){
            return null;
        }
        Node node = head;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    public int find(Node target){
        int index = 0;
        Node node = head;
        while (node != null){
            if (node.equal(target)) {
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    // Adds an element to the end
    public boolean add(T data){
        if (data == null){
            return false;
        } else {
            if(head == null){
                head = new Node(data);
                tail = head;
                size++;
                return true;
            } else{
                tail.next = new Node(data);
                tail = tail.next;
                size++;
                return true;
            }
        }
    }
    public int size(){
        return size;
    }
    public class Node{
        private T data;
        private Node next;

        public Node(T data){
            this.data = data;
        }

        public Node(){
            this.data = null;
        }

        public Node(T data, Node next){
            this.data = data;
            this.next = next;
        }

        public T getData(){
            return data;
        }

        boolean equal(Node element) {
            return data.equals(element.data);
        }


    }
}
