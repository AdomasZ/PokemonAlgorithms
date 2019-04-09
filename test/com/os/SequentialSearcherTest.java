package com.os;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequentialSearcherTest {

    @Test
    void testSequentialSearchBinaryTree() {
        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon4 = new Pokemon(5, "five", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        Pokemon pokemon5 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        BinarySearchTree<Pokemon> tree = new BinarySearchTree<>();

        tree.add(pokemon);
        tree.add(pokemon1);
        tree.add(pokemon2);
        tree.add(pokemon3);

        SequentialSearcher searcher = new SequentialSearcher();

        assertEquals(1, searcher.sequentialSearch(tree, pokemon3));
        assertEquals(1, searcher.sequentialSearch(tree, pokemon5));
        assertEquals(3, searcher.sequentialSearch(tree, pokemon2));
        assertEquals(2, searcher.sequentialSearch(tree, pokemon));
        assertEquals(4, searcher.sequentialSearch(tree, pokemon1));

        assertEquals(-1, searcher.sequentialSearch(tree, pokemon4));
    }

    @Test
    void testSequentialSearchStack() {
        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon4 = new Pokemon(5, "five", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon5 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        Stack<Pokemon> stack = new Stack();

        stack.push(pokemon);
        stack.push(pokemon1);
        stack.push(pokemon2);
        stack.push(pokemon3);
        stack.push(pokemon5);

        SequentialSearcher searcher = new SequentialSearcher();


        assertEquals(5, searcher.sequentialSearch(stack, pokemon3));
        assertEquals(1, searcher.sequentialSearch(stack, pokemon));
        assertEquals(3, searcher.sequentialSearch(stack, pokemon2));
        assertEquals(5, searcher.sequentialSearch(stack, pokemon5));
        assertEquals(2, searcher.sequentialSearch(stack, pokemon1));

        assertEquals(-1, searcher.sequentialSearch(stack, pokemon4));
    }

    @Test
    void testSequentialLinkedList() {
        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon4 = new Pokemon(5, "five", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        MyLinkedList<Pokemon> list = new MyLinkedList<>();

        list.add(pokemon);
        list.add(pokemon1);
        list.add(pokemon2);
        list.add(pokemon3);

        SequentialSearcher searcher = new SequentialSearcher();


        assertEquals(3, searcher.sequentialSearch(list, pokemon3));
        assertEquals(0, searcher.sequentialSearch(list, pokemon));
        assertEquals(2, searcher.sequentialSearch(list, pokemon2));
        assertEquals(1, searcher.sequentialSearch(list, pokemon1));

        assertEquals(-1, searcher.sequentialSearch(list, pokemon4));

    }

    @Test
    void testSequentialDoublyLinkedList() {
        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon4 = new Pokemon(5, "five", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        MyDoublyLinkedList<Pokemon> list = new MyDoublyLinkedList<>();

        list.add(pokemon);
        list.add(pokemon1);
        list.add(pokemon2);
        list.add(pokemon3);

        SequentialSearcher searcher = new SequentialSearcher();


        assertEquals(3, searcher.sequentialSearch(list, pokemon3));
        assertEquals(0, searcher.sequentialSearch(list, pokemon));
        assertEquals(2, searcher.sequentialSearch(list, pokemon2));
        assertEquals(1, searcher.sequentialSearch(list, pokemon1));

        assertEquals(-1, searcher.sequentialSearch(list, pokemon4));
    }

    @Test
    void testSequentialQueue() {
        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon4 = new Pokemon(5, "five", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        MyQueue<Pokemon> queue = new MyQueue<>();

        queue.insert(pokemon);
        queue.insert(pokemon1);
        queue.insert(pokemon2);
        queue.insert(pokemon3);

        SequentialSearcher searcher = new SequentialSearcher();


        assertEquals(3, searcher.sequentialSearch(queue, pokemon3));
        assertEquals(0, searcher.sequentialSearch(queue, pokemon));
        assertEquals(2, searcher.sequentialSearch(queue, pokemon2));
        assertEquals(1, searcher.sequentialSearch(queue, pokemon1));

        assertEquals(-1, searcher.sequentialSearch(queue, pokemon4));
    }

}