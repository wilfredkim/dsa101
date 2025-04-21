package com.wilfred.dsa.algorithms.sorts.bubblesort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 5, 1, 3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*    Advantages of Bubble Sort:
        Bubble sort is easy to understand and implement.
        It does not require any additional memory space.
        It is a stable sorting algorithm, meaning that elements with the same key value maintain their
         relative order in the sorted output.


        Disadvantages of Bubble Sort:
        Bubble sort has a time complexity of O(n2) which makes it very slow for large data sets.
        Bubble sort has almost no or limited real world applications. It is mostly used in academics to teach different ways of sorting.

        */
    static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }


            }
        }
    }
//other implementation
    static void bubbleSort2(int[] array){
        for(int i=0; i< array.length-1; i++){
            for( int j =0; j<array.length-1-i; j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1]= temp;
                }
            }

        }
    }


}
