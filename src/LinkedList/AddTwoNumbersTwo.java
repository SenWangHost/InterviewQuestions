/**
 *
 */
package LinkedList;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * @author SenWang
 *
 */
public class AddTwoNumbersTwo {
    /**
     * This is my own solution to this question.
     * @param l1 the first singly linked list that represents the first integer.
     * @param l2 the second singly linekd list that represents the second integer.
     * @return the head of the singly linked list that represents the result.
     */
    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode rev1 = reverse(l1);
        ListNode rev2 = reverse(l2);
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int carriage = 0;
        while (rev1 != null || rev2 != null) {
            int digit1 = 0;
            int digit2 = 0;
            if (rev1 != null) {
                digit1 = rev1.val;
                rev1 = rev1.next;
            }
            if (rev2 != null) {
                digit2 = rev2.val;
                rev2 = rev2.next;
            }
            int sum = digit1 + digit2 + carriage;
            carriage = sum / 10;
            curr.val = sum % 10;
            if (rev1 != null || rev2 != null || carriage == 1) {
                curr.next = new ListNode(carriage);
                curr = curr.next;
            }
        }
        return reverse(result);
    }
    /**
     * This is the helper function to reverse the list.
     * @param list the input linked list to be reversed.
     * @return the reversed linked list.
     */
    private static ListNode reverse(ListNode list) {
        ListNode prev = null;
        while (list != null) {
            ListNode temp = list.next;
            list.next = prev;
            prev = list;
            list = temp;
        }
        return prev;
    }
    /**
     * This is reference solution that uses stack to reverse the list, which I
     * think is pretty impressive.
     * @param l1 the first singly linked list that represents the first integer.
     * @param l2 the second singly linekd list that represents the second integer.
     * @return the head of the singly linked list that represents the result.
     */
    public static ListNode solutionRef(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        // put the elements in the stack, the same
        // as reverse when popping them out.
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int carriage = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int digit1 = 0;
            int digit2 = 0;
            if (!stack1.isEmpty()) {
                digit1 = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                digit2 = stack2.pop();
            }
            int sum = digit1 + digit2 + carriage;
            carriage = sum / 10;
            curr.val = sum % 10;
            if (!stack1.isEmpty() || !stack2.isEmpty() || carriage == 1) {
                curr.next = new ListNode(carriage);
                curr = curr.next;
            }
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array1 = {7, 2, 4, 3};
        int[] array2 = {5, 6, 4};
        ListNode test1 = AddTwoNumbersTwo.createList(array1);
        ListNode test2 = AddTwoNumbersTwo.createList(array2);
        ListNode result = AddTwoNumbersTwo.solution(test1, test2);
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
