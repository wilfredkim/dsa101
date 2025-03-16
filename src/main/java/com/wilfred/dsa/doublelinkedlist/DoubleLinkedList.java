package com.wilfred.dsa.doublelinkedlist;


import com.wilfred.dsa.linkedlist.Node;

public class DoubleLinkedList {

    private DNode head;
    private DNode tail;
    int length;

    public DoubleLinkedList(int value) {
        DNode newNode = new DNode(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        DNode temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        DNode newNode = new DNode(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public DNode removeLast() {
        if (length == 0) {
            return null;
        }
        DNode temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;

        }
        length--;

        return temp;

    }

    public void prepend(int value) {
        DNode newNode = new DNode(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
            tail.prev = head;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public DNode removeFirst() {
        if (length == 0) {
            return null;
        }
        DNode temp = head;

        if (length == 1) {
            tail = null;
            head = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;

        }
        length--;
        return temp;

    }

    public DNode get(int index) {
        if (index <= 0 || index >= length) {
            return null;
        }
        DNode temp = head;
        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        DNode node = get(index);
        if (node != null) {
            node.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }

        DNode before = get(index - 1);
        DNode after = before.next;
        DNode newNode = new DNode(value);
        before.next = newNode;
        newNode.prev = before;
        newNode.next = after;
        after.prev = newNode;
        length++;
        return true;
    }

    public DNode remove(int index) {

        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }
        DNode before = get(index - 1);
        DNode temp = before.next;//to be remove
        DNode after = temp.next;
        before.next = after;
        after.prev = before;
        temp.next = null;
        temp.prev = null;
        length--;

      /*  //other way of doing with one variable
        DNode temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next =null;
        temp.prev=null;
        length--;*/
        return temp;


    }

    public void swapFirstLast() {
        if (length == 0) {
            return;
        }
        if (length < 2) {
            return;
        }
        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    public void reverse() {
        DNode current = head;
        DNode temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    public DNode reverseDLL(DNode head) {
        // Your code here
        DNode temp = null;
        DNode  current = head;

        while(current!=null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;

        }

        return (temp != null) ? temp.prev : head;

    }

    public void swapPairs() {
        if (length == 0) {
            return;
        }
        DNode current = head;
        while (current != null && current.next!=null) {
            System.out.println("Current::::::::::"+ current.value);
            System.out.println("Next::::::::::"+ current.next.value);
            int temp =current.value;
            current.value = current.next.value;
            current.next.value = temp;
            current = current.next.next;


        }
    }


    public boolean isPalindrome() {
        if (length <= 1) {
            return true;
        }
        DNode headF = head;
        DNode backT = tail;
        for (int i = 0; i < length / 2; i++) {
            if (headF.value != backT.value) {
                return false;
            }
            headF = headF.next;
            backT = backT.prev;
        }
        return true;
    }


    public void reverseExplain() {
        // 'current' starts at the head of the list. This is the starting point
        // for the reversal process.
        DNode current = head;

        // 'temp' is a temporary variable used for swapping nodes. It is initially
        // set to null since we haven't started the swapping process yet.
        DNode temp = null;

        // We enter a loop that will continue as long as 'current' is not null.
        // This loop goes through each node in the list.
        while (current != null) {
            // Store the previous node of 'current' in 'temp'.
            // This is needed because we will be overwriting 'current.prev' next,
            // and we don't want to lose this reference.
            temp = current.prev;

            // The next two lines are where we swap the 'next' and 'prev' references
            // of the 'current' node. This effectively reverses the direction of the
            // links for 'current'.
            current.prev = current.next; // 'prev' now points to what used to be 'next'
            current.next = temp;         // 'next' now points to what used to be 'prev'

            // Move to the next node in the original list. After the swap, the original
            // 'next' node is now in 'current.prev', so we update 'current' to this node.
            current = current.prev;
        }

        // After the while loop, the list is reversed, but our 'head' and 'tail' pointers
        // are still pointing to the original head and tail. So we need to swap them.
        temp = head;   // Store the original head in 'temp'
        head = tail;   // Update head to be the original tail
        tail = temp;   // Update tail to be what was originally the head
    }


}
