/**
 *
 */
package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 * @author SenWang
 *
 */
public class PalindromePermutation {
    /**
     * this is my own solution to this question.
     */
    public static boolean solution(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        boolean mid = false;
        for (Integer value : map.values()) {
            if (value % 2 != 0) {
                if (!mid) {
                    mid = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * this is my another solution to this question.
     */
    public static boolean solutionRef(String s) {
        int[] map = new int[128];
        s = s.toLowerCase();
        char[] array = s.toCharArray();
        for (char c : array) {
            map[c]++;
        }
        boolean mid = false;
        for (int fre : map) {
            if (fre % 2 != 0) {
                if (!mid) {
                    mid = true;
                } else {
                    return false;
                }
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
        String s = "aab";
        System.out.println(solution(s));
    }

}
