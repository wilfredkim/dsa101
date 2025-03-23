package com.wilfred.dsa.doublelinkedlist;

import com.wilfred.dsa.linkedlist.LinkedList;

public class DMain {
    public static void main(String[] args) {
        DoubleLinkedList myLinkedList = new DoubleLinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
       // myLinkedList.append(4);

        System.out.println("\nLinked List:");
        myLinkedList.printList();

        myLinkedList.swapPairs();
        System.out.println("\nLinked List 2:");
        myLinkedList.printList();
    }
}
