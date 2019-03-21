package com.os;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {
    private static MyLinkedList<Pokemon> linkedList = new MyLinkedList<>();

    public static void main(String[] args) throws IOException {
        readPokemons();
        System.out.println(linkedList.get(1).getData().getName());
        System.out.println(linkedList.get(2).getData().getName());
        System.out.println(linkedList.get(1).getData().compareTo(linkedList.get(2).getData()));
        linkedList.swapRight(linkedList.get(1));
        System.out.println(linkedList.get(1).getData().getName());
        System.out.println(linkedList.get(2).getData().getName());
        System.out.println(linkedList.get(1).getData().compareTo(linkedList.get(2).getData()));
    }
    private static void readPokemons() throws IOException {
        String fileIn = "C:\\Users\\zitku\\Google Drive\\SCHOOL\\Data Structures and Algorithms\\ThinkDataStructures-master\\Pokemon Algorithms\\src\\com\\os\\Pokemon.csv";
        String fileOut = "PokemonOrdered.csv";
        String line = null;

        // Read all lines in from CSV file and create pokemon
        FileReader fileReader = new FileReader(fileIn);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        //Skip first line
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] temp = line.split(",");
            int nr              = Integer.parseInt(temp[0]);
            String name         = temp[1];
            String type1        = temp[2];
            String type2        = temp[3];
            int total           = Integer.parseInt(temp[4]);
            int HP              = Integer.parseInt(temp[5]);
            int attack          = Integer.parseInt(temp[6]);
            int defense         = Integer.parseInt(temp[7]);
            int SPattack        = Integer.parseInt(temp[8]);
            int SPdefense       = Integer.parseInt(temp[9]);
            int speed           = Integer.parseInt(temp[10]);
            int generation      = Integer.parseInt(temp[11]);
            boolean legendary   = Boolean.parseBoolean(temp[12]);
            Pokemon pokemon = new Pokemon(nr, name, type1, type2, total, HP, attack, defense, SPattack, SPdefense, speed, generation, legendary);
            linkedList.add(pokemon);
        }
        bufferedReader.close();
    }
}
