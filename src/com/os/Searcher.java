package com.os;

public class Searcher {
    public SequentialSearcher sequentialSearcher;
    public BinarySearcher binarySearcher;

    public Searcher() {
        sequentialSearcher = new SequentialSearcher();
        binarySearcher = new BinarySearcher();
    }


}
