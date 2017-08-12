/**
 *
 */
package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * @author SenWang
 *
 */
public class PalindromeLinkedList {
    /**
     * This is my own solution to this question.
     * @param head the head of the singly linked list.
     * @return true if it is a palindrome false otherwise.
     */
    public static boolean solution(ListNode head) {
        List<Integer> array = new ArrayList<Integer>();
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }
        int low = 0;
        int high = array.size() - 1;
        while (low <= high) {
            if (!array.get(low).equals(array.get(high))) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    /**
     * This is the reference solution to this question. The idea is simply to find
     * the middle point of the linked list and try to reverse the right half of the list
     * and compare the right half and left half. Thus, the algorithm of reversing a linked
     * list is also important here.
     * @param head the head of the singly linked list.
     * @return true if it is a palindrome false otherwise.
     */
    public static boolean solutionRef(ListNode head) {
        // find the the length of the list
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        p = head;
        // find the middle node of the list
        ListNode q = head;
        for (int i = 0; i < (length + 1) / 2; i++) {
            q = q.next;
        }
        // reverse the list.
        ListNode prev = null;
        while (q != null) {
            ListNode next = q.next;
            q.next = prev;
            prev = q;
            q = next;
        }
        // compare the left half and the reversed right half.
        while (p != null && prev != null) {
            if (p.val == prev.val) {
                p = p.next;
                prev = prev.next;
            } else {
                return false;
            }
        }
        return true;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        boolean result = PalindromeLinkedList.solutionRef(head);
        System.out.println(result);
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
