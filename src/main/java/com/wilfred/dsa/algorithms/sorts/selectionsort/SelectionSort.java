package com.wilfred.dsa.algorithms.sorts.selectionsort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {4, 2, 6, 5, 1, 3};
        selectionSort(arr2);
        System.out.println(Arrays.toString(arr2));

    }
    static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }

        }
    }

    /*...
    Complexity Analysis of Selection Sort
Time Complexity: O(n2) ,as there are two nested loops:

One loop to select an element of Array one by one = O(n)
Another loop to compare that element with every other Array element = O(n)
Therefore overall complexity = O(n) * O(n) = O(n*n) = O(n2)
Auxiliary Space: O(1) as the only extra memory used is for temporary variables.

Advantages of Selection Sort
Easy to understand and implement, making it ideal for teaching basic sorting concepts.
Requires only a constant O(1) extra memory space.
It requires less number of swaps (or memory writes) compared to many other standard algorithms. Only cycle sort beats it in terms of memory writes. Therefore it can be simple algorithm choice when memory writes are costly.
Disadvantages of the Selection Sort
Selection sort has a time complexity of O(n^2) makes it slower compared to algorithms like Quick Sort or Merge Sort.
Does not maintain the relative order of equal elements which means it is not stable.
    * */


}
