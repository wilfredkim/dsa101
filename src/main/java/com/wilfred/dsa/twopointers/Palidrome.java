package com.wilfred.dsa.twopointers;

public class Palidrome {
    public static void main(String[] args) {
        String word = "loop";
        System.out.println(isPalidrome(word));
    }

    public static boolean isPalidrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (end > start) {
            if (s.charAt(end) != s.charAt(start)) {
                return false;
            }
            end--;
            start++;

        }
        return true;
    }
}
