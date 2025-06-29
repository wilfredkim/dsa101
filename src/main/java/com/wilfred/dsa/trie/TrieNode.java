package com.wilfred.dsa.trie;

import java.util.HashMap;

public class TrieNode {
    boolean end;
    HashMap<Character, TrieNode> keys;

    public TrieNode() {
        this.end = false;
        this.keys = new HashMap<>();

    }
}
