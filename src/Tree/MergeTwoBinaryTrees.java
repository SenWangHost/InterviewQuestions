/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node. Otherwise,
 * the NOT null node will be used as the node of new tree.
 *
 * Example 1:
 * Input:
 *     Tree 1                     Tree 2
 *        1                         2
 *       / \                       / \
 *      3   2                     1   3
 *     /                           \   \
 *    5                             4   7
 * Output:
 * Merged tree:
 *       3
 *      / \
 *     4   5
 *    / \   \
 *   5   4   7
 * Note: The merging process must start from the root nodes of both trees.
 * @author SenWang
 *
 */
public class MergeTwoBinaryTrees {
    /**
     * This is recursive solution to this question.
     * @param t1 the root node of the first tree.
     * @param t2 the root node of the second tree.
     * @return the root node of the merged tree.
     */
    public static TreeNode solution(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 != null && t2 == null) {
            return t1;
        } else if (t1 == null && t2 != null) {
            return t2;
        } else {
            TreeNode root = new TreeNode(t1.val + t2.val);
            root.left = solution(t1.left, t2.left);
            root.right = solution(t1.right, t2.right);
            return root;
        }
    }
    /**
     * This is iterative solution to this question. This solution works
     * but the code is extremely complicated and runs slow.
     * @param t1 the root node of the first tree.
     * @param t2 the root node of the second tree.
     * @return the root node of the merged tree.
     */
    public static TreeNode solution2(TreeNode t1, TreeNode t2) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        Stack<TreeNode> resStack = new Stack<TreeNode>();
        stack1.push(t1);
        stack2.push(t2);
        TreeNode root = new TreeNode(0);
        resStack.push(root);
        while (!resStack.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            TreeNode resNode = resStack.pop();
            if (resNode == null) {
                continue;
            }
            if (node1 == null && node2 == null) {
                resNode = null;
                continue;
            }
            int val1, val2;
            if (node1 != null) {
                val1 = node1.val;
                if (node1.left != null) {
                    resNode.left = new TreeNode(0);
                }
                if (node1.right != null) {
                    resNode.right = new TreeNode(0);
                }
                stack1.push(node1.left);
                stack1.push(node1.right);
            } else {
                val1 = 0;
                stack1.push(null);
                stack1.push(null);
            }
            if (node2 != null) {
                val2 = node2.val;
                if (node2.left != null) {
                    resNode.left = new TreeNode(0);
                }
                if (node2.right != null) {
                    resNode.right = new TreeNode(0);
                }
                stack2.push(node2.left);
                stack2.push(node2.right);
            } else {
                val2 = 0;
                stack2.push(null);
                stack2.push(null);
            }
            resNode.val = val1 + val2;
            if (resNode.left != null) {
                resStack.push(resNode.left);
            } else {
                resStack.push(null);
            }
            if (resNode.right != null) {
                resStack.push(resNode.right);
            } else {
                resStack.push(null);
            }
        }
        return root;
    }
    /**
     * This is the reference iterative solution to this question.
     * The detailed explanation is on leetcode.
     * @param t1 the root node of the first tree.
     * @param t2 the root node of the second tree.
     * @return the root node of the merged tree.
     */
    public static TreeNode solutionRef(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        Deque<TreeNode[]> stack = new ArrayDeque <TreeNode[]>();
        stack.push(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[] {t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[] {t[0].right, t[1].right});
            }
        }
        return t1;
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
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);
        TreeNode result = MergeTwoBinaryTrees.solution2(t1, t2);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
        System.out.println(result.left.left.val);
        System.out.println(result.left.right.val);
        System.out.println(result.right.right.val);
    }
}
