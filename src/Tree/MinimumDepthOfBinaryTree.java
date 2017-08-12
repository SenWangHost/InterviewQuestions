/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * @author SenWang
 *
 */
public class MinimumDepthOfBinaryTree {
    /**
     * This is the recursive solution to this question.
     * @param root the root node of this tree.
     * @return the min depth of this tree.
     */
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left != null && root.right == null) {
            return 1 + solution(root.left);
        } else if (root.right != null && root.left == null) {
            return 1 + solution(root.right);
        } else {
            return 1 + Math.min(solution(root.left), solution(root.right));
        }
    }
    /**
     * This is the iterative solution to this question, which uses
     * breadth first search to find the minimum depth of this tree.
     * @param root the root node of this tree.
     * @return the minimum depth of this tree.
     */
    public static int solution2(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        if (root == null) {
            return 0;
        }
        int level = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode curr = queue.poll();
                size--;
                if (curr.left == null && curr.right == null) {
                    return level;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            level++;
        }
        return level;
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
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int result = MinimumDepthOfBinaryTree.solution2(root);
        System.out.println(result);
    }
}
