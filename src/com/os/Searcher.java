package com.os;

public class Searcher {
    private SequentialSearcher sequentialSearcher;
    private BinarySearcher binarySearcher;

    public Searcher() {
        sequentialSearcher = new SequentialSearcher();
        binarySearcher = new BinarySearcher();
    }


}
