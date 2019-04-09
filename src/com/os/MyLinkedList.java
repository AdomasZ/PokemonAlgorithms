package com.os;

public class MyLinkedList<T>{
    private Node head;
    private Node tail;
    private int size = 0;


    public void swapRight(Node node){
        if (node.next == null || size < 2)
            return;
        Node nodeRight = node.next;
        Node nodeRihgtNext = nodeRight.next;
        if(node != head){
            Node nodeRightNext = nodeRight.next;
            Node nodeLeft = get(find(node.getData())-1);
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
        int nodeIndex = find(node.getData());
        int node1Index = find(node1.getData());
        int difference = nodeIndex > node1Index? nodeIndex-node1Index:node1Index-nodeIndex;
        if(difference > 1){
            Node node1Left = get(node1Index-1);
            Node node1Right = get(node1Index+1);
            Node nodeLeft = get(nodeIndex-1);
            if(node == head){
                head = node1;
                head.next = node.next;
                node1Left.next = node;
                node.next = node1Right;
            } else if (node1 == head){
                head = node;
                head.next = node1Right;
                nodeLeft.next = node1;
                node1.next = node.next;
            } else {
                nodeLeft.next = node1;
                node1.next = node.next;
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

    public void printList(){
        Node node = head;
        while (node != null){
            System.out.println(node.getData().toString());
            node = node.next;
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

    public int find(T target){
        int index = 0;
        Node node = head;
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

    public void add(int index, T element) {
        if (index == 0) {
            head = new Node(element, head);
        }
        else {
            Node nodeInfront = get(index - 1);
            Node nodeToBeAdded = new Node(element, nodeInfront.next);
            nodeInfront.next = nodeToBeAdded;
        }
        size++;

    }

    @Override
    public String toString() {
        String returnString = "";
        for(int i = 0; i < size() - 1; i++) {
            returnString += get(i).data + "\n";
        }
        return returnString;
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

        public void setData(T data) {
            this.data = data;
        }

        boolean equal(Node element) {
            return data.equals(element.data);
        }


    }
}
