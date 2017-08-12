/**
 *
 */
package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two
 * nodes v and w as the lowest node in T that has both v and w as descendants
 * (where we allow a node to be a descendant of itself).”
 *              _______6______
 *             /              \
 *          ___2__          ___8__
 *         /      \        /      \
 *        0      _4_      7        9
 *              /   \
 *             3     5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
 * Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself
 * according to the LCA definition.
 * @author SenWang
 *
 */
public class LowestCommonAncestorOfBST {
    /**
     * This is the iterative solution to this question, which
     * uses depth first search algorithm.
     * @param root the root node of this tree.
     * @param p the first input tree node.
     * @param q the second input tree node.
     * @return the LCA of tree node p and q
     */
    public static TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        List<TreeNode> pPath = new ArrayList<TreeNode>();
        List<TreeNode> qPath = new ArrayList<TreeNode>();
        findPath(root, p, pPath);
        findPath(root, q, qPath);
        int max = -1;
        int index = 0;
        int length = Math.min(pPath.size(), qPath.size());
        while (index < length) {
            if (pPath.get(index).val == qPath.get(index).val) {
                max = Math.max(max, index);
            }
            index++;
        }
        return pPath.get(max);
    }
    /**
     * This is the recursive helper function to find the path from root
     * to input node.
     * @param root the root node of this tree.
     * @param target the target node for reaching.
     * @param list the list for containing the path.
     */
    private static void findPath(TreeNode root, TreeNode target, List<TreeNode> list) {
        if (root == null || target == null) {
            return;
        }
        if (root.val == target.val) {
            list.add(root);
            return;
        } else if (root.val > target.val) {
            list.add(root);
            findPath(root.left, target, list);
        } else {
            list.add(root);
            findPath(root.right, target, list);
        }
    }
    /**
     * This is the recursive solution to this question, which
     * is based on the idea of depth first search.
     * @param root the root node of this tree.
     * @param p the first input tree node.
     * @param q the second input tree node.
     * @return the LCA of tree node p and q
     */
    public static TreeNode solution2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p.val < root.val && root.val < q.val) {
            return root;
        }
        if (q.val < root.val && root.val < p.val) {
            return root;
        }
        if (p.val == root.val) {
            return p;
        }
        if (q.val == root.val) {
            return q;
        }
        if (p.val < root.val && q.val < root.val) {
            return solution2(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return solution2(root.right, p, q);
        }
        return null;
    }
    /**
     * This is a clear version of the recursive solution based on the reference solution.
     * @param root the root node of this tree.
     * @param p the first input tree node.
     * @param q the second input tree node.
     * @return the LCA of tree node p and q
     */
    public static TreeNode solutionRef1(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return solutionRef1(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return solutionRef1(root.right, p, q);
        } else {
            return root;
        }
    }
    /**
     * This is one concise and short iterative reference solution to this question.
     * @param root the root node of this tree.
     * @param p the first input tree node.
     * @param q the second input tree node.
     * @return the LCA of tree node p and q
     */
    public static TreeNode solutionRef2(TreeNode root, TreeNode p, TreeNode q) {
        // both q and p is larger or smaller than the root's value.
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            if (p.val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
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
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
//        TreeNode target = root.right.left;
//        List<TreeNode> list = new ArrayList<TreeNode>();
//        findPath(root, target, list);
//        for (TreeNode temp : list) {
//            System.out.println(temp.val);
//        }
        TreeNode p = root.left.right.left;
        TreeNode q = root.left.right.right;
        TreeNode result = LowestCommonAncestorOfBST.solutionRef2(root, p, q);
        System.out.println(result.val);
    }
}
