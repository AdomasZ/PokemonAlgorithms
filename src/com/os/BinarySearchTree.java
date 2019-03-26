package com.os;


import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T> {

    private TreeNode root;

    /**
     * Creates a new BinarySearchTree with the root node including the given pokemon
     * @param data root pokemon of the search tree
     */
    public BinarySearchTree(T data) {
        root = new TreeNode(data);
    }

    /**
     * Creates an empty binary search tree
     */
    public BinarySearchTree() {
        root = null;
    }

    // Adding data

    /**
     * Adds a new object to the Binary Search tree
     * @param data The object that should be added
     */
    public void add(T data) {
        root = recursiveAdd(root, data);
    }

    /**
     * Recursive function that should add the given data to the node where it belongs in the Binary Search Tree.
     * Looping recursively through the tree to find the correct empty spot
     * @param node current node
     * @param data data that should be added
     * @return node with the added data
     */
    private TreeNode recursiveAdd(TreeNode node, T data) {
            //breaking condition, if the current node is empty, it will be inserted there
            if(node == null) {
                return new TreeNode(data);
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

    //Finding/Containing data

    /**
     * Checks whether specific data is inside of the Binary Search Tree
     * @param data Data that should be found
     * @return true if it exists in the Binary Search Tree, false if not
     */
    public boolean contains(T data) {
        return recursiveContains(root, data);
    }

    /**
     * Recursive function that should check every node to find the data
     * @param node current node
     * @param data data that should be found
     * @return true if it exists in the Binary Search Tree, false if not
     */
    private boolean recursiveContains(TreeNode node, T data) {
        //Check whether the current one is empty, then the searched Object doesn't exist
        if(node == null) {
            return false;
        }

        if(data == node.getData()) {
            return true;
        }
        else {
            Comparable<Object> comparable = (Comparable) data;
            if(comparable.compareTo(node.getData()) > 0) {
                //Data that should be found is bigger, so it should check on the right side
                return recursiveContains(node.getRight(), data);
            }
            else {
                //Data that should be found is smaller, so it should check on the left side
                return recursiveContains(node.getLeft(), data);
            }
        }
    }

    //Deleting data

    /**
     * Delete a given object from the tree
     * @param data the object that should be deleted
     */
    public void delete(T data) {
        root = recursiveDelete(root, data);
    }

    /**
     * Recursive function to delete a given object from the Binary Search Tree
     * Visits in a recursive way all the nodes to find it
     * @param node Current node
     * @param data Object that should be deleted
     * @return next node to visit
     */
    private TreeNode<T> recursiveDelete(TreeNode node, T data) {
        if(node == null) {
            return null;
        }

        if(data == node.getData()) {
            //delete the node
            // if it has no children
            if(node.getLeft() == null && node.getRight() == null) {
                return null;
            }

            // if it has only one child
            if(node.getRight() == null) {
                return node.getLeft();
            }

            if(node.getLeft() == null) {
                return node.getRight();
            }

            // if it has two children, replace the node with the smallest one of the right subtree
            T smallestValue = findSmallestValue(node.getRight());
            node.setData(smallestValue);
            node.setRight(recursiveDelete(node.getRight(), smallestValue));
            return node;
        }
        else {
            Comparable<Object> comparable = (Comparable) data;
            if(comparable.compareTo(node.getData()) > 0) {
                //Find the data on the right side to delete it
                node.setRight(recursiveDelete(node.getRight(), data));
        }
            else {
                //Go to the left side of the Tree to delete it somewhere there
                node.setLeft(recursiveDelete(node.getLeft(), data));
            }
        }
        return node;
    }

    /**
     * Finds the smallest value in a given node/subtree
     * @param node node to be searched for the smallest value
     * @return returns value of smallest node
     */
    private T findSmallestValue(TreeNode node) {
        if(node.getLeft() == null) {
            return (T) node.getData();
        }
        else {
            return findSmallestValue(node.getLeft());
        }
    }

    //Depth-First Search/Traversal

    /**
     * Prints the whole Tree using in-order traversal
     */
    public void inorderTraversal() {
        recursiveInorderTraversal(root);
    }

    /**
     * In-order traversal
     * @param node starting point
     */
    private void recursiveInorderTraversal(TreeNode node) {
        if(node != null) {
            //Left node
            if (node.getLeft() != null) {
                recursiveInorderTraversal(node.getLeft());
            }

            //node
            System.out.println(node.getData().toString());

            //right node
            if (node.getRight() != null) {
                recursiveInorderTraversal(node.getRight());
            }
        }
    }

    /**
     * Prints the whole Tree using pre-order traversal
     */
    public void preorderTraversal() {
        recursivePreorderTraversal(root);
    }

    /**
     * Pre-order traversal
     * @param node starting point
     */
    private void recursivePreorderTraversal(TreeNode node) {
        if(node != null) {
            //node
            System.out.println(node.getData().toString());

            //left node
            if (node.getLeft() != null) {
                recursiveInorderTraversal(node.getLeft());
            }

            //right node
            if (node.getRight() != null) {
                recursiveInorderTraversal(node.getRight());
            }
        }
    }

    /**
     * Prints the whole Tree using post-order traversal
     */
    public void postorderTraversal() {
        recursivePostorderTraversal(root);
    }

    /**
     * Post-order traversal
     * @param node starting point
     */
    private void recursivePostorderTraversal(TreeNode node) {
        if(node != null) {
            //left node
            if (node.getLeft() != null) {
                recursiveInorderTraversal(node.getLeft());
            }

            //right node
            if (node.getRight() != null) {
                recursiveInorderTraversal(node.getRight());
            }

            //node
            System.out.println(node.getData().toString());
        }
    }

    //Breadth-First Search/Traversal

    public void levelOrderTraversal() {
        completeLevelOrderTraversal(root);
    }

    private void completeLevelOrderTraversal(TreeNode start) {
        if(start == null) {
            return;
        }

        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(start);

        while(!nodes.isEmpty()) {
            TreeNode node = nodes.remove();

            System.out.println(node.getData().toString());

            if(node.getLeft() != null) {
                nodes.add(node.getLeft());
            }

            if(node.getRight() != null) {
                nodes.add(node.getRight());
            }
        }

    }

}
