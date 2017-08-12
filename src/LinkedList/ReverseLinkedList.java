/**
 *
 */
package LinkedList;

/**
 * Reverse a singly linked list.
 * @author SenWang
 */
public class ReverseLinkedList {
    /**
     * This is my own solution to this question.
     * @param head the head node of the singly linked list.
     * @return the head of the reversed linked list.
     */
    public static ListNode solution(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    /**
     * This is reference solution to this question, which uses recursive method. However, the first
     * solution is encouraged.
     * @param head the head node of the singly linked list.
     * @return the head of the reversed linked list.
     */
    public static ListNode solutionRef(ListNode head) {
        return solutionRecursive(head, null);
    }
    /**
     * This is the recursive helper function for recursive method.
     * @param head the head node of the singly linked list.
     * @param prev the prev node of the singly linked list.
     * @return the head of the reversed linked list.
     */
    private static ListNode solutionRecursive(ListNode head, ListNode prev) {
        if (head == null) {
            return null;
        }
        ListNode next = head.next;
        head.next = prev;
        return solutionRecursive(next, head);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        ListNode result = ReverseLinkedList.solution(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

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
