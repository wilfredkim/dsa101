package com.wilfred.dsa.trie;

import java.util.HashMap;

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
}
