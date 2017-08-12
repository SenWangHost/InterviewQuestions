/**
 *
 */
package Tree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
 * of every node never differ by more than 1.
 * @author SenWang
 *
 */
public class BalancedBinaryTree {
    /**
     * This is the recursive solution to this question.
     * @param root the root node of this tree.
     * @return true if this tree is balanced, false otherwise.
     */
    public static boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Math.abs(leftDepth - rightDepth) <= 1 && solution(root.left) && solution(root.right);
    }
    /**
     * This is the recursive helper function for calculating
     * the depth of a node.
     * @param node the starting node for calculating the depth.
     * @return the depth starting from this node.
     */
    private static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
    /**
     * This is one recursive reference solution to this question, which is
     * based on depth first search. When the sub tree of the current node (inclusive) is balanced,
     * the function dfsHeight() returns a non-negative value as the height. Otherwise -1 is returned.
     * According to the leftHeight and rightHeight of the two children, the parent node could check if the sub tree
     * is balanced, and decides its return value.
     * @param root the root node of this tree.
     * @return true if this tree is balanced, false otherwise.
     */
    public static boolean solutionRef(TreeNode root) {
        return dfsHeight(root) != -1;
    }
    /**
     * This is the recursive helper function to calculate the height for
     * one specific node. If the tree starting from this node is unbalanced,
     * return -1;
     * @param node one specific in the tree.
     * @return the height starting from this node.
     */
    private static int dfsHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfsHeight(node.left);
        if (left == -1) {
            return -1;
        }
        int right = dfsHeight(node.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
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
        boolean result = BalancedBinaryTree.solution(root);
        System.out.println(result);
    }

}
