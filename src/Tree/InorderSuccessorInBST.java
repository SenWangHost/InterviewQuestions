/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 * @author SenWang
 *
 */
public class InorderSuccessorInBST {
    /**
     * this is my own solution to this question.
     */
    public static TreeNode solution(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        boolean find = false;
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (find) {
                return curr;
            } else {
                if (curr == p) {
                    find = true;
                }
            }
            TreeNode right = curr.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return null;
    }
    /**
     * the iterative reference solution
     */
    public static TreeNode solutionRef(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (root.val > p.val) {
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return succ;
    }
    /**
     * the recursive solution to this question.
     */
    public static TreeNode solutionRef2(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val <= p.val) {
            return solutionRef2(root.right, p);
        } else {
            TreeNode left = solutionRef2(root.left, p);
            if (left == null) {
                return root;
            }
            return left;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        TreeNode result = solution(root, root.right);
        System.out.println(result.val);
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
