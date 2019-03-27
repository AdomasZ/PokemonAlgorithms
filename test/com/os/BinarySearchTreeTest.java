package com.os;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    /**
     * Tests whether objects can be added
     */
    @Test
    void TestAdd() {
        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        BinarySearchTree<Pokemon> tree = new BinarySearchTree();

        tree.add(pokemon);

        assertEquals(true, tree.contains(pokemon));
    }

    /**
     * Tests whether contains works correctly
     */
    @Test
    void testContains() {
        BinarySearchTree<Pokemon> tree = new BinarySearchTree<>();

        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        assertEquals(false, tree.contains(pokemon));

        tree.add(pokemon);
        tree.add(pokemon1);
        tree.add(pokemon2);
        tree.add(pokemon3);

        assertEquals(true, tree.contains(pokemon));
        assertEquals(true, tree.contains(pokemon1));
        assertEquals(true, tree.contains(pokemon2));
        assertEquals(true, tree.contains(pokemon3));
    }

    /**
     * Tests whether delete works
     */
    @Test
    void testDelete() {
        //delete four, add four, delete two, add two, delete one
        BinarySearchTree<Pokemon> tree = new BinarySearchTree<>();

        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        tree.add(pokemon);
        tree.add(pokemon1);
        tree.add(pokemon2);
        tree.add(pokemon3);

        assertEquals(true, tree.contains(pokemon));
        assertEquals(true, tree.contains(pokemon1));
        assertEquals(true, tree.contains(pokemon2));
        assertEquals(true, tree.contains(pokemon3));

        //delete node without children
        tree.delete(pokemon3);

        assertEquals(true, tree.contains(pokemon));
        assertEquals(true, tree.contains(pokemon1));
        assertEquals(true, tree.contains(pokemon2));
        assertEquals(false, tree.contains(pokemon3));

        tree.add(pokemon3);

        //delete node with one child
        tree.delete(pokemon1);

        assertEquals(true, tree.contains(pokemon));
        assertEquals(false, tree.contains(pokemon1));
        assertEquals(true, tree.contains(pokemon2));
        assertEquals(true, tree.contains(pokemon3));

        tree.add(pokemon1);

        //delete node with two children
        tree.delete(pokemon);
        assertEquals(false, tree.contains(pokemon));
        assertEquals(true, tree.contains(pokemon1));
        assertEquals(true, tree.contains(pokemon2));
        assertEquals(true, tree.contains(pokemon3));
    }

    /**
     * Tests the output of the in-order traversal
     */
    @Test
    void testInorderTraversal() {
        BinarySearchTree<Pokemon> tree = new BinarySearchTree<>();

        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        tree.add(pokemon);
        tree.add(pokemon1);
        tree.add(pokemon2);
        tree.add(pokemon3);

        String compareString = pokemon3.toString() + "\n" + pokemon.toString() + "\n" + pokemon2.toString() + "\n" + pokemon1.toString() + "\n";

        assertEquals(compareString, tree.inorderTraversal());
    }

    /**
     * Tests the output of the pre-order traversal
     */
    @Test
    void testPreorderTraversal() {
        BinarySearchTree<Pokemon> tree = new BinarySearchTree<>();

        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        tree.add(pokemon);
        tree.add(pokemon1);
        tree.add(pokemon2);
        tree.add(pokemon3);

        String compareString = pokemon.toString() + "\n" + pokemon3.toString() + "\n" + pokemon1.toString() + "\n" + pokemon2.toString() + "\n";

        assertEquals(compareString, tree.preorderTraversal());
    }

    /**
     * Tests the output of the post-order traversal
     */
    @Test
    void testPostorderTraversal() {
        BinarySearchTree<Pokemon> tree = new BinarySearchTree<>();

        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        tree.add(pokemon);
        tree.add(pokemon1);
        tree.add(pokemon2);
        tree.add(pokemon3);

        String compareString = pokemon3.toString() + "\n" + pokemon2.toString() + "\n" + pokemon1.toString() + "\n" + pokemon.toString() + "\n";

        assertEquals(compareString, tree.postorderTraversal());
    }

    /**
     * Tests the output of the level order traversal
     */
    @Test
    void testLevelOrderTraversal() {
        BinarySearchTree<Pokemon> tree = new BinarySearchTree<>();

        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

        tree.add(pokemon);
        tree.add(pokemon1);
        tree.add(pokemon2);
        tree.add(pokemon3);

        String compareString = pokemon.toString() + "\n" + pokemon3.toString() + "\n" + pokemon1.toString() + "\n" + pokemon2.toString() + "\n";

        assertEquals(compareString, tree.levelOrderTraversal());
    }

}