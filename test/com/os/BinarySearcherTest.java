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
}