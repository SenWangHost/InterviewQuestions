/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the
 * BST such that their sum is equal to the given target.
 * Example 1:
 * Input:
 *      5
 *     / \
 *    3   6
 *   / \   \
 *  2   4   7
 * Target = 9
 *
 * Output: True
 * Example 2:
 * Input:
 *      5
 *     / \
 *    3   6
 *   / \   \
 *  2   4   7
 * Target = 28
 * Output: False
 * @author SenWang
 *
 */
public class TwoSumFourInputIsBST {
    /**
     * this is my own solution to this question, which uses a hash set
     */
    public static boolean solution(TreeNode root, int k) {
        Set<Integer> set = new HashSet<Integer>();
        Queue<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.add(root);
        while (stack.size() > 0) {
            TreeNode node = stack.poll();
            if (set.contains(k - node.val)) {
                return true;
            } else {
                set.add(node.val);
            }
            if (node.left != null) {
                stack.offer(node.left);
            }
            if (node.right != null) {
                stack.offer(node.right);
            }
        }
        return false;
    }
    /**
     * this is recursive verison of my solution
     */
    public static boolean solution2(TreeNode root, int k) {
        Set<Integer> set = new HashSet<Integer>();
        return solution2Helper(set, root, k);
    }
    /**
     * this is the helper function to solution
     */
    private static boolean solution2Helper(Set<Integer> set, TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        } else {
            set.add(root.val);
        }
        return solution2Helper(set, root.left, k) || solution2Helper(set, root.right, k);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        System.out.println(solution2(root, 8));
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
