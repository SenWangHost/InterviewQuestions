/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can
 * see ordered from top to bottom.
 * For example:
 * Given the following binary tree,
 *     1            <---
 *   /   \
 *  2     3         <---
 *   \     \
 *    5     4       <---
 * You should return [1, 3, 4].
 * @author SenWang
 *
 */
public class BinaryTreeRightSideView {
    /**
     * This is the iterative solution to this question, which uses breadth
     * first search algorithm.
     * @param root the root node of this binary tree.
     * @return an array list of integers for storing the results.
     */
    public static List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean added = false;
            while (size > 0) {
                TreeNode curr = queue.poll();
                size--;
                if (!added) {
                    result.add(curr.val);
                    added = true;
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
            }
        }
        return result;
    }
    /**
     * This is another iterative solution to this question, which uses depth
     * first search algorithm.
     * @param root the root node of this binary tree.
     * @return an array list of integers for storing the results.
     */
    public static List<Integer> solution2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> nodeStack = new ArrayDeque<TreeNode>();
        Deque<Integer> levelStack = new ArrayDeque<Integer>();
        if (root == null) {
            return result;
        }
        nodeStack.push(root);
        levelStack.push(0);
        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            int level = levelStack.pop();
            if (level >= result.size()) {
                result.add(curr.val);
            } else {
                result.set(level, curr.val);
            }
            if (curr.left != null || curr.right != null) {
                level++;
            }
            if (curr.right != null) {
                nodeStack.push(curr.right);
                levelStack.push(level);
            }
            if (curr.left != null) {
                nodeStack.push(curr.left);
                levelStack.push(level);
            }
        }
        return result;
    }
    /**
     * This is the recursive solution to this question.
     * @param root the root node of this binary tree.
     * @return an array list of integers for storing the results.
     */
    public static List<Integer> solution3(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        solutionRec(root, 0, result);
        return result;
    }
    /**
     * This is the recursive helper function to the solution above.
     * @param root the root node of this binray tree.
     * @param list the list storing the results.
     */
    private static void solutionRec(TreeNode root, int level,List<Integer> list) {
        if (root == null) {
            return;
        }
        if (level >= list.size()) {
            list.add(root.val);
        } else {
            list.set(level, root.val);
        }
        solutionRec(root.left, level + 1, list);
        solutionRec(root.right, level + 1, list);
    }
    /**
     * The reference solution has the same idea as mine.
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        // root.right.right = new TreeNode(4);
        List<Integer> result = BinaryTreeRightSideView.solution3(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
