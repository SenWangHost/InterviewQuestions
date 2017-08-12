/**
 *
 */
package LinkedList;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 < m < n <= length of list.
 * @author SenWang
 */
public class ReverseLinkedListTwo {
    /**
     * This is my own solution to this question. The first phase to move the pointer
     * to the starting position where reversing needs. The second is to reverse the list.
     * @param head the head of the linked list to be reversed.
     * @param m the starting position.
     * @param n the ending position.
     * @return the head of the linked list after reversing.
     */
    public static ListNode solutionRef(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        int k = 1;
        while (curr.next != null && k != m) {
            prev = prev.next;
            curr = curr.next;
            k++;
        }
        // reverse the list
        while (curr.next != null && k != n) {
            ListNode prevNext = prev.next;
            prev.next = curr.next;
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prevNext;
            k++;
        }
        return dummy.next;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {1, 2, 3, 4 ,5};
        ListNode test = ReverseLinkedListTwo.arrayToList(array);
        ListNode result = ReverseLinkedListTwo.solutionRef(test, 2, 4);
        ReverseLinkedListTwo.printList(result);
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
