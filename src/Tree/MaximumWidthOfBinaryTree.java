/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a binary tree, write a function to get the maximum width of the given tree.
 * The width of a tree is the maximum width among all levels. The binary tree has the same structure
 * as a full binary tree, but some nodes are null.
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most
 * non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:
Input:

           1
         /   \
        3     2
       / \     \
      5   3     9

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:
Input:

          1
         /
        3
       / \
      5   3

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:
Input:

          1
         / \
        3   2
       /
      5

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:
Input:

          1
         / \
        3   2
       /     \
      5       9
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


Note: Answer will in the range of 32-bit signed integer.
 * @author SenWang
 *
 */
public class MaximumWidthOfBinaryTree {
    /**
     * this is my own solution to this question
     */
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxwidth = 1;
        Deque<TreeNode> nodequeue = new ArrayDeque<TreeNode>();
        Deque<Integer> indexqueue = new ArrayDeque<Integer>();
        nodequeue.offer(root);
        indexqueue.offer(0);
        while (!nodequeue.isEmpty()) {
            int size = nodequeue.size();
            int left = 0;
            int right = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = nodequeue.poll();
                int index = indexqueue.poll();
                if (i == 0) {
                    left = index;
                }
                if (i == size - 1) {
                    right = index;
                }
                if (curr.left != null) {
                    nodequeue.offer(curr.left);
                    indexqueue.offer(index * 2);
                }
                if (curr.right != null) {
                    nodequeue.offer(curr.right);
                    indexqueue.offer(index * 2 + 1);
                }
            }
            maxwidth = Math.max(maxwidth, right - left + 1);
        }
        return maxwidth;
    }
    /**
     * this is the reference solution to this question, which is a depth first search algorithm
     */
    public static int solutionRef(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }
    /**
     * this is the helper function for dfs traversal
     */
    private static int dfs(TreeNode root, int level, int index, List<Integer> start, List<Integer> end) {
        if (root == null) {
            return 0;
        }
        if (start.size() == level) {
            start.add(index);
            end.add(index);
        } else {
            end.add(index);
        }
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, index * 2, start, end);
        int right = dfs(root.right, level + 1, index * 2 + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /**
     * This is the definition for the tree node class.
     * @author SenWang
     */
    private static class TreeNode {
        /**
         * The field for storing the integer.
         */
        @SuppressWarnings("unused")
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
}
