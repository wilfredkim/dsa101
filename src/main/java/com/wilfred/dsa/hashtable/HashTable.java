package com.wilfred.dsa.hashtable;

import java.util.*;

public class HashTable {

    private int size = 7;
    private Node[] dataMap;

    public HashTable() {
        dataMap = new Node[size];
    }

    class Node {

        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println(" {" + temp.key + "= " + temp.value + " }");
                temp = temp.next;
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyCharArray = key.toCharArray();
        for (int i = 0; i < keyCharArray.length; i++) {
            int asciiValue = keyCharArray[i];
            //23 is prime number to get more random number
            hash = (hash + asciiValue * 23) % dataMap.length;

        }
        return hash;

    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList<String> key() {
        ArrayList<String> keys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                keys.add(temp.key);
                temp = temp.next;
            }
        }
        return keys;
    }

    public boolean itemInCommon(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int i : array1) {
            hashMap.put(i, true);
        }
        for (int j : array2) {
            if (hashMap.get(j) != null) {
                return true;
            }
        }
        return false;

    }

    public static List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        List<Integer> results = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > 1) {
                results.add(entry.getKey());
            }
        }
        return results;


    }

    public static Character firstNonRepeatingChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < charArray.length; i++) {
            if (hashMap.getOrDefault(s.charAt(i), 0) == 1) {
                return s.charAt(i);
            }
        }
        return null;
    }

    public static List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String string : strings) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String canonical = new String(chars);
            System.out.println("canonical:::::::::::::::" + canonical);

            if (anagramGroups.containsKey(canonical)) {
                anagramGroups.get(canonical).add(string);
            } else {
                List<String> group = new ArrayList<>();
                group.add(string);
                anagramGroups.put(canonical, group);
            }
        }

        return new ArrayList<>(anagramGroups.values());
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (hashMap.containsKey(rem)) {
                return new int[]{hashMap.get(rem), i};

            } else {
                hashMap.put(nums[i], i);
            }
        }
        return new int[]{};

    }

    public static int[] subarraySum2(int[] nums, int target) {
        Map<Integer, Integer> sumIndex = new HashMap<>();
        sumIndex.put(0, -1);
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (sumIndex.containsKey(currentSum - target)) {
                return new int[]{sumIndex.get(currentSum - target) + 1, i};
            }
            sumIndex.put(currentSum, i);
        }

        return new int[]{};
    }

    public int[] subarraySum(int[] nums, int target) {
        int current = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            current += nums[right];
            while (current > target) {
                current -= nums[left];
                left++;
            }
            if (current == target) {
                return new int[]{left, right};
            }

        }
        return new int[]{};
    }

    public static List<Integer> removeDuplicates(List<Integer> myList) {
        HashSet<Integer> integers = new HashSet<>();
        for (Integer nym : myList) {
            integers.add(nym);
        }
        List<Integer> list = new ArrayList<>(integers);
        return list;
    }

    public static boolean hasUniqueChars(String string) {
        HashSet<Character> hashSet = new HashSet<>();
        for (char c : string.toCharArray()) {
            hashSet.add(c);
        }
        return hashSet.size() == string.length();

    }

    public List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        HashSet<Integer> hashSet = new HashSet<>();
        List<int[]> results = new ArrayList<>();
        for (int i : arr1) {
            hashSet.add(i);
        }
        for (int i : arr2) {
            int rem = target - i;
            if (hashSet.contains(rem)) {
                results.add(new int[]{rem, i});
            }
        }
        return results;


    }

    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            System.out.println("Values::::::::::::"+values[i]);
            while (num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }

        return roman.toString();
    }


    public List<List<String>> groupAnagramsw(String[] strings) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String string : strings) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String canonical = new String(chars);
            if (hashMap.containsKey(canonical)) {
                hashMap.get(canonical).add(string);
            } else {
                List<String> group = new ArrayList<>();
                group.add(string);
                hashMap.put(canonical, group);
            }
        }
        return new ArrayList<>(hashMap.values());


    }

}

