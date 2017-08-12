/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * @author SenWang
 *
 */
public class BinaryTreePreorderTraversal {
    /**
     * This is my own solution to this question, which uses recursion.
     * @param root the root node of this tree.
     * @return a list of integers representing the preorder traversal.
     */
    public static List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        solutionRec(root, result);
        return result;
    }
    /**
     * This is recursive helper function for the solution above.
     * @param root the root node of the tree.
     * @param a list of integer representing the traversal results.
     */
    private static void solutionRec(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        solutionRec(root.left, list);
        solutionRec(root.right, list);
    }
    /**
     * This is another solution to this question, which uses stack to achieve
     * the preorder traversal.
     * @param root the root node of this tree.
     * @return a list of integers representing the preorder traversal.
     */
    public static List<Integer> solution2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        return result;
    }
    /**
     * The reference solution has the same implementation as mine.
     */
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
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        List<Integer> result = BinaryTreePreorderTraversal.solution2(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
