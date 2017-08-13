/**
 *
 */
package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * @author SenWang
 *
 */
public class WordPattern {
    /**
     * This is my own solution to this question.
     * @param pattern a string representation of pattern.
     * @param str the input string to be checked.
     * @return true if the string mataches the pattern, false otherwise.
     */
    public static boolean solution(String pattern, String str) {
        String[] array = str.split(" ");
        if (pattern.length() != array.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (map.containsValue(array[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), array[i]);
            } else {
                if (!map.get(pattern.charAt(i)).equals(array[i])) {
                    return false;
                }
            }

        }
        return true;
    }
    /**
     * This is one of reference solution to this question, which makes use
     * of the property of put method of hashmap to check duplicate string.
     * @param pattern a string representation of pattern.
     * @param str the input string to be checked.
     * @return true if the string mataches the pattern, false otherwise.
     */
    public static boolean solutionRef(String pattern, String str) {
        String[] array = str.split(" ");
        if (pattern.length() != array.length) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        for (Integer i = 0; i < pattern.length(); i++) {
            if (map1.put(pattern.charAt(i), i) != map2.put(array[i], i)) {
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
        String pattern = "abba";
        String str = "dog cat cat dog";
        boolean result = WordPattern.solutionRef(pattern, str);
        System.out.println(result);
    }

}
