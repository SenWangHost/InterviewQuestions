/**
 *
 */
package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring.
 * @author SenWang
 *
 */
public class LongestSubStringWithoutRepeatingCharacters {
    /**
     * This is my own solution to this question. This solution is
     * acceptable and but use the map clear operation multiple times,
     * which slows down the efficiency of the program.
     * @param s the input string to be considered.
     * @return the length of longest substring without repeating characters.
     */
    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int result = 0;
        int index = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while (index < s.length()) {
            char temp = s.charAt(index);
            if (!map.containsKey(temp)) {
                map.put(temp, index);
                index++;
            } else {
                int start = map.get(temp);
                index = start + 1;
                if (map.size() > result) {
                    result = map.size();
                }
                map.clear();
            }
        }
        if (map.size() > result) {
            result = map.size();
        }
        return result;
    }
    /**
     * This is reference solution to this question, which uses
     * the sliding window concept to keep track of the substring
     * and hashset to store the unique characters.
     * @param s the input string to be considered.
     * @return the length of longest substring without repeating characters.
     */
    public static int solutionRef(String s) {
        int start = 0;
        int end = 0;
        int result = 0;
        Set<Character> set = new HashSet<Character>();
        while (start < s.length() && end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
                result = Math.max(result, end - start);
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return result;
    }
    /**
     * This is another reference solution to this question, which optimize
     * the sliding window by using hashmap.
     * The reason is that if s[j]s[j] have a duplicate in the range [i, j)[i,j) with index j'
     * , we don't need to increase ii little by little. We can skip all the elements in the range [i, j'][i,j​'
     * ] and let i to be j' + 1 directly.
     */
    public static int solutionRef2(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)));
            }
            result = Math.max(result, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "abcabcbb";
        int result = LongestSubStringWithoutRepeatingCharacters.solution(test);
        System.out.println(result);
    }

}
