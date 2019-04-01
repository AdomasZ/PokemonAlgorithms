package com.os;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


@SuppressWarnings("Duplicates")
public class Controller {
    private static MyLinkedList<Pokemon> linkedList = new MyLinkedList<>();
    private static BinarySearchTree<Pokemon> binarySearchTree = new BinarySearchTree<>();
    private static Stack<Pokemon> stack = new Stack();
    private static MyQueue<Pokemon> queue = new MyQueue<>();
    private static MyDoublyLinkedList<Pokemon> doublyLinkedList = new MyDoublyLinkedList<>();

    private static MyDoublyLinkedList<Pokemon> sortedDoublyLinkedList = new MyDoublyLinkedList<>();
    private static MyLinkedList<Pokemon> sortedLinkedList = new MyLinkedList<>();
    private static Stack<Pokemon> sortedStack = new Stack<>();
    private static MyQueue<Pokemon> sortedQueue = new MyQueue<>();

    private Sorter sorter = new Sorter();

    public Controller() {
        try {
            readPokemons("Name");
        }
        catch (IOException e) {
            System.out.println("Problems.");
        }

    }

    public String reset(String criteria) {
        try {
            linkedList = new MyLinkedList<>();
            binarySearchTree = new BinarySearchTree<>();
            stack = new Stack<>();
            queue = new MyQueue<>();
            doublyLinkedList = new MyDoublyLinkedList<>();
            readPokemons(criteria);
            String returnString = "Everything was resetted.\n";
            returnString += binarySearchTree.inorderTraversal() + "\n";
            return returnString;
        }
        catch (IOException e) {
            return "There was a problem resetting.\n";
        }

    }

    public long sort(String dataStructure, String sortingAlgorithm) {
        long start = System.currentTimeMillis();
        if(dataStructure.equals("ll")) {
            //Sort the linked list
            sortLinkedList(sortingAlgorithm);
            long end = System.currentTimeMillis();
            return end - start;

        }
        else if (dataStructure.equals("dll")){
            //Sort doubly linked list
            sortDoublyLinkedList(sortingAlgorithm);
            long end = System.currentTimeMillis();
            return end - start;
        }
        else if (dataStructure.equals("q")) {
            //Sort queue
            sortQueue(sortingAlgorithm);
            long end = System.currentTimeMillis();
            return end - start;
        }
        else if (dataStructure.equals("s")) {
            //sort stack
            sortStack(sortingAlgorithm);
            long end = System.currentTimeMillis();
            return end - start;
        }
        else {
            return -1;
        }
    }

    public static void readPokemons(String compareCriteria) throws IOException {
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
            pokemon.setCompareCriteria(compareCriteria);
            addPokemonToDatastructures(pokemon);
        }
        bufferedReader.close();
        //return linkedList;
    }

    public String getQueueString(Boolean sorted) {
        if(sorted) {
            return sortedQueue.toString();
        }
        else {
            return queue.toString();
        }
    }

    public String getStackString(Boolean sorted) {
        if(sorted) {
            return sortedStack.toString();
        }
        else {
            return stack.toString();
        }
    }

    public String getLinkedListString(Boolean sorted) {
        if(sorted) {
            return sortedLinkedList.toString();
        }
        else {
            return linkedList.toString();
        }
    }

    public String getDoublyLinkedListString(Boolean sorted) {
        if(sorted) {
            return sortedDoublyLinkedList.toString();
        }
        else {
            return doublyLinkedList.toString();
        }
    }

    public String getBinarySearchTreeString(Boolean sorted) {
        if(sorted) {
            return binarySearchTree.inorderTraversal();
        }
        else {
            return binarySearchTree.levelOrderTraversal();
        }
    }



    private static void addPokemonToDatastructures(Pokemon pokemon) {
        linkedList.add(pokemon);
        binarySearchTree.add(pokemon);
        stack.push(pokemon);
        queue.insert(pokemon);
        doublyLinkedList.add(pokemon);
    }

    //TODO
    private void sortLinkedList(String sortingAlgorithm) {
        if(sortingAlgorithm.equals("bs")) {
            //sort with bubble sort
            sortedLinkedList = sorter.bubbleSorter.bubbleSort(linkedList);
        }
        else if (sortingAlgorithm.equals("sbs")) {
            //sort with smart bubble sort
            //TODO
            //sortedLinkedList = sorter.smartBubbleSorter.smartBubbleSort(linkedList);
        }
        else if (sortingAlgorithm.equals("is")){
            //sort with insertion sort
            //TODO
            //sortedLinkedList = sorter.insertionSorter.insertionSort(linkedList);
        }
        else {
            //sort with quick sort
            sortedLinkedList = sorter.quickSorter.quickSort(linkedList);
        }
    }

    //TODO
    private void sortDoublyLinkedList(String sortingAlgorithm) {
        if(sortingAlgorithm.equals("bs")) {
            //sort with bubble sort
            sortedDoublyLinkedList = sorter.bubbleSorter.bubbleSort(doublyLinkedList);
        }
        else if (sortingAlgorithm.equals("sbs")) {
            //sort with smart bubble sort
            //TODO
            //sortedDoublyLinkedList = sorter.smartBubbleSorter.smartBubbleSort(doublyLinkedList);
        }
        else if (sortingAlgorithm.equals("is")){
            //sort with insertion sort
            //TODO
            //sortedDoublyLinkedList = sorter.insertionSorter.insertionSort(doublyLinkedList);
        }
        else {
            //sort with quick sort
            sortedDoublyLinkedList = sorter.quickSorter.quickSort(doublyLinkedList);
        }
    }

    //TODO
    private void sortQueue(String sortingAlgorithm) {
        if(sortingAlgorithm.equals("bs")) {
            //sort with bubble sort
            //sortedQueue = sorter.bubbleSorter.bubbleSort(queue);
        }
        else if (sortingAlgorithm.equals("sbs")) {
            //sort with smart bubble sort
            //TODO
            //sortedQueue = sorter.smartBubbleSorter.smartBubbleSort(queue);
        }
        else if (sortingAlgorithm.equals("is")){
            //sort with insertion sort
            //TODO
            //sortedQueue = sorter.insertionSorter.insertionSort(queue);
        }
        else {
            //sort with quick sort
            sortedQueue = sorter.quickSorter.quickSort(queue);
        }
    }

    //TODO
    private void sortStack(String sortingAlgorithm) {
        if(sortingAlgorithm.equals("bs")) {
            //sort with bubble sort
            //TODO
            //sortedStack = sorter.bubbleSorter.bubbleSort(stack);
        }
        else if (sortingAlgorithm.equals("sbs")) {
            //sort with smart bubble sort
            //TODO
            //sortedStack = sorter.smartBubbleSorter.smartBubbleSort(stack);
        }
        else if (sortingAlgorithm.equals("is")){
            //sort with insertion sort
            //TODO
            //sortedStack = sorter.insertionSorter.insertionSort(stack);
        }
        else {
            //sort with quick sort
            sortedStack = sorter.quickSorter.quickSort(stack);
        }
    }












    public static Pokemon sequentialNameSearch(String name)
    {
        for (Pokemon i : queue)
            if(i.getName().contains(name)){
                return i;
            }
        return null;
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


}
