/**
 *
 */
package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is
 * not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * @author SenWang
 *
 */
public class ReverseNodesInKGroup {
    /**
     * This is my own solution to this question, which is accpeted but the runtime complexity is slow.
     * @param head the head of linked list to be considered.
     * @param k the number of nodes to be reversed.
     * @return the head of the reversed linked list.
     */
    public static ListNode solution(ListNode head, int k) {
        int length = length(head);
        List<ListNode> list = split(head, k);
//        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            ListNode node = list.get(i);
            if (i != list.size() - 1) {
                list.set(i, reverse(node));
            } else {
                if (length % k == 0) {
                    list.set(i, reverse(node));
                }
            }
        }
        for (ListNode node : list) {
            printList(node);
            System.out.println("---------");
        }
        ListNode result = merge(list);
        return result;
    }
    /**
     * the length of linked list
     */
    private static int length(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count += 1;
        }
        return count;
    }
    /**
     * This is helper functio to split the list into k group
     */
    private static List<ListNode> split(ListNode head, int k) {
        List<ListNode> list = new ArrayList<ListNode>();
        list.add(head);
        int count = 0;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
            count += 1;
            if (count == k) {
                prev.next = null;
                prev = null;
                if (curr != null) {
                    list.add(curr);
                }
                count = 0;
            }
        }
        return list;
    }
    /**
     * the method to merge all splited list
     */
    private static ListNode merge(List<ListNode> list) {
        ListNode head = list.get(0);
        ListNode node = head;
        for (int i = 0; i < list.size(); i++) {
            while (node.next != null) {
                node = node.next;
            }
//            System.out.println(node.val);
//            System.out.println("____");
            if (i + 1 < list.size()) {
                node.next = list.get(i + 1);
                node = node.next;
            }
        }
        return list.get(0);
    }
    /**
     * The the helper function to reverse the linked list.
     * @param head the head of linked list to be considered.
     * @return the head of the reversed linked list.
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
     * this is one of reference solution to this question
     */
    public static ListNode solutionRef(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        // create a dummy head.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode begin = dummy;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reversePart(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
    /**
     * this is the helper function to reverse a part of list given
     * start node and end node.
     */
    private static ListNode reversePart(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode prev = begin;
        ListNode result = curr;
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        result.next = curr;
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {1,2,3,4,5,6};
        ListNode test = arrayToList(arr);
//        List<ListNode> list = split(test, 3);
//        for (ListNode head : list) {
//            printList(head);
//            System.out.println("-----");
//        }
        ListNode result = solutionRef(test, 3);
        printList(result);
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
