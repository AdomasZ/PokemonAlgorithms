package com.os;

public class SequentialSearcher {

    private static boolean found = false;

    /**
     * Searches for a specific pokemon inside a Binary Search Tree. Comparing depending on the comparable set in Pokemon
     * @param tree The tree in which the pokemon should be searched
     * @param data The pokemon
     * @return Position in the tree according to in-order traversal
     */
    public  int sequentialSearch(BinarySearchTree<Pokemon> tree, Pokemon data) {
        found = false;
        int steps = sequentialSearchRecursive(tree.getRoot(), data, 0);
        if (found) {
            return steps;
        }
        else  {
            return -1;
        }
   }

    /**
     * Recursive search for Pokemon in tree.
     * @param node The tree in which the pokemon should be searched
     * @param data The pokemon
     * @param steps Amount steps until now
     * @return Steps in total, therefore position
     */
    private int sequentialSearchRecursive(TreeNode<Pokemon> node, Pokemon data, int steps) {
        if(node != null) {
            if(node.getLeft() != null) {
                //steps ++;
                steps = sequentialSearchRecursive(node.getLeft(), data, steps);
                if(found) {
                    return steps;
                }
            }
            steps ++;
            if(((Comparable)node.getData()).compareTo((Comparable)data) == 0) {
                found = true;
                return steps;
            }
            if(node.getRight() != null) {
                //steps ++;
                steps = sequentialSearchRecursive(node.getRight(), data, steps);
                if(found) {
                    return steps;
                }
            }
        }
            return steps;


    }

    public int sequentialSearch(MyDoublyLinkedList<Pokemon> list, Pokemon data) {
        return list.find(data);
    }

    public int sequentialSearch(MyLinkedList<Pokemon> list, Pokemon data) {
        return list.find(data);
    }

    public int sequentialSearch(Stack<Pokemon> stack, Pokemon data) {
        //does the position start at 0 or 1? if its 0, counter needs to be: stack.size() - 1
        Stack<Pokemon> tstack = new Stack<>();
        int counter = stack.size();
        while (!stack.isEmpty()) {
            Pokemon pokemon = stack.pop();
            tstack.push(pokemon);
            if (pokemon.compareTo(data) == 0) {
                while (!tstack.isEmpty()) {
                    stack.push(tstack.pop());
                }
                return counter;
            }
            counter--;
        }
        return -1;
    }

    public int sequentialSearch(MyQueue<Pokemon> queue, Pokemon data) {
        int size = queue.size();
        int position = -1;
        for(int i = 0; i < size; i++) {
            Pokemon current = queue.delete();
            queue.insert(current);
            if(current.compareTo(data) == 0 && position == -1) {
                position = i;
            }
        }
        return position;
    }
}
