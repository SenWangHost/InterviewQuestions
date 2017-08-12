/**
 *
 */
package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author SenWang
 *
 */
public class ValidParentheses {
    /**
     * This is my own solution to this question.
     * @param s the string to be checked.
     * @return true if all parentheses are closed correctly, false otherwise.
     */
    public static boolean solution(String s) {
        if (s == null) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            char par = s.charAt(i);
            if (par == '(' || par == '[' || par == '{') {
                stack.push(par);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char counter = stack.pop();
                if (par == ')' && counter != '(') {
                    return false;
                } else if (par == ']' && counter != '[') {
                    return false;
                } else if (par == '}' && counter != '{') {
                    return false;
                }
            }
        }
        if (stack.size() == s.length() || stack.size() != 0) {
            return false;
        }
        return true;
    }
    /**
     * The reference solution also use one stack, however, instead of adding the left part of
     * any type of parentheses, it push its counterpart onto the stack.
     * @param s the string to be checked.
     * @return true if all parentheses are closed correctly, false otherwise.
     */
    public static boolean solutionRef1(String s) {
        if (s == null) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(') {
                stack.push(')');
            } else if (temp == '[') {
                stack.push(']');
            } else if (temp == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != temp) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test1 = "()[]{}";
        String test2 = "{()[]}()";
        String test3 = "([)]";
        String test4 = "({)}";
        String test5 = "([}";
        String test6 = "{[";
        String test7 = "]";
        System.out.println(solution(test1));
        System.out.println(solution(test2));
        System.out.println(solution(test3));
        System.out.println(solution(test4));
        System.out.println(solution(test5));
        System.out.println(solution(test6));
        System.out.println(solution(test7));
    }
}
