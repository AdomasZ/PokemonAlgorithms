package com.os;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSorterTest {
    private Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
    private Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
    private Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
    private Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
    private Pokemon pokemon4 = new Pokemon(5, "Five", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

    private InsertionSorter sorter = new InsertionSorter();


    @Test
    void insertionSort() {
    }

    @Test
    void insertionSort1() {
    }

    @Test
    void insertionSort2() {
    }

    @Test
    void insertionSortQueue() {
        MyQueue<Pokemon> queue = new MyQueue<>();
        MyQueue<Pokemon> compareQuee = new MyQueue<>();

        queue.insert(pokemon);
        queue.insert(pokemon1);
        queue.insert(pokemon2);
        queue.insert(pokemon3);
        queue.insert(pokemon4);

        compareQuee.insert(pokemon4);
        compareQuee.insert(pokemon3);
        compareQuee.insert(pokemon);
        compareQuee.insert(pokemon2);
        compareQuee.insert(pokemon1);

        MyQueue<Pokemon> sorted = sorter.insertionSort(queue);

        assertEquals(compareQuee.delete(), sorted.delete()); //five
        assertEquals(compareQuee.delete(), sorted.delete()); //four
        assertEquals(compareQuee.delete(), sorted.delete()); //one
        assertEquals(compareQuee.delete(), sorted.delete()); //three
        assertEquals(compareQuee.delete(), sorted.delete()); //two
    }
}