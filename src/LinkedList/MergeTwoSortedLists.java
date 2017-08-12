/**
 *
 */
package LinkedList;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together
 * the nodes of the first two lists.
 * @author SenWang
 *
 */
public class MergeTwoSortedLists {
    /**
     * This is my own solution to this question.
     * @param l1 the head of the first linked list.
     * @param l2 the head of the second linked list.
     * @return the merged linked list.
     */
    public static ListNode solution(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = null;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        if (curr1.val < curr2.val) {
            result = curr1;
            curr1 = curr1.next;
        } else {
            result = curr2;
            curr2 = curr2.next;
        }
        ListNode temp = result;
        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                temp.next = curr1;
                curr1 = curr1.next;
            } else {
                temp.next = curr2;
                curr2 = curr2.next;
            }
            temp = temp.next;
        }
        if (curr1 != null) {
            temp.next = curr1;
        }
        if (curr2 != null) {
            temp.next = curr2;
        }
        return result;
    }
    /**
     * This is the reference solution, which use the recursion.
     * @param l1 the head of the first linked list.
     * @param l2 the head of the second linked list.
     * @return the merged linked list.
     */
    public static ListNode solutionRef(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = solutionRef(l1.next, l2);
            return l1;
        } else {
            l2.next = solutionRef(l1, l2.next);
            return l2;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);
        ListNode result = MergeTwoSortedLists.solution(l1, l2);
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
