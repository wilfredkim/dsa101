package com.wilfred.dsa;

import java.util.*;

public class Problems {
    public static void main(String[] args) {
        int arr[] = {12, 35, 1, 10, 34, 1};
        int arr2[] = {1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1};
        int arr3[] = {1, 2, 0, 4, 3, 0, 5, 0};
        Problems problems = new Problems();
        System.out.println(problems.getSecondLargest(arr));
        System.out.println(problems.maxConsecutiveCount(arr2));
        problems.pushZerosToEnd(arr3);
        int[][] aaarr = {{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}};
        System.out.println(":::::::::::::: " + problems.numEquivDominoPairs(aaarr));
        System.out.println(":::::::::::::: " + problems.lengthOfLongestSubstring("pwwkew"));

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

    public static int maxSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public int getSecondLargest(int[] arr) {
        int largest = -1;
        int secondLargest = -1;
        for (int i : arr) {
            if (i > largest) {
                largest = i;
            }
        }
        for (int i : arr) {
            if (i > secondLargest && i != largest) {
                secondLargest = i;
            }
        }
        return secondLargest;

    }

    int maxProduct(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        System.out.println("sorted array " + Arrays.toString(arr));
        return Math.max(arr[0] * arr[1] * arr[len - 1],
                arr[len - 1] * arr[len - 2] * arr[len - 3]);

    }

    public int maxConsecutiveCount(int[] arr) {
        // code here

        int count = 0;
        int maxCount = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        return Math.max(maxCount, count);
    }

    void pushZerosToEnd(int[] arr) {
        // code here
        int len = arr.length;
        int count = 0;
        int[] nonZeros = new int[len];

        for (int j : arr) {
            if (j != 0) {
                nonZeros[count++] = j;
            }
        }
        while (count > len) {
            nonZeros[count++] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nonZeros[i];
        }


    }

    void reverseInGroups(int[] arr, int k) {
        int n = arr.length;

        for (int i = 0; i < n; i += k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);

            // Reverse the sub-array
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    public int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(array, mid, array.length));
        return merge(left, right);

    }

    int[] merge(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int index = 0;
        int[] combined = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                combined[index] = arr1[i];
                i++;
                index++;
            } else {
                combined[index] = arr2[j];
                j++;
                index++;
            }

        }
        while (i < arr1.length) {
            combined[index] = arr1[i];
            i++;
            index++;
        }
        while (j < arr2.length) {
            combined[index] = arr2[j];
            j++;
            index++;
        }
        return combined;
    }

    int[] addOne(int[] arr) {
        // code here
        int carry = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int sum = arr[i] + carry;
            arr[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0) {
            int[] newArr = new int[arr.length + 1];
            newArr[0] = carry;
            System.arraycopy(arr, 0, newArr, 1, arr.length);
            return newArr;
        }

        return arr;


    }


    static int repeatedSumOfDigits(int N) {
        int sum = 0;
        while (N > 0 || sum > 9) {
            if (N == 0) {
                N = sum;
                sum = 0;
            }
            sum += N % 10;
            N = N / 10;
        }
        return sum;
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1]
                    ? domino[0] * 10 + domino[1]
                    : domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int max = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        for (int right = left; right < s.length(); right++) {
            char current = s.toCharArray()[right];
            if (charMap.containsKey(current) && charMap.get(current) >= left) {
                left = charMap.getOrDefault(current,0) + 1;
            }
            charMap.put(current, right);

            max = Math.max(max, right - left+1 );
        }

        return max;

    }

}
