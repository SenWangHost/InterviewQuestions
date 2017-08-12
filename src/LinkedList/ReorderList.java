/**
 *
 */
package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a singly linked list L: L0?L1?…?Ln-1?Ln,
 * reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * @author SenWang
 *
 */
public class ReorderList {
    /**
     * This is my own solution to this question. This solution makes uses
     * of the hash map data structure.
     * @param head the head of the linked list to be reordered.
     */
    public static void solution(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        int count = -1;
        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        while (head != null) {
            count++;
            map.put(count, head);
            head = head.next;
        }
        ListNode temp = head;
        for (int i = 0; i <= count / 2; i++) {
            if (i == 0) {
                head = map.get(i);
                head.next = map.get(count - i);
                temp = head.next;
            } else {
                if (i == count / 2 && count % 2 == 0) {
                    temp.next = map.get(i);
                    map.get(i).next = null;
                } else {
                    temp.next = map.get(i);
                    temp.next.next = map.get(count - i);
                    map.get(count - i).next = null;
                }
                temp = temp.next.next;
            }
        }
    }
    /**
     * This is reference solution to this question, which requires three steps.
     * The efficiency is much faster than hash map method.
     * @param head the head of linked list to be reordered.
     */
    public static void solutionRef(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // step 1, cut the list into two halves.
        // prev will be the tail of the first half.
        // slow will be the head of the second half.
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        // step 2, reverse the second half. could be written as
        // Separate helper function.
        ListNode rev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = rev;
            rev = slow;
            slow = next;
        }
        // step 3, merge two half;
        ListNode temp = head;
        while (temp != null && rev != null) {
            ListNode next1 = temp.next;
            temp.next = rev;
            temp = next1;
            ListNode next2 = rev.next;
            if (temp != null) {
                rev.next = temp;
            }
            rev = next2;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {1, 2, 3, 4, 5, 6};
        ListNode test = ReorderList.arrayToList(array);
        ReorderList.solutionRef(test);
        ReorderList.printList(test);
    }
    /**
     * The helper function to transform a array of integers into linked list.
     * @param arr the array to be transformed.
     * @return the linked list representing the array.
     */
    public static ListNode arrayToList(int[] arr) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        for (int i = 0; i < arr.length; i++) {
            temp.val = arr[i];
            if (i != arr.length - 1) {
                temp.next = new ListNode(0);
                temp = temp.next;
            }
        }
        return result;
    }
    /**
     * This is the helper function to print the element
     * in the list.
     * @param head the head of the singly linked list.
     */
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    /**
     * The node for the linked list.
     * @author SenWang
     */
    public static class ListNode {
        /**
         * The value field for the list node.
         */
        private int val;
        /**
         * The next reference field for the list node.
         */
        private ListNode next;
        /**
         * The constructor for the ListNode.
         * @param x
         */
        public ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
