package com.os;

public class BinarySearcher {

    private static boolean found;

    /**
     * Using binary search to find a Pokemon inside a Binary Search Tree. Returns amount of steps used until it was found
     * @param tree Tree in which the pokemon should be found
     * @param data the pokemon
     * @return amount of steps, -1 when it was not found
     */
    public int binarySearch(BinarySearchTree<Pokemon> tree, Pokemon data) {
        found = false;
        int steps = binarySearchRecursive(tree.getRoot(), data, 0);
        if(found) {
            return steps;
        }
        else {
            return -1;
        }
    }

    /**
     * Recursive function to find the pokemon inside the binary search tree
     * @param node next node
     * @param data pokemon
     * @param steps amount steps until now
     * @return amount of steps until it was found
     */
    private int binarySearchRecursive(TreeNode<Pokemon> node, Pokemon data, int steps) {
        if(node != null) {
            steps ++;
                if(((Comparable)node.getData()).compareTo((Comparable)data) == 0) {
                    found = true;
                    return steps;
                }
                if(((Comparable)node.getData()).compareTo((Comparable)data) > 0) {
                    if(node.getLeft() != null) {
                        return binarySearchRecursive(node.getLeft(), data, steps);
                    }
                }
                if(((Comparable)node.getData()).compareTo((Comparable)data) < 0) {
                    if(node.getRight() != null) {
                        return binarySearchRecursive(node.getRight(), data, steps);
                    }
                }


        }
        return steps;
    }

    public int binarySearch(MyLinkedList<Pokemon> list, Pokemon data) {


        return -1;
    }


}
