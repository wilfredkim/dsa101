package com.wilfred.dsa.recursion;

public class Recursion {

    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        System.out.println("n::::::::::"+n);
        return n * factorial(n - 1);
    }
}
