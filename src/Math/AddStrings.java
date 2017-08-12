/**
 *
 */
package Math;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * Note:
 * 1. The length of both num1 and num2 is < 5100.
 * 2. Both num1 and num2 contains only digits 0-9.
 * 3. Both num1 and num2 does not contain any leading zero.
 * 4. You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * @author SenWang
 *
 */
public class AddStrings {
    /**
     * This is the my own solution to this question. Use the
     * string builder to speed up the formation of string.
     * @param num1 the string representation of the first number.
     * @param num2 the string representation of the second number.
     * @return the string representation of the sum of the two numbers.
     */
    public static String solution(String num1, String num2) {
        Deque<Character> stack1 = new ArrayDeque<Character>();
        Deque<Character> stack2 = new ArrayDeque<Character>();
        for (int i = 0; i < num1.length(); i++) {
            stack1.push(num1.charAt(i));
        }
        for (int i = 0; i < num2.length(); i++) {
            stack2.push(num2.charAt(i));
        }
        StringBuilder result = new StringBuilder("");
        int digit1 = 0;
        int digit2 = 0;
        int carriage = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                digit1 = stack1.pop() - '0';
            } else {
                digit1 = 0;
            }
            if (!stack2.isEmpty()) {
                digit2 = stack2.pop() - '0';
            } else {
                digit2 = 0;
            }
            int sum = (digit1 + digit2 + carriage);
            carriage = sum / 10;
            result.append(Integer.toString(sum % 10));
            if (stack1.isEmpty() && stack2.isEmpty()) {
                if (carriage == 1) {
                    result.append("1");
                }
            }
        }
        return result.reverse().toString();
    }
    /**
     * This is the reference solution. It uses the same idea and algorithm but with a much
     * compact code.
     * @param num1 the string representation of the first number.
     * @param num2 the string representation of the second number.
     * @return the string representation of the sum of the two numbers.
     */
    public static String solutionRef(String num1, String num2) {
        StringBuilder result = new StringBuilder("");
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            result.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return result.reverse().toString();
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String num1 = "999";
        String num2 = "1";
        String result = AddStrings.solution(num1, num2);
        System.out.println(result);
    }
}
