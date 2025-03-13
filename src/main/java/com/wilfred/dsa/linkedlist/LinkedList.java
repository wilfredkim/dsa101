package com.wilfred.dsa.linkedlist;

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


    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
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
        Node newNode = get(index - 1);
        Node temp = newNode.next;
        temp.next = newNode;
        newNode.next = temp.next;
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
            printList();
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
            printList();
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
        for( i=1; i<m;i++){
            prev = current;
            current = current.next;
        }
        Node reverseHead = current;
        Node  reverseTail = null;
        Node nextNode;
        while(i<=n){
            nextNode = current.next;
            current.next= reverseTail;
            reverseTail= current;
            current= nextNode;
            i++;
        }
        if(prev!=null){
            prev.next= reverseTail;
        }else{
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
}
