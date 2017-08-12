/**
 *
 */
package LinkedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * @author SenWang
 *
 */
public class MergeKSortedLists {
    /**
     * This is my own solution to this question. This solution works but not acceptable
     * because runtime complexity is pretty bad.
     * @param lists an array of head of linked lists.
     * @return one sorted list.
     */
    public static ListNode solution(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        int k = lists.length;
        ListNode[] tempLists = new ListNode[k];
        for (int i = 0; i < k; i++) {
            tempLists[i] = lists[i];
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (!checkNull(tempLists)) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < k; i++) {
                if (tempLists[i] != null && tempLists[i].val < min) {
                    min = tempLists[i].val;
                    index = i;
                }
            }
            if (index != -1) {
                // update the result list.
                temp.next = new ListNode(tempLists[index].val);
                // update the list node in the array
                tempLists[index] = tempLists[index].next;
                temp = temp.next;
            }
        }
        return dummy.next;
    }
    /**
     * The helper function to check all the nodes in the array
     * to be null or not.
     * @param lists an array of lists to be checked
     * @return true if the node in the list are all null, false otherwise.
     */
    private static boolean checkNull(ListNode[] lists) {
        int length = lists.length;
        for (int i = 0; i < length; i++) {
            if (lists[i] != null) {
                return false;
            }
        }
        return true;
    }
    /**
     * One iterative reference solution is to use priority queue as
     * an aiding data structure. This solution requires implementation of
     * comparator for the priority queue.
     * @param lists an array of head of linked lists.
     * @return one sorted list.
     */
    public static ListNode solutionRef1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {

            @Override
            public int compare(ListNode o1, ListNode o2) {
                // TODO Auto-generated method stub
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        // add the all elements into the priority queue.
        for (ListNode temp : lists) {
            if (temp != null) {
                queue.add(temp);
            }
        }
        // extract the element from the priority queue to construct the
        // resulting list.
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (!queue.isEmpty()) {
            temp.next = queue.poll();
            temp = temp.next;
            if (temp.next != null) {
                queue.add(temp.next);
            }
        }
        return dummy.next;
    }
    /**
     * Another reference solution makes use of the divide and conquer algorithm.
     * Simply, this question is a combination of merge two sorted lists.
     * The code is much clear than previous solution.
     * @param lists an array of head of linked lists.
     * @return one sorted list.
     */
    public static ListNode solutionRef2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        int length = lists.length;
        int mid = length / 2;
        ListNode[] first = Arrays.copyOfRange(lists, 0, mid);
        ListNode[] second = Arrays.copyOfRange(lists, mid, length);
        ListNode l1 = solutionRef2(first);
        ListNode l2 = solutionRef2(second);
        return mergeTwoLists(l1, l2);
    }
    /**
     * This is the helper function for merging two lists.
     * the code is from the merge two lists question.
     * @param list1 the head of the first sorted list.
     * @param list2 the head of the second sorted list.
     * @return the head of merged sorted list.
     */
    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            temp = temp.next;
        }
        while (list1 != null) {
            temp.next = new ListNode(list1.val);
            list1 = list1.next;
            temp = temp.next;
        }
        while (list2 != null) {
            temp.next = new ListNode(list2.val);
            list2 = list2.next;
            temp = temp.next;
        }
        return dummy.next;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 6};
        int[] array3 = {8, 9, 10};
        ListNode test1 = MergeKSortedLists.arrayToList(array1);
        ListNode test2 = MergeKSortedLists.arrayToList(array2);
        ListNode test3 = MergeKSortedLists.arrayToList(array3);
        ListNode[] test = new ListNode[3];
        test[0] = test1;
        test[1] = test2;
        test[2] = test3;
        ListNode result = MergeKSortedLists.solutionRef2(test);
        MergeKSortedLists.printList(result);
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
