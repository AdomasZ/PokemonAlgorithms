package com.os;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearcherTest {

    @Test
    void testBinarySearchBinarySearchTree() {
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

        BinarySearcher searcher = new BinarySearcher();

        assertEquals(2, searcher.binarySearch(tree, pokemon3));
        assertEquals(2, searcher.binarySearch(tree, pokemon5));
        assertEquals(3, searcher.binarySearch(tree, pokemon2));
        assertEquals(1, searcher.binarySearch(tree, pokemon));
        assertEquals(2, searcher.binarySearch(tree, pokemon1));

        assertEquals(-1, searcher.binarySearch(tree, pokemon4));
    }

    @Test
    void testBinarySearchLinkedList() {
        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon4 = new Pokemon(5, "Five", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        Pokemon pokemon5 = new Pokemon(6, "Six", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        MyLinkedList<Pokemon> list = new MyLinkedList<>();

        list.add(pokemon4);
        list.add(pokemon3);
        list.add(pokemon);
        list.add(pokemon2);
        list.add(pokemon1);

        BinarySearcher searcher = new BinarySearcher();

        assertEquals(2, searcher.binarySearch(list, pokemon));
        assertEquals(4, searcher.binarySearch(list, pokemon1));
        assertEquals(3, searcher.binarySearch(list, pokemon2));
        assertEquals(1, searcher.binarySearch(list, pokemon3));
        assertEquals(0, searcher.binarySearch(list, pokemon4));

        assertEquals(-1, searcher.binarySearch(list, pokemon5));
    }

    @Test
    void testBinarySearchDoublyLinkedList() {
        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon4 = new Pokemon(5, "Five", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        Pokemon pokemon5 = new Pokemon(6, "Six", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        MyDoublyLinkedList<Pokemon> list = new MyDoublyLinkedList<>();

        list.add(pokemon4);
        list.add(pokemon3);
        list.add(pokemon);
        list.add(pokemon2);
        list.add(pokemon1);

        BinarySearcher searcher = new BinarySearcher();

        assertEquals(2, searcher.binarySearch(list, pokemon));
        assertEquals(4, searcher.binarySearch(list, pokemon1));
        assertEquals(3, searcher.binarySearch(list, pokemon2));
        assertEquals(1, searcher.binarySearch(list, pokemon3));
        assertEquals(0, searcher.binarySearch(list, pokemon4));

        assertEquals(-1, searcher.binarySearch(list, pokemon5));
    }

    @Test
    void testBinarySearchStack(){
        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon4 = new Pokemon(5, "Five", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        Pokemon pokemon5 = new Pokemon(6, "Six", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        Stack<Pokemon> stack = new Stack<>();

        stack.push(pokemon4);
        stack.push(pokemon3);
        stack.push(pokemon);
        stack.push(pokemon2);
        stack.push(pokemon1);

        BinarySearcher searcher = new BinarySearcher();

        assertEquals(2, searcher.binarySearch(stack, pokemon));
        assertEquals(0, searcher.binarySearch(stack, pokemon1));
        assertEquals(1, searcher.binarySearch(stack, pokemon2));
        assertEquals(3, searcher.binarySearch(stack, pokemon3));
        assertEquals(4, searcher.binarySearch(stack, pokemon4));

        assertEquals(-1, searcher.binarySearch(stack, pokemon5));
    }

    @Test
    void testBinarySearchQueue() {
        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon4 = new Pokemon(5, "Five", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        Pokemon pokemon5 = new Pokemon(6, "Six", "Bla", "Water", 00, 4, 4, 4, 4, 4, 4, 4, true);

        MyQueue<Pokemon> queue = new MyQueue<>();

        queue.insert(pokemon4);
        queue.insert(pokemon3);
        queue.insert(pokemon);
        queue.insert(pokemon2);
        queue.insert(pokemon1);

        BinarySearcher searcher = new BinarySearcher();

        assertEquals(2, searcher.binarySearch(queue, pokemon));
        assertEquals(4, searcher.binarySearch(queue, pokemon1));
        assertEquals(3, searcher.binarySearch(queue, pokemon2));
        assertEquals(1, searcher.binarySearch(queue, pokemon3));
        assertEquals(0, searcher.binarySearch(queue, pokemon4));

        assertEquals(-1, searcher.binarySearch(queue, pokemon5));

    }
}