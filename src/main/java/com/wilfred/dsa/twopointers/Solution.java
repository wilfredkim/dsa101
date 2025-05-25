package com.wilfred.dsa.twopointers;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int leftPos = binarySearch(nums, 0, nums.length - 1, target);
        if (leftPos == -1) {
            return new int[]{-1, -1};
        } else {
            int startPos = leftPos;
            int endPos = leftPos;
            int temp1 = -1, temp2 = -1;
            while (startPos != -1) {
                temp1 = startPos;
                startPos = binarySearch(nums, 0, startPos - 1, target);
            }
            startPos = temp1;
            while (endPos != -1) {
                temp2 = endPos;
                endPos = binarySearch(nums, endPos + 1, nums.length - 1, target);
            }
            endPos = temp2;
            return new int[]{startPos, endPos};
        }
    }

        private int binarySearch(int[] nums, int left, int right, int target) {
            if (nums.length == 0) {
                return -1;
            }
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
}
