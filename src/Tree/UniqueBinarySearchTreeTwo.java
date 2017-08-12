/**
 *
 */
package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below
 *     1         3     3      2      1
 *      \       /     /      / \      \
 *       3     2     1      1   3      2
 *      /     /       \                 \
 *     2     1         2                 3
 * @author SenWang
 *
 */
public class UniqueBinarySearchTreeTwo {
    /**
     * This is my own solution to this question.
     * @param n the input integer number
     * @return a list of root containing all structure unique trees.
     */
    public static List<TreeNode> solutionRef(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return solutionRec(1, n);
    }
    /**
     * This is recursive helper function for this solution above.
     * @param start the start index for the range of roots.
     * @param end the end index for the range of roots.
     * @return a list of root node for containing the results.
     */
    private static List<TreeNode> solutionRec(int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = solutionRec(start, i - 1);
            List<TreeNode> rightSubtrees = solutionRec(i + 1, end);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
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
        @SuppressWarnings("unused")
        private TreeNode left;
        /**
         * The right reference to another tree node.
         */
        @SuppressWarnings("unused")
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

    }

}
