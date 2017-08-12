/**
 *
 */
package LinkedList;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * @author SenWang
 *
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * This is my own solution to this question,which uses two pointers
     * to find the tail of linked list and the deleted node.
     * @param head the head of the singly linked list.
     * @param n the n th node to be deleted.
     * @return the head of the linked list after removing the node.
     */
    public static ListNode solution(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (head.next == null && n >= 1) {
            return null;
        }
        ListNode delete = head;
        ListNode tail = head;
        ListNode prev = null;
        int count = 1;
        while (count < n) {
            tail = tail.next;
            count++;
        }
        while (tail.next != null) {
            prev = delete;
            delete = delete.next;
            tail = tail.next;
        }
        if (prev == null) {
            head = delete.next;
        } else {
            prev.next = delete.next;
        }
        return head;
    }
    /**
     * The reference solution has the same idea as mine. But it is more clean
     * and use the dummy node before the head of linked list.
     * @param head the head of the singly linked list.
     * @param n the n th node to be deleted.
     * @return the head of the linked list after removing the node.
     */
    public static ListNode solutionRef(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        // Move fast in front so that the gap between slow and fast becomes n
        for(int i = 1; i <= n + 1; i++)   {
            fast = fast.next;
        }
        // Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
    /**
     * This is test function for this question
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {1, 2, 3, 4, 5};
        ListNode test = RemoveNthNodeFromEndOfList.createList(array);
        ListNode result = RemoveNthNodeFromEndOfList.solution(test, 5);
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
