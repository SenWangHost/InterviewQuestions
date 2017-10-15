/**
 *
 */
package Tree;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
 * where largest means subtree with largest number of nodes in it.
 * Note:
 * A subtree must include all of its descendants.
 * Here's an example:
 *         10
 *         / \
 *        5  15
 *       / \   \
 *      1   8   7
 * The Largest BST Subtree in this case is the highlighted one.
 * The return value is the subtree's size, which is 3.
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 * @author SenWang
 *
 */
public class LargestBSTSubtree {
    /**
     * this is my own solution to this question.
     */
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (isBST(root, null, null)) {
            return countNodes(root);
        }
        return Math.max(solution(root.left), solution(root.right));

    }
    /**
     * the helper function to determine whether its is the bst
     */
    private static boolean isBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
    /**
     * the helper function to count the nodes
     */
    private static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    /**
     * this is the reference solution to this question, which actually combine those two
     * helper funcitons into one by using three element array.
     */
    public static int solutionRef(TreeNode root) {
        int[] result = new int[1];
        helper(root, result);
        return result[0];
    }
    /**
     * the helper function which counts and determine whether it is bst at the same time.
     */
    private static int[] helper(TreeNode root, int[] result) {
        // return 3-element array:
        // # of nodes in the subtree, leftmost value, rightmost value
        // # of nodes in the subtree will be -1 if it is not a BST
        int[] array = new int[3];
        if (root == null) {
            return array;
        }
        int[] leftArr = helper(root.left, result);
        int[] rightArr = helper(root.right, result);
        if (((leftArr[0] == 0) || (leftArr[0] > 0 && leftArr[2] < root.val)) &&
                ((rightArr[0] == 0) || (rightArr[0] > 0 && rightArr[1] > root.val))) {
            int size = 1 + leftArr[0] + rightArr[0];
            result[0] = Math.max(result[0], size);
            int leftBoundary = leftArr[0] == 0 ? root.val : leftArr[1];
            int rightBoundary = rightArr[0] == 0 ? root.val : rightArr[2];
            array[0] = size;
            array[1] = leftBoundary;
            array[2] = rightBoundary;

        } else {
            array[0] = -1;
        }
        return array;
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
