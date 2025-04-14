package com.wilfred.dsa.binarysearchtree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
       binarySearchTree.insert(10);
       binarySearchTree.insert(1);
       binarySearchTree.insert(3);
       binarySearchTree.insert(12);
       binarySearchTree.insert(76);
       binarySearchTree.insert(100);
       binarySearchTree.insert(55);
       binarySearchTree.insert(43);
       binarySearchTree.rInsert(43);
        System.out.println(binarySearchTree.root.left.right.value);
        System.out.println(binarySearchTree.contains(101));
        System.out.println(binarySearchTree.rContains(101));
       binarySearchTree.deleteNode(100);
        System.out.println(binarySearchTree.root.left.right.value);

    }
}
