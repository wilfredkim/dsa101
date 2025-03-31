package com.wilfred.dsa.hashtable;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashTable myHasTable = new HashTable();
        myHasTable.printTable();
        myHasTable.set("nails", 5000);
        myHasTable.set("nyundo", 1000);
        myHasTable.set("mabati", 200);
        myHasTable.printTable();
        System.out.println(myHasTable.get("mabati"));
        System.out.println(myHasTable.get("bbb"));
        System.out.println(myHasTable.key());

        int[] array1 = {2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 5};
        System.out.println(myHasTable.itemInCommon(array1, array2));
        int[] array3 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(myHasTable.findDuplicates(array3));
        System.out.println(myHasTable.firstNonRepeatingChar("aabbcc"));
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(myHasTable.groupAnagrams(strings));
        int [] nums ={1, 2, 3, 4, 5};
        int[] ints = myHasTable.twoSum(nums, 10);
        System.out.println(Arrays.toString(ints));

        int [] nums2 ={1, 2, 3, 4, 5};
        int[] ints2 = myHasTable.subarraySum(nums2, 9);
        System.out.println("Sub Array "+Arrays.toString(ints2));

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;
        myHasTable.findPairs(arr1,arr2,target);
        int[] longestUniquesNUms = {100, 4, 200, 1, 3, 2};
        System.out.println(myHasTable.longestConsecutiveSequence(longestUniquesNUms));
        System.out.println(myHasTable.intToRoman(58));


        int [] majorityElementsNums ={3,2,3};
        System.out.println(myHasTable.majorityElement(majorityElementsNums));


        int []  containsNums ={1,2,3,1,2,3};
        int k =2;
        System.out.println(myHasTable.containsNearbyDuplicate(containsNums,k));
        System.out.println(myHasTable.isAnagram("aacc","ccac"));
        System.out.println(myHasTable.missingNumber(new int[]{3,0,1}));
        System.out.println(myHasTable.wordPattern("abba","dog cat cat fish"));
    }
}
