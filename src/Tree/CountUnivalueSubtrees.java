/**
 *
 */
package Tree;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * For example:
 * Given binary tree,
 *              5
 *             / \
 *            1   5
 *           / \   \
 *          5   5   5
 * return 4.
 * @author SenWang
 *
 */
public class CountUnivalueSubtrees {
    /**
     * this is my own solution to this question.
     */
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isUni(root, root.val)) {
            return 1 + solution(root.left) + solution(root.right);
        } else {
            return solution(root.left) + solution(root.right);
        }
    }
    /**
     * the helper method to check whether it is a univalue tree
     */
    private static boolean isUni(TreeNode root, int value) {
        if (root == null) {
            return true;
        }
        if (root.val != value) {
            return false;
        }
        return isUni(root.left, value) && isUni(root.right, value);
    }
    /**
     * this is my another solution to this question.
     */
    public static int solution2(TreeNode root) {
        int[] count = new int[1];
        helper2(root, count);
        return count[0];
    }
    /**
     * the helper function
     */
    private static boolean helper2(TreeNode root, int[] count) {
        if (root == null) {
            return true;
        }
        boolean left = helper2(root.left, count);
        boolean right = helper2(root.right, count);
        if (left && right) {
            if (root.left != null && root.left.val != root.val) {
                return false;
            }
            if (root.right != null && root.right.val != root.val) {
                return false;
            }
            count[0] += 1;
            return true;
        }
        return false;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(solution2(root));
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
