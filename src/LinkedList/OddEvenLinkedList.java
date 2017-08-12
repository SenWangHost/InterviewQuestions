/**
 *
 */
package LinkedList;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 * @author SenWang
 *
 */
public class OddEvenLinkedList {
    /**
     * This is my own solution to this question, which uses
     * two pointers to keep track of the odd and even nodes.
     * @param head the head of the linked list.
     * @return the head of the linked list that is regrouped.
     */
    public static ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddhead = head;
        ListNode evenhead = head.next;
        ListNode odd = oddhead;
        ListNode even = evenhead;
        while (even != null && even.next != null) {
            ListNode tempOdd = odd.next.next;
            ListNode tempEven = even.next.next;
            odd.next = tempOdd;
            odd = tempOdd;
            even.next = tempEven;
            even = tempEven;
        }
        odd.next = evenhead;
        return oddhead;
    }
    /**
     * The reference solution has exactly the same idea as mine and
     * the code is very similar to mine.
     */
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ListNode test = OddEvenLinkedList.arrayToList(array);
        ListNode result = OddEvenLinkedList.solution(test);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
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
