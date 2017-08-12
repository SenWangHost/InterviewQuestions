/**
 *
 */
package LinkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list,
 * only nodes itself can be changed.
 * @author SenWang
 *
 */
public class SwapNodesInPairs {
    /**
     * This is my own solution to this question. This solution
     * makes use of two pointers.
     * @param head the head of the linked list to be considered.
     * @return the head of the linked list after swapping pairs.
     */
    public static ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        while (prev != null && curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            if (next != null && next.next != null) {
                prev.next = next.next;
            } else if (next != null && next.next == null) {
                prev.next = next;
            } else {
                prev.next = null;
            }

            if (prev == head) {
                head = curr;
            }
            prev = next;
            if (next != null) {
                curr = next.next;
            } else {
                curr = null;
            }
        }
        return head;
    }
    /**
     * This reference solution is just another solution using recursion. The
     * efficiency is lower than iterative solution.
     * @param head the head of the linked list to be considered.
     * @return the head of the linked list after swapping pairs.
     */
    public static ListNode solutionRef(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = solutionRef(head.next.next);
        next.next = head;
        return next;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ListNode test = SwapNodesInPairs.arrayToList(array);
        ListNode result = SwapNodesInPairs.solution(test);
        SwapNodesInPairs.printList(result);
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
