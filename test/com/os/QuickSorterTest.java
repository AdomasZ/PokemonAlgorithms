package com.os;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickSorterTest {

    @Test
    void testQuickSortLinkedList() {
        MyLinkedList<Pokemon> list = new MyLinkedList<>();
        MyLinkedList<Pokemon> compareList = new MyLinkedList<>();
        QuickSorter sorter = new QuickSorter();

        Pokemon pokemon = new Pokemon(1, "One", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon1 = new Pokemon(2, "Two", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon2 = new Pokemon(3, "Three", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon3 = new Pokemon(4, "Four", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);
        Pokemon pokemon4 = new Pokemon(5, "Five", "Fire", "Water", 500, 4, 4, 4, 4, 4, 4, 4, false);

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

}