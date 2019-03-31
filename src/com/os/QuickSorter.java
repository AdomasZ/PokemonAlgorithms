package com.os;


public class QuickSorter {

    public MyLinkedList<Pokemon> quickSort(MyLinkedList<Pokemon> list) {
        int left = 0;
        int right = list.size() - 1;

        return quickSort(list, left, right);
    }

    private MyLinkedList<Pokemon> quickSort(MyLinkedList<Pokemon> list, int left, int right) {
        if(left < right) {
            int partitionIndex = partition(list, left, right);

            quickSort(list, left, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, right);
        }
        return list;
    }


    private int partition(MyLinkedList<Pokemon> list, int left, int right) {
        Pokemon pivot = list.get(right).getData();
        int i = left - 1;

        for(int j = left; j < right; j++) {
            if (list.get(j).getData().compareTo(pivot) < 0) {
                i++;

                list.swap(list.get(i), list.get(j));
            }
        }


        list.swap(list.get(right), list.get(i+1));

        return i+1;
    }

}
