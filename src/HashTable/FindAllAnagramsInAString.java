/**
 *
 */
package HashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * @author SenWang
 *
 */
public class FindAllAnagramsInAString {
    /**
     * this is my own solution to this question, which uses the solution
     * from valid anagram.
     * @param s the first input string.
     * @param t the second input string.
     * @return a list of integer storing the strating index.
     */
    public static List<Integer> solution(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return result;
        }
        int index = 0;
        while (index <= s.length() - p.length()) {
            String sub = s.substring(index, index + p.length());
            if (validAnagram(sub, p)) {
                result.add(index);
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
     * the reference solution uses sliding window approach, which is also a general
     * approach to solve substring problems.
     * @param s the first input string.
     * @param t the second input string.
     * @return a list of integer storing the strating index.
     */
    public static List<Integer> solutionRef(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return list;
        }
        int[] hash = new int[256]; // character hash
        // record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        // two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            // move right everytime, if the character exists in p's hash, decrease the count
            // current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right)] >= 1) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            // when the count is down to 0, means we found the right anagram
            // then add window's left to result list
            if (count == 0) {
                list.add(left);
            }
            // if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            // ++ to reset the hash because we kicked out the left
            // only increase the count if the character is in p
            // the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() ) {
               if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }
        return list;
    }
    /**
     * This is the test function for this question above.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "abab";
        String p = "ab";
        List<Integer> result = FindAllAnagramsInAString.solution(s, p);
        for (int num : result) {
            System.out.println(num);
        }
    }

}
