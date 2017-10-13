/**
 *
 */
package Tree;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling
 * (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree
 * where the original right nodes turned into left leaf nodes. Return the new root.
 *
 * For example:
 * Given a binary tree {1,2,3,4,5},
 *        1
 *       / \
 *      2   3
 *     / \
 *    4   5
 * return the root of the binary tree [4,5,2,#,#,3,1].
 *        4
 *       / \
 *      5   2
 *     / \
 *    3   1
 * @author SenWang
 *
 */
public class BinaryTreeUpsideDown {
    /**
     * this is iterative reference solution to this question.
     */
    public static TreeNode solution(TreeNode root) {
        TreeNode curr = root;
        TreeNode next = null;
        TreeNode temp = null;
        TreeNode prev = null;

        while(curr != null) {
            next = curr.left;

            // swapping nodes now, need temp to keep the previous right child
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
    /**
     * this is the recursive solution solution to this question.
     */
    public static TreeNode solution2(TreeNode root) {
        if(root == null || root.left == null) {
            return root;
        }

        TreeNode newRoot = solution2(root.left);
        root.left.left = root.right;   // node 2 left children
        root.left.right = root;         // node 2 right children
        root.left = null;
        root.right = null;
        return newRoot;
    }
    /**
     * This is the test function to this question.
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
}
