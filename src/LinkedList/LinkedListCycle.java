/**
 *
 */
package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 * @author SenWang
 */
public class LinkedListCycle {
    /**
     * This is my own solution to this question, which makes use of the hashset.
     * This is solution is acceptable but use too much space.
     * @param head the head of the linked list.
     * @return true if it has cycle in it, false otherwise.
     */
    public static boolean solution(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            if (temp.next == null) {
                return false;
            }
            if (set.contains(temp)) {
                return true;
            } else {
                set.add(temp);
            }
            temp = temp.next;
        }
        return false;
    }
    /**
     * This is reference solution to this question, which use walker and runner method.
     * The idea is to use two pointers, one is walker, which moves step by step. Another
     * pointer is runner, which moves two steps at a time. If they could meet, there must be
     * a cycle in the linked list.
     * @param head the head of the linked list.
     * @return true if it has cycle in it, false otherwise.
     */
    public static boolean solutionRef(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode walker = head;
        ListNode runner = head;
        while (walker.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                return true;
            }
        }
        return false;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /**
     * This is the definition for the node in singly linked list.
     * @author SenWang
     */
    private static class ListNode {
        /**
         * The field of value for the node.
         */
        @SuppressWarnings("unused")
        private int val;
        /**
         * The reference to the next node.
         */
        private ListNode next;
        /**
         * The constructor for the node.
         * @param x the value to be stored in the node.
         */
        private ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
