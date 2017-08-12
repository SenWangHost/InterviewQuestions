/**
 *
 */
package String;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Note: You may assume that the string is well-formed:
 *
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 *
 * Example 1:
 * Given s = "324",
 * You should return a NestedInteger object which contains a single integer 324.
 *
 * Example 2:
 * Given s = "[123,[456,[789]]]",
 * Return a NestedInteger object containing a nested list with 2 elements:
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 *  i.  An integer containing value 456.
 *  ii. A nested list with one element:
 *      a. An integer containing value 789.
 * @author SenWang
 *
 */
public class MiniParser {
    /**
     * This is my own solution to this question. This solution is
     * acceptable and the runtime complexity would be O(n).
     * @param s the input string to be parsed.
     * @return the nested integer contains single integer or nested list.
     */
    public static NestedInteger solution(String s) {
        int length = s.length();
        int index = 0;
        int sign = 1;
        Deque<NestedInteger> stack = new ArrayDeque<NestedInteger>();
        while (index < length) {
            char temp = s.charAt(index);
            if (temp == '[') {
                NestedInteger nlist = new NestedInteger();
                stack.push(nlist);
            } else if (temp == ']') {
                if (stack.size() >= 2) {
                    NestedInteger prev = stack.pop();
                    NestedInteger curr = stack.pop();
                    curr.add(prev);
                    stack.push(curr);
                } else if (stack.size() == 1) {
                    return stack.pop();
                }
            } else if (temp == '-') {
                sign = -1;
            } else if (temp >= '0' && temp <= '9') {
                int number = 0;
                while (index < length && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    number = number * 10 + s.charAt(index) - '0';
                    index++;
                }
                NestedInteger single = new NestedInteger(number * sign);
                // reset the sign to be positive.
                sign = 1;
                if (stack.isEmpty()) {
                    return single;
                } else {
                    NestedInteger list = stack.pop();
                    list.add(single);
                    stack.push(list);
                    continue;
                }
            }
            index++;
        }
        return null;
    }
    /**
     * This is one of the reference solution that uses iterative solution.
     * This approach will just iterate through every char in the string (no recursion).
     * 1. If encounters '[', push current NestedInteger to stack and start a new one.
     * 2. If encounters ']', end current NestedInteger and pop a NestedInteger from stack to continue.
     * 3. If encounters ',', append a new number to curr NestedInteger, if this comma is not right after a brackets.
     * 4. Update index l and r, where l shall point to the start of a integer substring, while r shall points to
     * the end+1 of substring.
     * @param s the input string to be parsed.
     * @return the nested integer contains single integer or nested list.
     */
    public static NestedInteger solutionRef(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }
        Deque<NestedInteger> stack = new ArrayDeque<NestedInteger>();
        NestedInteger curr = null;
        int l = 0; // l shall point to the start of a number substring;
                   // r shall point to the end+1 of a number substring
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (ch == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
                l = r + 1;
            } else if (ch == ']') {
                String num = s.substring(l, r);
                if (!num.isEmpty()) {
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(curr);
                    curr = pop;
                }
                l = r+1;
            } else if (ch == ',') {
                if (s.charAt(r-1) != ']') {
                    String num = s.substring(l, r);
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                l = r + 1;
            }
        }

        return curr;
    }
    /**
     * The nested integer class implemented based on its
     * interface.
     */
    private static class NestedInteger {
        /**
         * This is the field for storing the single integer.
         */
        private Integer singleInt;
        /**
         * This is the field for storing the nested list.
         */
        private List<NestedInteger> list;
        /**
         * This is the Constructor initializes an empty nested list.
         */
        private NestedInteger() {
            list = new ArrayList<NestedInteger>();
            singleInt = null;
        }
        /**
         * This is the Constructor initializes a single integer.
         * @param value the integer value to be stored.
         */
        private NestedInteger(int value) {
            singleInt = value;
            list = null;
        }
        /**
         * The method to check whether the nested integer holds an single
         * integer.
         * @return true if this NestedInteger holds a single integer, rather than a nested list.
         */
        private boolean isInteger() {
            if (list == null && singleInt != null) {
                return true;
            }
            return false;
        }
        /**
         * The method to extract the single integer stored in this nested integer.
         * @return the single integer that this NestedInteger holds, if it holds a single integer
         *  Return null if this NestedInteger holds a nested list
         */
        private Integer getInteger() {
            if (list != null) {
                return null;
            }
            return singleInt;
        }
        /**
         * This is the method to Set this NestedInteger to hold a single integer.
         * @param value the integer value to be stored.
         */
        @SuppressWarnings("unused")
        private void setInteger(int value) {
            singleInt = value;
        }
        /**
         * This is the method to Set this NestedInteger to hold a nested list and adds a nested integer to it.
         * @param ni the nested integer to be added to the list.
         */
        private void add(NestedInteger ni) {
            if (list == null) {
                throw new NullPointerException();
            }
            list.add(ni);
        }
        /**
         * This is the method to extract the list store in this nested integer.
         * @return the nested list that this NestedInteger holds, if it holds a nested list
         * Return null if this NestedInteger holds a single integer
         */
        private List<NestedInteger> getList() {
            if (singleInt != null) {
                return null;
            }
            return list;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "[-123,[456,[789]]]";
        NestedInteger result = MiniParser.solution(test);
        System.out.println(result.isInteger());
        if (result.isInteger()) {
            System.out.println(result.getInteger());
        } else {
            List<NestedInteger> list = result.getList();
            System.out.println(list.size());
            Iterator<NestedInteger> iter = list.iterator();
            while (iter.hasNext()) {
                NestedInteger temp = iter.next();
                if (temp.isInteger()) {
                    System.out.println(temp.getInteger());
                } else {
                    System.out.println(temp.getList().size());
                }
            }
        }

    }
}
