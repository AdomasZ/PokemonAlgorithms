package com.os;

import java.io.IOException;

public class Test {
    MyLinkedList<Pokemon> myLinkedList;
    public Test() throws IOException {
        Controller.readPokemons("Name");
        int listSize = myLinkedList.size();
        for (int i = 0; i < listSize-1; i++) {
            Pokemon iPokemon = myLinkedList.get(i).getData();
            System.out.println("["+i+"]"+iPokemon.getNr() + ": "+iPokemon.getName());
        }

        boolean didSwap;
        for (int i = 0; i < listSize-1; i++) {
            didSwap = false;
            // The highest element always ends up at the end of the list after a pass. After every pass and element put in its place at the end to the list.
            // That's why evey time we check one element less.
            for (int j = 0; j < listSize-i-1; j++){
                if (myLinkedList.get(j).getData().compareTo(myLinkedList.get(j + 1).getData()) > 0) {
                    myLinkedList.swapRight(myLinkedList.get(j));
                    didSwap= true;
                }
            }
            System.out.println("Sorting...");
            if(!didSwap){
                break;
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        for(int k = 0; k < listSize-1; k++){
            Pokemon iPokemon = myLinkedList.get(k).getData();
            System.out.println("["+k+"]"+iPokemon.getNr() + ": "+iPokemon.getName() + ": "+iPokemon.isLegendary());
        }

    }
}
