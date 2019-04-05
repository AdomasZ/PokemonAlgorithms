package com.os;

public class InsertionSorter {
    MyLinkedList<Pokemon> test = new MyLinkedList<>();

    public MyLinkedList<Pokemon> insertionSort(MyLinkedList<Pokemon> list) {
        int n = list.size();
        //i did n++ instead of ++i... took me atleast 3 hours. I even made my own method checking the first letter of the string
        for(int i = 1; i < n; ++i) {
            Pokemon key = list.get(i).getData();
            int j = i - 1;

//            while(j >= 0 && compareHigherThan(list.get(j).getData(), key)) {
//                Pokemon pokemon = list.get(j).getData();
//                list.get(j + 1).setData(pokemon);
//                j = j - 1;
//            }

            while(j >= 0 && list.get(j).getData().compareTo(key) > 0) {
                Pokemon pokemon = list.get(j).getData();
                list.get(j + 1).setData(pokemon);
                j = j - 1;
            }
            list.get(j + 1).setData(key);
        }
        return list;
    }


//    private boolean compareHigherThan(Pokemon pokemon1, Pokemon pokemon2) {
//        int diff = pokemon1.getName().toLowerCase().charAt(0) - pokemon2.getName().toLowerCase().charAt(0);
//        if(diff > 0) {
//            return true;
//        }
//        return false;
//    }

    //TODO
    public MyDoublyLinkedList insertionSort(MyDoublyLinkedList<Pokemon> list) {
        int n = list.size();
        for(int i = 1; i < n; ++i) {
            Pokemon key = list.get(i).getData();
            int j = i - 1;

            while(j >= 0 && list.get(j).getData().compareTo(key) > 0) {
                Pokemon pokemon = list.get(j).getData();
                list.get(j + 1).setData(pokemon);
                j = j - 1;
            }
            list.get(j + 1).setData(key);
        }
        return list;
    }

}
