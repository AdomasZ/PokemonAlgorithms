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
}