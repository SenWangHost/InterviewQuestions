/**
 *
 */
package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an encoded string, return it's decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for
 * those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * @author SenWang
 *
 */
public class DecodeString {
    /**
     * This is the reference solution to this question, which makes
     * use of two stacks to keep track of the repeated number and resulting
     * string.
     * @param s the string input to be decoded.
     * @return the decoded string
     */
    public static String solutionRef(String s) {
        String result = "";
        Deque<Integer> countStack = new ArrayDeque<Integer>();
        Deque<String> resStack = new ArrayDeque<String>();
        int index = 0;
        while (index < s.length()) {
            // if this char is a number, then get the repeat number
            // and store it onto the stack.
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            // if it is a front parentheses, start to put result onto the stack
            } else if (s.charAt(index) == '[') {
                resStack.push(result);
                result = "";
                index++;
            // if it is a back parentheses, form the substring and update the result.
            } else if (s.charAt(index) == ']') {
                int repeatNum = countStack.pop();
                StringBuilder temp = new StringBuilder(resStack.pop());
                for (int i = 0; i < repeatNum; i++) {
                    temp.append(result);
                }
                result = temp.toString();
                index++;
            } else {
                result += s.charAt(index);
                index++;
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
        String test1 = "3[a]2[bc]";
        String test2 = "3[a2[c]]";
        String test3 = "2[abc]3[cd]ef";
        System.out.println(DecodeString.solutionRef(test1));
        System.out.println(DecodeString.solutionRef(test2));
        System.out.println(DecodeString.solutionRef(test3));
    }
}
