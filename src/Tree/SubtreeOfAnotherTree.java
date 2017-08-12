/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values
 * with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 *
 * Example 2:
 * Given tree s:
 *     3
 *    / \
 *   4   5
 *  / \
 * 1   2
 *    /
 *   0
 * Given tree t:
 *   4
 *  / \
 * 1   2
 * Return false.
 * @author SenWang
 *
 */
public class SubtreeOfAnotherTree {
    /**
     * This is my own solution to this question.
     * @param s the root node of the first tree.
     * @param t the root node of the second tree.
     * @return true if the second tree is a subtree of the first tree.
     */
    public static boolean solution(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s != null && t == null) {
            return false;
        } else if (s == null && t != null) {
            return false;
        } else {
            return sameTree(s, t) || solution(s.left, t) || solution(s.right, t);
        }
    }
    /**
     * This is the recursive helper function to check whether two
     * trees are the same, the same structure and same value.
     * @param first the root node of the first tree.
     * @param second the root node of the second tree.
     * @return true if two trees are the same, false otherwise.
     */
    private static boolean sameTree(TreeNode first, TreeNode second) {
        if (first == null && second == null) {
            return true;
        } else if (first != null && second == null) {
            return false;
        } else if (first == null && second != null) {
            return false;
        } else {
            if (first.val != second.val) {
                return false;
            } else {
                return sameTree(first.left, second.left) && sameTree(first.right, second.right);
            }
        }
    }
    /**
     * This is another solution to this question, which uses breadth first
     * search algorithm to find the node for starting comparison.
     * @param s the root node of the first tree.
     * @param t the root node of the second tree.
     * @return true if the second tree is a subtree of the first tree.
     */
    public static boolean solution2(TreeNode s, TreeNode t) {
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode curr = queue.poll();
                size--;
                if (sameTree(curr, t)) {
                    return true;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return false;
    }
    /**
     * This is one of the reference solution to this question, which converts
     * the two trees into string by preorder traversal and check whether the second
     * string is a substring of the first one.
     * @param s the root node of the first tree.
     * @param t the root node of the second tree.
     * @return true if the second tree is a subtree of the first tree.
     */
    public static boolean solutionRef(TreeNode s, TreeNode t) {
        String sStr = generateStr(s);
        String tStr = generateStr(t);
        return sStr.contains(tStr);
    }
    /**
     * This is the helper function to convert the tree to the string
     * by preorder traversal.
     * @param root the root node of this tree.
     * @return the string converted from the tree.
     */
    private static String generateStr(TreeNode root) {
        StringBuilder result = new StringBuilder("");
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        if (root == null) {
            result.append(", #");
            return result.toString();
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.append(", ");
            result.append(curr.val);
            if (curr.left == null) {
                result.append(", #");
            } else {
                stack.push(curr.left);
            }
            if (curr.right == null) {
                result.append(", #");
            } else {
                stack.push(curr.right);
            }
        }
        return result.toString();
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
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        // s.left.right.left = new TreeNode(0);
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        boolean result = SubtreeOfAnotherTree.solutionRef(s, t);
        System.out.println(result);
    }
}
