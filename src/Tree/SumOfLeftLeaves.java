/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Find the sum of all left leaves in a given binary tree.
 * Example:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * @author SenWang
 *
 */
public class SumOfLeftLeaves {
    /**
     * This is one iterative solution to this question, which uses
     * depth first search algorithm.
     * @param root the root node of this tree.
     * @return the sum of all left leaves in the tree.
     */
    public static int solution(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        int sum = 0;
        if (root == null) {
            return sum;
        }
        TreeNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.right;
        }
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            TreeNode leftNode = curr.left;
            while (leftNode != null) {
                TreeNode rightNode = leftNode.right;
                while (rightNode != null) {
                    stack.push(rightNode);
                    rightNode = rightNode.right;
                }
                if (leftNode.left == null && leftNode.right == null) {
                    sum += leftNode.val;
                }
                leftNode = leftNode.left;
            }
        }
        return sum;
    }
    /**
     * This is another iterative solution to this question, which uses
     * breadth first search algorithm.
     * @param root the root node of this tree.
     * @return the sum of all left leaves in the tree.
     */
    public static int solution2(TreeNode root) {
        int sum = 0;
        if (root == null || root.left == null && root.right == null) {
            return sum;
        }
        Deque<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            while (size > 0) {
                TreeNode curr = nodeQueue.poll();
                size--;
                if (curr.left != null && curr.left.left == null && curr.left.right == null) {
                    sum += curr.left.val;
                }
                if (curr.left != null) {
                    nodeQueue.offer(curr.left);
                }
                if (curr.right != null) {
                    nodeQueue.offer(curr.right);
                }
            }
        }
        return sum;
    }
    /**
     * This is the recursive solution to this question, which also uses
     * depth first search algorithm.
     * @param root the root node of this tree.
     * @return the sum of all left leaves in the tree.
     */
    public static int solution3(TreeNode root) {
        int[] sum = new int[1];
        solutionRec(root, false, sum);
        return sum[0];
    }
    /**
     * This is the recursive helper function to this question.
     * @param root the root node of this tree.
     * @param direction indicate this left node or right node.
     * @param array the one-size array for storing the sum of the node.
     */
    private static void solutionRec(TreeNode root, boolean direction, int[] array) {
        if (root == null) {
            return;
        }
        if (direction && root.left == null && root.right == null) {
            array[0] += root.val;
        }
        solutionRec(root.left, true, array);
        solutionRec(root.right, false, array);
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
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int result = SumOfLeftLeaves.solution2(root);
        System.out.println(result);
    }

}
