package com.os;


public class BinarySearchTree<T> {

    private Node root;

    /**
     * Creates a new BinarySearchTree with the root node including the given pokemon
     * @param data root pokemon of the search tree
     */
    public BinarySearchTree(T data) {
        root = new Node(data);
    }

    /**
     * Creates an empty binary search tree
     */
    public BinarySearchTree() {
        root = null;
    }

    public void add(T data) {
        root = recursiveAdd(root, data);
    }

    public Node recursiveAdd(Node node, T data) {
            //breaking condition, if the current node is empty, it will be inserted there
            if(node == null) {
                return new Node(data);
            }

            Comparable<Object> comparable = (Comparable) data;

            if(comparable.compareTo(node.getData()) > 0) {
                //New data is bigger and goes right
                node.setRight(recursiveAdd(node.getRight(), data));
            }
            else if(comparable.compareTo(node.getData()) < 0) {
                //New data is smaller goes left
                node.setLeft(recursiveAdd(node.getLeft(), data));
            }
            else {
                //Data already exists
                return node;
            }

            return node;
    }

    public void printTree() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node node) {
        if(node.getLeft() != null) {
            inorderTraversal(node.getLeft());
        }
        System.out.println(node.getData().toString());
        if(node.getRight() != null) {
            inorderTraversal(node.getRight());
        }
    }
}
