/**
 *
 */
package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression. You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F (T and F represent True and False respectively).

Note:

The length of the given string is ≤ 10000.
Each number will contain only one digit.
The conditional expressions group right-to-left (as usual in most languages).
The condition will always be either T or F. That is, the condition will never be a digit.
The result of the expression will always evaluate to either a digit 0-9, T or F.
Example 1:

Input: "T?2:3"

Output: "2"

Explanation: If true, then result is 2; otherwise result is 3.
Example 2:

Input: "F?1:T?4:5"

Output: "4"

Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

             "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
          -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
          -> "4"                                    -> "4"
Example 3:

Input: "T?T?F:5:3"

Output: "F"

Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

             "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
          -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
          -> "F"                                    -> "F"
 * @author SenWang
 *
 */
public class TernaryExpressionParser {
    /**
     * this is my own solution to this question, this solution is easy but slow.
     */
    public static String solution(String expression) {
        if (expression.length() < 5) {
            return null;
        }
        if (expression.length() == 5) {
            String[] array = expression.split("\\?");
            String[] options = array[1].split("\\:");
            if (array[0].equals("T")) {
                return options[0];
            } else {
                return options[1];
            }
        }
        int index = expression.lastIndexOf('?');
        String sub = expression.substring(index - 1, index + 4);
        String front = expression.substring(0, index - 1);
        String back = expression.substring(index + 4);
        return solution(front + solution(sub) + back);
    }
    /**
     * this is the reference solution to this question.
     */
    public static String solutionRef(String expression) {
        if (expression == null || expression.length() == 0) {
            return "";
        }
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop(); // pop '?'
                char first = stack.pop();
                stack.pop(); // pop ':'
                char second = stack.pop();
                if (c == 'T') {
                    stack.push(first);
                } else {
                    stack.push(second);
                }
            } else {
                stack.push(c);
            }
        }
        return String.valueOf(stack.peek());
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "T?T?F:5:3";
//        String[] array = test.split("\\:");
//        for (String str : array) {
//            System.out.println(str);
//        }
        System.out.println(solution(test));
    }

}
