/**
 *
 */
package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves,
 * repeat until the tree is empty.
 *
 * Example:
 * Given binary tree
 *          1
 *         / \
 *        2   3
 *       / \
 *      4   5
 * Returns [4, 5, 3], [2], [1].
 * Explanation:
 * 1. Removing the leaves [4, 5, 3] would result in this tree:
 *          1
 *         /
 *        2
 * 2. Now removing the leaf [2] would result in this tree:
 *          1
 * 3. Now removing the leaf [1] would result in the empty tree:
 *          []
 * Returns [4, 5, 3], [2], [1].
 * @author SenWang
 *
 */
public class FindLeavesOfBinaryTree {
    /**
     * this is my own solution to this question.
     */
    public static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        height(root, result);
        return result;
    }
    /**
     * the helper function
     */
    private static int height(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return -1;
        }
        int level = 1 + Math.max(height(root.left, result), height(root.right, result));
        if (level >= result.size()) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        root.left = null;
        root.right = null;
        return level;
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
        root.left.right = new TreeNode(5);
        List<List<Integer>> result = solution(root);
        for (List<Integer> list : result) {
            System.out.println(list);
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
}
