/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 * return its level order traversal as:
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 * @author SenWang
 *
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * This is my own solution to this question, which uses typical breadth first search algorithm.
     * @param root the root node of the tree
     * @return a two dimensional list, where each array containing all the node in the list.
     */
    public static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while (size > 0) {
                TreeNode curr = queue.poll();
                size--;
                list.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            result.add(list);
        }
        return result;
    }
    /**
     * This is another solution, which uses recursion and depth first search method.
     * @param root the root node of the tree
     * @return a two dimensional list, where each array containing all the node in the list.
     */
    public static List<List<Integer>> solution2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        solution2Rec(root, 0, result);
        return result;
    }
    /**
     * This is the helper function for depth first search solution above.
     * @param root the root node of the tree.
     * @param level the level the current node is at.
     * @param list the two dimensional list for storing the results.
     */
    private static void solution2Rec(TreeNode root, int level, List<List<Integer>> list) {
        if (root == null) {
            return;
        }
        if (level >= list.size()) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(root.val);
            list.add(temp);

        } else {
            List<Integer> temp = list.get(level);
            temp.add(root.val);
        }
        solution2Rec(root.left, level + 1, list);
        solution2Rec(root.right, level + 1, list);
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = BinaryTreeLevelOrderTraversal.solution2(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.print("[");
            List<Integer> list = result.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + ", ");
            }
            System.out.print("]");
            System.out.println("");
        }
    }
}
