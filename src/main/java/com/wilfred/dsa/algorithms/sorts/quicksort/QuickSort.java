package com.wilfred.dsa.algorithms.sorts.quicksort;

import java.util.Arrays;
import java.util.HashMap;

public class QuickSort {

    /*    ...
    *QuickSort is a sorting algorithm based on the Divide and Conquer that picks an element as a pivot and partitions the given array around the picked
    * pivot by placing the pivot in its correct position in the sorted array.

    It works on the principle of divide and conquer, breaking down the problem into smaller sub-problems.

    There are mainly three steps in the algorithm:

    Choose a Pivot: Select an element from the array as the pivot. The choice of pivot can vary (e.g., first element, last element, random element, or median).
    Partition the Array: Rearrange the array around the pivot. After partitioning, all elements smaller than the pivot will be on its left, and all elements greater than the pivot will be on its right.
    * The pivot is then in its correct position, and we obtain the index of the pivot.
    Recursively Call: Recursively apply the same process to the two partitioned sub-arrays (left and right of the pivot).
    Base Case: The recursion stops when there is only one element left in the sub-array, as a single element is already sorted.
    *
    *
    *
    *
    *Time Complexity
    *  find pivot is O(n)
    *   divide and sort is (O log n)
    *  Time complexity is O(n log n) for best and average case  Worst Case: (O(n²)), Occurs when the smallest or largest element is always chosen as the pivot (e.g., sorted arrays)
    * !!
    *
    * */
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int[] arr2 = {4, 6, 1, 7, 3, 2, 5};
        System.out.println("Pivot Index:::::::::" + pivot(arr2, 0, arr.length - 1));
        System.out.println(Arrays.toString(arr2));
        quickSort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));
        String s ="abcd";
        String t ="abcde";
        System.out.println(findTheDifference(s,t)+" ");

    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = pivot(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);

            }

        }
        swap(array, pivotIndex, swapIndex);
        return swapIndex;

    }


    public static void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }


    static void quickSort2(int arr[], int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        int swap = low;
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < arr[low]) {
                swap++;
                swap(arr, swap, i);
            }
        }
        swap(arr, low, swap);
        return swap;
    }


    public static char findTheDifference(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!hashMap.containsKey(c) || hashMap.get(c) == 0) {
                return c;
            }
            hashMap.put(c, hashMap.get(c) - 1);
        }

        return 0;

    }
}



