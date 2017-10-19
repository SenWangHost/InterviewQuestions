/**
 *
 */
package Tree;

/**
 * Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.
 * Especially, this path can be either increasing or decreasing. For example, [1,2,3,4] and [4,3,2,1]
 * are both considered valid, but the path [1,2,4,3] is not valid.
 * On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.
 * Example 1:
 * Input:
 *       1
 *      / \
 *     2   3
 * Output: 2
 * Explanation: The longest consecutive path is [1, 2] or [2, 1].
 * Example 2:
 * Input:
 *      2
 *     / \
 *    1   3
 * Output: 3
 * Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].
 * Note: All the values of tree nodes are in the range of [-1e7, 1e7].
 * @author SenWang
 *
 */
public class BinaryTreeLongestConsecutiveSequenceTwo {
    /**
     * this is the reference solution to this question.
     */
    public static int solutionRef(TreeNode root) {
        int[] max = new int[1];
        longestPath(root, max);
        return max[0];
    }
    /**
     * the helper function to the reference solution
     */
    private static int[] longestPath(TreeNode root, int[] result) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int inc = 1;
        int drc = 1;
        if (root.left != null) {
            int[] left = longestPath(root.left, result);
            if (root.val == root.left.val + 1) {
                drc = left[1] + 1;
            } else if (root.val == root.left.val - 1) {
                inc = left[0] + 1;
            }
        }
        if (root.right != null) {
            int[] right = longestPath(root.right, result);
            if (root.val == root.right.val + 1) {
                drc = Math.max(drc, right[1] + 1);
            } else if (root.val == root.right.val - 1) {
                inc = Math.max(inc, right[0] + 1);
            }
        }
        result[0] = Math.max(result[0], inc + drc - 1);
        return new int[] {inc, drc};
    }
    /**
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
