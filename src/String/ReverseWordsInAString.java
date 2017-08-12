/**
 *
 */
package String;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Clarification:
 * 1. What constitutes a word?
 *   A sequence of non-space characters constitutes a word.
 * 2. Could the input string contain leading or trailing spaces?
 *   Yes. However, your reversed string should not contain leading or trailing spaces.
 * 3. How about multiple spaces between two words?
 *   Reduce them to a single space in the reversed string.
 * @author SenWang
 *
 */
public class ReverseWordsInAString {
    /**
     * This is my own solution to this question.
     * @param s the input string to be considered.
     * @return the string with reversed word order.
     */
    public static String solution(String s) {
        // remove leading and trimming white spaces.
        s = s.trim();
        int index = 0;
        String result = "";
        StringBuilder word = new StringBuilder("");
        while (index < s.length()) {
            char temp = s.charAt(index);
            if (temp != ' ') {
                word.append(temp);
                index++;
            } else {
                result = " " + word.toString() + result;
                word.setLength(0);
                while (s.charAt(index) == ' ') {
                    index++;
                }
            }
        }
        result = word.toString() + result;
        return result;
    }
    /**
     * This is the reference solution that makes use of the built in
     * function.
     * @param s the input string to be considered.
     * @return the string with reversed word order.
     */
    public static String solutionRef(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "the  sky  is   blue";
        String result = ReverseWordsInAString.solution(test);
        System.out.println(result);
    }
}
