package com.os;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickSorterTest {

    private Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
    private Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
    private Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
    private Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
    private Pokemon pokemon4 = new Pokemon(5, "Five", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

    private QuickSorter sorter = new QuickSorter();

    @Test
    void testQuickSortLinkedList() {
        MyLinkedList<Pokemon> list = new MyLinkedList<>();
        MyLinkedList<Pokemon> compareList = new MyLinkedList<>();

        list.add(pokemon);
        list.add(pokemon1);
        list.add(pokemon2);
        list.add(pokemon3);
        list.add(pokemon4);

        compareList.add(pokemon4);
        compareList.add(pokemon3);
        compareList.add(pokemon);
        compareList.add(pokemon2);
        compareList.add(pokemon1);

        MyLinkedList<Pokemon> sorted = sorter.quickSort(list);

        assertEquals(compareList.get(0).getData(), sorted.get(0).getData()); //five
        assertEquals(compareList.get(1).getData(), sorted.get(1).getData()); //four
        assertEquals(compareList.get(2).getData(), sorted.get(2).getData()); //one
        assertEquals(compareList.get(3).getData(), sorted.get(3).getData()); //three
        assertEquals(compareList.get(4).getData(), sorted.get(4).getData()); //two

    }

    @Test
    void testQuickSortDoublyLinkedList() {
        MyDoublyLinkedList<Pokemon> list = new MyDoublyLinkedList<>();
        MyDoublyLinkedList<Pokemon> compareList = new MyDoublyLinkedList<>();

        list.add(pokemon);
        list.add(pokemon1);
        list.add(pokemon2);
        list.add(pokemon3);
        list.add(pokemon4);

        compareList.add(pokemon4);
        compareList.add(pokemon3);
        compareList.add(pokemon);
        compareList.add(pokemon2);
        compareList.add(pokemon1);

        MyDoublyLinkedList<Pokemon> sorted = sorter.quickSort(list);

        assertEquals(compareList.get(0).getData(), sorted.get(0).getData()); //five
        assertEquals(compareList.get(1).getData(), sorted.get(1).getData()); //four
        assertEquals(compareList.get(2).getData(), sorted.get(2).getData()); //one
        assertEquals(compareList.get(3).getData(), sorted.get(3).getData()); //three
        assertEquals(compareList.get(4).getData(), sorted.get(4).getData()); //two

    }

    @Test
    void testQuickSortQueue() {
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

        MyQueue<Pokemon> sorted = sorter.quickSort(queue);

        assertEquals(compareQuee.delete(), queue.delete()); //five
        assertEquals(compareQuee.delete(), queue.delete()); //four
        assertEquals(compareQuee.delete(), queue.delete()); //one
        assertEquals(compareQuee.delete(), queue.delete()); //three
        assertEquals(compareQuee.delete(), queue.delete()); //two

    }

    @Test
    void testQuickSortStack() {
        Stack<Pokemon> stack = new Stack<>();
        Stack<Pokemon> compareStack = new Stack<>();

        stack.push(pokemon);
        stack.push(pokemon1);
        stack.push(pokemon2);
        stack.push(pokemon3);
        stack.push(pokemon4);

        compareStack.push(pokemon4);
        compareStack.push(pokemon3);
        compareStack.push(pokemon);
        compareStack.push(pokemon2);
        compareStack.push(pokemon1);

        Stack<Pokemon> sorted = sorter.quickSort(stack);

        assertEquals(compareStack.pop(), stack.pop()); //five
        assertEquals(compareStack.pop(), stack.pop()); //four
        assertEquals(compareStack.pop(), stack.pop()); //one
        assertEquals(compareStack.pop(), stack.pop()); //three
        assertEquals(compareStack.pop(), stack.pop()); //two

    }

}