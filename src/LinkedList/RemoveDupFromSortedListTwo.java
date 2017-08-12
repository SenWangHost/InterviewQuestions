/**
 *
 */
package LinkedList;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * @author SenWang
 *
 */
public class RemoveDupFromSortedListTwo {
    /**
     * This is my own solution to this question. The basic idea is to
     * use three pointers to keep track of the previous previous element,
     * previous element and the current element.
     * @param head the head of linked list to be removed from.
     * @return the head of the linked list which only has distinct numbers.
     */
    public static ListNode solution(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode prevPrev = null;
        while (curr != null) {
            if (prev == null && prevPrev == null) {
                prevPrev = prev;
                prev = curr;
                curr = curr.next;
            } else if (prev != null && curr.val != prev.val) {
                prevPrev = prev;
                prev = curr;
                curr = curr.next;
            } else if (prev != null && curr.val == prev.val) {
                // while loop to find the node that is not dup before the dup.
                while (curr != null && curr.val == prev.val) {
                    curr = curr.next;
                }
                if (prevPrev == null) {
                    head = curr;
                } else {
                    prevPrev.next = curr;
                }
                prev = curr;
                if (curr != null) {
                    curr = curr.next;
                }
            }
        }
        return head;
    }
    /**
     * This is one of reference solution on leetcode. The idea is to use one
     * dummy head node and two pointers. The explantion of the code is pretty clear.
     * @param head the head of linked list to be removed from.
     * @return the head of the linked list which only has distinct numbers.
     */
    public static ListNode solutionRef(ListNode head) {
        //use two pointers, slow - track the node before the dup nodes,
        // fast - to find the last node of dups.
        ListNode dummy = new ListNode(0);
        ListNode fast = head;
        ListNode slow = dummy;
        slow.next = fast;
        while(fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;    //while loop to find the last node of the dups.
            }
            if (slow.next != fast) { //duplicates detected.
                slow.next = fast.next; //remove the dups.
                fast = slow.next;     //reposition the fast pointer.
            } else { //no dup, move down both pointer.
                slow = slow.next;
                fast = fast.next;
            }

        }
        return dummy.next;
    }
    /**
     * This is the recursive solution for this question. However, the iterative solution
     * would be better in terms of the performance.
     * @param head the head of linked list to be removed from.
     * @return the head of the linked list which only has distinct numbers.
     */
    public static ListNode solutionRef2(ListNode head) {
        // the base case
        if (head == null) {
            return head;
        }
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return solutionRef2(head.next);
        } else {
            head.next = solutionRef2(head.next);
        }
        return head;
    }
    /**
     * This is the test function for this problem.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {1, 1, 1, 2, 3, 3, 3, 3, 4, 5, 5, 5};
        ListNode test = RemoveDupFromSortedListTwo.createList(array);
        ListNode result = RemoveDupFromSortedListTwo.solution(test);
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
