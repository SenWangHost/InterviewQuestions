/**
 *
 */
package Tree;

/**
 * Given a binary tree, return the tilt of the whole tree.
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values
 * and the sum of all right subtree node values. Null node has tilt 0.
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 *
 * Example:
 * Input:
 *          1
 *        /   \
 *       2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * Note:
 * 1. The sum of node values in any subtree won't exceed the range of 32-bit integer.
 * 2. All the tilt values won't exceed the range of 32-bit integer.
 * @author SenWang
 *
 */
public class BinaryTreeTilt {
    /**
     * This is recursive solution to this question.
     * @param root the root node of this tree.
     * @return the tilt of this whole tree.
     */
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return tiltOfNode(root) + solution(root.left) + solution(root.right);
    }
    /**
     * This is the helper function to calculate the tile of
     * one node.
     * @param node the node inside the tree.
     * @return the tile of this node.
     */
    private static int tiltOfNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.abs(sumOfNode(node.left) - sumOfNode(node.right));
    }
    /**
     * This is the recursive helper function to calculate
     * sum of all the nodes' values in a tree.
     * @param root the root node of the tree.
     * @return the sum of all nodes' values.
     */
    private static int sumOfNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return root.val + sumOfNode(root.left) + sumOfNode(root.right);
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        int result = BinaryTreeTilt.solution(root);
        System.out.println(result);
    }

}
