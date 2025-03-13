package com.wilfred.dsa.twopointers;

import java.util.*;

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
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        int []  num3 = {-1,0,1,2,-1,-4};
        System.out.println("three sums!!  " + threeSum(num3));
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

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> integers = new ArrayList<>();
        int x = 0;
        int y = 0;
        while (x < nums1.length && y < nums2.length) {
            if (nums1[x] < nums2[y]) {
                integers.add(nums1[x]);
                x++;
            } else {
                integers.add(nums2[y]);
                y++;
            }
        }
        while (x < nums1.length) {
            integers.add(nums1[x]);
            x++;
        }
        while (y < nums2.length) {
            integers.add(nums2[y]);
            y++;
        }

        int length = integers.size();
        int mid = length / 2;

        if (length % 2 == 0) {
            return (double) (integers.get(mid) + integers.get(mid - 1)) / 2;
        } else {
            return integers.get(mid);
        }


    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        int start = 0;
        int end = length - 1;
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> indexs = new ArrayList<>();
        while (start < end) {
            int i = nums[start];
            int j = nums[end - 1];
            int k = nums[end];
            int sum = i + j + k;
            System.out.println("i:::::::"+i+ " ::::::::::j "+j +" ::::::::::::::k "+k);
            /* i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.*/
            if (sum == 0) {
                indexs.add(i);
                indexs.add(j);
                indexs.add(k);
                results.add(indexs);
                end--;
            } else if (sum <=1) {
                end--;
            } else {
                start++;
            }


        }
        return results;

    }

}
