/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given
 *        1
 *       / \
 *      2   5
 *     / \   \
 *    3   4   6
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 * @author SenWang
 *
 */
public class FlattenBinaryTreeToLinkedList {
    /**
     * This is the iterative solution to this question, the algorithm is based
     * on the depth first search and preorder traversal.
     * @param root the root node of this tree.
     */
    public static void solution(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode prev = null;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev == null) {
                prev = curr;
            } else {
                prev.right = curr;
                prev = prev.right;
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
            curr.left = null;
        }
    }
    /**
     * This is the recursive solution to this question.
     * @param root the root node of this tree.
     */
    public static void solution2(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        solution2(left);
        solution2(right);
        root.right = left;
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = right;
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        FlattenBinaryTreeToLinkedList.solution2(root);
        System.out.println(root.val);
        System.out.println(root.left);
        System.out.println(root.right.val);
        System.out.println(root.right.right.val);
        System.out.println(root.right.right.right.val);
        System.out.println(root.right.right.right.right.val);
        System.out.println(root.right.right.right.right.right.val);
    }

}
