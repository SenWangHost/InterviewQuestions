/**
 *
 */
package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 * Given s = "hello", return "holle".
 *
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * Note:
 * The vowels does not include the letter "y".
 * @author SenWang
 *
 */
public class ReverseVowelsOfString {
    /**
     * This is my own solution to this question. The idea is to use
     * two pointers to detect vowels characters and reverse them.
     * @param s the input string to be reversed.
     * @return the string after reversing its vowels
     */
    public static String solution(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String vowel = "aeiouAEIOU";
        int start = 0;
        int end = s.length() - 1;
        char[] array = s.toCharArray();
        while (start <= end) {
            if (vowel.indexOf(array[start]) >= 0 && vowel.indexOf(array[end]) >= 0) {
                char temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
            if (start < s.length() && vowel.indexOf(array[start]) < 0) {
                start++;
            }
            if (end >= 0 && vowel.indexOf(array[end]) < 0) {
                end--;
            }
        }
        return new String(array);
    }
    /**
     * This is the reference solution, which also uses two pointers, but
     * it stores all the vowel characters into the a hashset to reduce the
     * lookup into O(1).
     * @param s the input string to be reversed.
     * @return the string after reversing its vowels
     */
    public static String solutionRef(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        Set<Character> vowels = new
                HashSet<Character>(Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'}));
        char[] list = s.toCharArray();
        for (int i = 0, j = list.length - 1; i < j;) {
            if (!vowels.contains(list[i])) {
                i++;
                continue;
            }
            if (!vowels.contains(list[j])) {
                j--;
                continue;
            }
            char temp = list[i];
            list[i] = list[j];
            list[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(list);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "a.";
        String result = ReverseVowelsOfString.solution(test);
        System.out.println(result);
    }

}
