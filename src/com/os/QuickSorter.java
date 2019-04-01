package com.os;


public class QuickSorter {

    /**
     * Sorts a Linked list using quick sort and returns it sorted
     * @param list List to be sorted
     * @return sorted list
     */
    public MyLinkedList<Pokemon> quickSort(MyLinkedList<Pokemon> list) {
        int left = 0;
        int right = list.size() - 1;

        return quickSort(list, left, right);
    }

    /**
     * recursive call to sort a list with a given beginning point and ending point
     * @param list list to be sorted
     * @param left beginning
     * @param right end
     * @return sorted list
     */
    private MyLinkedList<Pokemon> quickSort(MyLinkedList<Pokemon> list, int left, int right) {
        if(left < right) {
            int partitionIndex = partition(list, left, right);

            quickSort(list, left, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, right);
        }
        return list;
    }

    /**
     * calculates the new pivot place and swaps the parts to the right positions
     * @param list list to be sorted
     * @param left beginning index of the list
     * @param right ending index of the list
     * @return position of the pivot with which everything was compared
     */
    @SuppressWarnings("Duplicates")
    private int partition(MyLinkedList<Pokemon> list, int left, int right) {
        Pokemon pivot = list.get(right).getData();
        int i = left - 1;

        for(int j = left; j < right; j++) {
            if (list.get(j).getData().compareTo(pivot) < 0) {
                i++;

                Pokemon temp = list.get(i).getData();
                list.get(i).setData(list.get(j).getData());
                list.get(j).setData(temp);

                //list.swap(list.get(i), list.get(j));
            }
        }

        Pokemon temp = list.get(right).getData();
        list.get(right).setData(list.get(i+1).getData());
        list.get(i+1).setData(temp);

        //list.swap(list.get(right), list.get(i+1));

        return i+1;
    }

    /**
     * Sorts a Doubly linked list using quick sort and returns it sorted
     * @param list List to be sorted
     * @return sorted list
     */
    public MyDoublyLinkedList<Pokemon> quickSort(MyDoublyLinkedList<Pokemon> list) {
        int left = 0;
        int right = list.size() - 1;

        return quickSort(list, left, right);
    }

    /**
     * recursive call to sort a list with a given beginning point and ending point
     * @param list list to be sorted
     * @param left beginning
     * @param right end
     * @return sorted list
     */
    private MyDoublyLinkedList<Pokemon> quickSort(MyDoublyLinkedList<Pokemon> list, int left, int right) {
        if(left < right) {
            int partitionIndex = partition(list, left, right);

            quickSort(list, left, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, right);
        }
        return list;
    }

    /**
     * calculates the new pivot place and swaps the parts to the right positions
     * @param list list to be sorted
     * @param left beginning index of the list
     * @param right ending index of the list
     * @return position of the pivot with which everything was compared
     */
    @SuppressWarnings("Duplicates")
    private int partition(MyDoublyLinkedList<Pokemon> list, int left, int right) {
        Pokemon pivot = list.get(right).getData();
        int i = left - 1;

        for(int j = left; j < right; j++) {
            if (list.get(j).getData().compareTo(pivot) < 0) {
                i++;


                Pokemon temp = list.get(i).getData();
                list.get(i).setData(list.get(j).getData());
                list.get(j).setData(temp);
                //list.swap(list.get(i), list.get(j));
            }
        }


        Pokemon temp = list.get(right).getData();
        list.get(right).setData(list.get(i+1).getData());
        list.get(i+1).setData(temp);
        //list.swap(list.get(right), list.get(i+1));

        return i+1;
    }

    /**
     * Sorts a queue using quick sort
     * @param queue queue to be sorted
     * @return sorted queue
     */
    public MyQueue<Pokemon> quickSort(MyQueue<Pokemon> queue) {
        Pokemon pivot = queue.peek();

        //Three new queues, one for smaller elements, one for bigger and one for the pivot element
        MyQueue<Pokemon> left = new MyQueue<>();
        MyQueue<Pokemon> right = new MyQueue<>();
        MyQueue<Pokemon> equals = new MyQueue<>();

        //adding next element to the corresponding queue
        while (!queue.isEmpty()) {
            Pokemon element = queue.delete();
            if (element.compareTo(pivot) < 0) {
                left.insert(element);
            } else if (element.compareTo(pivot) == 0) {
                equals.insert(element);
            } else {
                right.insert(element);
            }
        }

        //recursive part, as long as there is more than 1 element in each list
        if(left.size() > 1) {
            quickSort(left);
        }
        if(right.size() > 1) {
            quickSort(right);
        }

        //merging the queues in the right order
        while(!left.isEmpty()) {
            queue.insert(left.delete());
        }
        while(!equals.isEmpty()) {
            queue.insert(equals.delete());
        }
        while(!right.isEmpty()) {
            queue.insert(right.delete());
        }

        return queue;
    }

    /**
     * Sorts a stack using quick sort
     * @param stack stack to be sorted
     * @return sorted stack
     */
    public Stack<Pokemon> quickSort(Stack<Pokemon> stack) {
        Pokemon pivot = stack.peek();

        //Three new queues, one for smaller elements, one for bigger and one for the pivot element
        Stack<Pokemon> down = new Stack<>();
        Stack<Pokemon> top = new Stack<>();
        Stack<Pokemon> equals = new Stack<>();

        //adding next element to the corresponding queue
        while (!stack.isEmpty()) {
            Pokemon element = stack.pop();
            if (element.compareTo(pivot) > 0) {
                down.push(element);
            } else if (element.compareTo(pivot) == 0) {
                equals.push(element);
            } else {
                top.push(element);
            }
        }

        //recursive part, as long as there is more than 1 element in each list
        if(down.size() > 1) {
            quickSort(down);
        }
        if(top.size() > 1) {
            quickSort(top);
        }


        //merging the stacks in the right order, first adding everything to a temporary stack and then to the original
        //to keep it in the same order
        Stack<Pokemon> temp = new Stack<>();
        while(!down.isEmpty()) {
            temp.push(down.pop());
        }
        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        while(!equals.isEmpty()) {
            temp.push(equals.pop());
        }
        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        while(!top.isEmpty()) {
            temp.push(top.pop());
        }
        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        return stack;
    }

}
