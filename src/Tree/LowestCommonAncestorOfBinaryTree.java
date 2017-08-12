/**
 *
 */
package Tree;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
 * two nodes v and w as the lowest node in T that has both v and w as descendants
 * (where we allow a node to be a descendant of itself).”
 *               _______3______
 *              /              \
 *           ___5__          ___1__
 *          /      \        /      \
 *         6      _2       0       8
 *              /  \
 *             7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes
 * 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * @author SenWang
 *
 */
public class LowestCommonAncestorOfBinaryTree {
    /**
     * This is iterative solution to this question, which uses
     * depth first search to find the path for each input node and
     * compare their paths.
     * @param root the root node of this tree.
     * @param p the first input tree node.
     * @param q the second input tree node.
     * @return the LCA of tree node p and q
     */
    public static TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (inTree(root.left, p) && inTree(root.left, q)) {
            return solution(root.left, p, q);
        }
        if (inTree(root.right, p) && inTree(root.right, q)) {
            return solution(root.right, p, q);
        }
        return root;
    }
    /**
     * This is recursive helper function to check whether a node is in the tree.
     * @param root the root node of this tree.
     * @param target the target to be find.
     * @return true if the target is in the tree, false otherwise.
     */
    private static boolean inTree(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        if (root == target) {
            return true;
        }
        return inTree(root.left, target) || inTree(root.right, target);
    }
    /**
     * This is reference recursive solution to this question.
     * @param root the root node of this tree.
     * @param p the first input tree node.
     * @param q the second input tree node.
     * @return the LCA of tree node p and q
     */
    public static TreeNode solutionRef(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = solutionRef(root.left, p, q);
        TreeNode right = solutionRef(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        } else {
            return right;
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
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
//        TreeNode target = root.left.right.left;
//        List<TreeNode> list = findPath(root, target);
//        for (TreeNode temp : list) {
//            System.out.println(temp.val);
//        }
        TreeNode p = root;
        TreeNode q = root.left;
        TreeNode result = LowestCommonAncestorOfBinaryTree.solution(root, p, q);
        System.out.println(result.val);
    }

}
