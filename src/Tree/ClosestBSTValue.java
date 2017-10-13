/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * @author SenWang
 *
 */
public class ClosestBSTValue {
    /**
     * this is my own solution to this question.
     */
    public static int solution(TreeNode root, double target) {
        int result = Integer.MIN_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.val < target) {
                result = curr.val;
            } else {
                if (curr.val - target < target - result) {
                    result = curr.val;
                }
                return result;
            }
            TreeNode right = curr.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return result;
    }
    /**
     * this is the recursive solution to this question.
     */
    public static int solution2(TreeNode root, double target) {
        int result = root.val;
        TreeNode sub = null;
        if (target < result) {
            sub = root.left;
        } else {
            sub = root.right;
        }
        if (sub == null) {
            return result;
        }
        int result2 = solution2(sub, target);
        if (Math.abs(result - target) < Math.abs(result2 - target)) {
            return result;
        } else {
            return result2;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(solution2(root, 4.4));
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
