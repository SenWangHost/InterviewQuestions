/**
 *
 */
package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * @author SenWang
 *
 */
public class RansomNote {
    /**
     * This is my own solution to this question. This solution is acceptable
     * but runs slow because it calls the built-in replaceFirst function multiple times.
     * @param ransomNote the ransomNote to be checked.
     * @param magazine the magazine containing necessary letters that can be used.
     * @return true if the ransom can be constructed, false otherwise.
     */
    public static boolean solution(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char temp = ransomNote.charAt(i);
            if (magazine.indexOf(temp) == -1) {
                return false;
            } else {
                magazine = magazine.replaceFirst(Character.toString(temp), "");
            }
        }
        return true;
    }
    /**
     * This is my another solution to this question.
     * @param ransomNote the ransomNote to be checked.
     * @param magazine the magazine containing necessary letters that can be used.
     * @return true if the ransom can be constructed, false otherwise.
     */
    public static boolean solution2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); i++) {
            char temp = magazine.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char temp = ransomNote.charAt(i);
            if (map.containsKey(temp)) {
                int fre = map.get(temp);
                if (fre == 0) {
                    return false;
                } else {
                    map.put(temp, fre - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
    /**
     * This is the reference solution that is even faster than
     * map and array of 26 to keep track of the English letters
     * that appears in both ransomNote and magazine.
     * @param ransomNote the ransomNote to be checked.
     * @param magazine the magazine containing necessary letters that can be used.
     * @return true if the ransom can be constructed, false otherwise.
     */
    public static boolean solutionRef(String ransomNote, String magazine) {
        int[] table = new int[26];
        for (char temp : magazine.toCharArray()) {
            table[temp - 'a']++;
        }
        for (char temp : ransomNote.toCharArray()) {
            table[temp - 'a']--;
            if (table[temp - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String ransomNote = "aa";
        String magazine = "ab";
        boolean result = RansomNote.solutionRef(ransomNote, magazine);
        System.out.println(result);
    }

}
