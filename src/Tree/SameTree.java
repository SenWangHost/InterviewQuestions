/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * @author SenWang
 *
 */
public class SameTree {
    /**
     * This is my own solution to this question.
     * @param p the root node of the first tree.
     * @param q the root node of the second tree.
     * @return true if the two trees are the same, false otherwise.
     */
    public static boolean solution(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        } else {
            if (p.val != q.val) {
                return false;
            }
            return solution(p.left, q.left) && solution(p.right, q.right);
        }
    }
    /**
     * This is one reference solution for this question, which uses iterative
     * method to do preorder traversal for both of the tree.
     * @param p the root node of the first tree.
     * @param q the root node of the second tree.
     * @return true if the two trees are the same, false otherwise.
     */
    public static boolean solutionRef(TreeNode p, TreeNode q) {
        Deque<TreeNode> stack1 = new ArrayDeque<TreeNode>();
        Deque<TreeNode> stack2 = new ArrayDeque<TreeNode>();
        if (p != null) {
            stack1.push(p);
        }
        if (q != null) {
            stack2.push(q);
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if (node1.val != node2.val) {
                return false;
            }
            if (node1.right != null) {
                stack1.push(node1.right);
            }
            if (node2.right != null) {
                stack2.push(node2.right);
            }
            if (stack1.size() != stack2.size()) {
                return false;
            }
            if (node1.left != null) {
                stack1.push(node1.left);
            }
            if (node2.left != null) {
                stack2.push(node2.left);
            }
            if (stack1.size() != stack2.size()) {
                return false;
            }
        }
        return stack1.size() == stack2.size();
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
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        //root2.right = new TreeNode(2);
        boolean result = SameTree.solution(root1, root2);
        System.out.println(result);
    }

}
