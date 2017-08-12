/**
 *
 */
package LinkedList;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than
 * or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * @author SenWang
 *
 */
public class PartitionList {
    /**
     * This is my own solution to this question.
     * @param head the head of linked list to be considered.
     * @param x the integer value to be compared with.
     * @return the head of linked list after partition.
     */
    public static ListNode solution(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode large = largeHead;
        while (head != null) {
            if (head.val < x) {
                small.next = new ListNode(head.val);
                small = small.next;
            } else {
                large.next = new ListNode(head.val);
                large = large.next;
            }
            head = head.next;
        }
        if (smallHead.next == null) {
            head = largeHead.next;
            return head;
        }
        head = smallHead.next;
        small.next = largeHead.next;
        return head;
    }
    /**
     * The reference solution has exactly the same idea as mine.
     */
    /**
     * this is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {1, 2};
        ListNode test = PartitionList.arrayToList(array);
        ListNode result = PartitionList.solution(test, 2);
        PartitionList.printList(result);
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
