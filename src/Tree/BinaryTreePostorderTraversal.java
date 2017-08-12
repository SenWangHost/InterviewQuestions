/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [3,2,1].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * @author SenWang
 *
 */
public class BinaryTreePostorderTraversal {
    /**
     * This is my own solution to this question.
     * @param root the root node of the tree.
     * @return an array list containing the traversal results.
     */
    public static List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        solutionRec(root, result);
        return result;
    }
    /**
     * This is the recursive helper function for the recursive solution above.
     * @param root the root node of the tree.
     * @param list the list containing the traversal result;
     */
    private static void solutionRec(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        solutionRec(root.left, list);
        solutionRec(root.right, list);
        list.add(root.val);
    }
    /**
     * This is the iterative solution to this question. This solution is acceptable
     * but the code is way too much complicated.
     * @param root the root node of the tree.
     * @return an array list containing the traversal results.
     */
    public static List<Integer> solution2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (curr.left == null && curr.right == null) {
                result.add(curr.val);
                visited.add(curr);
                stack.pop();
            } else if (curr.left != null && curr.right == null) {
                if (visited.contains(curr.left)) {
                    result.add(curr.val);
                    visited.add(curr);
                    stack.pop();
                } else {
                    stack.push(curr.left);
                }
            } else if (curr.left == null && curr.right != null) {
                if (visited.contains(curr.right)) {
                    result.add(curr.val);
                    visited.add(curr);
                    stack.pop();
                } else {
                    stack.push(curr.right);
                }
            } else {
                if (visited.contains(curr.left) && visited.contains(curr.right)) {
                    result.add(curr.val);
                    visited.add(curr);
                    stack.pop();
                } else {
                    stack.push(curr.right);
                    stack.push(curr.left);
                }
            }
        }
        return result;
    }
    /**
     * This is the iterative reference solution to this question, which
     * is based on the iterative solution to preorder traversal, but just
     * reverses the process of adding the node value to the result.
     * @param root the root node of the tree.
     * @return an array list containing the traversal results.
     */
    public static List<Integer> solutionRef(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(0, curr.val);
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
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
        List<Integer> result = BinaryTreePostorderTraversal.solutionRef(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
