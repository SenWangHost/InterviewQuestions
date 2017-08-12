/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * You need to find the largest value in each row of a binary tree.
 * Example:
 * Input:
 *        1
 *       / \
 *      3   2
 *     / \   \
 *    5   3   9
 * Output: [1, 3, 9]
 * @author SenWang
 *
 */
public class FindLargestValueInEachTreeRow {
    /**
     * This is the iterative solution to this question.
     * @param root the root node of this tree.
     * @return an list of integer containing largest element in each row.
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
            int max = Integer.MIN_VALUE;
            while (size > 0) {
                TreeNode curr = queue.poll();
                size--;
                max = Math.max(max, curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            result.add(max);
        }
        return result;
    }
    /**
     * This is the recursive solution to this question, which uses depth
     * first search algorithm.
     * @param root the root node of this tree.
     * @return a list of integers containing the max value in each row.
     */
    public static List<Integer> solution2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        solutionRec(root, 0, result);
        return result;
    }
    /**
     * This is the recursive helper function to the solution above.
     * @param root the root node of this tree.
     * @param level the level which the current node is at.
     * @param list the list of integers for storing the max in each row.
     */
    private static void solutionRec(TreeNode root, int level, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (level >= list.size()) {
            list.add(root.val);
        } else {
            list.set(level, Math.max(list.get(level), root.val));
        }
        solutionRec(root.left, level + 1, list);
        solutionRec(root.right, level + 1, list);
    }
    /**
     * The reference solutions are the same as the two solutions above.
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
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        List<Integer> result = FindLargestValueInEachTreeRow.solution2(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
