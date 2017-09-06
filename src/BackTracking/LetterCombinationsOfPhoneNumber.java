/**
 *
 */
package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * @author SenWang
 *
 */
public class LetterCombinationsOfPhoneNumber {
    /**
     * This is my own solution to this question, which uses back tracking method.
     * @param digits the string representation of phone number.
     * @return a list of string containing the results.
     */
    public static List<String> solution(String digits) {
        String[] table = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backTrack(result, new StringBuilder(), digits, table, 0);
        return result;
    }
    /**
     * This is recursive helper function to the back tracking solution above.
     * @param result the list of string for storing the result.
     * @param temp the temporary string builder for storing one result.
     * @param digits the input digits.
     * @param table the table for converting digit to characters.
     * @param index the index for tracking one specific digit.
     */
    private static void backTrack(List<String> result, StringBuilder temp, String digits, String[] table, int index) {
        if (temp.length() == digits.length()) {
            result.add(temp.toString());
            return;
        }
        if (index >= digits.length()) {
            return;
        }
        if (temp.length() > digits.length()) {
            return;
        }
        int tIndex = digits.charAt(index) - '2';
        String candidates = table[tIndex];
        for (int i = 0; i < candidates.length(); i++) {
            temp.append(candidates.charAt(i));
            backTrack(result, temp, digits, table, index + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    /**
     * This is the iterative solution to this question, which uses LinkedList
     * implemented queue to perform recursive process.
     * @param digits the string representation of phone number.
     * @return a list of string containing the results.
     */
    public static List<String> solutionRef(String digits) {
        LinkedList<String> result = new LinkedList<String>();
        String[] table = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if (digits == null || digits.length() == 0) {
            return result;
        }
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            int index = digits.charAt(i) - '2';
            String candidates = table[index];
            int size = result.size();
            while (size > 0) {
                String base = result.poll();
                size--;
                for (char c : candidates.toCharArray()) {
                    result.add(base + c);
                }
            }
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String digits = "26";
        List<String> result = LetterCombinationsOfPhoneNumber.solutionRef(digits);
        System.out.println(result);
    }

}
