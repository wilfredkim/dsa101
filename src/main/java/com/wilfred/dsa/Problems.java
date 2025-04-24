package com.wilfred.dsa;

import java.util.*;

public class Problems {
    public static void main(String[] args) {
        int arr[] = {5, 3, 8, 1, 6, 9};
        System.out.println(Arrays.toString(findMaxMin(arr)));
    }

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i : nums) {
            if (i != val) {
                count++;
            }

        }
        return count;
    }

    public static int[] findMaxMin(int[] myList) {

        int min = myList[0];
        int max = myList[0];
        for (int i : myList) {
            if (i > max) {
                max = i;
            } else if (i < min) {
                min = i;
            }
        }
        return new int[]{max, min};
    }



}
