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
        int left = 0;
        int right = list.size()-1;

        return binarySearch(list, data, left, right);
    }

    @SuppressWarnings("Duplicates")
    private int binarySearch(MyLinkedList<Pokemon> list, Pokemon data, int left, int right) {
        while(right >= left) {
            int middle = (left + right) / 2;
            if(list.get(middle).getData().compareTo(data) == 0) {
                return middle;
            }
            else if (list.get(middle).getData().compareTo(data) > 0) {
                right = middle - 1;
            }
            else if (list.get(middle).getData().compareTo(data) < 0) {
                left = middle + 1;
            }

        }
        return -1;
    }

    public int binarySearch(MyDoublyLinkedList<Pokemon> list, Pokemon data) {
        int left = 0;
        int right = list.size()-1;

        return binarySearch(list, data, left, right);
    }

    @SuppressWarnings("Duplicates")
    private int binarySearch(MyDoublyLinkedList<Pokemon> list, Pokemon data, int left, int right) {
        while(right >= left) {
            int middle = (left + right) / 2;
            if(list.get(middle).getData().compareTo(data) == 0) {
                return middle;
            }
            else if (list.get(middle).getData().compareTo(data) > 0) {
                right = middle - 1;
            }
            else if (list.get(middle).getData().compareTo(data) < 0) {
                left = middle + 1;
            }

        }
        return -1;
    }

    /**
     * Gives back the index of a specific Pokemon in a stack. Index 0 means it is at the top of the stack
     * @param stack Stack to be searched
     * @param data Pokemon to be searched for
     * @return index, -1 if it was not found
     */
    public int binarySearch(Stack<Pokemon> stack, Pokemon data) {
        int left = 0;
        int right = stack.size() - 1;

        return binarySearch(stack, data, left, right);
    }

    /**
     * Gives back the index of a specific Pokemon in a stack. Index 0 means it is at the top of the stack
     * @param stack stack to be searched
     * @param data pokemon that should be found
     * @param top starting position
     * @param bottom ending position
     * @return index, -1 if it was not found
     */
    private int binarySearch(Stack<Pokemon> stack, Pokemon data, int top, int bottom) {
        while(bottom >= top) {
            int middle = (top + bottom) / 2;
            Stack<Pokemon> temp = new Stack<>();
            for(int i = 0; i < middle; i++) {
                temp.push(stack.pop());
            }

            //Middle element to compare
            Pokemon element = stack.peek();

            //combine stack with temp again
            while(!temp.isEmpty()){
                stack.push(temp.pop());
            }

            //compare again
            if(element.compareTo(data) == 0) {
                return middle;
            }
            else {
                if(element.compareTo(data) < 0) {
                    bottom = middle - 1;
                }
                else if(element.compareTo(data) > 0) {
                    top = middle + 1;
                }
            }

        }
        return -1;
    }

    /**
     * Gives back the index of a specific Pokemon in a queue. Index 0 means it is at the front of the queue
     * @param queue Queue to be searched
     * @param data Pokemon to be searched for
     * @return index, -1 if it was not found
     */
    public int binarySearch(MyQueue<Pokemon> queue, Pokemon data) {
        int front = 0;
        int end = queue.size() - 1;

        return binarySearch(queue, data, front, end);
    }

    /**
     * Gives back the index of a specific Pokemon in a queue. Index 0 means it is at the front of the queue
     * @param queue Queue to be searched
     * @param data Pokemon to be searched for
     * @param front starting position
     * @param end ending position
     * @return index, -1 if it was not found
     */
    private int binarySearch(MyQueue<Pokemon> queue, Pokemon data, int front, int end) {
        while (front <= end) {
            int middle = (front + end) / 2;
            MyQueue<Pokemon> temp = new MyQueue<>();
            for(int i = 0; i < middle; i++) {
                temp.insert(queue.delete());
            }

            //Middle element to compare
            Pokemon element = queue.peek();

            //Adding rest to temp
            while(!queue.isEmpty()) {
                temp.insert(queue.delete());
            }

            //combine queue with temp again
            while(!temp.isEmpty()) {
                queue.insert(temp.delete());
            }

            //compare and change part to search
            if(element.compareTo(data) == 0) {
                return middle;
            }
            else {
                if(element.compareTo(data) > 0) {
                    end = middle - 1;
                }
                else if(element.compareTo(data) < 0) {
                    front = middle + 1;
                }
            }
        }
        return -1;
    }


}
