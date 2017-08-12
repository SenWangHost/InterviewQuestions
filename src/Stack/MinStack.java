/**
 *
 */
package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 1. push(x) -- Push element x onto stack.
 * 2. pop() -- Removes the element on top of the stack.
 * 3. top() -- Get the top element.
 * 4. getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * @author SenWang
 *
 */
public class MinStack {
    /**
     * This is my own implementation for this min stack, which just
     * uses one variable to keep track of the min value.
     * @author SenWang
     */
    public static class minStack {
        /**
         * The norm stack uses to support the major operations.
         */
        private Deque<Integer> stack;
        /**
         * The variable to store the min element.
         */
        private int min;
        /**
         * The constructor to initialize the data structure.
         */
        public minStack() {
            stack = new ArrayDeque<Integer>();
            min = Integer.MAX_VALUE;
        }
        /**
         * The push operation of the min stack.
         * @param x the element to be pushed onto the stack.
         */
        public void push(int x) {
            stack.push(x);
            if (x < min) {
                min = x;
            }
        }
        /**
         * The pop operation of the min stack.
         * @return the element that is removed from the top of the stack.
         */
        public int pop() {
            int temp = stack.pop();
            if (temp == min) {
                if (!stack.isEmpty()) {
                    int[] mem = new int[stack.size()];
                    min = stack.peek();
                    for (int i = 0; i < mem.length; i++) {
                        int num = stack.pop();
                        mem[i] = num;
                        if (num < min) {
                            min = num;
                        }
                    }
                    // restore the stack sequence.
                    for (int i = mem.length - 1; i >= 0; i--) {
                        stack.push(mem[i]);
                    }
                } else {
                    min = Integer.MAX_VALUE;
                }
            }
            return temp;
        }
        /**
         * The top operation of the min stack, which retrieves the top
         * element but doesn't remove it.
         * @return the top element of the stack.
         */
        public int top() {
            return stack.peek();
        }
        /**
         * The method to get the min element of the stack.
         * @return the min element in the stack.
         */
        public int getMin() {
            return min;
        }
    }
    /**
     * This is one reference implementation of the min stack. The internal structure
     * is the same as mine and always push current min twice onto stack.
     */
    public static class minStackRef1 {
        /**
         * The norm stack uses to support the major operations.
         */
        private Deque<Integer> stack;
        /**
         * The variable to store the min element.
         */
        private int min;
        /**
         * The constructor to initialize the data structure.
         */
        public minStackRef1() {
            stack = new ArrayDeque<Integer>();
            min = Integer.MAX_VALUE;
        }
        /**
         * The push operation of the min stack.
         * @param x the element to be pushed onto the stack.
         */
        public void push(int x) {
            // only push the old minimum value when the current
            // minimum value changes after pushing the new value x
            if (x <= min) {
                min = x;
                stack.push(min);
            }
            stack.push(x);
        }
        /**
         * The pop operation of the min stack.
         * @return the element that is removed from the top of the stack.
         */
        public int pop() {
            int temp = stack.pop();
            if (temp == min) {
                min = stack.pop();
            }
            return temp;
        }
        /**
         * The top operation of the min stack, which retrieves the top
         * element but doesn't remove it.
         * @return the top element of the stack.
         */
        public int top() {
            return stack.peek();
        }
        /**
         * The method to get the min element of the stack.
         * @return the min element in the stack.
         */
        public int getMin() {
            return min;
        }
    }
    /**
     * This is another reference solution that makes use of linked list. In
     * each node, both the integer and current min is stored.
     */
    public static class minStackRef2 {
        private Node head;
        /**
         * The constructor to initialize the data structure.
         */
        public minStackRef2() {
            head = null;
        }
        /**
         * The push operation of the min stack.
         * @param x the element to be pushed onto the stack.
         */
        public void push(int x) {
            if(head == null)
                head = new Node(x, x);
            else
                head = new Node(x, Math.min(x, head.min), head);
        }
        /**
         * The pop operation of the min stack.
         * @return the element that is removed from the top of the stack.
         */
        public void pop() {
            head = head.next;
        }
        /**
         * The top operation of the min stack, which retrieves the top
         * element but doesn't remove it.
         * @return the top element of the stack.
         */
        public int top() {
            return head.val;
        }
        /**
         * The method to get the min element of the stack.
         * @return the min element in the stack.
         */
        public int getMin() {
            return head.min;
        }
        /**
         * The node class used for linked list.
         */
        private class Node {
            int val;
            int min;
            Node next;

            private Node(int val, int min) {
                this(val, min, null);
            }

            private Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        minStack test = new minStack();
        test.push(-2);
        test.push(0);
        test.push(-3);
        System.out.println(test.getMin());
        test.pop();
        System.out.println(test.getMin());
        System.out.println(test.top());
        test.pop();
        System.out.println(test.getMin());
        System.out.println(test.top());
    }
}
