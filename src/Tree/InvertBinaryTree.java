/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Invert a binary tree.
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * to
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * @author SenWang
 *
 */
public class InvertBinaryTree {
    /**
     * This is the iterative solution to this question.
     * @param root the root node of this tree.
     * @return the root node of the inverted binary search tree.
     */
    public static TreeNode solution(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        if (root == null) {
            return null;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.left != null && curr.right != null) {
                TreeNode temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
                stack.push(curr.left);
                stack.push(curr.right);
            } else if (curr.left != null && curr.right == null) {
                curr.right = curr.left;
                curr.left = null;
                stack.push(curr.right);
            } else if (curr.left == null && curr.right != null) {
                curr.left = curr.right;
                curr.right = null;
                stack.push(curr.left);
            }
        }
        return root;
    }
    /**
     * This is the recursive solution to this question.
     * @param root the root node of this tree.
     * @return the root node of this inverted tree.
     */
    public static TreeNode solution2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = solution(right);
        root.right = solution(left);
        return root;
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
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode result = InvertBinaryTree.solution2(root);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
        System.out.println(result.left.left.val);
        System.out.println(result.left.right.val);
        System.out.println(result.right.left.val);
        System.out.println(result.right.right.val);
    }
}
