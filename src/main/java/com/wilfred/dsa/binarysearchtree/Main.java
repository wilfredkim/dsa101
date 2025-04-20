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

        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);
        System.out.println("\nBreadth First Search:");
        System.out.println(myBST.BFS());

        System.out.println("\nDFS PreOrder:");
        System.out.println(myBST.DFSPreOrder());

        System.out.println("\nDFS PostOrder:");
        System.out.println(myBST.DFSPostOrder());


        System.out.println("\nDFS InOrder:");
        System.out.println(myBST.DFSInOrder());

        System.out.println("\niS Valid BFS:");
        System.out.println(myBST.isValidBST());

        BinarySearchTree KthElement = new BinarySearchTree();
        //5, 3, 7, 2, 4, 6, 8
        KthElement.insert(5);
        KthElement.insert(3);
        KthElement.insert(7);
        KthElement.insert(2);
        KthElement.insert(4);
        KthElement.insert(6);
        KthElement.insert(8);
        System.out.println("\nDFS InOrder:");
        System.out.println(KthElement.DFSInOrder());
        System.out.println(KthElement.kthSmallest(1));
        System.out.println(KthElement.kthSmallest(3));
        System.out.println(KthElement.kthSmallest(6));
        System.out.println(KthElement.kthSmallest(12));

        BinarySearchTree p = new BinarySearchTree();
        p.insert(3);
        p.insert(9);
        p.insert(20);
        p.insert(15);
        p.insert(7);

        System.out.println(KthElement.levelOrderBottom());




    }
}
