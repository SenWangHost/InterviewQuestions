/**
 *
 */
package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 *  "((()))",
 *  "(()())",
 *  "(())()",
 *  "()(())",
 *  "()()()"
 * ]
 * @author SenWang
 *
 */
public class GenerateParentheses {
    /**
     * This is my own solution to this question, which uses backtracking.
     * @param n the number of parentheses pairs to be used.
     * @return all posssible valid results.
     */
    public static List<String> solution(int n) {
        List<String> result = new ArrayList<String>();
        backTrack(result, new StringBuilder(), 2 * n);
        return result;
    }
    /**
     * This is the recursive helper function for backTracking.
     * @param result the list of string for storing the result.
     * @param temp the temporary string builder for storing one result.
     * @param length the length of the final result.
     */
    private static void backTrack(List<String> result, StringBuilder temp, int length) {
        if (temp.length() > length) {
            return;
        }
        if (temp.length() > 0 && temp.charAt(0) == ')') {
            return;
        }
        if (temp.length() == length && isValid(temp.toString())) {
            result.add(temp.toString());
            return;
        }
        String par = "()";
        for (int i = 0; i < 2; i++) {
            temp.append(par.charAt(i));
            backTrack(result, temp, length);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    /**
     * This is the helper function to chck whether this string result
     * is valid.
     * @param input the input string to be validated.
     * @return true if the expression is valid, false otherwise.
     */
    private static boolean isValid(String input) {
        if (input == null || input.length() == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (temp == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
    /**
     * This is the reference backtracking solution to this question, which
     * use number to keep track of the number of left and right parentheses.
     * @param n the number of parentheses pairs to be used.
     * @return all posssible valid results.
     */
    public static List<String> solutionRef(int n) {
        List<String> result = new ArrayList<String>();
        backTrackRef(result, new StringBuilder(), n, n);
        return result;
    }
    /**
     * This is the backtracking helper function to the solution above.
     * @param result the list of string representing the results.
     * @param temp the temporary string builder for storing one result.
     * @param left the number of left parentheses.
     * @param right the number of right parentheses.
     */
    private static void backTrackRef(List<String> result, StringBuilder temp, int left, int right) {
        if (left > right) {
            return;
        }
        if (left > 0) {
            temp.append("(");
            backTrackRef(result, temp, left - 1, right);
            temp.deleteCharAt(temp.length() - 1);
        }
        if (right > 0) {
            temp.append(")");
            backTrackRef(result, temp, left, right - 1);
            temp.deleteCharAt(temp.length() - 1);
        }
        if (left == 0 && right == 0) {
            result.add(temp.toString());
            return;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 3;
        List<String> result = GenerateParentheses.solutionRef(n);
        System.out.println(result);
    }

}
