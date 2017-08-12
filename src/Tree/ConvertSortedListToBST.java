/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author SenWang
 *
 */
public class ConvertSortedListToBST {
    /**
     * This is the recursive solution to this question.
     * @param head the head of the singly linked list.
     * @return the root node of the tree that is converted from the linked list.
     */
    public static TreeNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = solution(head);
        root.right = solution(slow.next);
        return root;
    }
    /**
     * This is the iterative solution to this question.
     * @param head the head of the singly linked list.
     * @return the root node of the tree that is converted from the linked list.
     */
    public static TreeNode solution2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        TreeNode result = new TreeNode(0);
        Deque<TreeNode> treeStack = new ArrayDeque<TreeNode>();
        treeStack.push(result);
        Deque<ListNode> listStack = new ArrayDeque<ListNode>();
        listStack.push(head);
        while (!treeStack.isEmpty()) {
            TreeNode curr = treeStack.pop();
            ListNode list = listStack.pop();
            // split the list
            ListNode prev = list;
            ListNode slow = list;
            ListNode fast = list;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            prev.next = null;
            // assign the mid value to the current node
            curr.val = slow.val;
            if (list != null) {
                if (list.next == null) {
                    curr.left = new TreeNode(list.val);
                } else {
                    curr.left = new TreeNode(0);
                    treeStack.push(curr.left);
                    listStack.push(list);
                }
            }
            if (slow.next != null) {
                if (slow.next.next == null) {
                    curr.right = new TreeNode(slow.next.val);
                } else {
                    curr.right = new TreeNode(0);
                    treeStack.push(curr.right);
                    listStack.push(slow.next);
                }
            }
        }
        return result;
    }
    /**
     * The helper function to transform a array of integers into linked list.
     * @param arr the array to be transformed.
     * @return the linked list representing the array.
     */
    private static ListNode arrayToList(int[] arr) {
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
    private static class ListNode {
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
    /**
     * This is the definition for the tree node class.
     * @author SenWang
     */
    private static class TreeNode {
        /**
         * The field for storing the integer.
         */
        private int val;
        /**
         * The left reference to another tree node.
         */
        private TreeNode left;
        /**
         * The right reference to another tree node.
         */
        private TreeNode right;
        /**
         * The constructor for the tree node
         * @param x the integer value to be stored into the tree node.
         */
        private TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {0, 1, 2, 3, 4, 5};
        ListNode list = arrayToList(array);
        TreeNode result = ConvertSortedListToBST.solution2(list);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
        System.out.println(result.left.left.val);
        System.out.println(result.left.right.val);
        System.out.println(result.right.left.val);
    }
}
