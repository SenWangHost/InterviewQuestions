/**
 *
 */
package LinkedList;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * @author SenWang
 *
 */
public class RotateList {
    /**
     * This is my own solution to this question, which uses two pointers.
     * This solution is acceptable and runtime complexity is linear.
     * @param head the head of linked list to be rotated.
     * @param k the number of places to be rotated.
     * @return the head of the linked list after rotation.
     */
    public static ListNode solution(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        ListNode prev = head;
        ListNode curr = head;
        int count = 0;
        while (count < k) {
            curr = curr.next;
            count++;
        }
        while (curr.next != null) {
            prev = prev.next;
            curr = curr.next;
        }
        ListNode newHead = prev.next;
        prev.next = null;
        curr.next = head;
        head = newHead;
        return head;
    }
    /**
     * This reference solution to this question presents another idea, which is to connect
     * the tail of the list to the head to form a cycle, and continue to move the tail node len-k
     * steps and cut it.
     * @param head the head of linked list to be rotated.
     * @param k the number of places to be rotated.
     * @return the head of the linked list after rotation.
     */
    public static ListNode solutionRef(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        k = k % length;
        for (int i = 0; i < length - k; i++) {
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {1, 2, 3, 4, 5};
        ListNode test = RotateList.arrayToList(array);
        ListNode result = RotateList.solution(test, 0);
        RotateList.printList(result);
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
