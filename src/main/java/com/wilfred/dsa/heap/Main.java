package com.wilfred.dsa.heap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Heap myHeap = new Heap();
        myHeap.insert(56);
        myHeap.insert(99);
        myHeap.insert(72);
        myHeap.insert(61);
        myHeap.insert(58);
        System.out.println(myHeap.getHeap());
        myHeap.insert(100);
        System.out.println(myHeap.getHeap());

        Heap myHeap2 = new Heap();

        myHeap2.insert(95);
        myHeap2.insert(75);
        myHeap2.insert(80);
        myHeap2.insert(55);
        myHeap2.insert(60);
        myHeap2.insert(50);
        myHeap2.insert(65);
        System.out.println("Heap 2" + myHeap2.getHeap());
        myHeap2.remove();
        System.out.println("Heap 2" + myHeap2.getHeap());
        myHeap2.remove();
        System.out.println("Heap 2" + myHeap2.getHeap());
        int[] nums3 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k3 = 4;
        //System.out.println(myHeap2.findKthSmallest(nums3, k3));
        System.out.println(myHeap2.findKthLargest(nums3, k3));
        System.out.println("topKFrequent:::" + Arrays.toString(myHeap2.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println("findRelativeRanks:::" + Arrays.toString(myHeap2.findRelativeRanks(new int[]{5,4,3,2,1})));

    }
}
