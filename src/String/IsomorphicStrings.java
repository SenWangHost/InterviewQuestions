/**
 *
 */
package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of
 * characters. No two characters may map to the same character but a character may map to itself.
 *
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * Note:
 * You may assume both s and t have the same length.
 * @author SenWang
 *
 */
public class IsomorphicStrings {
    /**
     * This is my own solution to this question.
     * @param s the first input string.
     * @param t the second input string.
     * @return true if those two strings are isomorphic, false otherwise.
     */
    public static boolean solution(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char first = s.charAt(i);
            char second = t.charAt(i);
            if (!map.containsKey(first) && map.containsValue(second)) {
                return false;
            }
            map.put(first, second);
        }
        StringBuilder build = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            build.append(map.get(s.charAt(i)));
        }
        return build.toString().equals(t);
    }
    /**
     * This is one of the reference solution without using hash map.
     * which uses array to keep track of the last seen position of characters in s and t.
     * @param s the first input string.
     * @param t the second input string.
     * @return true if those two strings are isomorphic, false otherwise.
     */
    public static boolean solutionRef(String s, String t) {
        int[] positions = new int[512]; // 256 * 2 = 512 size for two string positions.
        for (int i = 0; i < s.length(); i++) {
            if (positions[s.charAt(i)] != positions[t.charAt(i) + 256]) {
                return false;
            }
            positions[s.charAt(i)] = i + 1;
            positions[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "egg";
        String t = "add";
        boolean result = IsomorphicStrings.solutionRef(s, t);
        System.out.println(result);
    }

}
