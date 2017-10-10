/**
 *
 */
package Tree;

/**
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that
 * all its elements lies in [L, R] (R >= L). You might need to change the root of the tree,
 * so the result should return the new root of the trimmed binary search tree.
 *
 * Example 1:
 * Input:
 *      1
 *     / \
 *    0   2
 * L = 1
 * R = 2
 * Output:
 *    1
 *     \
 *      2
 * Example 2:
 * Input:
 *    3
 *   / \
 *  0   4
 *   \
 *    2
 *   /
 *  1
 *  L = 1
 *  R = 3
 *  Output:
 *      3
 *     /
 *    2
 *   /
 *  1
 * @author SenWang
 *
 */
public class TrimABST {
    /**
     * this is my own solution to this question.
     */
    public static TreeNode solution(TreeNode root, int L, int R) {
        TreeNode newRoot = null;
        newRoot = helper(root, newRoot, L, R);
        return newRoot;
    }
    /**
     * helper function
     */
    private static TreeNode helper(TreeNode root, TreeNode newRoot, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val >= L && root.val <= R) {
            newRoot = new TreeNode(root.val);
            newRoot.left = helper(root.left, newRoot.left, L, R);
            newRoot.right = helper(root.right, newRoot.right, L, R);
            return newRoot;
        }
        newRoot = helper(root.left, newRoot, L, R);
        if (newRoot != null) {
            return newRoot;
        }
        newRoot = helper(root.right, newRoot, L, R);
        return newRoot;
    }
    /**
     * this is the reference solution to this question
     */
    public static TreeNode solutionRef(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val < L) {
            return solutionRef(root.right, L, R);
        }
        if (root.val > R) {
            return solutionRef(root.left, L, R);
        }
        root.left = solutionRef(root.left, L, R);
        root.right = solutionRef(root.right, L, R);
        return root;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

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
