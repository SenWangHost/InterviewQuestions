/**
 *
 */
package LinkedList;

/**
 * Sort a linked list using insertion sort.
 * @author SenWang
 */
public class InsertionSortList {
    /**
     * This is my own solution to this question. This solution
     * is actually figured out when solving the sort list question.
     * @param head the head of linked list to be sorted.
     * @return the head of the sorted linked list.
     */
    public static ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(head.val);
        ListNode temp = head.next;
        while (temp != null) {
            if (temp.val <= result.val) {
                ListNode next = result;
                result = new ListNode(temp.val);
                result.next = next;
            } else {
                ListNode prev = null;
                ListNode curr = result;
                while (curr != null && curr.val <= temp.val) {
                    prev = curr;
                    curr = curr.next;
                }
                prev.next = new ListNode(temp.val);
                prev.next.next = curr;
            }
            temp = temp.next;
        }
        return result;
    }
    /**
     * The reference solution uses the dummy node to make
     * space complexity to be O(1).
     * @param head the head of the linked list.
     * @return the head of sorted linked list.
     */
    public static ListNode solutionRef(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        ListNode prev = dummy;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            curr.next = prev.next;
            prev.next = curr;
            prev = dummy;
            curr = next;
        }
        return dummy.next;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {4, 7, 2, 5, 3};
        ListNode test = InsertionSortList.arrayToList(array);
        ListNode result = InsertionSortList.solution(test);
        InsertionSortList.printList(result);
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
