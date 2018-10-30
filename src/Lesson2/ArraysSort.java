package Lesson2;

import java.util.Random;

public class ArraysSort {
    public static void main(String[] args) {
        int arrSize = 1_000_000_000;
        MyArrayList<Integer> myList = new MyArrayList<>();

        for (int i = 0; i < arrSize; i++) {
            myList.insert(new Random().nextInt(500));
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                MyArrayList<Integer> myListBubble = new MyArrayList<>();
                for (int i = 0; i < arrSize; i++) {
                    myListBubble.insert(myList.get(i));
                }
                //System.out.println(myListBubble);
                long startInsert = System.nanoTime();
                myListBubble.insertionSort();
                System.out.println("Сортировка пузырьком за " + ((System.nanoTime() - startInsert) / 1_000_000_000.0) + " сек");
                //System.out.println(myListBubble);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                MyArrayList<Integer> myListInsert = new MyArrayList<>();
                for (int i = 0; i < arrSize; i++) {
                    myListInsert.insert(myList.get(i));
                }
                //System.out.println(myListInsert);
                long startInsert = System.nanoTime();
                myListInsert.insertionSort();
                System.out.println("Сортировка вставкой за " + ((System.nanoTime() - startInsert) / 1_000_000_000.0) + " сек");
                //System.out.println(myListInsert);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                MyArrayList<Integer> myListSelect = new MyArrayList<>();
                for (int i = 0; i < arrSize; i++) {
                    myListSelect.insert(myList.get(i));
                }
                //System.out.println(myListSelect);
                long startSelect = System.nanoTime();
                myListSelect.selectionSort();
                System.out.println("Сортировка выбором за " + ((System.nanoTime() - startSelect) / 1_000_000_000.0) + " сек");
                //System.out.println(myListSelect);
            }
        }).start();
    }
}