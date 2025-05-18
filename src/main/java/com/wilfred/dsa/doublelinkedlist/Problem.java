package com.wilfred.dsa.doublelinkedlist;

import com.wilfred.dsa.binarysearchtree.BinarySearchTree;

import java.util.ArrayList;

public class Problem {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int value) {
            this.val = value;
        }
    }

    ;


    public Node flatten(Node head) {
        if(head == null)
            return null;
        Node current = head;
        while (current != null) {
           if(current.child ==null){
               current = current.next;
           }else{
               Node child =  current.child;
               while (child.next!=null){
                   child = child.next;
               }
               child.next = current.next;
               if(child.next!=null){
                   child.next.prev= child;
               }
               current.next =current.child;
               current.next.prev=current;
               current.child=null;

           }
        }
        return head;

    }

    public void recursion(Node currentNode) {

    }
}
