package com.wilfred.dsa.stacks;


import com.wilfred.dsa.doublelinkedlist.DNode;

public class Stack {
    private Node top;
    private int height;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (top == null || height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop() {
        if (top == null || height == 0) {
            return null;
        }
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;

    }

    public void getTop() {
        if (top == null) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
    }

    public void getHeight() {
        System.out.println("Height: " + height);
    }
}
