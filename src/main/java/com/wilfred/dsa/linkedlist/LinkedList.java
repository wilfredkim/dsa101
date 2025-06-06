package com.wilfred.dsa.linkedlist;

import java.util.HashSet;
import java.util.Set;

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


    public Node reverse() {
        if (head == null)
            return null;

        Node currentNode = head;
        Node prev = null;
        while (currentNode != null) {
            Node next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;


        }

        return prev;

    }

    public ListNode reverseBetweenBestCode(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        int i = 1;
        ListNode current = head;
        ListNode start = head;

        // Move current to the `left` position
        while (i < left) {
            start = current;
            current = current.next;
            i++;
        }
        ListNode prev = null;
        ListNode tail = current;

        // Reverse the sublist between left and right
        while (i >= left && i <= right) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
            i++;
        }
        start.next = prev;
        tail.next = current;

        // If reversing starts from head, return new head (prev)
        if (left > 1) {
            return head;
        } else {
            return prev;
        }
    }

    public ListNode reverse(ListNode listNode) {
        ListNode current = listNode;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
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

    public Node findKthFromEnd2(int k) {
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public Node findKthFromEnd(int k) {
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
        // Step 1: Check for an empty list.
        // If the list is empty, there is nothing
        // to partition, so we exit the method.
        if (head == null) return;

        // Step 2: Create two dummy nodes.
        // These dummy nodes act as placeholders
        // to simplify list manipulation.
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        // Step 3: Initialize pointers for new lists.
        // 'prev1' and 'prev2' will track the end nodes of
        // the two lists that are being created.
        Node prev1 = dummy1;
        Node prev2 = dummy2;

        // Step 4: Start with the head of the original list.
        Node current = head;

        // Step 5: Iterate through the original list.
        while (current != null) {

            // Step 6: Compare current node value with 'x'.
            // Nodes are partitioned based on their value
            // being less than or greater than/equal to 'x'.

            // Step 6.1: If value is less than 'x',
            // add node to the first list.
            if (current.value < x) {
                prev1.next = current;  // Link node to the end of the first list.
                prev1 = current;       // Update the end pointer of the first list.
            } else {
                // Step 6.2: If value is greater or equal,
                // add node to the second list.
                prev2.next = current;  // Link node to the end of the second list.
                prev2 = current;       // Update the end pointer of the second list.
            }

            // Move to the next node in the original list.
            current = current.next;
        }

        // Step 7: Terminate the second list.
        // This prevents cycles in the list.
        prev2.next = null;

        // Step 8: Connect the two lists.
        // The first list is followed by the second list.
        prev1.next = dummy2.next;

        // Step 9: Update the head of the original list.
        // The head now points to the start of the first list.
        head = dummy1.next;
    }


    public void partitionList2(int x) {
        if (head == null || head.next == null) {
            return;
        }
        Node end = head;

        // Find the last node
        while (end.next != null) {
            end = end.next;
        }

        Node newEnd = end;
        Node prev = null;
        Node curr = head;

        while (curr != newEnd) {
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

    public void removeDuplicatesPass() {
        // Step 1: Create a Set to store unique node values.
        // We initialize a HashSet, which allows for fast look-up
        // to check for duplicates later on.
        Set<Integer> values = new HashSet<>();

        // Step 2: Initialize a Node variable 'previous' to null.
        // 'previous' will help us unlink a node if it's a duplicate.
        Node previous = null;

        // Step 3: Initialize 'current' to point to the head node.
        // 'current' will be used to iterate through the linked list.
        Node current = head;

        // Step 4: Begin iteration through the linked list.
        // We will keep iterating until 'current' becomes null,
        // indicating we have reached the end of the list.
        while (current != null) {

            // Step 5: Check for duplicates.
            // We check if the current node's value is already in the set.
            if (values.contains(current.value)) {

                // Step 6: Remove the duplicate node.
                // By setting 'previous.next' to 'current.next',
                // we remove the link to 'current', effectively
                // deleting it from the list.
                previous.next = current.next;

                // Step 7: Update the length of the list.
                // Since we removed a node, we decrement the length by 1.
                length -= 1;

            } else {

                // Step 8: Add unique value to set.
                // If the current value is not a duplicate,
                // we add it to the set for future reference.
                values.add(current.value);

                // Step 9: Update 'previous' node.
                // We set 'previous' to the 'current' node, as we
                // move forward in the list.
                previous = current;
            }

            // Step 10: Move to the next node.
            // We update 'current' to point to the next node in the list,
            // continuing our iteration.
            current = current.next;
        }
    }

    public void removeDuplicates() {
        Node current = head;
        Node previous = null;
        HashSet<Integer> integers = new HashSet<>();
        while (current != null) {
            if (integers.contains(current.value)) {
                previous.next = current.next;
                length--;
            } else {
                integers.add(current.value);
                previous = current;
            }

            current = current.next;
        }
    }

    public void reverseBetween(int startIndex, int endIndex) {
        // Check: If linked list is empty, nothing to reverse.
        // Exit the method.
        if (head == null) return;

        // Create a 'dummyNode' that precedes the head.
        // Simplifies handling edge cases.
        Node dummyNode = new Node(0);
        dummyNode.next = head;

        // 'previousNode' is used to navigate to the node
        // right before our sublist begins.
        Node previousNode = dummyNode;

        // Move 'previousNode' to node just before sublist.
        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        // 'currentNode' marks the first node of sublist.
        Node currentNode = previousNode.next;

        // Loop reverses the section from startIndex to endIndex.
        for (int i = 0; i < endIndex - startIndex; i++) {

            // 'nodeToMove' is the node we'll move to sublist start.
            Node nodeToMove = currentNode.next;

            // Detach 'nodeToMove' from its current position.
            currentNode.next = nodeToMove.next;

            // Attach 'nodeToMove' at the beginning of the sublist.
            nodeToMove.next = previousNode.next;

            // Move 'nodeToMove' to the start of our sublist.
            previousNode.next = nodeToMove;
        }

        // Adjust 'head' if the first node was part of sublist.
        head = dummyNode.next;
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


    public void reverseBetween3(int m, int n) {
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


    public static boolean detectLoop(Node head) {
        Node current = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            current = current.next;
            fast = fast.next.next;
            if (fast == current) {
                return true;
            }
        }
        return false;

    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
    }

    static void linkdelete(Node head, int n, int m) {
        // your code here
        if (m <= 0)
            return;
        int len = 0;
        int mAfter = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            len++;
        }
        current = head;
        Node prev = null;
        for (int i = 0; i < len; i++) {
            if (i == n) {
                prev = current;
            }
            if (prev != null) {
                mAfter++;
            }
            if (mAfter == m) {
                prev = current.next;
            }
            current = current.next;
        }

    }

    public static ListNode add(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.next = newNode;

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode results = new ListNode(0);
        ListNode current = results;
        int carryForward = 0;
        while (l1 != null || l2 != null || carryForward != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carryForward + x + y;
            carryForward = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        printList(results.next);
        return results.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode current = head;
        HashSet<ListNode> listNodes = new HashSet<>();
        while (!listNodes.contains(current)) {
            if (current.next == null) {
                return null;
            }
            listNodes.add(current);
            current = current.next;
        }
        return current;
    }

    public ListNode detectCycleUsingFloyds(ListNode head) {
        if (head == null)
            return null;
        ListNode hare = head;
        ListNode tortoise = head;
        while (true) {
            hare = hare.next;
            tortoise = tortoise.next;
            //check for tail value
            if (hare == null || hare.next == null) {
                return null;
            } else {
                hare = hare.next;
            }
            if (hare == tortoise) {
                break;
            }

        }
        ListNode p1 = head, p2 = tortoise;
        while (p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return  p1;

    }

    public boolean hasCycle(ListNode head) {
        ListNode current = head;
        ListNode slow = head;
        while (current != null && current.next != null) {
            slow = slow.next;
            current = current.next.next;
            if (current == slow) {
                return true;
            }
        }
        return false;

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode results = new ListNode(-1);
        ListNode tail = results;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                tail.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            tail = tail.next;

        }
        while (list1 != null) {
            tail.next = new ListNode(list1.val);
            list1 = list1.next;
            tail = tail.next;
        }
        while (list2 != null) {
            tail.next = new ListNode(list2.val);
            list2 = list2.next;
            tail = tail.next;
        }
        return results.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode results = head;
        ListNode current = results;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return results;


    }

    public static ListNode deleteDuplicatesEntirely(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode results = new ListNode(-1);
        results.next = head;
        ListNode current = head;
        ListNode prev = results;
        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                prev.next = current.next;
            } else {
                prev = prev.next;

            }
            current = current.next;
        }
        return results.next;


    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode results = head;
        ListNode current = results;
        while (current != null && current.next != null) {
            int temp = current.val;
            current.val = current.next.val;
            current.next.val = temp;
            current = current.next.next;
        }
        return results;

    }

    public static ListNode partition(ListNode head, int x) {

        ListNode before = new ListNode(-1);
        ListNode after = new ListNode(-1);
        ListNode tailA = before, tailB = after;
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                tailA.next = new ListNode(current.val);
                tailA = tailA.next;
            } else {
                tailB.next = new ListNode(current.val);
                tailB = tailB.next;
            }
            current = current.next;
        }
        tailB.next = null;
        tailA.next = after.next;

        return before.next;


    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        ListNode results = new ListNode(0);
        results.next = head;
        ListNode leftNode = results;
        for (int i = 1; i < left; i++) {
            leftNode = leftNode.next;
        }
        ListNode rightNode = leftNode.next;
        ListNode prev = null;

        for (int i = left; i <= right; i++) {
            ListNode next = rightNode.next;
            rightNode.next = prev;
            prev = rightNode;
            rightNode = next;
        }
        leftNode.next.next = rightNode;
        leftNode.next = prev;
        return results.next;
    }


    public static void main(String[] args) {
       /* Node head = new Node(2);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(2);
        System.out.print("Original Linked List: ");
        printList(head);
        System.out.print("Original Linked List: ");

        removeDuplicates(head);
        printList(head);*/
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        //head2.next.next.next = new ListNode(4);
        //head2.next.next.next.next = new ListNode(5);
        ListNode listNode = mergeTwoLists(head, head2);
        printList(head2);
        System.out.println();

        ListNode listNode1 = reverseBetween(head2, 2, 3);
        System.out.println("PART");
        printList(listNode1);

    }


    void bubbleSort() {
        // If list length is less than 2, no need to sort
        if (this.length < 2)
            return;

        // Initialize sortedUntil as null (nothing is sorted initially)
        Node sortedUntil = null;

        // Outer loop continues until sorted part reaches the second node
        while (sortedUntil != this.head.next) {

            // Start with the head node
            Node current = this.head;

            // Inner loop for each pass
            while (current.next != sortedUntil) {

                // Compare current node with next node
                Node nextNode = current.next;

                // If current node is greater, swap values
                if (current.value > nextNode.value) {
                    int temp = current.value;
                    current.value = nextNode.value;
                    nextNode.value = temp;
                }

                // Move to the next node
                current = current.next;
            }

            // After each pass, the largest element is bubbled to the end
            // Thus, update sortedUntil to point to the last sorted element
            sortedUntil = current;
        }
    }

    void selectionSort() {
        if (this.length < 2)
            return;
        Node current = this.head;
        while (current.next != null) {
            Node smallest = current;
            Node innerCurrent = current.next;
            while (innerCurrent != null) {
                if (innerCurrent.value < smallest.value) {
                    smallest = innerCurrent;
                }
                innerCurrent = innerCurrent.next;
            }
            if (smallest != current) {
                int temp = smallest.value;
                smallest.value = current.value;
                current.value = temp;
            }
            current = current.next;
        }
    }

    void insertionSort() {
        Node current = this.head;
        while (current.next != null) {
            int temp = current.next.value;
            int j = current.value;
            while (temp < j) {
                current.next.value = j;
                current.value = temp;

            }

        }
    }

    public void insertionSort2() {
        if (length < 2) {
            return; // List is already sorted
        }

        Node sortedListHead = head;
        Node unsortedListHead = head.next;
        sortedListHead.next = null;

        while (unsortedListHead != null) {
            Node current = unsortedListHead;
            unsortedListHead = unsortedListHead.next;

            if (current.value < sortedListHead.value) {
                current.next = sortedListHead;
                sortedListHead = current;
            } else {
                Node searchPointer = sortedListHead;
                while (searchPointer.next != null && current.value > searchPointer.next.value) {
                    searchPointer = searchPointer.next;
                }
                current.next = searchPointer.next;
                searchPointer.next = current;
            }
        }

        head = sortedListHead;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
    }


    public void merge2(LinkedList otherList) {
        Node combinedNode = new Node(0);
        Node current = head;
        Node otherNode = otherList.head;
        while (current != null && otherNode != null) {
            if (current.value < otherNode.value) {
                combinedNode.next = current;
                current = current.next;
            } else {
                combinedNode.next = otherNode;
                otherNode = otherNode.next;
            }
            combinedNode = combinedNode.next;
        }
        if (current != null) {
            combinedNode.next = current;
        } else {
            combinedNode.next = otherNode;

        }
        while (otherNode != null) {
            combinedNode.next = otherNode;
            otherNode = otherNode.next;
        }
        head = combinedNode.next;

    }

    public void merge(LinkedList otherList) {
        // get the head node of the other linked list
        Node otherHead = otherList.head;
        // create a dummy node to serve as the head of the merged linked list
        Node dummy = new Node(0);
        // create a current node to keep track of the last node in the merged list
        Node current = dummy;

        // iterate through both input linked lists as long as they are not null
        while (head != null && otherHead != null) {
            // compare the values of the head nodes of the two lists
            if (head.value < otherHead.value) {
                // append the smaller node to the merged list and
                //update the head of that list to its next node
                current.next = head;
                head = head.next;
            } else {
                // append the smaller node to the merged list and
                //update the head of that list to its next node
                current.next = otherHead;
                otherHead = otherHead.next;
            }
            // update the "current" node to be the last node in the merged list
            current = current.next;
        }

        // if either of the input lists still has nodes,
        // append them to the end of the merged list
        if (head != null) {
            current.next = head;
        } else {
            current.next = otherHead;
            // If current list is empty, update tail to last node of other list
            // Otherwise, tail remains the last node of the current list
            tail = otherList.tail;
        }

        // update the head of the current list to be the second node
        // in the merged list (since the first node is the dummy node)
        head = dummy.next;
        // update the length of the current list to reflect the merged list
        length += otherList.getLength();
    }


}
