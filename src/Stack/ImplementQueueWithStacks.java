/**
 *
 */
package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Notes:
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size,
 * and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque
 * (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 * @author SenWang
 *
 */
public class ImplementQueueWithStacks {
    /**
     * This is my own implementation for this question. It uses two stacks. One main
     * stack is to keep track of the elements in the queue. One aiding stack is to help
     * retrieve the first element when use pop and peek operations in the queue.
     * For this solution, the runtime complexity of push is O(1), the runtime complexity of
     * pop is amortized O(1).
     * Another approach is also to use two stacks, but store the element in the main stack in
     * reverse order. In that case, the runtime complexity of push is O(n), the runtime complexity
     * of pop is O(1).
     * @author SenWang
     */
    public static class MyQueue {
        /**
         * the main stack to store the elements.
         */
        private Deque<Integer> main;
        /**
         * the aiding stack for achieving the queue functionality.
         */
        private Deque<Integer> aid;
        /**
         * Initialize the data structure with the constructor.
         */
        public MyQueue() {
            main = new ArrayDeque<Integer>();
            aid = new ArrayDeque<Integer>();
        }
        /**
         * Push the element x to the back of the queue.
         * @param x the element to be pushed.
         */
        public void push(int x) {
            main.push(x);
        }
        /**
         * Remove the element from in front of the queue and return that element.
         * @return the element to be removed.
         */
        public int pop() {
            // get the first element in the stack.
            while (main.size() > 1) {
                int temp = main.pop();
                aid.push(temp);
            }
            // restore the main stack.
            int result = main.pop();
            while (aid.size() > 0) {
                int temp = aid.pop();
                main.push(temp);
            }
            return result;
        }
        /**
         * get the front element.
         * @return the front element.
         */
        public int peek() {
            // reach the first element on the stack.
            while (main.size() > 1) {
                int temp = main.pop();
                aid.push(temp);
            }
            // get the first element.
            int result = main.pop();
            // push the first element back to the main stack.
            main.push(result);
            // restore the stack.
            while (aid.size() > 0) {
                int temp = aid.pop();
                main.push(temp);
            }
            return result;
        }
        /**
         * return whether the queue is empty.
         * @return true if the queue is empty, false otherwise.
         */
        public boolean empty() {
            return main.size() == 0;
        }
    }
    /** This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyQueue test = new MyQueue();
        if (test.empty()) {
            System.out.println("Currently, the queue is empty.");
        }
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        System.out.println(test.peek());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.peek());
    }
}
