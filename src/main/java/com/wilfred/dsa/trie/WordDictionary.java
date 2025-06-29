package com.wilfred.dsa.trie;

public class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        addWord(word, root);
    }

    private void addWord(String word, TrieNode node) {
        if (word.isEmpty()) {
            node.end = true;
            return;
        }
        char firstChar = word.charAt(0);
        node.keys.putIfAbsent(firstChar, new TrieNode());
        addWord(word.substring(1), node.keys.get(firstChar));
    }

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
}
