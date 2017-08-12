/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 *
 * Example 1:
 * Input:
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 * Output: [3, 14.5, 11]
 *
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 * @author SenWang
 *
 */
public class AverageOfLevelsInBinaryTree {
    /**
     * This is my own solution to this question, which uses queue to achieve
     * breadth first search in the tree.
     * @param root the root node of the tree.
     * @return an array list contains the average of each level in the tree.
     */
    public static List<Double> solution(TreeNode root) {
        List<Double> result = new ArrayList<Double>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            int div = size;
            while (size > 0) {
                TreeNode curr = queue.poll();
                size--;
                sum += curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            result.add(sum / div);
        }
        return result;
    }
    /**
     * This is the recursive solution of mine.
     * @param root the root node of the tree.
     * @return an array list contains the average of each level in the tree.
     */
    public static List<Double> solution2(TreeNode root) {
        List<Double> result = new ArrayList<Double>();
        List<Integer> count = new ArrayList<Integer>();
        solution2Rec(root, 0, result, count);
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i) / count.get(i));
        }
        return result;
    }
    /**
     * This is the recursive helper function for the above solution.
     * @param root the root node of the tree.
     * @param list an array list to store the average of each level.
     */
    private static void solution2Rec(TreeNode root, int level, List<Double> sum, List<Integer> count) {
        if (root == null) {
            return;
        }
        if (level < sum.size()) {
            sum.set(level, sum.get(level) + root.val);
            count.set(level, count.get(level) + 1);
        } else {
            sum.add((double) root.val);
            count.add(1);
        }
        solution2Rec(root.left, level + 1, sum, count);
        solution2Rec(root.right, level + 1, sum, count);
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
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        List<Double> result = AverageOfLevelsInBinaryTree.solution2(root);
        Iterator<Double> iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
