package com.example.project.Insertion_Sort;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class InsertionSort {

    // PART A. implementing insertion sort
    public static int[] insertionSort(int[] elements) {
        int loopCounter = 0;
        for (int i = 1; i < elements.length; i++) {
            int j = i;
            while (j > 0 && elements[j] < elements[j - 1]) {
                int temp = elements[j];
                elements[j] = elements[j - 1];
                elements[j - 1] = temp;
                j--;
                loopCounter++;
            }
        }
        System.out.println("INSERTION SORT: NUMBER OF ITERATIONS: " + loopCounter);
        return elements;
    }

   
    public static void selectionSort(int[] elements) {
        int loopCounter = 0;
        for (int i = 0; i < elements.length; i++) {
            int min = elements[i];
            int minIdx = i;
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j] < min) {
                    minIdx = j;
                    min = elements[j];
                }
                loopCounter++;
            }
            int temp = elements[i];
            elements[i] = elements[minIdx];
            elements[minIdx] = temp;
        }
        System.out.println("SELECTION SORT: NUMBER OF ITERATIONS: " + loopCounter);
    }

    // PART B. sorting a 1000-word list
    public static ArrayList<String> insertionSortWordList(ArrayList<String> words) {
        for (int i = 1; i < words.size(); i++) {
            int j = i;
            while (j > 0 && words.get(j).compareTo(words.get(j - 1)) < 0) {
                words.set(j, words.set(j - 1, words.get(j)));
                j--;
            }
        }
        return words;
    }

    public static void selectionSortWordList(ArrayList<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String min = words.get(i);
            int minIdx = i;
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(j).compareTo(min) < 0) {
                    minIdx = j;
                    min = words.get(j);
                }
            }
            words.set(i, words.set(minIdx, words.get(i)));
        }
    }

    public static ArrayList<String> loadWordsInto(ArrayList<String> wordList) {
        try {
            Scanner input = new Scanner(new File("src/main/java/com/example/project/Selection_Sort/words.txt"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordList;
    }

    public static void main(String[] args) {
        int[] arrA = {8,1,7,9,10,3,5,6,4,15,13,11,12,14,2};
        int[] arrB = {8,1,7,9,10,3,5,6,4,15,13,11,12,14,2};
        InsertionSort.selectionSort(arrA);
        System.out.println(Arrays.toString(arrA));
        System.out.println();
        InsertionSort.insertionSort(arrB);
        System.out.println(Arrays.toString(arrB));        
    }

}