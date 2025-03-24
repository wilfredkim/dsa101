package com.wilfred.dsa.stacks;

import java.util.*;
import java.util.Stack;

public class TestStack<T> {
    private ArrayList<T> stackList = new ArrayList<>();

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public void printStack() {
        for (int i = stackList.size() - 1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public int size() {
        return stackList.size();
    }

    public void push(int value) {
        Integer newElement = value;

        stackList.add((T) newElement);

    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T lastItem = stackList.get(stackList.size() - 1);
        stackList.remove(lastItem);
        return lastItem;

    }

    public static String reverseString(String word) {
        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            stack.add(word.charAt(i));
        }
        String reverse = "";
        while (!stack.isEmpty()) {
            Character pop = stack.get(stack.size() - 1);
            reverse += pop;
            stack.remove(pop);
        }
        return reverse;


    }

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> additionalStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            while (!additionalStack.isEmpty() && additionalStack.peek() > temp) {
                stack.push(additionalStack.pop());
            }

            additionalStack.push(temp);
        }

        while (!additionalStack.isEmpty()) {
            stack.push(additionalStack.pop());
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseString("word"));
    }


}
