package com.wilfred.dsa.linkedlist;

import java.util.HashMap;
import java.util.HashSet;

public class LinkedList {
    private Node head;
    private Node tail;
    int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }


    public void append(int value) {
        Node nodeToBeAppended = new Node(value);
        if (length == 0) {
            head = nodeToBeAppended;
            tail = nodeToBeAppended;
        } else {
            tail.next = nodeToBeAppended;
            tail = nodeToBeAppended;

        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node prev = head;
        Node temp = head;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        tail = prev;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;

    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index <= 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node findMiddleNode() {
        int mid;
        if (length % 2 == 0) {
            mid = (length + 1) / 2;
        } else {
            mid = length / 2;
        }

        if (mid <= 0) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;

        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;


    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp;
            temp.next = before;
            after = temp;
            before = after;
        }

    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }


    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public Node findKthFromEnd(int k) {
        int length = getLength();
        if (head == null || length < k) {
            return null;
        }
        Node first = head;
        Node kthNode = head;
        for (int i = 0; i < k; i++) {
            if (first == null) {
                return null;
            }
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            kthNode = kthNode.next;
        }
        return kthNode;

    }

    public void partitionListMine(int x) {
        int start = 0;
        int end = length - 1;
        while (start < end) {
            Node startNode = get(start);
            Node endNode = get(end);

            System.out.println("end**************");
            if (startNode != null && endNode != null && startNode.value > x && endNode.value < x) {
                int temp = startNode.value;
                startNode.value = endNode.value;
                endNode.value = temp;
                start++;
                end--;

            } else if (startNode != null && endNode != null && startNode.value < x && endNode.value > x) {
                start++;
                end--;
            } else if (startNode != null && startNode.value < x) {
                start++;
            } else {
                end--;
            }

        }


    }

    public void partitionList(int x) {
        if (head == null || head.next == null) {
            return;
        }
        Node start = head;
        Node end = head;

        // Find the last node
        while (end.next != null) {
            end = end.next;
        }

        Node newEnd = end;
        Node prev = null;
        Node curr = head;

        while (curr != newEnd) {
            System.out.println("end**************");
            if (curr.value >= x) {
                // Move node to end
                if (prev != null) {
                    prev.next = curr.next; // Skip current node
                } else {
                    head = curr.next; // Move head forward
                }

                newEnd.next = curr;
                curr.next = null;
                newEnd = curr;

                // Move to next node
                curr = (prev != null) ? prev.next : head;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        // If the last node is also greater than x, move it to the end
        if (newEnd.value >= x && newEnd != end) {
            if (prev != null) {
                prev.next = newEnd.next;
            }
            newEnd.next = null;
            end.next = newEnd;
        }
    }

    public void removeDuplicates() {
        HashSet<Integer> hashSet = new HashSet<>();
        int count = 0;
        if (head == null || length <= 0)
            return;
        hashSet.add(head.value);
        while (head.next != null) {
            if (hashSet.contains(head.value)) {
                head = head.next.next;
            } else {
                hashSet.add(head.value);
                head = head.next;
            }

        }
    }

    public int binaryToDecimal() {
        if (head == null)
            return 0;
        int num = 0;
        while (head != null) {
            num = (num * 2) + head.value;
            head = head.next;

        }
        return num;
    }


    public void reverseBetween(int m, int n) {
        Node current = head;
        Node prev = null;
        int i;
        for (i = 1; i < m; i++) {
            prev = current;
            current = current.next;
        }
        Node reverseHead = current;
        Node reverseTail = null;
        Node nextNode;
        while (i <= n) {
            nextNode = current.next;
            current.next = reverseTail;
            reverseTail = current;
            current = nextNode;
            i++;
        }
        if (prev != null) {
            prev.next = reverseTail;
        } else {
            head = reverseTail;
        }
        reverseHead.next = current;


    }


    public int getLength() {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    int getMiddle(Node head) {
        int mid;
        int length = getLength();
        if (length % 2 == 0) {
            mid = (length + 1) / 2;
        } else {
            mid = length / 2;
        }


        Node temp = head;
        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    public Node rotate(int k) {
        if (k == 0 || head == null)
            return head;
        Node tail = head;
        int len = 1;

        while (tail.next != null) {
            tail = tail.next;
            len += 1;
        }
        k %= len;
        if (k == 0)
            return head;

        tail.next = head;

        // Traverse the linked list to find the kth node
        tail = head;
        for (int i = 1; i < k; i++)
            tail = tail.next;

        // Update the (k + 1)th node as the new head
        head = tail.next;

        // Break the loop by updating next pointer of kth node
        tail.next = null;
        return head;
    }

    int getKthFromLast(Node head, int k) {
        // Your code here

        int len = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        if (len < k)
            return -1;
        temp = head;
        for (int i = 0; i < len - k + 1; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    Node deleteLastOccurrence(Node head, int key) {
        Node prev = null;
        Node lastPrev = null;
        Node last = null;
        Node current = head;

        while (current != null) {
            if (current.value == key) {
                lastPrev = prev;
                last = head;
            }
            prev = current;
            current = current.next;
        }
        if (last != null) {
            if (lastPrev != null) {
                lastPrev.next = last.next;
            } else {
                head = head.next;
            }
        }
        return head;
    }

    Node deleteMid(Node head) {
        Node current = head;
        int len = 0;
        while (current != null) {
            current = current.next;
            len++;
        }
        int mid = (length % 2 == 0) ? (length + 1) / 2 : length / 2;
        if (mid <= 0 || mid > length) {
            return null;
        }
        Node prev = null;
        current = head;
        for (int i = 0; i < mid - 1; ++i) {
            prev = current;
            current = current.next;
        }
        if (prev != null) {
            prev.next = current.next;
        }
        return head;
    }

    Node deleteMid2(Node head) {
        if (head == null)
            return null;
        if (head.next == null) {
            return null;
        }

        Node prev = null;
        Node start = head;
        Node end = head;
        while (end != null && end.next != null) {
            end = end.next.next;

            // Update prev to hold the previous
            // slow pointer value
            prev = start;

            start = start.next;
        }
        prev.next = start.next;

        return head;

    }

   static Node removeDuplicates(Node head) {
        // Your code here
        Node current = head;
        while (current != null && current.next != null) {
            if (current.value == current.next.value) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return current;

    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(2);
        System.out.print("Original Linked List: ");
        printList(head);
        System.out.print("Original Linked List: ");

        removeDuplicates(head);
        printList(head);
    }

}
