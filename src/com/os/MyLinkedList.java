package com.os;

import java.io.IOException;

public class MyLinkedList<T> {
    private Node head;
    private Node tail;
    public int size = 0;
    public static void main(String[] args) throws IOException {
        MyLinkedList a = new MyLinkedList<>();
        a.testSwap();
    }

    public void testFind(){
        MyLinkedList a = new MyLinkedList<>();
        a.add(0);
        a.add(1);
        Node n1 = a.get(0);
        System.out.println(a.find(a.get(0), n1));
    }
    public void testSwap(){
        MyLinkedList a = new MyLinkedList<>();
        a.add(0);
        a.add(1);
        Node n0 = a.get(0);
        Node n1 = a.get(1);
        a.swapRight(n0);
        a.swapRight(n1);
        System.out.println(find(a.get(0),n0));
    }
    public void swapRight(Node node){
        if (node.next == null || size < 2)
            return;
        Node nodeRight = node.next;
        if(node != head){
            Node nodeLeft = get(find(head, node)-1);
            nodeLeft.next = nodeRight;
            nodeRight.next = node;
        } else {
            Node oldHead = head;
            head = nodeRight;
            head.next = oldHead;
            oldHead.next = nodeRight.next;
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

    public int find(Node head, Node target){
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
