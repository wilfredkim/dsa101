package com.wilfred.dsa.trie;

public class Main {
    public static void main(String[] args) {
        TrieImpl trie = new TrieImpl();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
