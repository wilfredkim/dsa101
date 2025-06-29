package com.wilfred.dsa.trie;

public interface Trie {

    void insert(String word);

    boolean search(String word);

    boolean startsWith(String prefix);


}
