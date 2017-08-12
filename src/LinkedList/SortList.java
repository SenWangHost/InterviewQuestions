/**
 *
 */
package LinkedList;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * @author SenWang
 *
 */
public class SortList {
    /**
     * This is my own solution to this question, which uses the insertion sort.
     * But the worst case runtime complexity would be O(n^2).
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
     * In order make the runtime complexity be O(n * log(n)), merge
     * sort has be used here. In fact, the merge function has already been solved
     * in another interview question: MergeTwoSortedList. The key here is to implement
     * the merge sort function.
     */
    public static ListNode solution2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // step 1. cut the list into two halves.
        ListNode left = head;
        ListNode right = null;
        int length = length(head);
        int count = 0;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            count++;
            if (count > length / 2) {
                right = curr;
                prev.next = null;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        // step 2. sort each half recursively.
        left = solution2(left);
        right = solution2(right);
        // step 3. merge the sort two halves.
        return merge(left, right);
    }
    /**
     * This is the helper function to calculate the length of
     * the singly linked list.
     * @param head the head of the linked list.
     * @return the length of the linked list.
     */
    private static int length(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    /**
     * This is the helper function to merge two sorted list.
     * @param l1 the head of first sorted linked list.
     * @param l2 the head of second sorted linked list.
     * @return the merged sorted linked list.
     */
    private static ListNode merge(ListNode l1, ListNode l2) {
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
     * The reference solution also use the merge sort method.
     * The difference is that when divide the linked list into
     * two halves, they use slow and fast pointers.
     */
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {4, 7, 2, 5 ,3, 2, 4};
        ListNode test = SortList.arrayToList(array);
        ListNode result = SortList.solution2(test);
        SortList.printList(result);
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
