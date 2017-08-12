/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is
 * changed to the original key plus sum of all keys greater than the original key in BST.
 * Example:
 * Input: The root of a Binary Search Tree like this:
 *            5
 *          /   \
 *         2     13
 * Output: The root of a Greater Tree like this:
 *            18
 *          /    \
 *        20     13
 * @author SenWang
 *
 */
public class ConvertBSTToGreaterTree {
    /**
     * This is recursive solution to this question, which first
     * do a two in-order traversal to the tree.
     * @param root the root node of this tree.
     * @return the root node of the tree after conversion.
     */
    public static TreeNode solution(TreeNode root) {
        int sum = sumOfTree(root);
        // do a in-order traversal to change the node's value.
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        if (root == null) {
            return null;
        }
        TreeNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        int accum = 0;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            int val = curr.val;
            curr.val = sum - accum;
            accum += val;
            TreeNode right = curr.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return root;
    }
    /**
     * This is recursive helper function to calculate the sum
     * of tree.
     * @param root the root node of this tree.
     * @return sum of all nodes'values in the tree.
     */
    private static int sumOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sumOfTree(root.left) + sumOfTree(root.right);
    }
    /**
     * This is another iterative solution to this question, which does
     * a reverse in-order traversal.
     * @param root the root node of this tree.
     * @return the root node of the tree after conversion.
     */
    public static TreeNode solution2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        if (root == null) {
            return null;
        }
        TreeNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.right;
        }
        int accum = 0;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            int val = curr.val;
            curr.val += accum;
            accum += val;
            TreeNode left = curr.left;
            while (left != null) {
                stack.push(left);
                left = left.right;
            }
        }
        return root;
    }
    /**
     * This is the recursive solution to this question, which does
     * reverse in-order traversal.
     * @param root the root node of this tree.
     * @return the root node of this tree after conversion.
     */
    public static TreeNode solution3(TreeNode root) {
        int[] sum = new int[1];
        solutionRec(root, sum);
        return root;
    }
    /**
     * This is the recursive helper function to do reverse in-order
     * traversal.
     * @param root the root node of this tree.
     * @param the one-size integer array for updating the sum.
     */
    private static void solutionRec(TreeNode root, int[] update) {
        if (root == null) {
            return;
        }
        solutionRec(root.right, update);
        root.val += update[0];
        update[0] = root.val;
        solutionRec(root.left, update);
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
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        TreeNode result = ConvertBSTToGreaterTree.solution3(root);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
    }
}
