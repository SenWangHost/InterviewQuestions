/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 * @author SenWang
 *
 */
public class SumRootToLeafNumbers {
    /**
     * This is the iterative solution to this question.
     * @param root the root node of this tree.
     * @return total sum of roof-to-leaf numbers
     */
    public static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> nodeStack = new ArrayDeque<TreeNode>();
        Deque<Integer> numStack = new ArrayDeque<Integer>();
        int sum = 0;
        nodeStack.push(root);
        numStack.push(root.val);
        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            int value = numStack.pop();
            if (curr.left == null && curr.right == null) {
                sum += value;
            }
            if (curr.right != null) {
                nodeStack.push(curr.right);
                numStack.push(value * 10 + curr.right.val);
            }
            if (curr.left != null) {
                nodeStack.push(curr.left);
                numStack.push(value * 10 + curr.left.val);
            }
        }
        return sum;
    }
    /**
     * This is the recursive solution to this question, which also uses
     * depth first search algorithm.
     * @param root the root node of this tree.
     * @return total sum of roof-to-leaf numbers
     */
    public static int solution2(TreeNode root) {
        int[] sum = new int[1];
        solutionRec(root, null, sum);
        return sum[0];
    }
    /**
     * This is the recursive helper function to the solution above.
     * @param root the root node of this tree.
     * @param parent the parent node of the current node.
     * @param array the one-size array for containing the result.
     */
    private static void solutionRec(TreeNode root, TreeNode parent, int[] array) {
        if (root == null) {
            return;
        }
        if (parent != null) {
            root.val += parent.val * 10;
        }
        if (root.left == null && root.right == null) {
            array[0] += root.val;
        }
        solutionRec(root.left, root, array);
        solutionRec(root.right, root, array);
    }
    /**
     * This is one recursive reference solution to this question.
     * @param root the root node of this tree.
     * @return total sum of roof-to-leaf numbers
     */
    public static int solutionRef(TreeNode root) {
        return solutionRefHelper(root, 0);
    }
    /**
     * This the recursive helper function to the solution above.
     * @param root the root node of this tree.
     * @param prev the parent's node's value.
     * @return total sum of roof-to-leaf numbers.
     */
    private static int solutionRefHelper(TreeNode root, int prev) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val + prev * 10;
        }
        return solutionRefHelper(root.left, root.val) + solutionRefHelper(root.right, root.val);
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int result = SumRootToLeafNumbers.solution2(root);
        System.out.println(result);
    }
}
