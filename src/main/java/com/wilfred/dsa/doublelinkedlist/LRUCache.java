package com.wilfred.dsa.doublelinkedlist;

import java.util.HashMap;

class LRUCache {

    class LRUCacheNode {
        int value;
        LRUCacheNode next;
        LRUCacheNode prev;

        public LRUCacheNode(int value) {
            this.value = value;
        }
    }

    LRUCacheNode head;
    LRUCacheNode tail;

    int length;


    public LRUCache(int capacity) {

        LRUCacheNode lruCacheNode = new LRUCacheNode(capacity);
        head = lruCacheNode;
        tail = lruCacheNode;
        length++;
    }

    public int get(int key) {
        if (key <= 0 || key >= length) {
            return -1;
        }
        LRUCacheNode temp = head;
        if (key < length / 2) {
            for (int i = 0; i < key; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > key; i--) {
                temp = temp.prev;
            }
        }
        return temp.value;

    }

    public void put(int key, int value) {

        LRUCacheNode temp = head;
        if (key < length / 2) {
            for (int i = 0; i < key; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > key; i--) {
                temp = temp.prev;
            }
        }

        if (temp != null) {
            temp.value = value;

        }

    }
}
