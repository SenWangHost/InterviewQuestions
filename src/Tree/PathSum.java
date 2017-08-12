/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all
 * the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *           5
 *          / \
 *         4   8
 *        /   / \
 *       11  13  4
 *      /  \      \
 *     7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author SenWang
 *
 */
public class PathSum {
    /**
     * This is my own solution to this question. This is the acceptable recursive
     * solution.
     * @param root the root node of the tree
     * @param sum the sum of the path
     * @return true such path exists in the tree, false otherwise.
     */
    public static boolean solution(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            return true;
        }
        return solution(root.right, sum - root.val) || solution(root.left, sum - root.val);
    }
    /**
     * This is the iterative solution to this question, which uses
     * depth first search.
     * @param root the root node of the tree
     * @param sum the sum of the path
     * @return true such path exists in the tree, false otherwise.
     */
    public static boolean solution2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> nodeStack = new ArrayDeque<TreeNode>();
        Deque<Integer> valueStack = new ArrayDeque<Integer>();
        nodeStack.push(root);
        valueStack.push(sum);
        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            int value = valueStack.pop();
            if (curr.left == null && curr.right == null && curr.val == value) {
                return true;
            }
            if (curr.right != null) {
                nodeStack.push(curr.right);
                valueStack.push(value - curr.val);
            }
            if (curr.left != null) {
                nodeStack.push(curr.left);
                valueStack.push(value - curr.val);
            }
        }
        return false;
    }
    /**
     * The reference recursive and iterative solution have the same implementation
     * as my two solutions.
     */
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        boolean result = PathSum.solution2(root, 22);
        System.out.println(result);
    }
}
