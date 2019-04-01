package com.os;

public class Searcher {
    private SequentialSearcher sequentialSearcher;
    private BinarySearcher binarySearcher;
    private InsertionSorter insertionSorter;

    public Searcher() {
        sequentialSearcher = new SequentialSearcher();
        binarySearcher = new BinarySearcher();
        insertionSorter = new InsertionSorter();
    }


}
