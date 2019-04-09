package com.os;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
    private ButtonGroup datastructures;
    private ButtonGroup sorting;
    private ButtonGroup searching;
    private ButtonGroup orderCondition;

    private JRadioButton linkedList;
    private JRadioButton doublyLinkedList;
    private JRadioButton queue;
    private JRadioButton stack;
    private JRadioButton binarySearchTree;

    private JRadioButton bubbleSort;
    private JRadioButton smartBubbleSort;
    private JRadioButton insertionSort;
    private JRadioButton quickSort;

    private JRadioButton sequentialSearch;
    private JRadioButton binarySearch;

    private JRadioButton name;
    private JRadioButton number;

    private JButton sort;
    private JButton search;
    private JButton resetOrderCondition;

    private JTextField searchTerm;

    private JTextArea output;

    private Controller controller;

    private final String linkedListString = "Linked List";
    private final String doublyLinkedListString = "Doubly Linked List";
    private final String queueString = "Queue";
    private final String stackString = "Stack";
    private final String binarySearchTreeString = "Binary Search Tree";

    private final String bubbleSortString = "Bubble Sort";
    private final String smartBubbleSortString = "Smart Bubble Sort";
    private final String insertionSortString = "Insertion Sort";
    private final String quickSortString = "Quick Sort";

    private final String sequentialSearchString = "Sequential Search";
    private final String binarySearchString = "Binary Search";

    private final String nameString = "Name";
    private final String numberString = "Number";

    public static void main(String args[]) {
        GUI gui = new GUI();
    }

    public GUI() {
        super();
        this.setSize(800, 600);
        this.setVisible(true);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        //setup radio buttons
        setupRadioButtons();

        //Layout
        this.setLayout(new BorderLayout());


        //Top part with radio buttons
        JPanel topGroupControls = new JPanel();
        topGroupControls.setLayout(new GridLayout(1,3));

        JPanel datastructuresList = new JPanel();
        datastructuresList.setLayout(new GridLayout(6, 1));
        JPanel sortAlgorithmList = new JPanel();
        sortAlgorithmList.setLayout(new GridLayout(6, 1));
        JPanel searchAlgorithmList = new JPanel();
        searchAlgorithmList.setLayout(new GridLayout(6,1));

        JLabel labelDataStructures = new JLabel("Data structures:");
        JLabel labelSortAlgorithm = new JLabel("Sort algorithm:");
        JLabel labelSearchAlgorithm = new JLabel("Search algorithm:");
        JLabel labelOrderCondition = new JLabel("Order condition:");

        datastructuresList.add(labelDataStructures);
        datastructuresList.add(linkedList);
        datastructuresList.add(doublyLinkedList);
        datastructuresList.add(queue);
        datastructuresList.add(stack);
        datastructuresList.add(binarySearchTree);

        sortAlgorithmList.add(labelSortAlgorithm);
        sortAlgorithmList.add(bubbleSort);
        sortAlgorithmList.add(smartBubbleSort);
        sortAlgorithmList.add(insertionSort);
        sortAlgorithmList.add(quickSort);

        searchAlgorithmList.add(labelSearchAlgorithm);
        searchAlgorithmList.add(sequentialSearch);
        searchAlgorithmList.add(binarySearch);
        searchAlgorithmList.add(labelOrderCondition);
        searchAlgorithmList.add(name);
        searchAlgorithmList.add(number);

        topGroupControls.add(datastructuresList);
        topGroupControls.add(sortAlgorithmList);
        topGroupControls.add(searchAlgorithmList);

        //Middle part, search bar and buttons
        JPanel middle = new JPanel();
        middle.setLayout(new GridLayout(3,1));
        JPanel sortLine = new JPanel();
        sortLine.setLayout(new FlowLayout());
        JPanel searchLine = new JPanel();
        searchLine.setLayout(new FlowLayout());
        JPanel orderLine = new JPanel();
        orderLine.setLayout(new FlowLayout());

        Dimension buttonDimension = new Dimension(120, 25);
        sort = new JButton("Sort");
        sort.setMinimumSize(buttonDimension);
        sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sort();
            }
        });
        search = new JButton("Search");
        search.setMinimumSize(buttonDimension);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });
        resetOrderCondition = new JButton("Reset order condition");
        resetOrderCondition.setMinimumSize(buttonDimension);
        resetOrderCondition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });

        searchTerm = new JTextField();
        searchTerm.setPreferredSize(new Dimension(200, 20));

        sortLine.add(sort);
        searchLine.add(searchTerm);
        searchLine.add(search);
        orderLine.add(resetOrderCondition);

        middle.add(sortLine);
        middle.add(searchLine);
        middle.add(orderLine);

        //output
        JPanel outputPanel = new JPanel();
        //outputPanel.setLayout(new FlowLayout());

        output = new JTextArea();
        output.setText("Output\n");
        output.setEditable(false);

        JScrollPane scroll = new JScrollPane(output);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(700, 200));

        outputPanel.add(scroll);

        this.add(topGroupControls, BorderLayout.NORTH);
        this.add(middle, BorderLayout.CENTER);
        this.add(outputPanel, BorderLayout.SOUTH);
        this.setVisible(true);

        controller = new Controller();

    }

    private void setupRadioButtons() {
        //data structures
        linkedList = new JRadioButton(linkedListString);
        linkedList.setActionCommand(linkedListString);
        doublyLinkedList = new JRadioButton(doublyLinkedListString);
        doublyLinkedList.setActionCommand(doublyLinkedListString);
        queue = new JRadioButton(queueString);
        queue.setActionCommand(queueString);
        stack = new JRadioButton(stackString);
        stack.setActionCommand(stackString);
        binarySearchTree = new JRadioButton(binarySearchTreeString);
        binarySearchTree.setActionCommand(binarySearchTreeString);

        linkedList.setSelected(true);

        datastructures = new ButtonGroup();
        datastructures.add(linkedList);
        datastructures.add(doublyLinkedList);
        datastructures.add(queue);
        datastructures.add(stack);
        datastructures.add(binarySearchTree);

        //sorting
        bubbleSort = new JRadioButton(bubbleSortString);
        bubbleSort.setActionCommand(bubbleSortString);
        smartBubbleSort = new JRadioButton(smartBubbleSortString);
        smartBubbleSort.setActionCommand(smartBubbleSortString);
        insertionSort = new JRadioButton(insertionSortString);
        insertionSort.setActionCommand(insertionSortString);
        quickSort = new JRadioButton(quickSortString);
        quickSort.setActionCommand(quickSortString);

        bubbleSort.setSelected(true);

        sorting = new ButtonGroup();
        sorting.add(bubbleSort);
        sorting.add(smartBubbleSort);
        sorting.add(insertionSort);
        sorting.add(quickSort);

        //searching
        sequentialSearch = new JRadioButton(sequentialSearchString);
        sequentialSearch.setActionCommand(sequentialSearchString);
        binarySearch = new JRadioButton(binarySearchString);
        binarySearch.setActionCommand(binarySearchString);

        sequentialSearch.setSelected(true);

        searching = new ButtonGroup();
        searching.add(sequentialSearch);
        searching.add(binarySearch);

        //sorting criteria
        name = new JRadioButton(nameString);
        name.setActionCommand(nameString);
        number = new JRadioButton(numberString);
        number.setActionCommand(numberString);

        name.setSelected(true);

        orderCondition = new ButtonGroup();
        orderCondition.add(name);
        orderCondition.add(number);

    }

    public void sort() {
        String dsString = currentDataStructureSelected();
        String sString = currentSortMethodSelected();
        String dsFull = datastructures.getSelection().getActionCommand();
        String sFull = sorting.getSelection().getActionCommand();

        long time = controller.sort(dsString, sString);

        output.setText(getDatastructureStringSorted(dsString));
        output.append("\nThe " + dsFull + " was sorted by the " + sFull + " algorithm in " + time + " miliseconds.\n");
    }

    public void search() {
        String searchPart = searchTerm.getText();
        String nameString = "";
        int nr = 0;
        String ds = currentDataStructureSelected();
        String sa = currentSearchAlgorithm();
        if(number.isSelected()) {
            try {
                nr = Integer.parseInt(searchPart);
            }
            catch (Exception e){

            }
        }
        else {
            nameString = searchPart;
        }
        Pokemon pokemon = new Pokemon(nr, nameString, "", "", 0,0,0,0,0,0,0, 0, false);
        if(name.isSelected()) {
            pokemon.setCompareCriteria(name.getActionCommand());
        }
        else if (number.isSelected()) {
            pokemon.setCompareCriteria(number.getActionCommand());
        }
        output.setText("The pokemon is at position: " + controller.search(ds, sa, pokemon));

    }

    public void reset() {
        String order = "";
        if(name.isSelected()) {
            order = name.getActionCommand();
        }
        else if (number.isSelected()) {
            order = number.getActionCommand();
        }
        output.setText(controller.reset(order));
    }

    private String getDatastructureStringSorted(String dsString) {
        if(dsString.equals("ll")) {
            return controller.getLinkedListString(true);
        }
        if(dsString.equals("dll")) {
            return controller.getDoublyLinkedListString(true);
        }
        if(dsString.equals("q")) {
            return controller.getQueueString(true);
        }
        if(dsString.equals("s")) {
            return controller.getStackString(true);
        }
        if (dsString.equals("bst")) {
            return controller.getBinarySearchTreeString(true);
        }
        return "";
    }

    private String currentDataStructureSelected() {
        if(datastructures.getSelection().getActionCommand().equalsIgnoreCase(linkedListString)) {
            return "ll";

        }
        else if (datastructures.getSelection().getActionCommand().equalsIgnoreCase(doublyLinkedListString)){
                return "dll";
        }
        else if (datastructures.getSelection().getActionCommand().equalsIgnoreCase(queueString)) {
            return "q";
        }
        else if(datastructures.getSelection().getActionCommand().equalsIgnoreCase(stackString)) {
            return "s";
        }
        else if(datastructures.getSelection().getActionCommand().equalsIgnoreCase(binarySearchTreeString)) {
            return "bst";
        }
        else {
            return "-";
        }
    }

    private String currentSortMethodSelected() {
        if(sorting.getSelection().getActionCommand().equalsIgnoreCase(bubbleSortString)) {
            return "bs";
        }
        else if (sorting.getSelection().getActionCommand().equalsIgnoreCase(smartBubbleSortString)) {
            return "sbs";
        }
        else if (sorting.getSelection().getActionCommand().equalsIgnoreCase(insertionSortString)) {
            return "is";
        }
        else if (sorting.getSelection().getActionCommand().equalsIgnoreCase(quickSortString)) {
            return "qs";
        }
        else {
            return "-";
        }
    }

    private String currentSearchAlgorithm() {
        if(searching.getSelection().getActionCommand().equalsIgnoreCase(sequentialSearchString)) {
            return "ss";
        }
        else if (searching.getSelection().getActionCommand().equalsIgnoreCase(binarySearchString)) {
            return "bs";
        }
        else {
            return "-";
        }
    }

}
