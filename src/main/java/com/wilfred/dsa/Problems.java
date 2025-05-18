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


        String palidrome = "aaabaaa";
        String palidrome2 = "aabbaa";
        int len = palidrome.length();
        int len2 = palidrome2.length();
        System.out.println("Mid index is  " + len / 2);
        System.out.println("Index @ mid is " + palidrome.toCharArray()[len / 2]);
        System.out.println("Mid index is  " + len2 / 2);
        System.out.println("Index @ mid is " + palidrome2.toCharArray()[len2 / 2] + " and " + palidrome2.toCharArray()[(len2 / 2) - 1]);

        System.out.println("is a palindrome:::::::::::::" + isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("is a validPalindrome:::::::::::::" + validPalindrome("abc"));
        System.out.println("backspaceCompare:::::::::::::" + backspaceCompare("a##c", "#a#c"));

        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height2 = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("::::::::::max area:::: " + problems.maxArea(height));
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(":::::::::: trap: hhereee****::: " + problems.trap2(height2));
        System.out.println(":::::::::: trap: hhereee****::: " + problems.trap3(height2));

        // System.out.println("::::::::::min capacity:::: " + problems.minCapability(nums, 2));
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
        for (int right = 0; right < s.length(); right++) {
            char current = s.toCharArray()[right];
            if (charMap.containsKey(current) && charMap.get(current) >= left) {
                left = charMap.getOrDefault(current, 0) + 1;
            }
            charMap.put(current, right);

            max = Math.max(max, right - left + 1);
        }

        return max;

    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        String cleanString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanString.length() - 1;
        char[] charArray = cleanString.toCharArray();
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

    public static boolean validPalindrome(String s) {
        if (s.length() <= 1) return true;

        char[] sCharArray = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (sCharArray[left] != sCharArray[right]) {
                return validSubPalindrome(s, left + 1, right) || validSubPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;

    }

    public static boolean validSubPalindrome(String str, int left, int right) {
        if (str.length() <= 1) {
            return true;
        }
        char[] chars = str.toCharArray();
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean backspaceCompare(String s, String t) {
        int p1 = s.length() - 1;
        int p2 = t.length() - 1;

        while (p1 >= 0 || p2 >= 0) {
            if ((p1 >= 0 && s.charAt(p1) == '#') || (p2 >= 0 && t.charAt(p2) == '#')) {
                if (p1 >= 0 && s.charAt(p1) == '#') {
                    int backCount = 2;
                    while (backCount > 0) {
                        p1--;
                        backCount--;
                        if (p1 >= 0 && s.charAt(p1) == '#') {
                            backCount += 2;
                        }
                    }
                }

                if (p2 >= 0 && t.charAt(p2) == '#') {
                    int backCount = 2;
                    while (backCount > 0) {
                        p2--;
                        backCount--;
                        if (p2 >= 0 && t.charAt(p2) == '#') {
                            backCount += 2;
                        }
                    }
                }
            } else {
                char c1 = (p1 >= 0) ? s.charAt(p1) : '\0';
                char c2 = (p2 >= 0) ? t.charAt(p2) : '\0';
                if (c1 != c2) {
                    return false;
                }
                p1--;
                p2--;
            }
        }

        return true;

    }

    public String buildString(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (builder.length() > 0) {
                    builder.deleteCharAt(builder.length() - 1);
                }
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.getOrDefault(target - nums[i], 0), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return new int[]{};

    }

    public int maxArea(int[] height) {
        if (height.length <= 1)
            return 0;
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            int maxStart = height[start];
            int maxEnd = height[end];
            //width * len
            int currentArea = Math.min(maxStart, maxEnd) * (end - start);
            maxArea = Math.max(maxArea, currentArea);
            if (maxStart < maxEnd) {
                start++;
            } else {
                end--;
            }

        }
        return maxArea;

    }

    public int trap(int[] height) {
        //brute force
        int count = 0;
        int maxLeft = 0;
        int maxRight = 0;
        for (int left = 0; left < height.length; left++) {
            maxLeft = Math.max(maxLeft, height[left]);
            for (int right = left + 1; right < height.length; right++) {
                maxRight = Math.max(maxRight, height[right]);
            }
            int currentWater = Math.min(maxLeft, maxRight) - height[left];
            if (currentWater > 0) {
                count += currentWater;
            }
            maxRight = 0;

        }
        return count;

    }

    public int trap2(int[] height) {
        int count = 0;
        int start = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int end = height.length - 1;
        while (start < end) {

            if (height[start] < height[end]) {
                if (height[start] > maxStart) {
                    maxStart = height[start];
                } else {
                    count += maxStart - height[start];
                }
                start++;
            } else {
                if (height[end] > maxEnd) {
                    maxEnd = height[end];
                } else {
                    count += maxEnd - height[end];
                }
                end--;
            }
        }
        return count;

    }

    public int trap3(int[] height) {
        int count = 0;
        int start = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int end = height.length - 1;
        while (start < end) {
            maxStart = Math.max(maxStart, height[start]);
            maxEnd = Math.max(maxEnd, height[end]);
            if (maxStart < maxEnd) {
                int currentWater = Math.min(maxStart, maxEnd) - height[start];
                if (currentWater > 0) {
                    count += currentWater;
                }
                start++;
            } else {
                int currentWater = Math.min(maxStart, maxEnd) - height[end];
                if (currentWater > 0) {
                    count += currentWater;
                }
                end--;
            }
        }
        return count;
    }

    public int minCapability(int[] nums, int k) {
        if (nums.length <= 1)
            return 0;

        int min = Integer.MAX_VALUE;

        for (int right = k; right < nums.length; right++) {
            int maxLeft = nums[right - k];
            int maxRight = nums[right];
            System.out.println("Left:::::::::::::::::: " + maxLeft);
            System.out.println("Right:::::::::::::::::: " + maxRight);
            min = Math.min(min, Math.max(maxLeft, maxRight));
            System.out.println("min:::::::::::::::::: " + min);
            System.out.println("------------------");


        }
        return min;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() &&(c == ')' && stack.peek() == '(') || (c == '}' && stack.peek() == '{') || (c == ']' && stack.peek() == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
