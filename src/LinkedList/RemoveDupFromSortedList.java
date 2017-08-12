/**
 *
 */
package LinkedList;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 *
 * @author SenWang
 *
 */
public class RemoveDupFromSortedList {
    /**
     * This is my own solution to this question.
     * @param head the head of the linked list to be removed from.
     * @return the head of the linked list which doesn't contain duplicates.
     */
    public static ListNode solution(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            if (prev == null || curr.val != prev.val) {
                prev = curr;
                curr = curr.next;
            } else {
                prev.next = curr.next;
                curr = prev.next;
            }
        }
        return head;
    }
    /**
     * Most other iterative reference solution has the same idea as mine,
     * but there are also recursive solution, which is much shorter than
     * the iterative solution.
     * @param head the head of the linked list to be removed from.
     * @return the head of the linked list which doesn't contain duplicates.
     */
    public static ListNode solutionRef(ListNode head) {
        // the base case
        if (head == null || head.next == null) {
            return head;
        }
        // the recursive case.
        head.next = solutionRef(head.next);
        if (head.val == head.next.val) {
            return head.next;
        } else {
            return head;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {1};
        ListNode test = RemoveDupFromSortedList.createList(array);
        ListNode result = RemoveDupFromSortedList.solution(test);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    /**
     * This is the helper function for creating a singly linked list
     * from an integer array.
     * @param array the integer array as the input.
     * @return the head of created singly linked list.
     */
    private static ListNode createList(int[] array) {
        ListNode result = new ListNode(array[0]);
        ListNode temp = result;
        for (int i = 1; i < array.length; i++) {
            temp.next = new ListNode(array[i]);
            temp = temp.next;
        }
        return result;
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
