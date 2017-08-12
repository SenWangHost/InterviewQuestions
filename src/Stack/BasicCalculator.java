/**
 *
 */
package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
 * non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 *
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * @author SenWang
 *
 */
public class BasicCalculator {
    /**
     * This is the reference solution to this question.
     * @param s the string expression to be evaluated.
     * @return the evaluation result.
     */
    public static int solutionRef(String s) {
        int result = 0;
        int sign = 1;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            // if this is a number, extract it and store it in the result.
            if (Character.isDigit(temp)) {
                int number = temp - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    number = number * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                result += sign * number;
            } else if (temp == '+') {
                sign = 1;
            } else if (temp == '-') {
                sign = -1;
            } else if (temp == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (temp == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }
    /**
     * This is the test function for this problem.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test1 = "1 + 1";
        String test2 = "2-1 + 2";
        String test3 = "(1 + (4 + 5 + 2) - 3) + (6 + 8)";
        int result1 = BasicCalculator.solutionRef(test1);
        int result2 = BasicCalculator.solutionRef(test2);
        int result3 = BasicCalculator.solutionRef(test3);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
