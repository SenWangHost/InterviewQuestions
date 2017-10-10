/**
 *
 */
package LinkedList;


/**
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * Example:
 * Input:
 * 1->2->3
 * Output:
 * 1->2->4
 *
 * @author SenWang
 */
public class PlusOneLinkedList {
    /**
     * This is my own solutio to this question, which simply reverses the list
     * calculate the result digit by digit.
     * @param head the head of the list representing the number.
     * @return the head of the list representing the number after adding one.
     */
    public static ListNode solution(ListNode head) {
        ListNode rev = reverse(head);
        // printList(rev);
        ListNode temp = rev;
        int carriage = 0;
        while (temp != null) {
            if (temp.val < 9) {
                temp.val++;
                break;
            } else {
                temp.val = 0;
                carriage = 1;
            }
            if (temp.next == null && carriage == 1) {
                temp.next = new ListNode(carriage);
                temp = temp.next;
                break;
            } else {
                temp = temp.next;
            }
        }
        return reverse(rev);
    }
    /**
     * The is the helper function to reverse the list.
     * @param head the head of the list to be reversed.
     * @return the head of the reversed list.
     */
    private static ListNode reverse(ListNode head) {
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
     * anothe solution of mine, which doesn't use reverse function
     */
    public static ListNode solution2(ListNode head) {
        ListNode node = head;
        ListNode increment = null;
        while (node.next != null) {
            if (node.val != 9) {
                increment = node;
            }
            node = node.next;
        }
        if (node.val != 9) {
            node.val += 1;
            return head;
        }
        if (increment != null) {
            increment.val += 1;
            increment = increment.next;
            while (increment != null) {
                increment.val = 0;
                increment = increment.next;
            }
            return head;
        } else {
            ListNode nHead = new ListNode(1);
            nHead.next = head;
            while (head != null) {
                head.val = 0;
                head = head.next;
            }
            return nHead;
        }
    }
    /**
     * This is one reference solution, which use two pointers to keep
     * track of the possible digit that needs to be incremented. Also
     * use the dummy node at the beginning to handle the case, such as
     * 9->9->9
     * @param head the head of the list representing the number.
     * @return the head of the list representing the number after adding one.
     */
    public static ListNode solutionRef(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = dummy;
        while (curr.next != null) {
            curr = curr.next;
            // move the previous pointer only when carry is not needed.
            if (curr.val != 9) {
                prev = curr;
            }
        }
        if (curr.val != 9) {
            curr.val++;
        } else {
            prev.val++;
            prev = prev.next;
            while (prev != null) {
                prev.val = 0;
                prev = prev.next;
            }
        }
        if (dummy.val == 0) {
            return dummy.next;
        }
        return dummy;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {9, 8};
        ListNode test = PlusOneLinkedList.arrayToList(array);
        ListNode result = PlusOneLinkedList.solution(test);
        PlusOneLinkedList.printList(result);
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
