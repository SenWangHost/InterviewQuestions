/**
 *
 */
package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together. This solution is slow and time limit exceeds.
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * [
 *  ["ate", "eat","tea"],
 *  ["nat","tan"],
 *  ["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 * @author SenWang
 *
 */
public class GroupAnagrams {
    /**
     * This is my own solution to this question above.
     * @param strs an array of strings to be considered.
     * @return two dimensional lists representing the results.
     */
    public static List<List<String>> solution(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        int index = 0;
        while (index < strs.length) {
            if (!strs[index].equals("#")) {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[index]);
                for (int i = index + 1; i < strs.length; i++) {
                    if (!strs[i].equals("#") && validAnagram(strs[index], strs[i])) {
                        temp.add(strs[i]);
                        strs[i] = "#";
                    }
                }
                result.add(temp);
            }
            index++;
        }
        return result;
    }
    /**
     * This is my own solution to this question, which uses array
     * to represent the hash table
     * @param s the first string to be considered.
     * @param t the second string to be considered.
     * @return true if two strings are anagram, false otherwise
     */
    private static boolean validAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int sIndex = sArr[i] - 'a';
            int tIndex = tArr[i] - 'a';
            table[sIndex]++;
            table[tIndex]--;
        }
        for (int num : table) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * this is one of the reference solution to this question, which uses
     * convert string to char array and sort the char array to determine the anagrams.
     * @param strs an array of strings to be considered.
     * @return two dimensional lists representing the results.
     */
    public static List<List<String>> solutionRef(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
    /**
     * this is the test function for this question above.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = GroupAnagrams.solution(strs);
        for (List<String> list : result) {
            System.out.println(list);
        }
    }

}
