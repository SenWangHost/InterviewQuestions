/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * Example 1:
 * Input:
 *     2
 *    / \
 *   1   3
 * Output:
 * 1
 * Example 2:
 * Input:
 *      1
 *     / \
 *    2   3
 *   /   / \
 *  4   5   6
 * /
 * 7
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 * @author SenWang
 *
 */
public class FindBottomLeftTreeValue {
    /**
     * This is the iterative solution to this question, which
     * uses breadth first search algorithm.
     * @param root the root node of this tree.
     * @return the leftmost value in the last row of the tree.
     */
    public static int solution(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode curr = queue.poll();
                size--;
                if (size == 0 && curr.left == null && curr.right == null) {
                    result = curr.val;
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
            }
        }
        return result;
    }
    /**
     * This is another iterative solution, which uses depth first search algorithm.
     * @param root the root node of this tree.
     * @return the leftmost value in the last row of the tree.
     */
    public static int solution2(TreeNode root) {
        Deque<TreeNode> nodeStack = new ArrayDeque<TreeNode>();
        Deque<Integer> levelStack = new ArrayDeque<Integer>();
        nodeStack.push(root);
        levelStack.push(0);
        int result = 0;
        int level = 0;
        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            int depth = levelStack.pop();
            if (curr.left == null && curr.right == null && depth >= level) {
                result = curr.val;
                level = depth;
            }
            if (curr.left != null) {
                nodeStack.push(curr.left);
                levelStack.push(depth + 1);
            }
            if (curr.right != null) {
                nodeStack.push(curr.right);
                levelStack.push(depth + 1);
            }
        }
        return result;
    }
    /**
     * This is the recursive solution to this question, which also uses
     * depth first search algorithm.
     * The recusive solution's efficiency is always higher than iterative
     * solution on leetcode.
     * @param root the root node of this tree.
     * @return the leftmost value in the last row of the tree.
     */
    public static int solution3(TreeNode root) {
        int[] result = new int[2];
        solutionRec(root, 0, result);
        return result[0];
    }
    /**
     * This is the recursive helper function for the solution above.
     * @param root the root node of this tree.
     * @param level the current level at which current node is.
     * @param array the two size array containing the leftmost value and its depth.
     */
    private static void solutionRec(TreeNode root, int level, int[] array) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && level >= array[1]) {
            array[0] = root.val;
            array[1] = level;
            return;
        }
        solutionRec(root.right, level + 1, array);
        solutionRec(root.left, level + 1, array);
    }
    /**
     * This is one reference solution for the breadth first search algorithm.
     * Doing BFS right-to-left means we can simply return the last node's value and don't have to keep track of
     * the first node in the current row or even care about rows at all.
     * @param root the root node of this tree.
     * @return the leftmost value in the last row of the tree.
     */
    public static int solutionRef(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) {
                queue.offer(root.right);
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
        }
        return root.val;
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        int result = FindBottomLeftTreeValue.solutionRef(root);
        System.out.println(result);
    }

}
