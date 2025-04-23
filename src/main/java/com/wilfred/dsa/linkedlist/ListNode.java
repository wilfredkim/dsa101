package com.wilfred.dsa.linkedlist;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeSort(lists, 0, lists.length - 1);

    }


    ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int midIndex = start + (end - start) / 2;
        ListNode l1 = mergeSort(lists, start, midIndex);
        ListNode l2 = mergeSort(lists, midIndex + 1, end);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // if either of the input lists still has nodes,
        // append them to the end of the merged list
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        return dummy.next;

    }

    public ListNode sortList(ListNode head) {
        int l = getLength(head);
        if (l == 0) {
            return null;
        }
        return mergeSort(head, 0, l - 1);

    }

    public int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    ListNode mergeSort(ListNode listNode, int start, int end) {
        if (getLength(listNode)==1) {
            return listNode;
        }
        int midIndex = start + (end - start) / 2;
        ListNode l1 = mergeSort(listNode, start, midIndex);
        ListNode l2 = mergeSort(listNode, midIndex + 1, end);
        return merge(l1, l2);
    }

    class Solution {
        public ListNode sortList(ListNode head) {
            int l = getLength(head);
            if (l == 0) {
                return null;
            }
            return mergeSort(head, 0, l - 1);
        }

        int getLength(ListNode head) {
            int len = 0;
            while (head != null) {
                head = head.next;
                len++;
            }
            return len;
        }
        ListNode mergeSort(ListNode listNode, int start, int end) {
            if (getLength(listNode)==1) {
                return listNode;
            }
            int midIndex = start + (end - start) / 2;
            ListNode l1 = mergeSort(listNode, start, midIndex);
            ListNode l2 = mergeSort(listNode, midIndex + 1, end);
            return merge(l1, l2);
        }
        public ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    current.next = l1;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    l2 = l2.next;
                }
                current = current.next;
            }

            // if either of the input lists still has nodes,
            // append them to the end of the merged list
            if (l1 != null) {
                current.next = l1;
            } else {
                current.next = l2;
            }
            return dummy.next;

        }
    }
}
