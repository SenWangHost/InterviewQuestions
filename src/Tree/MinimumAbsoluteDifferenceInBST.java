/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary search tree with non-negative values,
 * find the minimum absolute difference between values of any two nodes.
 * Example:
 * Input
 *     1
 *      \
 *       3
 *      /
 *     2
 * Output:
 * 1
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * Note: There are at least two nodes in this BST.
 * @author SenWang
 *
 */
public class MinimumAbsoluteDifferenceInBST {
    /**
     * this is my own solution to this question.
     */
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        int diff = Integer.MAX_VALUE;
        Integer prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            System.out.println(curr.val + " " + diff + " " + prev);
            if (prev != null) {
                diff = Math.min(Math.abs(curr.val - prev), diff);
            }
            prev = curr.val;
            TreeNode right = curr.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return diff;
    }
    /**
     * this is recursive solution to this question.
     */
    public static int solution2(TreeNode root) {
        int[] diff = new int[1];
        diff[0] = Integer.MAX_VALUE;
        helper(root, null, diff);
        return diff[0];
    }
    /**
     * this is the helper function to this solution
     */
    private static void helper(TreeNode root, Integer prev, int[] diff) {
        if (root == null) {
            return;
        }
        helper(root.left, root.val, diff);
        System.out.println(root.val + " " + prev);
        if (prev != null) {
            diff[0] = Math.min(Math.abs(root.val - prev), diff[0]);
        }
        prev = root.val;
        helper(root.right, root.val, diff);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(2236);
        root.right.left = new TreeNode(1277);
        root.right.right = new TreeNode(2776);
        root.right.left.left = new TreeNode(519);
        System.out.println(solution2(root));
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
