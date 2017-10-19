/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the
 * parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 * For example,
 *       1
 *        \
 *         3
 *        / \
 *       2   4
 *        \
 *         5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 *         2
 *          \
 *           3
 *          /
 *         2
 *        /
 *       1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 * @author SenWang
 *
 */
public class BinaryTreeLongestConsecutiveSequence {
    /**
     * this is my own solution to this question.
     */
    public static int solution(TreeNode root) {
        int[] max = new int[1];
        max[0] = 1;
        traverse(root, max);
        return max[0];
    }
    /**
     * the helper method to traverse
     */
    private static void traverse(TreeNode root, int[] max) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        max[0] = Math.max(max[0], helper(root));
        traverse(root.left, max);
        traverse(root.right, max);
    }
    /**
     * the longest path starting from one node
     */
    private static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftResult = 1;
        if (root.left != null && root.left.val - root.val == 1) {
            leftResult = 1 + helper(root.left);
        }
        int rightResult = 1;
        if (root.right != null && root.right.val - root.val == 1) {
            rightResult = 1 + helper(root.right);
        }
        return Math.max(leftResult, rightResult);
    }
    /**
     * this is iterative solution to this question.
     */
    public static int solutionRef2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 1;
        Deque<TreeNode> nodestack = new ArrayDeque<TreeNode>();
        Deque<Integer> lenstack = new ArrayDeque<Integer>();
        nodestack.push(root);
        lenstack.push(1);
        while (!nodestack.isEmpty()) {
            TreeNode node = nodestack.pop();
            int length = lenstack.pop();
            result = Math.max(result, length);
            if (node.right != null) {
                nodestack.push(node.right);
                if (node.right.val == node.val + 1) {
                    lenstack.push(length + 1);
                } else {
                    lenstack.push(1);
                }
            }
            if (node.left != null) {
                nodestack.push(node.left);
                if (node.left.val == node.val + 1) {
                    lenstack.push(length + 1);
                } else {
                    lenstack.push(1);
                }
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
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(helper(root.right.right));
        System.out.println(solutionRef2(root));
    }
    /**
     * this is the reference solution to this question.
     */
    public static int solutionRef(TreeNode root) {
        int[] max = new int[1];
        helperRef(root, 0, root.val, max);
        return max[0];
    }
    /**
     * the helper function for the reference solution
     */
    private static void helperRef(TreeNode root, int curr, int target, int[] max) {
        if (root == null) {
            return;
        }
        if (root.val == target) {
            curr++;
        } else {
            curr = 1;
        }
        max[0] = Math.max(max[0], curr);
        helperRef(root.left, curr, root.val + 1, max);
        helperRef(root.right, curr, root.val + 1, max);
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
}
