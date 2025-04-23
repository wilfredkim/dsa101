package com.wilfred.dsa.algorithms.sorts.mergesort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {100, 0, 20, 4, 5, 6, 8, 102, 600, 1000, 777, 99};
        System.out.println(Arrays.toString(mergeSort(nums)));
    }
    //space complexity O(n)
    //time complexity
    //--- breaking down it takes O(log n)
    //--- merging  the arrays takes O(n)
    //  -- time complexity is O(n log n)


    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int midIndex = array.length / 2;// it is  arrays of integers   so decimal places in odd numbers does not apply in int
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));
        return merge(left, right);
    }

    void mergeSort(int arr[], int l, int r) {
        int mid = arr.length / 2;
        int[] leftSide = mergeSort(Arrays.copyOfRange(arr, l, mid));
        int[] rightSide = mergeSort(Arrays.copyOfRange(arr, mid, r));
         merge(leftSide,rightSide);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] combined = new int[arr1.length + arr2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                combined[index] = arr1[i];
                index++;
                i++;
            } else {
                combined[index] = arr2[j];
                index++;
                j++;
            }
        }
        while (i < arr1.length) {
            combined[index] = arr1[i];
            index++;
            i++;
        }
        while (j < arr2.length) {
            combined[index] = arr2[j];
            index++;
            j++;
        }
        return combined;
    }
}
