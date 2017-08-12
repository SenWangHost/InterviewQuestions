/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 *      1
 *    /   \
 *   2     3
 *    \
 *     5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * @author SenWang
 *
 */
public class BinaryTreePath {
    /**
     * This is my own solution to this question. This is the iterative solution
     * using depth first search algorithm.
     * This is recursive solution to this question.
     * @param root the root node of this tree.
     * @return a list containing the string representations of all root-to-leaf paths.
     */
    public static List<String> solution(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> nodeStack = new ArrayDeque<TreeNode>();
        Deque<StringBuilder> strStack = new ArrayDeque<StringBuilder>();
        nodeStack.push(root);
        strStack.push(new StringBuilder("").append(root.val));
        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            StringBuilder currStr = strStack.pop();
            if (curr.right != null) {
                nodeStack.push(curr.right);
                StringBuilder right = new StringBuilder(currStr);
                right.append("->");
                right.append(curr.right.val);
                strStack.push(right);
            }
            if (curr.left != null) {
                nodeStack.push(curr.left);
                StringBuilder left = new StringBuilder(currStr);
                left.append("->");
                left.append(curr.left.val);
                strStack.push(left);
            }
            if (curr.left == null && curr.right == null) {
                result.add(currStr.toString());
            }
        }
        return result;
    }
    /**
     * This is another solution to this question, which uses breadth first search
     * algorithm to solve this problem.
     * @param root the root node of this tree.
     * @return a list containing the string representations of all root-to-leaf paths.
     */
    public static List<String> solution2(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
        Deque<StringBuilder> strQueue = new ArrayDeque<StringBuilder>();
        nodeQueue.offer(root);
        strQueue.offer(new StringBuilder("").append(root.val));
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            while (size > 0) {
                TreeNode curr = nodeQueue.poll();
                StringBuilder currStr = strQueue.poll();
                size--;
                if (curr.left != null) {
                    nodeQueue.offer(curr.left);
                    StringBuilder left = new StringBuilder(currStr);
                    left.append("->");
                    left.append(curr.left.val);
                    strQueue.offer(left);
                }
                if (curr.right != null) {
                    nodeQueue.offer(curr.right);
                    StringBuilder right = new StringBuilder(currStr);
                    right.append("->");
                    right.append(curr.right.val);
                    strQueue.offer(right);
                }
                if (curr.left == null && curr.right == null) {
                    result.add(currStr.toString());
                }
            }
        }
        return result;
    }
    /**
     * This is the recursive solution to this question, which is same as
     * using depth first search algorithm.
     * @param root the root node of this tree.
     * @return a list containing the string representations of all root-to-leaf paths.
     */
    public static List<String> solution3(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        StringBuilder path = new StringBuilder("").append(root.val);
        solution3Rec(root, path, result);
        return result;
    }
    /**
     * This is the recursive helper function for the solution above.
     * @param root the root node of this tree.
     * @param list the list of string containing all the root-to-leaf paths.
     */
    private static void solution3Rec(TreeNode root, StringBuilder str, List<String> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(str.toString());
            return;
        }
        if (root.left != null) {
            StringBuilder left = new StringBuilder(str);
            left.append("->");
            left.append(root.left.val);
            solution3Rec(root.left, left ,list);
        }
        if (root.right != null) {
            StringBuilder right = new StringBuilder(str);
            right.append("->");
            right.append(root.right.val);
            solution3Rec(root.right, right, list);
        }
    }
    /**
     * The above three solutions include all the reference solutions.
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
        List<String> result = BinaryTreePath.solution3(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
