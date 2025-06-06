package com.wilfred.dsa;

import java.util.HashMap;

public class Test {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int left = 0;
        if (s.length() <= 1) {
            return s.length();
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char current = s.toCharArray()[right];
            if (hashMap.containsKey(current) && hashMap.getOrDefault(current, 0) >= left) {
                left = hashMap.getOrDefault(current, 0) + 1;
            }
            hashMap.put(current, right);
            longest = Math.max(longest, right - left + 1);

        }
        return longest;
    }

    int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start < end) {
            int maxStart = height[start];
            int maxEnd = height[end];

            max = Math.max(max, (Math.min(maxStart, maxEnd) * (end - start)));

            if (maxStart < maxEnd) {
                start++;
            } else {
                end--;
            }


        }
        return max;
    }
}
