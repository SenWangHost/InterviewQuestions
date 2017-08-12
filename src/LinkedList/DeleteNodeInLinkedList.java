/**
 *
 */
package LinkedList;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 * @author SenWang
 */
public class DeleteNodeInLinkedList {
    /**
     * This is my own solution to this question.
     * @param node the node to be deleted.
     */
    public void solution(ListNode node) {
        // would not delete the tail, so the following statement is always valid.
        int value = node.next.val;
        ListNode temp = node.next.next;
        // change the deleted node's value to be the value of next node.
        node.val = value;
        node.next = temp;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DeleteNodeInLinkedList test = new DeleteNodeInLinkedList();
        ListNode head = test.new ListNode(1);
        head.next = test.new ListNode(2);
        head.next.next = test.new ListNode(3);
        head.next.next.next = test.new ListNode(4);
        test.solution(head.next.next);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    /**
     * This is definition for the node in singly linked list.
     * @author SenWang
     */
    private class ListNode {
        /**
         * The value field for the node.
         */
        private int val;
        /**
         * The reference to the next node.
         */
        private ListNode next;
        /**
         * The constructor for the list node.
         * @param x the val to be stored in the node.
         */
        private ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
