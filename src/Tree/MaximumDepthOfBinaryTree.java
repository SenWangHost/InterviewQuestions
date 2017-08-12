/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * @author SenWang
 *
 */
public class MaximumDepthOfBinaryTree {
    /**
     * This is my own solution to this question, which uses recursion.
     * @param root the root node of the binary tree.
     * @return the max depth of the binary tree
     */
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = 1 + solution(root.left);
        int rightDepth = 1 + solution(root.right);
        return Math.max(leftDepth, rightDepth);
    }
    /**
     * This is the iterative solution for this question, which uses
     * deep first search algorithm.
     * @param root the root node of the binary tree.
     * @return the max depth of the binary tree.
     */
    public static int solutionRef(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> nodeStack = new ArrayDeque<TreeNode>();
        Deque<Integer> valueStack = new ArrayDeque<Integer>();
        nodeStack.push(root);
        valueStack.push(1);
        int result = 0;
        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            int temp = valueStack.pop();
            result = Math.max(result, temp);
            if (curr.left != null) {
                nodeStack.push(curr.left);
                valueStack.push(temp + 1);
            }
            if (curr.right != null) {
                nodeStack.push(curr.right);
                valueStack.push(temp + 1);
            }
        }
        return result;
    }
    /**
     * This is another solution which uses bread first search algorithm.
     * @param root the root node of the binary tree.
     * @return the max depth of the binary tree.
     */
    public static int solutionRef2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode temp = queue.poll();
                size--;
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            level++;
        }
        return level;
    }
    /**
     * This is the definition for the tree node class.
     * @author SenWang
     */
    private static class TreeNode {
        /**
         * The field for storing the integer.
         */
        @SuppressWarnings("unused")
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
        int result = MaximumDepthOfBinaryTree.solutionRef2(root);
        System.out.println(result);
    }

}
