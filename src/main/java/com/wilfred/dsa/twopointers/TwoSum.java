package com.wilfred.dsa.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int target = 6;
        // System.out.println(isTwoSumPresent(nums, target));
        //System.out.println(Arrays.toString(twoSum2(nums, target)));
        //System.out.println((trap(height)));
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(maxArea(height));
    }


    public static boolean isTwoSumPresent(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (end > start) {
            if (nums[start] + nums[end] == target) {
                return true;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }

        }
        return false;

    }

    public static int trap(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int count = 0;
        int maxStart = height[start];
        int maxEnd = height[end];
        while (end > start) {
            if (maxStart < maxEnd) {
                start++;
                maxStart = Math.max(maxStart, height[start]);
                count += (maxStart) - height[start];
            } else {
                end--;
                maxEnd = Math.max(maxEnd, height[end]);
                count += (maxEnd) - height[end];

            }
        }
        return count;

    }

    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxStart = height[start];
        int maxEnd = height[end];
        int count = 0;
        int max = 0;
        while (end > start) {
            if (Math.min(maxStart, maxEnd) > max) {
                max = Math.min(maxStart, maxEnd) * Math.min(maxStart, maxEnd);
            }
            if (maxStart < maxEnd) {
                start++;
                maxStart = Math.max(maxStart, height[start]);
            } else {
                end--;
                maxEnd = Math.max(maxEnd, height[end]);
            }


        }

        return max;

    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (end > start) {
            char swap = s[start];
            s[start] = s[end];
            s[end] = swap;
            end--;
            start++;

        }
        System.out.println(Arrays.toString(s));
    }


    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> set = new HashMap<>();
        int[] results = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (set.containsKey(rem)) {
                results[0] = set.get(rem);
                results[1] = i;
                return results;
            } else {
                set.put(nums[i], i);

            }

        }
        return results;
    }

}
