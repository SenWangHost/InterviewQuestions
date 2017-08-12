/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree [1,null,2,3],
 *   1
 *    \
 *     2
 *    /
 *   3
 * return [1,3,2].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * @author SenWang
 *
 */
public class BinaryTreeInoderTraversal {
    /**
     * This is recursive solution to this question.
     * @param root the root node of this tree.
     * @return a list containing the in order traversal results.
     */
    public static List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        solutionRec(root, result);
        return result;
    }
    /**
     * This is the recursive helper function for the solution above.
     * @param root the root node of this tree.
     * @param list the list containing the traversal results.
     */
    private static void solutionRec(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        solutionRec(root.left, list);
        list.add(root.val);
        solutionRec(root.right, list);
    }
    /**
     * This is the iterative solution that uses stack to achieve it.
     * @param root the root node of this tree.
     * @return a list containing the in order traversal results.
     */
    public static List<Integer> solution2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            TreeNode right = curr.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return result;
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        List<Integer> result = BinaryTreeInoderTraversal.solution2(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
