package com.wilfred.dsa.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(4);
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();

        System.out.println("\nLinked List:");
        myLinkedList.printList();
        myLinkedList.append(2);
        System.out.println("\nLinked List After Append:");
        myLinkedList.printList();
        myLinkedList.removeLast();
        System.out.println("\nLinked List After Removal:");
        myLinkedList.printList();

        myLinkedList.prepend(5);
        System.out.println("\nLinked List After Prepend:");
        myLinkedList.printList();

        myLinkedList.removeFirst();
        System.out.println("\nLinked List After Remove First:");
        myLinkedList.printList();
    }

}
