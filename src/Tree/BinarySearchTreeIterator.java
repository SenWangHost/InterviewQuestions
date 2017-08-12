/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * @author SenWang
 *
 */
public class BinarySearchTreeIterator {
    /**
     * This is my own solution to this question. This solution is
     * fast but use O(n) space, which n is the number of nodes in
     * the tree.
     * @author SenWang
     */
    public static class BSTIterator {
        /**
         * The arraylist for storing the pre-order traversal
         * of this tree.
         */
        private List<Integer> list;
        /**
         * The index of current element in the list
         */
        private int index;
        /**
         * The constructor for BST iterator.
         * @param root the root node of this tree.
         */
        public BSTIterator(TreeNode root) {
            list = new ArrayList<Integer>();
            index = 0;
            preOrderTraversal(root, list);
        }
        /**
         * This is the recursive helper function to traverse the binary
         * search tree recursively and store the elements in the list.
         * @param root the root node of this tree.
         * @param list the list for storing the elements.
         */
        private void preOrderTraversal(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            preOrderTraversal(root.left, list);
            list.add(root.val);
            preOrderTraversal(root.right, list);
        }
        /**
         * The method has next for checking whether we have
         * the next smallest element.
         * @return true if we have the next smallest element, false otherwise.
         */
        public boolean hasNext() {
            return index < list.size();
        }
        /**
         * The method next for getting the next smallest element
         * in this tree.
         * @return the next smallest element in this tree.
         */
        public int next() {
            return list.get(index++);
        }
    }
    /**
     * This is another solution to this question, which uses stack
     * to keep track of the smallest element in the tree.
     * @author SenWang
     */
    public static class BSTIterator2 {
        /**
         * This is the stack used to keep track of the smallest
         * element in the binary search tree.
         */
        private Deque<TreeNode> stack;
        /**
         * This is constructor for this solution.
         * @param root the root node of this tree.
         */
        public BSTIterator2(TreeNode root) {
            stack = new ArrayDeque<TreeNode>();
            if (root == null) {
                return;
            }
            TreeNode temp = root;
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
        }
        /**
         * The method has next for checking whether we have
         * the next smallest element.
         * @return true if we have the next smallest element, false otherwise.
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        /**
         * The method next for getting the next smallest element
         * in this tree.
         * @return the next smallest element in this tree.
         */
        public int next() {
            TreeNode smallest = stack.pop();
            TreeNode right = smallest.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
            return smallest.val;
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
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(10);
        BSTIterator2 iter = new BSTIterator2(root);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
