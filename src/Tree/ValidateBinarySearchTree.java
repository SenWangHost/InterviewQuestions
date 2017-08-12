/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *    2
 *   / \
 *  1   3
 * Binary tree [2,1,3], return true.
 * Example 2:
 *    1
 *   / \
 *  2   3
 * Binary tree [1,2,3], return false.
 * @author SenWang
 *
 */
public class ValidateBinarySearchTree {
    /**
     * This is the iterative solution to this question.
     * @param root the root node of this tree.
     * @return true if this tree is binary search tree, false otherwise.
     */
    public static boolean solution(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        solutionRec(root, result);
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i - 1) >= result.get(i)) {
                return false;
            }
        }
        return true;
    }
    /**
     * This is the recursive helper function to check the binary tree
     * property.
     * @param root the root node of this tree.
     * @param list the list containing the traversal results.
     * @return if this tree is a binary search tree.
     */
    private static void solutionRec(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        solutionRec(root.left, list);
        list.add(root.val);
        solutionRec(root.right, list);
    }
    /**
     * This is the iterative solution to this question, which uses
     * depth first search algorithm to do a pre-order algorithm.
     * @param root the root node of this tree.
     * @return true if this tree is binary search tree, false otherwise.
     */
    public static boolean solution2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null) {
                if (prev.val >= curr.val) {
                    return false;
                }
            }
            prev = curr;
            TreeNode right = curr.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return true;
    }
    /**
     * This is one of recursive iterative solution to this question.
     * Basically what I am doing is recursively iterating over the tree while defining interval
     * <minVal, maxVal> for each node which value must fit in.
     */
    public static boolean solutionRef(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    /**
     * This is recursive helper function for this question.
     * @param root the root node of this tree.
     * @param low the low limit for root's value.
     * @param high the high limit for root's value.
     * @return true if this tree is a BST, false otherwise.
     */
    private static boolean isValidBST(TreeNode root, int low, int high) {
        if (root == null) {
            return true;
        }
        if (root.val >= high || root.val <= low) {
            return false;
        }
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
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
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        boolean result = ValidateBinarySearchTree.solutionRef(root);
        System.out.println(result);
    }
}
