/**
 *
 */
package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size,
 * and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque
 * (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 * @author SenWang
 *
 */
public class ImplementStackWithQueues {
    /**
     * This is my own solution to this question, which uses two queues.
     * @author SenWang
     */
    public static class MyStack {
        /**
         * The main queue to keep track of the element on the stack.
         */
        private Deque<Integer> main;
        /**
         * The aiding queue to help get the top element on the stack.
         */
        private Deque<Integer> aid;
        /**
         * Initialize the data structure with the constructor.
         */
        public MyStack() {
            main = new ArrayDeque<Integer>();
            aid = new ArrayDeque<Integer>();
        }
        /**
         * push element x onto the stack.
         * @param x the element to be pushed.
         */
        public void push(int x) {
            main.offer(x);
        }
        /**
         * remove the element at the top of the stack and return that element.
         * @return the element at the top of the stack.
         */
        public int pop() {
            while (main.size() > 1) {
                int temp = main.poll();
                aid.offer(temp);
            }
            // get the top element on the stack.
            int top = main.poll();
            // restore the stack by retrieve the element from the aid.
            while (aid.size() > 0) {
                int temp = aid.poll();
                main.offer(temp);
            }
            return top;
        }
        /**
         * get the top element on the stack, but don't remove it.
         * @return the top element on the stack.
         */
        public int top() {
            while (main.size() > 1) {
                int temp = main.poll();
                aid.offer(temp);
            }
            // get the top the element on the stack.
            int top = main.poll();
            aid.offer(top);
            while (aid.size() > 0) {
                int temp = aid.poll();
                main.offer(temp);
            }
            return top;
        }
        /**
         * check whether the stack is empty.
         * @return true if the stack is empty, false otherwise.
         */
        public boolean empty() {
            return main.size() == 0;
        }
    }
    /**
     * This is another implementation of stack, which uses only one queue.
     * The runtime complexity for pop is O(n) and it beats 90% of answer in java.
     * @author SenWang
     */
    public static class MyStack2 {
        /**
         * The queue to keep track of the elements.
         */
        private Deque<Integer> main;
        /**
         * Initialize the data structure with the constructor.
         */
        public MyStack2() {
            main = new ArrayDeque<Integer>();
        }
        /**
         * push element x onto the stack.
         * @param x the element to be pushed.
         */
        public void push(int x) {
            main.offer(x);
        }
        /**
         * remove the element at the top of the stack and return that element.
         * @return the element at the top of the stack.
         */
        public int pop() {
            // move the top element to the head of the queue.
            for (int i = 0; i < main.size() - 1; i++) {
                int temp = main.poll();
                main.offer(temp);
            }
            return main.poll();
        }
        /**
         * get the top element on the stack, but don't remove it.
         * @return the top element on the stack.
         */
        public int top() {
            // move the top element to the head of the queue.
            for (int i = 0; i < main.size() - 1; i++) {
                int temp = main.poll();
                main.offer(temp);
            }
            int result = main.poll();
            main.offer(result);
            return result;
        }
        /**
         * check whether the stack is empty.
         * @return true if the stack is empty, false otherwise.
         */
        public boolean empty() {
            return main.size() == 0;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyStack2 test = new MyStack2();
        if (test.empty()) {
            System.out.println("The stack is currently empty!");
        }
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        System.out.println(test.top());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
    }
}
