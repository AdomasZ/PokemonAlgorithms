package com.os;

public class Node<T> {
    private Object data;
    private Node left;
    private Node right;

    /**
     * Creates a new node with the given Object as saved data
     * @param pObject the object that should be saved in the node
     */
    public Node(T pObject) {
        data = pObject;
        left = null;
        right = null;
    }

    /**
     * Sets the left node of the specific node
     * @param nLeft the new left node
     */
    public void setLeft(Node nLeft) {
        left = nLeft;
    }

    /**
     * Sets the right node of the specific node
     * @param nRight the new right node
     */
    public void setRight(Node nRight) {
        right = nRight;
    }

    /**
     * Returns the left node
     * @return the left node
     */
    public Node getLeft() {
        return left;
    }

    /**
     * Returns the right node
     * @return the right node
     */
    public Node getRight() {
        return right;
    }

    public Object getData() {
        return data;
    }
}
