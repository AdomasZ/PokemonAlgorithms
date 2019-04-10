package com.os;

public class MyDoublyLinkedList<T>{
    private DoubleNode head;
    private DoubleNode tail;
    private int size = 0;

    public void swapRight(DoubleNode nodeLeft){
        DoubleNode nodeRight = nodeLeft.next;
        if ( nodeLeft.prev != null ){
            nodeLeft.prev.next = nodeRight;
        }
        else {
            head = nodeRight;
        }

        if ( nodeRight.next != null ){
            nodeRight.next.prev = nodeLeft;
        }
        nodeLeft.next  = nodeRight.next;
        nodeRight.prev = nodeLeft.prev;
        nodeRight.next = nodeLeft;
        nodeLeft.prev = nodeRight;
    }

    public void swap(DoubleNode nodeLeft, DoubleNode nodeRight){
        if ( nodeLeft.prev != null ){
            nodeLeft.prev.next = nodeRight;
        }
        else {
            head = nodeRight;
        }
        if ( nodeRight.next != null ){
            nodeRight.next.prev = nodeLeft;
        }
        nodeLeft.next  = nodeRight.next;
        nodeRight.prev = nodeLeft.prev;
        nodeRight.next = nodeLeft;
        nodeLeft.prev = nodeRight;
    }

    public MyDoublyLinkedList() {
        head = null;
    }

    public MyDoublyLinkedList(T head) {
        this.head = new DoubleNode(head);
    }

    public DoubleNode get(int index){
        if(index >= size){
            return null;
        }
        DoubleNode node = head;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    public void printList(){
        DoubleNode node = head;
        while (node != null){
            System.out.println(node.getData().toString());
            node = node.next;
        }
    }

    public int find(T target){
        int index = 0;
        DoubleNode node = head;
        while (node != null){
            if (((Comparable)node.getData()).compareTo(target) == 0) {
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
                head = new DoubleNode(data);
                tail = head;
                size++;
                return true;
            } else{
                tail.next = new DoubleNode(data, tail);
                tail = tail.next;
                size++;
                return true;
            }
        }
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        String returnString = "";
        for(int i = 0; i < size(); i++) {
            returnString += get(i).data + "\n";
        }
        return returnString;
    }

    public class DoubleNode {
        private T data;
        public DoubleNode next;
        public DoubleNode prev;

        public DoubleNode(T data){
            this.data = data;
        }
        public void setData(T data){
            this.data = data;
        }
        public DoubleNode(){
            this.data = null;
        }

        public DoubleNode(T data, DoubleNode next, DoubleNode prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public DoubleNode(T data, DoubleNode prev){
            this.data = data;
            this.prev = prev;
        }

        public T getData(){
            return data;
        }

        boolean equal(DoubleNode element) {
            return data.equals(element.data);
        }
    }
}
