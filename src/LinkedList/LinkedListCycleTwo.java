/**
 *
 */
package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Note: Do not modify the linked list.
 * Follow up:
 * Can you solve it without using extra space?
 * @author SenWang
 *
 */
public class LinkedListCycleTwo {
    /**
     * This is my own solution for this question, which
     * uses the hashset to track the node we have come across.
     * The space and runtime complexity are both bad.
     * @param head the head of the singly linked list to be considered.
     * @return the node where the cycle begins, if there is no cycle, return null.
     */
    public static ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        Set<ListNode> set = new HashSet<ListNode>();
        while (temp != null) {
            if (temp.next == null) {
                return null;
            }
            if (temp.next == temp) {
                return temp;
            }
            if (set.contains(temp.next)) {
                return temp.next;
            } else {
                set.add(temp);
            }
            temp = temp.next;
        }
        return null;
    }
    /**
     * This is the reference solution for this question. This solution
     * use two pointers and the detailed explanation is on leetcode, the link
     * is https://discuss.leetcode.com/topic/19367/java-o-1-space-solution-with-detailed-explanation/12,
     * with a good picture attached to post 113.
     * @param head the head of the singly linked list to be considered.
     * @return the node where the cycle begins, if there is no cycle, return null.
     */
    public static ListNode solutionRef(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // start a new node from the head and try
                // to reach the slow pointer at the same pace.
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
    /**
     * This is test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = head;
        ListNode result = LinkedListCycleTwo.solutionRef(head);
        System.out.println(result.val);
    }
    /**
     * This is the definition for the node in singly linked list.
     * @author SenWang
     */
    private static class ListNode {
        /**
         * The field of value for the node.
         */
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
