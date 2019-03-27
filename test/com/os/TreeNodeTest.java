package com.os;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {

    /**
     * Tests the initialisation of the node
     */
    @Test
    void testInit() {
        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        TreeNode<Pokemon> node = new TreeNode<>(pokemon);

        assertEquals(pokemon, node.getData());
        assertEquals(null, node.getLeft());
        assertEquals(null, node.getRight());
    }

    /**
     * Tests the set and get methods for the left node
     */
    @Test
    void testSetGetLeft() {
        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        TreeNode<Pokemon> node = new TreeNode<>(pokemon);
        TreeNode<Pokemon> node1 = new TreeNode<>(pokemon1);

        node.setLeft(node1);

        assertEquals(node1, node.getLeft());
    }

    /**
     * Tests the set and get methods for the right node
     */
    @Test
    void testSetGetRight() {
        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        TreeNode<Pokemon> node = new TreeNode<>(pokemon);
        TreeNode<Pokemon> node1 = new TreeNode<>(pokemon1);

        node.setRight(node1);

        assertEquals(node1, node.getRight());
    }

    /**
     * Tests the set and get methods for the data
     */
    @Test
    void testSetGetData() {
        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        TreeNode<Pokemon> node = new TreeNode<>(pokemon);

        assertEquals(pokemon, node.getData());

        node.setData(pokemon1);

        assertEquals(pokemon1, node.getData());

    }

}