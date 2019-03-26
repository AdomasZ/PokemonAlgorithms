package com.os;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {
    private static MyLinkedList<Pokemon> linkedList = new MyLinkedList<>();
    private static BinarySearchTree<Pokemon> binarySearchTree = new BinarySearchTree<>();
    private static Stack<Pokemon> stack = new Stack();

    public static void main(String[] args) throws IOException {
        readPokemons();
        System.out.println("Inorder Traversal:");
        binarySearchTree.inorderTraversal();

        System.out.println();

        System.out.println("Preorder Traversal:");
        binarySearchTree.preorderTraversal();

        System.out.println();

        System.out.println("Postorder Traversal:");
        binarySearchTree.postorderTraversal();

        System.out.println();

        System.out.println("Levelorder Traversal:");
        binarySearchTree.levelOrderTraversal();

        System.out.println();



        //System.out.println(binarySearchTree.contains(new Pokemon(2,"test", "sf", "sf", 4, 3, 4, 3, 4,3, 4, 4, false)));
        //binarySearchTree.printTree();
        //Test test = new Test();
    }

    void bubbleSort(MyLinkedList<Pokemon> list)
    {
        int n = list.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (list.get(j).getData().compareTo(list.get(j+1))==1)
                {
                    // swap arr[j+1] and arr[i]
                    list.swapRight(list.get(j));
                }
    }

    //is an array of int fine or do i have to use list or something
    public static void insertionSort(int arr[]) {
        int i, key, j;
        int n = arr.length;
        for (i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    private static void testSwap(int i, int j){
        System.out.println(linkedList.get(i).getData().getName());
        System.out.println(linkedList.get(j).getData().getName());
        System.out.println(linkedList.get(i).getData().compareTo(linkedList.get(j).getData()));
        linkedList.swap(linkedList.get(i), linkedList.get(j));
        System.out.println(linkedList.get(i).getData().getName());
        System.out.println(linkedList.get(j).getData().getName());
        System.out.println(linkedList.get(i).getData().compareTo(linkedList.get(j).getData()));
    }

    public static MyLinkedList<Pokemon> readPokemons() throws IOException {
        String fileIn = "src/com/os/Pokemon.csv";
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
            addPokemonToDatastructures(pokemon);
        }
        bufferedReader.close();
        return linkedList;
    }

    private static void addPokemonToDatastructures(Pokemon pokemon) {
        linkedList.add(pokemon);
        binarySearchTree.add(pokemon);
        stack.push(pokemon);
    }
}
