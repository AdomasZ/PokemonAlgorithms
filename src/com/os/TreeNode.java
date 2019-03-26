package com.os;

public class TreeNode<T> {
    private Object data;
    private TreeNode left;
    private TreeNode right;

    /**
     * Creates a new node with the given Object as saved data
     * @param pObject the object that should be saved in the node
     */
    public TreeNode(T pObject) {
        data = pObject;
        left = null;
        right = null;
    }

    /**
     * Sets the left node of the specific node
     * @param nLeft the new left node
     */
    public void setLeft(TreeNode nLeft) {
        left = nLeft;
    }

    /**
     * Sets the right node of the specific node
     * @param nRight the new right node
     */
    public void setRight(TreeNode nRight) {
        right = nRight;
    }

    public void setData(T nData) {
        data = nData;
    }

    /**
     * Returns the left node
     * @return the left node
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * Returns the right node
     * @return the right node
     */
    public TreeNode getRight() {
        return right;
    }

    public Object getData() {
        return data;
    }
}
