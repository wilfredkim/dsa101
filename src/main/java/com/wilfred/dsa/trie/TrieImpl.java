package com.wilfred.dsa.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TrieImpl implements Trie {
    TrieNode root;

    public TrieImpl() {
        this.root = new TrieNode();
    }

    @Override
    public void insert(String word) {
        insert(word, root);

    }

    private void insert(String word, TrieNode node) {
        if (word.isEmpty()) {
            node.end = true;
            return;
        }
        char firstChar = word.charAt(0);
        node.keys.putIfAbsent(firstChar, new TrieNode());
        insert(word.substring(1), node.keys.get(firstChar));
    }

    @Override
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNode node) {
        if (word.isEmpty() && node.end) {
            return true;
        } else if (word.isEmpty()) {
            return false;
        }
        char firstChar = word.charAt(0);
        TrieNode next = node.keys.get(firstChar);
        if (next == null) {
            return false;
        }
        return search(word.substring(1), next);
    }

    @Override
    public boolean startsWith(String prefix) {
        return startsWith(prefix, root);
    }

    private boolean startsWith(String prefix, TrieNode node) {
        if (prefix.isEmpty()) {
            return true;
        }
        char firstChar = prefix.charAt(0);
        TrieNode next = node.keys.get(firstChar);
        if (next == null) {
            return false;
        }
        return startsWith(prefix.substring(1), next);
    }

    class FindSumPairs {
        int[] nums1;
        int[] nums2;
        Map<Integer, Integer> map;


        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            this.map = new HashMap<>();
            for (int num : nums2) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        public void add(int index, int val) {
            int oldVal = nums2[index];
            int newVal = oldVal + val;

            map.put(oldVal, map.get(oldVal) - 1);
            if (map.get(oldVal) == 0) {
                map.remove(oldVal);
            }
            map.put(newVal, map.getOrDefault(newVal, 0) + 1);

            nums2[index] = newVal;
        }

        public int count(int tot) {
            int count = 0;
            for (int num : nums1) {
                int complement = tot - num;
                count += map.getOrDefault(complement, 0);
            }
            return count;
        }
    }
}
