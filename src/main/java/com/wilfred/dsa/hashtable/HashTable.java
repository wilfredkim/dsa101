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
            System.out.println("Values::::::::::::" + values[i]);
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


    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i : nums) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }
        int max = nums.length / 2;
        int value = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                value = entry.getKey();
            }
        }
        return value;

    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSumOfSquares(n);
        }

        return n == 1;
    }

    private int getSumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> hashSet = new HashMap<>();
        HashMap<Character, Integer> hashSet2 = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (hashSet.containsKey(c)) {
                hashSet.put(c, hashSet.getOrDefault(c, 0) + 1);
            } else {
                hashSet.put(c, 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (hashSet2.containsKey(c)) {
                hashSet2.put(c, hashSet2.getOrDefault(c, 0) + 1);
            } else {
                hashSet2.put(c, 1);
            }
        }
        return hashSet.size() == hashSet2.size();
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            hashSet.add(i);
        }
        return nums.length != hashSet.size();

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!hashMap.containsKey(c)) return false;
            hashMap.put(c, hashMap.get(c) - 1);
            if (hashMap.get(c) == 0) hashMap.remove(c);
        }

        return hashMap.isEmpty();

    }

    public int missingNumber(int[] nums) {
        int max = Integer.MAX_VALUE;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            hashSet.add(i);
        }
        for (int i = 0; i < max; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }
        return max;

    }

    public static boolean areValuesEqualAtIndices(HashMap<Integer, String> map1, HashMap<Integer, String> map2,
                                                  int index1, int index2) {
        return map1.get(index1) != null && map1.get(index1).equals(map2.get(index2));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(word)) return false;
            } else {
                charToWord.put(ch, word);
            }
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != ch) return false;
            } else {
                wordToChar.put(word, ch);
            }
        }

        return true;
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            }
        }
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word : words) {
            if (isCompletingWord(word, letterCount)) {
                return word;
            }
        }
        return "";

    }
    private static boolean isCompletingWord(String word, Map<Character, Integer> letterCount) {
        Map<Character, Integer> wordCount = new HashMap<>();
        for (char c : word.toCharArray()) {
            wordCount.put(c, wordCount.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : letterCount.entrySet()) {
            if (wordCount.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }


}

