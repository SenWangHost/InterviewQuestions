/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at
 * the given depth d. The root node is at depth 1.
 * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1,
 * create two tree nodes with value v as N's left subtree root and right subtree root.
 * And N's original left subtree should be the left subtree of the new left subtree root,
 * its original right subtree should be the right subtree of the new right subtree root.
 * If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v
 * as the new root of the whole original tree, and the original tree is the new root's left subtree.
 *
 * Example 1:
 * Input:
 * A binary tree as following:
 *            4
 *          /   \
 *         2     6
 *        / \   /
 *       3   1 5
 * v = 1
 * d = 2
 * Output:
 *           4
 *          / \
 *         1   1
 *        /     \
 *       2       6
 *      / \     /
 *     3   1   5
 * Example 2:
 * Input:
 * A binary tree as following:
 *       4
 *      /
 *     2
 *    / \
 *   3   1
 * v = 1
 * d = 3
 * Output:
 *       4
 *      /
 *     2
 *    / \
 *   1   1
 *  /     \
 * 3       1
 * Note:
 * The given d is in range [1, maximum depth of the given tree + 1].
 * The given binary tree has at least one tree node.
 * @author SenWang
 *
 */
public class AddOneRowToTree {
    /**
     * This is the iterative solution to this question, which
     * uses breadth first search algorithm.
     * @param root the root node of this tree.
     * @param v the value of the adding row.
     * @param d the depth of the adding row.
     * @return the root node of the tree after adding the row.
     */
    public static TreeNode solution(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        int level = 1;
        boolean added = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode curr = queue.poll();
                size--;
                TreeNode left = curr.left;
                TreeNode right = curr.right;
                if (level == d - 1) {
                    curr.left = new TreeNode(v);
                    curr.right = new TreeNode(v);
                    curr.left.left = left;
                    curr.right.right = right;
                    added = true;
                }
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            if (added) {
                return root;
            }
            level++;
        }
        return root;
    }
    /**
     * This is another iterative solution to this question, which
     * uses depth first search algorithm.
     * @param root the root node of this tree.
     * @param v the value of the adding row.
     * @param d the depth of the adding row.
     * @return the root node of the tree after adding the row.
     */
    public static TreeNode solution2(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Deque<TreeNode> nodeStack = new ArrayDeque<TreeNode>();
        Deque<Integer> levelStack = new ArrayDeque<Integer>();
        nodeStack.push(root);
        levelStack.push(1);
        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            int level = levelStack.pop();
            TreeNode left = curr.left;
            TreeNode right = curr.right;
            if (level == d - 1) {
                curr.left = new TreeNode(v);
                curr.right = new TreeNode(v);
                curr.left.left = left;
                curr.right.right = right;
                continue;
            }
            if (left != null) {
                nodeStack.push(left);
                levelStack.push(level + 1);
            }
            if (right != null) {
                nodeStack.push(right);
                levelStack.push(level + 1);
            }
        }
        return root;
    }
    /**
     * This is the recursive solution, which actually also
     * uses depth first search algorithm.
     * The recursive solution is faster than the two solutions above.
     * @param root the root node of this tree.
     * @param v the value of the adding row.
     * @param d the depth of the adding row.
     * @return the root node of the tree after adding the row.
     */
    public static TreeNode solution3(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        solutionRec(root, 1, v, d);
        return root;
    }
    /**
     * This is the recursive helper function to the solution above.
     * @param root the root node of this tree.
     * @param level the level at which the current node is at.
     * @param v the value of the adding row.
     * @param d the depth of the adding row.
     */
    private static void solutionRec(TreeNode root, int level, int v, int d) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (level == d - 1) {
            root.left = new TreeNode(v);
            root.right = new TreeNode(v);
            root.left.left = left;
            root.right.right = right;
            return;
        }
        solutionRec(root.left, level + 1, v, d);
        solutionRec(root.right, level + 1, v, d);
    }
    /**
     * The three reference solutions have the same idea as the three solutions above.
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
        TreeNode root = new TreeNode(4);
        root.left  = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        TreeNode result = AddOneRowToTree.solution2(root, 1, 2);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
        System.out.println(result.left.left.val);
        System.out.println(result.right.right.val);
        System.out.println(result.left.left.left.val);
        System.out.println(result.left.left.right.val);
        System.out.println(result.right.right.left.val);
    }

}
