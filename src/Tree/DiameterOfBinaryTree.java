/**
 *
 */
package Tree;


/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *        1
 *       / \
 *      2   3
 *     / \
 *    4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * @author SenWang
 *
 */
public class DiameterOfBinaryTree {
    /**
     * This is my recursive solution to this question. This recursive solution
     * is acceptable but runs slowly and way too much helper function.
     * @param root the root node of this tree.
     * @return the diameter of this tree.
     */
    public static int solution(TreeNode root) {
        int[] max = new int[1];
        solutionRec(root, max);
        return max[0];
    }
    /**
     * This is recursive helper function for solution above.
     * @param root the root node of this tree.
     * @param max the max length of path that needs to be updated.
     */
    private static void solutionRec(TreeNode root, int[] max) {
        if (root == null) {
            return;
        }
        int nodePath = longestPath(root);
        max[0] = Math.max(max[0], nodePath);
        solutionRec(root.left, max);
        solutionRec(root.right, max);
    }
    /**
     * The longest path for one specific node.
     * @param node the input for the specific node.
     * @return the longest for this specific node.
     */
    private static int longestPath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = 0;
        int rightMax = 0;
        if (node.left != null) {
            leftMax = 1 + maxLevel(node.left);
        }
        if (node.right != null) {
            rightMax = 1 + maxLevel(node.right);
        }
        return leftMax + rightMax;
    }
    /**
     * This is the recursive helper function to find the maximum depth
     * of a tree.
     * @param root the root node of the tree.
     * @return the max depth of a tree.
     */
    private static int maxLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int leftLevel = 1 + maxLevel(root.left);
        int rightLevel = 1 + maxLevel(root.right);
        return Math.max(leftLevel, rightLevel);
    }
    /**
     * This is the recursive reference solution to this question.
     * For every node, length of longest path which pass it = MaxDepth of its left subtree + MaxDepth of its right subtree.
     * @param root the root node of this tree.
     * @return the diameter of this tree.
     */
    public static int solutionRef(TreeNode root) {
        int[] max = new int[1];
        maxDepth(root, max);
        return max[0];
    }
    /**
     * This is helper function for calculating the longest path
     * and updating the max.
     * @param root the root node of this tree.
     * @param a one size array holding the maximum.
     */
    private static int maxDepth(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left, max);
        int right = maxDepth(root.right, max);
        max[0] = Math.max(max[0], left + right);
        return Math.max(left, right) + 1;
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
//        System.out.println(maxLevel(root));
        int result = DiameterOfBinaryTree.solutionRef(root);
        System.out.println(result);
    }
}
