package com.wilfred.dsa.queues;

import java.util.List;
import java.util.Stack;

public class MyQueue {
    //stack
    Stack<Integer> inputStack ;

    //inputStack
    Stack<Integer> outputStack ;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);

    }

    public int pop() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.isEmpty() ? -1 : outputStack.pop();

    }

    public int peek() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.isEmpty() ? -1 : outputStack.peek();

    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}
