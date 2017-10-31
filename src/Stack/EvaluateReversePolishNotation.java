/**
 *
 */
package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * @author SenWang
 *
 */
public class EvaluateReversePolishNotation {
    /**
     * this is my own solution to this question.
     */
    public static int solution(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                if (stack.size() >= 2) {
                    int second = stack.pop();
                    int first = stack.pop();
                    int result = 0;
                    if (str.equals("+")) {
                        result = first + second;
                    } else if (str.equals("-")) {
                        result = first - second;
                    } else if (str.equals("*")) {
                        result = first * second;
                    } else if (str.equals("/")) {
                        result = first / second;
                    }
                    stack.push(result);
                }
            } else {
                int number = Integer.parseInt(str);
                stack.push(number);
            }
        }
        return stack.peek();
    }
    /**
     * the reference solution has the same idea as mine.
     */
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // String[] tokens = {"2","1","+","3","*"};
        String[] tokens2 = {"4","13","5","/","+"};
        System.out.println(solution(tokens2));
    }

}
