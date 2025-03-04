package com.wilfred.dsa.slidingwindow;

import java.util.*;

public class Solution {

    public int findLength(int[] nums, int k) {

        int current = 0;
        int left = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            current += nums[right];
            while (current > k) {
                current -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int findLength(String s) {
        int cur = 0;
        int left = 0;
        int ans = 0;
        for (int right = 0; right < s.length() - 1; right++) {
            if (s.charAt(right) == '0') {
                cur += 1;
            }
            while (cur > 1) {
                if (s.charAt(left) == '0') {
                    cur -= 1;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int current = 0;
        int left = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            current += nums[right];
            while (current > k) {
                current -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int findBestSubarray(int[] nums, int k) {
        int length = nums.length;
        if (k >= length)
            return -1;
// sum of first subarray;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }
        //find the remaining
        //updating max value;
        int ans = maxSum;
        for (int i = k; i < nums.length; i++) {
            ans += nums[i] - nums[i - k];
            ans = Math.max(maxSum, ans);
        }
        return ans;

    }

    public static int smallestSubarrayWithSum(int[] nums, int X) {
        int sum = 0, left = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > X) {
                minLength = Math.min(minLength, right - left + 1);
                sum = -nums[left];
                left++;
            }
        }
        return (minLength == Integer.MAX_VALUE) ? -1 : minLength;


    }

    static ArrayList<Integer> subarraySum(int[] arr, int target) {

        int left = 0, sum = 0;
        ArrayList<Integer> results = new ArrayList<>();
        for (int right = 0; right < arr.length - 1; right++) {
            sum += arr[right];
            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;

            }
            if (target == sum) {
                results.add(left + 1);
                results.add(right + 1);
                return results;
            }


        }
        return (ArrayList<Integer>) List.of(-1);
    }


    public static int maximumSumSubarray(int[] arr, int k) {
        int maxSum = 0;
        int firstSum = 0;
        for (int i = 0; i < k; i++) {
            firstSum += arr[i];
        }

        maxSum = firstSum;

        for (int i = k; i < arr.length; i++) {
            maxSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, maxSum);

        }
        return maxSum;


    }


    static ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> results = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        results.add(map.size());
        for (int i = k; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            map.put(arr[i - k], map.getOrDefault(arr[i - k], 0) - 1);

            if (map.get(arr[i - k]) == 0) {
                map.remove(arr[i - k]);
            }
            results.add(map.size());
        }
        return results;
    }

    static List<Integer> FirstNegativeInteger(int arr[], int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                queue.addLast(i);
            }
        }

        for (int i = k; i < arr.length; i++) {
            if (!queue.isEmpty()) {
                ans.add(arr[queue.peekFirst()]);
            } else {
                // Else the window does not have a negative integer
                ans.add(0);
            }
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.removeFirst();
            }
            if (arr[i] < 0) {
                queue.addLast(i);
            }
        }
        if (!queue.isEmpty()) {
            ans.add(arr[queue.peekFirst()]);
        } else {
            ans.add(0);
        }

        return ans;


    }

    public static ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        Deque<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        for (int i = k; i < arr.length; i++) {
            ans.add(arr[queue.peekFirst()]);
            while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        ans.add(arr[queue.peekFirst()]);
        return ans;
    }

    static int maximum_toys(int cost[], int K) {
        int left = 0;
        int count = 0;
        int maxCost = 0;
        for (int right = 0; right < cost.length - 1; right++) {
            maxCost += cost[right];
            count++;
            if (maxCost > K) {
                maxCost -= cost[left];
                left++;
                count--;
            }
        }
        return count;
    }

    static int longestUniqueSubstr(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s.length();
        }
        int results = 0;
        int right = 0, left = 0;
        boolean[] isVisited = new boolean[Character.MAX_VALUE];
        while (right < s.length()) {
            while (isVisited[s.charAt(right) - 'a']) {
                isVisited[s.charAt(left) - 'a'] = false;
                left++;
            }
            isVisited[s.charAt(right) - 'a'] = true;
            results = Math.max(results, (right - left + 1));
            right++;

        }
        return results;
    }

    public static void main(String[] args) {
        int[] arr = {100, 200, 300, 400};
        int k = 3;
        //System.out.println(maximumSumSubarray(arr, k));
        int[] nums = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        System.out.println(maxOfSubarrays(nums, k));
        int[] cost = {1, 12, 5, 111, 200, 1000, 10};
        int K = 50;
        System.out.println(maximum_toys(cost, K));

    }
}
