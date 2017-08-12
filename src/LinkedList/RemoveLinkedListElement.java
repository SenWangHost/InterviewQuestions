/**
 *
 */
package LinkedList;

/**
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * @author SenWang
 */
public class RemoveLinkedListElement {
    /**
     * This is my own solution to this question.
     * @param head the head of the list to be removed element from.
     * @param val the value specified to remove.
     * @return the list after removing specific element.
     */
    public static ListNode solution(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // delete the possible head element.
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode prev = null;
        ListNode curr = head;
        // delete other element if its value is equal to val.
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                curr = prev.next;
                continue;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
    /**
     * The reference solution has the same idea as mine, basically using two pointers
     * to keep track of the previous and next element.
     */
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] testArray = {1, 2, 2, 1};
        ListNode head = RemoveLinkedListElement.arrayToList(testArray);
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println("---------");
        ListNode result = RemoveLinkedListElement.solution(head, 1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    /**
     * The helper function to create a linked list with an array.
     * @param array the array of integers to be put into list
     * @return a singly linked list having the same element as the array.
     */
    private static ListNode arrayToList(int[] array) {
        ListNode head = new ListNode(array[0]);
        ListNode temp = head;
        for (int i = 1; i < array.length; i++) {
            temp.next = new ListNode(array[i]);
            temp = temp.next;
        }
        return head;
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
